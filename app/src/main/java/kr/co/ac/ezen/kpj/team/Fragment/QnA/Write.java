package kr.co.ac.ezen.kpj.team.Fragment.QnA;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.File;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.R;
import kr.co.ac.ezen.kpj.team.Utility.RealPathUtil;
import kr.co.ac.ezen.kpj.team.retrofit.RetrofitService;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Write extends AppCompatActivity {
    @BindView(R.id.et_title)
    EditText et_title;
    @BindView(R.id.et_writer) EditText et_writer;
    @BindView(R.id.et_content) EditText et_content;
    @BindView(R.id.btn_add)
    Button btn_add;
    @BindView(R.id.btn_write)
    Button btn_write;
    @BindView(R.id.et_pw)
    EditText et_pw;

    MultipartBody.Part filePart = null;
    RequestBody titleBody= null;
    RequestBody writerBody= null;
    RequestBody contentBody= null;
    RequestBody pwBody= null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_add)
    public void onClickBtnAdd(View view) {
        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(
                        Intent.createChooser(intent,"Select picture"),0);
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {

            }
        };

        TedPermission.with(Write.this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == 0) {
                File file = new File(
                        RealPathUtil.getRealPath(Write.this,
                                data.getData()));
                if (file.exists()) {
                    Log.d("ksj","exist");
                }
                filePart =
                        MultipartBody.Part.createFormData("file",
                                file.getName(),
                                RequestBody.create(MediaType.parse("image/*"), file));

            }
        }
    }

    @OnClick(R.id.btn_write)
    public void onClickBtnWrite(View view) {
        String title = et_title.getText().toString();
        String writer = et_writer.getText().toString();
        String content = et_content.getText().toString();
        String pw = et_pw.getText().toString();

        titleBody =
                RequestBody.create(MediaType.parse("text/plain"),
                        title);
        writerBody =
                RequestBody.create(MediaType.parse("text/plain"),
                        writer);
        contentBody =
                RequestBody.create(MediaType.parse("text/plain"),
                        content);
        pwBody =
                RequestBody.create(MediaType.parse("text/plain"),
                        pw);


        Call<Void> observ;

//        if (filePart ==null){
//            observ = RetrofitService.getInstance().getRetrofitRequest()
//                    .insertData(titleBody,writerBody,contentBody);
//        } else {
            observ = RetrofitService.getInstance().getRetrofitRequest()
                    .insertData(filePart,titleBody,writerBody,contentBody,pwBody);
        //}


        observ.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Log.d("ksj","suc");
                    Toast.makeText(Write.this, "글이 작성되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Log.d("ksj","fail");
                    Toast.makeText(Write.this, "글 작성에 실패하셨습니다.1", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(Write.this, "글 작성에 실패하셨습니다.2", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
