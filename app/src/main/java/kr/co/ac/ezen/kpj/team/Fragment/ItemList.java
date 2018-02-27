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
    @BindView(R.id.list_lookaround) LinearLayout list_lookaround;
    @BindView(R.id.list_basicfunction) LinearLayout list_basicfunction;
    @BindView(R.id.list_basicsetting) LinearLayout list_basicseting;
    @BindView(R.id.list_playstore) LinearLayout list_playstore;
    @BindView(R.id.list_kakaotalk) LinearLayout list_kakaotalk;
    @BindView(R.id.list_internet) LinearLayout list_internet;
    @BindView(R.id.list_traffic) LinearLayout list_traffic;
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
    @OnClick({R.id.btn_lookaround,R.id.btn_basicfunction,R.id.btn_basicsetting,R.id.btn_playstore,R.id.btn_kakaotalk,R.id.btn_internet,R.id.btn_traffic})
    public void onclick(View view){
        switch (view.getId()) {
            case R.id.btn_lookaround:
                if (list_lookaround.getVisibility() == View.VISIBLE) {
                    list_lookaround.setVisibility(View.GONE);
                } else if (list_lookaround.getVisibility() == View.GONE) {
                    list_lookaround.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_basicfunction:
                if(list_basicfunction.getVisibility()==View.VISIBLE) {
                    list_basicfunction.setVisibility(View.GONE);
                }else if(list_basicfunction.getVisibility()==View.GONE){
                    list_basicfunction.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_basicsetting:
                if(list_basicseting.getVisibility()==View.VISIBLE) {
                    list_basicseting.setVisibility(View.GONE);
                }else if(list_basicseting.getVisibility()==View.GONE){
                    list_basicseting.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_playstore:
                if(list_playstore.getVisibility()==View.VISIBLE) {
                    list_playstore.setVisibility(View.GONE);
                }else if(list_playstore.getVisibility()==View.GONE){
                    list_playstore.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_kakaotalk:
                if(list_kakaotalk.getVisibility()==View.VISIBLE) {
                    list_kakaotalk.setVisibility(View.GONE);
                }else if(list_kakaotalk.getVisibility()==View.GONE){
                    list_kakaotalk.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_internet:
                if(list_internet.getVisibility()==View.VISIBLE) {
                    list_internet.setVisibility(View.GONE);
                }else if(list_internet.getVisibility()==View.GONE){
                    list_internet.setVisibility(View.VISIBLE);
                } break;
            case R.id.btn_traffic:
                if(list_traffic.getVisibility()==View.VISIBLE) {
                    list_traffic.setVisibility(View.GONE);
                }else if(list_traffic.getVisibility()==View.GONE){
                    list_traffic.setVisibility(View.VISIBLE);
                } break;
        }
    }

    @OnClick({R.id.tx_lookaround_hardware,R.id.tx_lookaround_gesture,R.id.tx_basicfunction_contact, R.id.tx_basicfunction_call,
            R.id.tx_basicfunction_call2,R.id.tx_basicfunction_message,R.id.tx_basicfunction_message2,R.id.tx_basicfunction_camera,
            R.id.tx_basicfunction_video,R.id.tx_basicfunction_album,R.id.tx_basicsetting_textsize,
            R.id.tx_basicsetting_brightness,R.id.tx_basicsetting_colouring,R.id.tx_basicsetting_sound,R.id.tx_basicsetting_alarm,R.id.tx_basicsetting_display,
            R.id.tx_playstore_basic,R.id.tx_playstore_search,R.id.tx_playstore_install,R.id.tx_playstore_delete,R.id.tx_kakaotalk_basic,R.id.tx_kakaotalk_profile,
            R.id.tx_kakaotalk_text,R.id.tx_kakaotalk_album,R.id.tx_kakaotalk_voice,R.id.tx_kakaotalk_group,R.id.tx_internet_basic,R.id.tx_internet_use,
            R.id.tx_internet_use2,R.id.tx_internet_favorite,R.id.tx_traffic_basic,R.id.tx_traffic_search,R.id.tx_traffic_subway})

    public void onclicku(View view){
        switch (view.getId()) {
            case R.id.tx_lookaround_hardware:
                Intent intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","lookaround_hardware");
                startActivity(intent);
                break;
            case R.id.tx_lookaround_gesture:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","lookaround_gesture");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_contact:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicfunction_contact");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_call:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicfunction_call");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_call2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicfunction_call2");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_message:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicfunction_message");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_message2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicfunction_message2");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_camera:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicfunction_camera");
                intent.putExtra("code","gesture");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_video:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicfunction_video");
                startActivity(intent);
                break;
            case R.id.tx_basicfunction_album:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code1","basicfunction_album");
                intent.putExtra("code2","gesture");
                startActivity(intent);
                break;
            case R.id.tx_basicsetting_textsize:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicsetting_textsize");
                startActivity(intent);
                break;
            case R.id.tx_basicsetting_brightness:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicsetting_brightness");
                startActivity(intent);
                break;
            case R.id.tx_basicsetting_colouring:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicsetting_colouring");
                startActivity(intent);
                break;
            case R.id.tx_basicsetting_sound:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicsetting_sound");
                startActivity(intent);
                break;
            case R.id.tx_basicsetting_alarm:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicsetting_alarm");
                startActivity(intent);
                break;
            case R.id.tx_basicsetting_display:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","basicsetting_display");
                startActivity(intent);
                break;
            case R.id.tx_playstore_basic:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","playstore_basic");
                startActivity(intent);
                break;
            case R.id.tx_playstore_search:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("id","playstore_search");
                startActivity(intent);
                break;
            case R.id.tx_playstore_install:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","playstore_install");
                startActivity(intent);
                break;
            case R.id.tx_playstore_delete:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","playstore_delete");
                startActivity(intent);
                break;
            case R.id.tx_kakaotalk_basic:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","playstore_basic");
                startActivity(intent);
                break;
            case R.id.tx_kakaotalk_profile:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","kakaotalk_profile");
                startActivity(intent);
                break;
            case R.id.tx_kakaotalk_text:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","kakaotalk_text");
                startActivity(intent);
                break;
            case R.id.tx_kakaotalk_album:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","kakaotalk_album");
                startActivity(intent);
                break;
            case R.id.tx_kakaotalk_voice:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","kakaotalk_voice");
                startActivity(intent);
                break;
            case R.id.tx_kakaotalk_group:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","kakaotalk_group");
                startActivity(intent);
                break;
            case R.id.tx_internet_basic:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","internet_basice");
                startActivity(intent);
                break;
            case R.id.tx_internet_use:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","internet_use");
                startActivity(intent);
                break;
            case R.id.tx_internet_use2:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","internet_use2");
                startActivity(intent);
                break;
            case R.id.tx_internet_favorite:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","internet_favorite");
                startActivity(intent);
                break;
            case R.id.tx_traffic_basic:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","traffic_basic");
                startActivity(intent);
                break;
            case R.id.tx_traffic_search:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","traffic_search");
                startActivity(intent);
                break;
            case R.id.tx_traffic_subway:
                intent = new Intent(getActivity(),gif_activity.class);
                intent.putExtra("code","traffic_subway");
                startActivity(intent);
                break;
        }
    }
}
