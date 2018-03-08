package kr.co.ac.ezen.kpj.team;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import kr.co.ac.ezen.kpj.team.DBmanager.DBmanager;

public class gif_activity extends AppCompatActivity {
    TextView tx_title;
    TextView tx_content;
    ImageView img_gif;
    DBmanager dbmanager;
    String code;
    String title;
    String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif_activity);

        tx_title = findViewById(R.id.tx_title);
        tx_content = findViewById(R.id.tx_content);
        img_gif = findViewById(R.id.img_gif);
        dbmanager = new DBmanager(gif_activity.this,"SmartPhone.db",null,1);




        Intent intent = getIntent();
        code = intent.getStringExtra("code");
        Log.d("code : ",code);
        Log.d("shb 패키지명",this.getPackageName());
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
        Glide.with(this).load(getResources().getIdentifier(code,"drawable",this.getPackageName())).into(gifImage);
        title= dbmanager.gettitle(code);
        content=dbmanager.getcontent(code);
        tx_title.setText(title);
        tx_content.setText(content);
    }
}
