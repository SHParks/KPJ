package kr.co.ac.ezen.kpj.team.Fragment.QnA.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ac.ezen.kpj.team.Beans.Board_Comment;
import kr.co.ac.ezen.kpj.team.Fragment.QnA.Delete;
import kr.co.ac.ezen.kpj.team.Fragment.QnA.Views;
import kr.co.ac.ezen.kpj.team.R;


/**
 * Created by Administrator on 2018-02-14.
 */

public class Cmt_Adapter extends BaseAdapter {
    ArrayList<Board_Comment> cmts = new ArrayList<>();
    Context context;

    public Cmt_Adapter(ArrayList<Board_Comment> cmts, Context context) {
        this.cmts = cmts;
        this.context = context;
    }

    @Override
    public int getCount() {
        return cmts.size();
    }

    @Override
    public Object getItem(int position) {
        return cmts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cmt_item,  parent, false);
            holder.cmt_name = convertView.findViewById(R.id.cmt_name);
            holder.cmt_content = convertView.findViewById(R.id.cmt_content);
            holder.cmt_ip = convertView.findViewById(R.id.cmt_ip);
            holder.cmt_del = convertView.findViewById(R.id.cmt_del);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Log.d("shn","되냐2");

        final Board_Comment tmp = (Board_Comment) getItem(position);
        holder.cmt_name.setText(tmp.getCmt_name());
        holder.cmt_content.setText(tmp.getCmt_content());
        holder.cmt_ip.setText(tmp.getCmt_ip());
        holder.cmt_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Delete.class);
                intent.putExtra("id",tmp.getCmt_id()+"");
                intent.putExtra("content",tmp.getCmt_content());
                intent.putExtra("type","cmt");
//                ((Views)context).startActivityForResult(intent,1);
                context.startActivity(intent);
            }
        });

//        holder.item_layout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context,Views.class);
//                intent.putExtra("id",tmp.getId()+"");
//                intent.putExtra("name",tmp.getName());
//                intent.putExtra("title",tmp.getTitle());
//                intent.putExtra("content",tmp.getContent());
//                intent.putExtra("pw",tmp.getPw());
//                intent.putExtra("date",tmp.getWritedate()+"");
//                intent.putExtra("ip",tmp.getIp());
//                context.startActivity(intent);
//            }
//        });


        return convertView;
    }

    public class Holder{
        TextView cmt_name,cmt_content,cmt_ip;
        Button cmt_del;
    }
}
