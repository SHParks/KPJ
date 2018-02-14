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
    String id;
    String img;
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

        /*Intent intent = getIntent();
        id = intent.getStringExtra("id");
        String code = id;
        Log.d("code",code);
        if(code.equals("1_1")) {
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.address).into(gifImage);
            tx_title.setText("기억의 습작");
            tx_content.setText("냥냥다아다아다");
        } else if(code.equals("1_2")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.addalarm).into(gifImage);
            tx_title.setText("아브라카다브라");
            tx_content.setText("다리밑고양이");
        } else if(code.equals(1_3)){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.address).into(gifImage);
        }else if(code.equals(2_1)){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.address).into(gifImage);
        } else if(code.equals(2_2)){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.address).into(gifImage);
        }else if(code.equals(2_3)){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.address).into(gifImage);
        } else if(code.equals(3_1)){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.address).into(gifImage);
        }

*/

       /* img = dbmanager.getImg(id,id_list);
        content = dbmanager.getContent(id,id_list);
        title = dbmanager.getTitle(id,id_list);
        */
    }
}
