package kr.co.ac.ezen.kpj.team.Adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import kr.co.ac.ezen.kpj.team.Beans.ItemList;
import kr.co.ac.ezen.kpj.team.MainActivity;
import kr.co.ac.ezen.kpj.team.R;
import kr.co.ac.ezen.kpj.team.gif_activity;

/**
 * Created by Administrator on 2018-02-26.
 */

public class SearchAdapter extends BaseAdapter {
    ArrayList<ItemList> itemList = new ArrayList<>();
    Context context;

    public SearchAdapter(ArrayList<ItemList> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.searchlist,  parent, false);

            holder.title = convertView.findViewById(R.id.searchtitle);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        final ItemList item = (ItemList) getItem(position);
        Log.d("ksj","1 : " + item.getTitle());
        holder.title.setText(item.getTitle());
        holder.title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,gif_activity.class);
                intent.putExtra("code",item.getCode());
                ((MainActivity)context).startActivity(intent);
            }
        });

        return convertView;
    }

    public class Holder{
        TextView title;
    }
}
