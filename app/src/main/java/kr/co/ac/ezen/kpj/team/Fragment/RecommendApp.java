package kr.co.ac.ezen.kpj.team.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import kr.co.ac.ezen.kpj.team.R;
import kr.co.ac.ezen.kpj.team.Utility.InstallCheck;

public class RecommendApp extends Fragment {
    ArrayList<String> packageList = new ArrayList<>();
    ArrayList<RelativeLayout> layoutList = new ArrayList<>();
    @BindView(R.id.youtube)
    RelativeLayout youtube;
    @BindView(R.id.kakaoTalk)
    RelativeLayout kakaoTalk;
    @BindView(R.id.kakaoMap)
    RelativeLayout kakaoMap;
    @BindView(R.id.metro)
    RelativeLayout metro;
    @BindView(R.id.naver)
    RelativeLayout naver;
    @BindView(R.id.addressBook)
    RelativeLayout addressBook;


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
        packageList.add("com.google.android.youtube");
        packageList.add("com.kakao.talk");
        packageList.add("net.daum.android.map");
        packageList.add("teamDoppelGanger.SmarterSubway");
        packageList.add("com.nhn.android.search");
        packageList.add("com.nhn.android.addressbookbackup");

        layoutList.add(youtube);
        layoutList.add(kakaoTalk);
        layoutList.add(kakaoMap);
        layoutList.add(metro);
        layoutList.add(naver);
        layoutList.add(addressBook);


        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        for(int i=0; i < packageList.size(); i++){
            Log.d("alc",layoutList.get(i)+" ");
            if (InstallCheck.searchAppPackage(getActivity(),packageList.get(i))){
                layoutList.get(i).setVisibility(View.GONE);
                Log.d("alc",layoutList.get(i)+"숨김");
            }else {
                layoutList.get(i).setVisibility(View.VISIBLE);
            }
        }
    }

    @OnClick({R.id.downYoutube, R.id.downKakaoTalk, R.id.downKakaoMap, R.id.downMetro, R.id.downNaver, R.id.downAddressBook})
    public void onclick(View view){
        String packageName="";
        switch (view.getId()){
            case R.id.downYoutube:
                packageName = "com.google.android.youtube";
                break;
            case R.id.downKakaoTalk:
                packageName = "com.kakao.talk";
                break;
            case R.id.downKakaoMap:
                packageName = "net.daum.android.map";
                break;
            case R.id.downMetro:
                packageName = "teamDoppelGanger.SmarterSubway";
                break;
            case R.id.downNaver:
                packageName = "com.nhn.android.search";
                break;
            case R.id.downAddressBook:
                packageName = "com.nhn.android.addressbookbackup";
                break;
        }
//        if (InstallCheck.searchAppPackage(getActivity(),packageName)){
//            InstallCheck.executeLocalAppPackage(getActivity(),packageName);
//        } else {
//            InstallCheck.executeStoreAppPackage(getActivity(),packageName);
//        }
        InstallCheck.executeStoreAppPackage(getActivity(),packageName);
    }
}
