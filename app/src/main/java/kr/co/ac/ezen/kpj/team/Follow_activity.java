package kr.co.ac.ezen.kpj.team;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.Beans.ItemList;
import kr.co.ac.ezen.kpj.team.DBmanager.DBmanager;

public class Follow_activity extends AppCompatActivity {
    @BindView(R.id.follow_back)
    ImageView follow_back;
    @BindView(R.id.follow_left)
    Button follow_left;
    @BindView(R.id.follow_right)
    Button follow_right;
    @BindView(R.id.follow_img)
    ImageView follow_img;
    @BindView(R.id.follow_title)
    TextView follow_title;
    @BindView(R.id.follow_text)
    TextView follow_text;
    DBmanager db = new DBmanager(Follow_activity.this,"SmartPhone.db",null,1);
    ArrayList<ItemList> list = new ArrayList<>();
    int cursor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_activity);
        ButterKnife.bind(this);

        list.add(db.getItem("basicfunction_call2"));
        list.add(db.getItem("basicfunction_message2"));
        list.add(db.getItem("playstore_search"));
        list.add(db.getItem("internet_use"));
        list.add(db.getItem("traffic_subway"));
        follow_left.setEnabled(false);

        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(follow_img);
        Glide.with(this).load(getResources().getIdentifier(list.get(cursor).getCode(), "drawable", this.getPackageName())).into(gifImage);
        follow_title.setText(list.get(cursor).getTitle());
        follow_text.setText(list.get(cursor).getContent());


        follow_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @OnClick({R.id.follow_left,R.id.follow_right})
    public void click(View view){
        switch (view.getId()){
            case R.id.follow_left:
                cursor--;
                break;
            case  R.id.follow_right:
                cursor++;
                break;
        }

        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(follow_img);
        Glide.with(this).load(getResources().getIdentifier(list.get(cursor).getCode(), "drawable", this.getPackageName())).into(gifImage);
        follow_title.setText(list.get(cursor).getTitle());
        follow_text.setText(list.get(cursor).getContent());


        follow_left.setEnabled(true);
        follow_right.setEnabled(true);
        if (cursor==0){
            follow_left.setEnabled(false);
        } else if (cursor==list.size()-1) {
            follow_right.setEnabled(false);
        }
    }
}
