package kr.co.ac.ezen.kpj.team.Fragment.QnA;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.Beans.Board_Comment;
import kr.co.ac.ezen.kpj.team.Beans.Board_File;
import kr.co.ac.ezen.kpj.team.Beans.Board_Item;
import kr.co.ac.ezen.kpj.team.Fragment.QnA.Adapter.Cmt_Adapter;
import kr.co.ac.ezen.kpj.team.R;
import kr.co.ac.ezen.kpj.team.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Views extends AppCompatActivity {
    @BindView(R.id.item_name) TextView item_name;
    @BindView(R.id.item_title) TextView item_title;
    @BindView(R.id.item_content) TextView item_content;
    @BindView(R.id.item_date) TextView item_date;
    @BindView(R.id.item_del) Button item_del;
    @BindView(R.id.item_ip) TextView item_ip;
    @BindView(R.id.item_image) ImageView item_image;
    @BindView(R.id.item_down) Button item_down;
    @BindView(R.id.item_cmt) ListView item_cmt;
    @BindView(R.id.item_edit) Button item_edit;
    @BindView(R.id.item_list) Button item_list;
    @BindView(R.id.cmt_add) Button cmt_add;
    @BindView(R.id.cmt_content)
    EditText cmt_content;
    @BindView(R.id.cmt_name)
    EditText cmt_name;
    @BindView(R.id.cmt_pw)
    EditText cmt_pw;
    Cmt_Adapter cmt_adapter;
    String id,title,type,content,pw;
    ArrayList<Board_File> item_file = new ArrayList<>();
    ArrayList<Board_Comment> cmt_list = new ArrayList<>();
    Board_Item item = new Board_Item();
    Boolean check = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);




        Intent intent = getIntent();
        id = intent.getStringExtra("id");



        Call<Void> obser = RetrofitService.getInstance().getRetrofitRequest().clickId(id);
        obser.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                } else {
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });

        Call<ArrayList<Board_File>> obser2 = RetrofitService.getInstance().getRetrofitRequest().getFile(id);
        obser2.enqueue(new Callback<ArrayList<Board_File>>() {
            @Override
            public void onResponse(Call<ArrayList<Board_File>> call, Response<ArrayList<Board_File>> response) {
                if (response.isSuccessful()) {
                    item_file = response.body();
                    if (item_file.size()!=0) {
                        String file = item_file.get(0).getFile_name();
                        if (file.substring(file.indexOf(".")+1,file.length()).equals("png") || file.substring(file.indexOf(".")+1,file.length()).equals("jpg") || file.substring(file.indexOf(".")+1,file.length()).equals("jpeg") || file.substring(file.indexOf(".")+1,file.length()).equals("bmp")) {
                            Glide.with(Views.this).load("http://13.125.173.223:8080/shp/resources/upload/" + item_file.get(0).getFile_name()).into(item_image);
                        } else if (file.substring(file.indexOf(".")+1,file.length()).equals("gif")){
                            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(item_image);
                            Glide.with(Views.this).load("http://13.125.173.223:8080/shp/resources/upload/" + item_file.get(0).getFile_name()).into(gifImage);
                        }
                        else {
                            item_down.setVisibility(View.VISIBLE);
                            item_down.setText(file);
                            item_down.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://13.125.173.223:8080/shp/resources/upload/" + item_file.get(0).getFile_name())));

                                }
                            });
                        }
                    }
                    Log.d("shb","성공");
                } else {
                    Log.d("shb","실패1");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Board_File>> call, Throwable t) {
                Log.d("shb","실패2");
                t.printStackTrace();
            }
        });

    }

    public void getItem(String id){
        Call<Board_Item> getItem = RetrofitService.getInstance().getRetrofitRequest().getItem(id);
        getItem.enqueue(new Callback<Board_Item>() {
            @Override
            public void onResponse(Call<Board_Item> call, Response<Board_Item> response) {
                if (response.isSuccessful()) {
                    item = response.body();
                    item_name.setText("작성자 : "+item.getName());
                    title = item.getTitle();
                    item_title.setText(title);
                    content = item.getContent();
                    item_content.setText(content);
                    pw = item.getPw();
                    String[] ipcut = item.getIp().split("\\.");
                    String moip = ipcut[0] +"." +ipcut[1]+".*.*";
                    item_ip.setText("IP : "+moip);

                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd", Locale.KOREA);
                    String dtime = formatter.format(item.getWritedate());
                    item_date.setText("날짜 : "+dtime);
                } else {

                }
            }

            @Override
            public void onFailure(Call<Board_Item> call, Throwable t) {

            }
        });


    }

    public void getCmts(String id){
        Log.d("ksj","id : " + id);
        Call<ArrayList<Board_Comment>> getCmt = RetrofitService.getInstance().getRetrofitRequest().getCmt(id);
        getCmt.enqueue(new Callback<ArrayList<Board_Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Board_Comment>> call, Response<ArrayList<Board_Comment>> response) {
                if (response.isSuccessful()) {
                    cmt_list = response.body();
                    if (cmt_list.size()>0){
                        item_cmt.setVisibility(View.VISIBLE);
                        cmt_adapter = new Cmt_Adapter(cmt_list,Views.this);
                        item_cmt.setAdapter(cmt_adapter);
                    }
                    else {
                        item_cmt.setVisibility(View.GONE);
                    }
                } else {

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Board_Comment>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        getItem(id);
        getCmts(id);
    }





    @OnClick(R.id.cmt_add)
    public void cmt_add(View view){
        if (cmt_name.getText().toString().equals("")){
            Toast.makeText(this, "작성자명을 입력 해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        } else if (cmt_pw.getText().toString().equals("")){
            Toast.makeText(this, "패스워드를 입력 해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        } if (cmt_content.getText().toString().equals("")){
            Toast.makeText(this, "내용을 입력 해 주세요.", Toast.LENGTH_SHORT).show();
            return;
        }

        Call<Void> insertCmt = RetrofitService.getInstance().getRetrofitRequest().insertCmt(id,cmt_name.getText().toString(),cmt_pw.getText().toString(),cmt_content.getText().toString());
        insertCmt.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(Views.this, "댓글 작성 완료", Toast.LENGTH_SHORT).show();
                    getCmts(id);
                    cmt_name.setText("");
                    cmt_pw.setText("");
                    cmt_content.setText("");
                } else {
                    Log.d("shb","fail");
                    Toast.makeText(Views.this, "서버 오류", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }

    @OnClick(R.id.item_del)
    public void item_del(View view){
        type="item";
        Intent intent2 = new Intent(Views.this,Delete.class);
        intent2.putExtra("type",type);
        intent2.putExtra("id",id);
        intent2.putExtra("content",title);
        startActivityForResult(intent2,1);

    }
    @OnClick(R.id.item_edit)
    public void setItem_edit(View view){
        Intent intent = new Intent(Views.this,Edit.class);
        intent.putExtra("id",id);
        intent.putExtra("title",title);
        intent.putExtra("content",content);
        intent.putExtra("pw",pw);
        intent.putExtra("type","item");
        startActivityForResult(intent,2);
    }
    @OnClick(R.id.item_list)
    public void item_list(){
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                Log.d("shb","글 삭제 완료");
                finish();
            }


//            else if (resultCode == 1){
//                Log.d("shb 댓글삭제","완료");
//                getCmts(id);
//            }
        } else if (requestCode == 2){
            if (resultCode == RESULT_OK){
            }
        }

    }

}