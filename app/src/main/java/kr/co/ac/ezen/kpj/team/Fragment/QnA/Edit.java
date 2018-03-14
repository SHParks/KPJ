package kr.co.ac.ezen.kpj.team.Fragment.QnA;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
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

public class Edit extends AppCompatActivity {
    @BindView(R.id.edit_check)
    RelativeLayout edit_check;
    @BindView(R.id.check_type)
    TextView check_type;
    @BindView(R.id.check_content)
    TextView check_content;
    @BindView(R.id.check_pw)
    EditText check_pw;
    @BindView(R.id.btn_moveEdit)
    Button btn_moveEdit;
    @BindView(R.id.btn_movecancel)
    Button btn_movecancel;

    @BindView(R.id.edit_edit)
    LinearLayout edit_edit;
    @BindView(R.id.edit_title)
    EditText edit_title;
    @BindView(R.id.edit_pw)
    EditText edit_pw;
    @BindView(R.id.edit_content)
    EditText edit_content;
    @BindView(R.id.btn_edit)
    Button btn_edit;
    @BindView(R.id.btn_cancel)
    Button btn_cancel;

    String id,content,title,pw,type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_edit);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        edit_title.setText(intent.getStringExtra("title"));
        edit_content.setText(intent.getStringExtra("content"));
        edit_pw.setText(intent.getStringExtra("pw"));

        type = intent.getStringExtra("type");
        if (type.equals("item")){
            check_type.setText("게시물 : ");
        } else if (type.equals("cmt")){
            check_type.setText("댓글 : ");
        }
        check_content.setText(intent.getStringExtra("content")+" 를 수정 하시겠습니까?");

    }

    @OnClick({R.id.btn_moveEdit,R.id.btn_movecancel,R.id.btn_edit,R.id.btn_cancel})
    public void edit_btns(View view){
        switch (view.getId()){
            case R.id.btn_edit:
                title = edit_title.getText().toString();
                content = edit_content.getText().toString();
                pw = edit_pw.getText().toString();
                if (title.equals("")){
                    Toast.makeText(this, "제목을 입력 해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (content.equals("")){
                    Toast.makeText(this, "내용을 입력 해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (pw.equals("")){
                    Toast.makeText(this, "패스워드를 입력 해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Call<Void> edit = RetrofitService.getInstance().getRetrofitRequest().editItem2(id,title,content,pw);
                edit.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        Toast.makeText(Edit.this, "글이 수정 되었습니다.", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK);
                        finish();

                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(Edit.this, "수정 실패하셨습니다.2", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
                Log.d("shb content1",content);
                Log.d("shb content2",edit_content.getText().toString());
                break;
            case R.id.btn_cancel:
                finish();
                break;
            case R.id.btn_moveEdit:
                Call<String> pwCheck = RetrofitService.getInstance().getRetrofitRequest().pwCheck(id,check_pw.getText().toString());
                pwCheck.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {
                            String alert = response.body();

                            if (alert.equals("0")){
                                Toast.makeText(Edit.this, "패스워드가 일치하지 않습니다.", Toast.LENGTH_SHORT).show();
                            } else if (alert.equals("1")) {
                                Toast.makeText(Edit.this, "패스워드가 확인되었습니다.", Toast.LENGTH_SHORT).show();
                                edit_check.setVisibility(View.GONE);
                                edit_edit.setVisibility(View.VISIBLE);
                            }
                        } else {
                            Log.d("shb","fail");
                            Toast.makeText(Edit.this, "서버 오류", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
                break;
            case R.id.btn_movecancel:
                finish();
                break;
        }
    }
}
