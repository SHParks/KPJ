package kr.co.ac.ezen.kpj.team;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import kr.co.ac.ezen.kpj.team.DBmanager.DBmanager;

public class gif_activity extends AppCompatActivity {
    TextView tx_title;
    TextView tx_content;
    ImageView img_gif;
    DBmanager dbmanager;
    Integer id;
    Integer id_list;
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

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);
        id_list = intent.getIntExtra("id_list",0);

       /* img = dbmanager.getImg(id,id_list);
        content = dbmanager.getContent(id,id_list);
        title = dbmanager.getTitle(id,id_list);
        */
    }
}
