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
        id = intent.getStringExtra("id");
        String code = id;
        Log.d("jp",code);

        if(code.equals("lookaround_hardware")) {
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_album).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);
        } else if(code.equals("lookaround_gesture")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_message).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicfunction_contact")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_contact).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        }else if(code.equals("basicfunction_call")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_call).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicfunction_call2")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_call2).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        }else if(code.equals("basicfunction_message")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_message).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicfunction_message2")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_message2).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicfunction_camera")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_camera).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicfunction_video")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_video).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicfunction_album")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicfunction_album).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicsetting_textsize")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicsetting_textsize).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicsetting_brightness")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicsetting_brightness).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicsetting_colouring")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicsetting_colouring).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicsetting_sound")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicsetting_sound).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicsetting_alarm")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicsetting_alarm).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("basicsetting_display")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.basicsetting_display).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("playstore_basic")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.playstore_delete).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("playstore_search")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.playstore_search).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("playstore_install")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.playstore_install).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("playstore_delete")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.playstore_delete).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("kakaotalk_basic")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.kakaotalk_album).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("kakaotalk_profile")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.kakaotalk_profile).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("kakaotalk_text")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.kakaotalk_text).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("kakaotalk_album")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.kakaotalk_album).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("kakaotalk_voice")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.kakaotalk_voice).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("kakaotalk_group")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.kakaotalk_group).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("internet_basic")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.internet_favorite).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("internet_use")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.internet_use).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("internet_use2")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.internet_use2).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("internet_favorite")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.internet_favorite).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("traffic_basic")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.traffic_search).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("traffic_search")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.traffic_search).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        } else if(code.equals("traffic_subway")){
            GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(img_gif);
            Glide.with(this).load(R.drawable.traffic_subway).into(gifImage);
            title= dbmanager.gettitle(code);
            content=dbmanager.getcontent(code);
            tx_title.setText(title);
            tx_content.setText(content);

        }




       /* img = dbmanager.getImg(id,id_list);
        content = dbmanager.getContent(id,id_list);
        title = dbmanager.getTitle(id,id_list);
        */
    }
}
