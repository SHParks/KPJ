package kr.co.ac.ezen.kpj.team;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import kr.co.ac.ezen.kpj.team.DBmanager.DBmanager;
import kr.co.ac.ezen.kpj.team.Utility.InstallCheck;

public class gif_activity extends AppCompatActivity {
    TextView tx_title;
    TextView tx_content;
    ImageView img_gif;
    DBmanager dbmanager;
    Button linkapp;
    String code;
    String title;
    String content;
    ImageView gif_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_activity);

        tx_title = findViewById(R.id.tx_title);
        tx_content = findViewById(R.id.tx_content);
        img_gif = findViewById(R.id.img_gif);
        gif_back = findViewById(R.id.gif_back);
        linkapp = findViewById(R.id.linkapp);

        dbmanager = new DBmanager(gif_activity.this, "SmartPhone.db", null, 1);
        gif_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent intent = getIntent();
        code = intent.getStringExtra("code");
        Log.d("code : ", code);
        Log.d("shb 패키지명", this.getPackageName());
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
        Glide.with(this).load(getResources().getIdentifier(code, "drawable", this.getPackageName())).into(gifImage);
        title = dbmanager.gettitle(code);
        content = dbmanager.getcontent(code);
        tx_title.setText(title);
        tx_content.setText(content);


        if (code.equals("kakaotalk_basic") || code.equals("playstore_basic") || code.equals("traffic_basic") || code.equals("internet_basic")) {
            img_gif.setVisibility(View.GONE);
            linkapp.setVisibility(View.VISIBLE);
            if (code.equals("kakaotalk_basic")) {
                linkapp.setText("카카오톡");
                linkapp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (InstallCheck.searchAppPackage(gif_activity.this, "com.kakao.talk")) {
                            InstallCheck.executeLocalAppPackage(gif_activity.this, "com.kakao.talk");
                        } else {
                            InstallCheck.executeStoreAppPackage(gif_activity.this, "com.kakao.talk");
                        }
                    }
                });
            } else if (code.equals("playstore_basic")) {
                linkapp.setText("플레이스토어");
                linkapp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try {
                            InstallCheck.executeLocalAppPackage(gif_activity.this, "com.android.vending");
                        } catch (android.content.ActivityNotFoundException anfe) {
                            Toast.makeText(gif_activity.this, "스토어가 설치되어있지 않습니다.", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/"));
                            intent.setPackage("com.android.chrome");
                            startActivity(intent);
                        }

                    }
                });
            } else if (code.equals("traffic_basic")) {
                linkapp.setText("지하철종결자");
                linkapp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (InstallCheck.searchAppPackage(gif_activity.this, "teamDoppelGanger.SmarterSubway")) {
                            InstallCheck.executeLocalAppPackage(gif_activity.this, "teamDoppelGanger.SmarterSubway");
                        } else {
                            InstallCheck.executeStoreAppPackage(gif_activity.this, "teamDoppelGanger.SmarterSubway");
                        }
                    }
                });
            } else if (code.equals("internet_basic")) {
                linkapp.setText("크롬");
                linkapp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (InstallCheck.searchAppPackage(gif_activity.this, "com.android.chrome")) {
                            InstallCheck.executeLocalAppPackage(gif_activity.this, "com.android.chrome");
                        } else {
                            InstallCheck.executeStoreAppPackage(gif_activity.this, "com.android.chrome");
                        }
                    }
                });
            }
        }
    }
}
