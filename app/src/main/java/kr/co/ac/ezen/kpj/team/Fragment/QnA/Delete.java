package kr.co.ac.ezen.kpj.team.Fragment.QnA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.R;
import kr.co.ac.ezen.kpj.team.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delete extends AppCompatActivity {
    @BindView(R.id.del_btn)
    Button del_btn;
    @BindView(R.id.del_content)
    TextView del_content;
    @BindView(R.id.del_type)
    TextView del_type;
    @BindView(R.id.del_pw)
    EditText del_pw;
    @BindView(R.id.del_cancel)
    Button del_cancel;
    String type;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_delete);
        ButterKnife.bind(this);

        Intent getIntent = getIntent();

        type = getIntent.getStringExtra("type");
        if (type.equals("item")){
            del_type.setText("게시물 : ");
        } else if (type.equals("cmt")){
            del_type.setText("댓글 : ");
        }
        del_content.setText(getIntent.getStringExtra("content")+" 를 삭제 하시겠습니까?");
        id = getIntent.getStringExtra("id");

    }
    @OnClick(R.id.del_btn)
    public void onClickDel_btn(View view){
        String id_del = id;
        String pw_del = del_pw.getText().toString();


        Log.d("shb",id_del+"/"+pw_del+"/"+type);

        Call<String> del_item2 = RetrofitService.getInstance().getRetrofitRequest().deleteItem2(type,id_del,pw_del);
        del_item2.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    Log.d("shb","suc1");
                    String alert = response.body();
                    Log.d("shb",alert+"asdsad");

                    if (alert.equals("0")){
                        Toast.makeText(Delete.this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT).show();
                    } else if (alert.equals("1")){
                        Toast.makeText(Delete.this, "글이 삭제 되었습니다.", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK);
                        finish();
                    } else if (alert.equals("2")){
                        Toast.makeText(Delete.this, "댓글이 삭제 되었습니다.", Toast.LENGTH_SHORT).show();
                        //setResult(1);
                        finish();
                    }
                } else {
                    Log.d("shb","fail");
                    Toast.makeText(Delete.this, "삭제 실패하셨습니다.2", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
            }
        });

//        Call<Integer> del_item = RetrofitService.getInstance().getRetrofitRequest().deleteItem(typeBody,idBody,pwBody);
//        del_item.enqueue(new Callback<Integer>() {
//            @Override
//            public void onResponse(Call<Integer> call, Response<Integer> response) {
//                if (response.isSuccessful()) {
//                    Log.d("shb","suc1");
//                    Integer alert = response.body();
//                    Log.d("shb",alert+"asdsad");
//                    if (alert==0){
//                        Toast.makeText(Delete.this, "삭제 실패하셨습니다.1", Toast.LENGTH_SHORT).show();
//                    } else if (alert==1){
//                        Toast.makeText(Delete.this, "글이 삭제 되었습니다.", Toast.LENGTH_SHORT).show();
//                    } else if (alert==2){
//                        Toast.makeText(Delete.this, "댓글이 삭제 되었습니다.", Toast.LENGTH_SHORT).show();
//                    }
//
//                    finish();
//                } else {
//                    Log.d("shb","fail");
//                    Toast.makeText(Delete.this, "삭제 실패하셨습니다.2", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Integer> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
    }

    @OnClick(R.id.del_cancel)
    public void del_cancel (){
        finish();
    }
}
