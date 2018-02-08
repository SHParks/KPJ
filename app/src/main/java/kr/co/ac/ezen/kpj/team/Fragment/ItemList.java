package kr.co.ac.ezen.kpj.team.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.R;
import kr.co.ac.ezen.kpj.team.gif_activity;

public class ItemList extends Fragment {
    @BindView(R.id.list_1) LinearLayout list_1;
    @BindView(R.id.list_2) LinearLayout list_2;
    @BindView(R.id.list_3) LinearLayout list_3;
    @BindView(R.id.list_4) LinearLayout list_4;
    @BindView(R.id.list_5) LinearLayout list_5;
    @BindView(R.id.list_6) LinearLayout list_6;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.activity_item_list,container,false);
        final ObservableScrollView scrollView = (ObservableScrollView) rootview.findViewById(R.id.scroll);
        Activity parentActivity = getActivity();
        ButterKnife.bind(this,rootview);

        if (parentActivity instanceof ObservableScrollViewCallbacks) {
            ScrollUtils.addOnGlobalLayoutListener(scrollView, new Runnable() {
                @Override
                public void run() {
                    scrollView.scrollTo(0, 0);
                }
            });
            scrollView.setTouchInterceptionViewGroup((ViewGroup) parentActivity.findViewById(R.id.root));
            scrollView.setScrollViewCallbacks((ObservableScrollViewCallbacks) parentActivity);
        }

        return rootview;
    }
    @OnClick({R.id.btn_1,R.id.btn_2,R.id.btn_3,R.id.btn_4,R.id.btn_5,R.id.btn_6})
    public void onclick(View view){
        switch (view.getId()) {
            case R.id.btn_1:
                if (list_1.getVisibility() == View.VISIBLE) {
                    list_1.setVisibility(View.GONE);
                } else if (list_1.getVisibility() == View.GONE) {
                    list_1.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_2:
                if(list_2.getVisibility()==View.VISIBLE) {
                    list_2.setVisibility(View.GONE);
                }else if(list_2.getVisibility()==View.GONE){
                    list_2.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_3:
                if(list_3.getVisibility()==View.VISIBLE) {
                    list_3.setVisibility(View.GONE);
                }else if(list_3.getVisibility()==View.GONE){
                    list_3.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_4:
                if(list_4.getVisibility()==View.VISIBLE) {
                    list_4.setVisibility(View.GONE);
                }else if(list_4.getVisibility()==View.GONE){
                    list_4.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_5:
                if(list_5.getVisibility()==View.VISIBLE) {
                    list_5.setVisibility(View.GONE);
                }else if(list_5.getVisibility()==View.GONE){
                    list_5.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_6:
                if(list_6.getVisibility()==View.VISIBLE) {
                    list_6.setVisibility(View.GONE);
                }else if(list_6.getVisibility()==View.GONE){
                    list_6.setVisibility(View.VISIBLE);
                } break;

        }
    }

    @OnClick({R.id.tx_1_1,R.id.tx_1_2,R.id.tx_1_3,R.id.tx_2_1,R.id.tx_2_2,R.id.tx_2_3,R.id.tx_3_1,R.id.tx_3_2,R.id.tx_3_3,R.id.tx_4_1,R.id.tx_4_2,R.id.tx_4_3,R.id.tx_5_1,R.id.tx_5_2,R.id.tx_5_3,R.id.tx_6_1,R.id.tx_6_2,R.id.tx_6_3})
    public void onclicku(View view){
        switch (view.getId()) {
            case R.id.tx_1_1:
                Intent intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",1);
                intent.putExtra("id_list",1);
                startActivity(intent);
                break;
            case R.id.tx_1_2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",1);
                intent.putExtra("id_list",2);
                startActivity(intent);
                break;
            case R.id.tx_1_3:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",1);
                intent.putExtra("id_list",3);
                startActivity(intent);
                break;
            case R.id.tx_2_1:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",2);
                intent.putExtra("id_list",1);
                startActivity(intent);
                break;
            case R.id.tx_2_2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",2);
                intent.putExtra("id_list",2);
                startActivity(intent);
                break;
            case R.id.tx_2_3:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",2);
                intent.putExtra("id_list",3);
                startActivity(intent);
                break;
            case R.id.tx_3_1:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",3);
                intent.putExtra("id_list",1);
                startActivity(intent);
                break;
            case R.id.tx_3_2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",3);
                intent.putExtra("id_list",2);
                startActivity(intent);
                break;
            case R.id.tx_3_3:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",3);
                intent.putExtra("id_list",3);
                startActivity(intent);
                break;
            case R.id.tx_4_1:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",4);
                intent.putExtra("id_list",1);
                startActivity(intent);
                break;
            case R.id.tx_4_2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",4);
                intent.putExtra("id_list",2);
                startActivity(intent);
                break;
            case R.id.tx_4_3:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",4);
                intent.putExtra("id_list",3);
                startActivity(intent);
                break;
            case R.id.tx_5_1:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",5);
                intent.putExtra("id_list",1);
                startActivity(intent);
                break;
            case R.id.tx_5_2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",5);
                intent.putExtra("id_list",2);
                startActivity(intent);
                break;
            case R.id.tx_5_3:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",5);
                intent.putExtra("id_list",3);
                startActivity(intent);
                break;
            case R.id.tx_6_1:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",6);
                intent.putExtra("id_list",1);
                startActivity(intent);
                break;
            case R.id.tx_6_2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",6);
                intent.putExtra("id_list",2);
                startActivity(intent);
                break;
            case R.id.tx_6_3:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id",6);
                intent.putExtra("id_list",3);
                startActivity(intent);
                break;
        }
    }


}
