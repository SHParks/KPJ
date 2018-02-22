package kr.co.ac.ezen.kpj.team.Fragment.QnA.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ac.ezen.kpj.team.Beans.Board_Item;
import kr.co.ac.ezen.kpj.team.Fragment.QnA.Views;
import kr.co.ac.ezen.kpj.team.R;


/**
 * Created by Administrator on 2018-01-30.
 */

public class Index_Adapter extends BaseAdapter {
    ArrayList<Board_Item> items = new ArrayList<>();
    Context context;


    public Index_Adapter(ArrayList<Board_Item> items, Context context) {
        this.items = items;
        this.context = context;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d("shn","되냐1");
        Holder holder = new Holder();

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.index_item,  parent, false);

            holder.item_id = convertView.findViewById(R.id.index_item_id);
            holder.item_name = convertView.findViewById(R.id.index_item_name);
            holder.item_title = convertView.findViewById(R.id.index_item_title);
            holder.item_layout = convertView.findViewById(R.id.item_layout);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        Log.d("shn","되냐2");

        final Board_Item tmp = (Board_Item) getItem(position);
        Log.d("shb",tmp.getId()+"/"+tmp.getName()+"/"+tmp.getTitle());
        holder.item_id.setText(tmp.getId()+"");
        holder.item_name.setText(tmp.getName()+"");
        holder.item_title.setText(tmp.getTitle()+"");

        holder.item_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("shb 체크0","체크");
                Intent intent = new Intent(context,Views.class);
                intent.putExtra("id",tmp.getId()+"");
                Log.d("shb 체크-1",tmp.getId()+"");
//                intent.putExtra("name",tmp.getName());
//                intent.putExtra("title",tmp.getTitle());
//                intent.putExtra("content",tmp.getContent());
//                intent.putExtra("pw",tmp.getPw());
//                intent.putExtra("date",tmp.getWritedate()+"");
//                intent.putExtra("ip",tmp.getIp());
                context.startActivity(intent);
                Log.d("shb 체크-2","체크");
            }
        });


        return convertView;
    }

    public class Holder{
        TextView item_id,item_name,item_title;
        LinearLayout item_layout;
    }
}
