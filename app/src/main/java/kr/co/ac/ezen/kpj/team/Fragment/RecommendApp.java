package kr.co.ac.ezen.kpj.team.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.R;

public class RecommendApp extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootview = (ViewGroup)inflater.inflate(R.layout.activity_recommend_app,container,false);
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
    @OnClick({R.id.downYoutube, R.id.downKakaoTalk, R.id.kakaoMap, R.id.downMetro, R.id.downNaver, R.id.downAddressBook})
    public void onclick(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);

        switch (view.getId()){
            case R.id.downYoutube:
                intent.setData(Uri.parse("market://details?id=com.google.android.youtube"));
                startActivity(intent);
                break;
            case R.id.downKakaoTalk:
                intent.setData(Uri.parse("market://details?id=com.kakao.talk"));
                startActivity(intent);
                break;
            case R.id.downKakaoMap:
                intent.setData(Uri.parse("market://details?id=net.daum.android.map"));
                startActivity(intent);
                break;
            case R.id.downMetro:
                intent.setData(Uri.parse("market://details?id=teamDoppelGanger.SmarterSubway"));
                startActivity(intent);
                break;
            case R.id.downNaver:
                intent.setData(Uri.parse("market://details?id=com.nhn.android.search"));
                startActivity(intent);
                break;
            case R.id.downAddressBook:
                intent.setData(Uri.parse("market://details?id=com.nhn.android.addressbookbackup"));
                startActivity(intent);
                break;
        }
    }
}
