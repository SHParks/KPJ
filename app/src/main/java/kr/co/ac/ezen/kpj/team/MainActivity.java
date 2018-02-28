package kr.co.ac.ezen.kpj.team;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.Scrollable;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.nineoldandroids.view.ViewHelper;
import com.nineoldandroids.view.ViewPropertyAnimator;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import kr.co.ac.ezen.kpj.team.Adapter.SearchAdapter;
import kr.co.ac.ezen.kpj.team.Beans.ItemList;
import kr.co.ac.ezen.kpj.team.DBmanager.DBmanager;
import kr.co.ac.ezen.kpj.team.Fragment.NavigationAdapter;
import kr.co.ac.ezen.kpj.team.Utility.BackPressCloseHandler;
import kr.co.ac.ezen.kpj.team.Utility.SlidingTabLayout;

public class MainActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {
    private View mHeaderView;
    private View mToolbarView;
    private int mBaseTranslationY;
    private ViewPager mPager;
    private NavigationAdapter mPagerAdapter;
    @BindView(R.id.selbtn)
    TextView selbtn;
    @BindView(R.id.textedit)
    EditText textedit;
    @BindView(R.id.selectpage)
    ListView selectpage;
    SearchAdapter searchAdapter;
    ArrayList<ItemList> searchList = new ArrayList<>();
    DBmanager dbmanager = new DBmanager(MainActivity.this,"SmartPhone.db",null,1);
    private BackPressCloseHandler backPressCloseHandler = new BackPressCloseHandler(this);
    @BindView(R.id.sliding_tabs) SlidingTabLayout sliding_tabs;
    @BindView(R.id.logo)
    ImageView logo;
    @BindView(R.id.appname)
    TextView appname;
    boolean focus = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        mHeaderView = findViewById(R.id.header);
        ViewCompat.setElevation(mHeaderView, getResources().getDimension(R.dimen.toolbar_elevation));
        mToolbarView = findViewById(R.id.toolbar);
        mPagerAdapter = new NavigationAdapter(getSupportFragmentManager());

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mPagerAdapter);



        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);
        slidingTabLayout.setCustomTabView(R.layout.tab_indicator, android.R.id.text1);
        slidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.accent));
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(mPager);






        // When the page is selected, other fragments' scrollY should be adjusted
        // according to the toolbar status(shown/hidden)
        slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {
            }

            @Override
            public void onPageSelected(int i) {
                showToolbar();
                propagateToolbarState(toolbarIsShown());
            }

            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });

        propagateToolbarState(toolbarIsShown());




        textedit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }


            @Override
            public void afterTextChanged(Editable s) {
                if (textedit.getText().toString().equals("")){
                    selectpage.setVisibility(View.GONE);
                    sliding_tabs.setVisibility(SlidingTabLayout.VISIBLE);
                    //searchList = new ArrayList<>();
                } else {
                    if (dbmanager.getSearchList(textedit.getText().toString()) != null) {
                        selectpage.setVisibility(View.VISIBLE);
                        sliding_tabs.setVisibility(SlidingTabLayout.GONE);
                        searchList = dbmanager.getSearchList(textedit.getText().toString());
                        searchAdapter = new SearchAdapter(searchList, MainActivity.this);
                        selectpage.setAdapter(searchAdapter);
                    } else {
                        selectpage.setVisibility(View.VISIBLE);
                        sliding_tabs.setVisibility(SlidingTabLayout.GONE);
                        searchList = new ArrayList<>();
                        searchAdapter = new SearchAdapter(searchList, MainActivity.this);
                        selectpage.setAdapter(searchAdapter);
                    }
                }

            }
        });
    }

//    @OnTextChanged(R.id.textedit)
//    public void textedit(){
//        if (textedit.getText().toString().equals("")){
//            selectpage.setVisibility(View.GONE);
//            //searchList = new ArrayList<>();
//        } else {
//            if (dbmanager.getSearchList(textedit.getText().toString()) != null) {
//                selectpage.setVisibility(View.VISIBLE);
//                searchList = dbmanager.getSearchList(textedit.getText().toString());
//                searchAdapter = new SearchAdapter(searchList, MainActivity.this);
//                selectpage.setAdapter(searchAdapter);
//            }
//        }
//    }


    @Override
    public void onBackPressed() {
        if (textedit.getVisibility() == View.VISIBLE){
            sliding_tabs.setVisibility(SlidingTabLayout.VISIBLE);
            textedit.setVisibility(View.GONE);
            selectpage.setVisibility(View.GONE);
            textedit.setText("");
            logo.setVisibility(View.VISIBLE);
            appname.setVisibility(View.VISIBLE);
        } else {
            backPressCloseHandler.onBackPressed();
        }
    }

    //주석주
    @OnClick(R.id.selbtn)
    public void selbtn(View view){
                if (textedit.getVisibility() == View.GONE){ // 에디트 텍스트가 숨겨져 있을때
                    textedit.setVisibility(View.VISIBLE);
                    sliding_tabs.setVisibility(SlidingTabLayout.GONE);
                    selectpage.setVisibility(View.VISIBLE);
                    logo.setVisibility(View.GONE);
                    appname.setVisibility(View.GONE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
                } else { //에디트 텍스트가 보일 때
                    sliding_tabs.setVisibility(SlidingTabLayout.VISIBLE);
                    textedit.setVisibility(View.GONE);
                    selectpage.setVisibility(View.GONE);
                    textedit.setText("");
                    logo.setVisibility(View.VISIBLE);
                    appname.setVisibility(View.VISIBLE);
                    InputMethodManager imm = (InputMethodManager) getSystemService(MainActivity.INPUT_METHOD_SERVICE);
                    imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
                }

    }



    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        if (dragging) {
            int toolbarHeight = mToolbarView.getHeight();
            float currentHeaderTranslationY = ViewHelper.getTranslationY(mHeaderView);
            if (firstScroll) {
                if (-toolbarHeight < currentHeaderTranslationY) {
                    mBaseTranslationY = scrollY;
                }
            }
            float headerTranslationY = ScrollUtils.getFloat(-(scrollY - mBaseTranslationY), -toolbarHeight, 0);
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewHelper.setTranslationY(mHeaderView, headerTranslationY);
        }
    }

    @Override
    public void onDownMotionEvent() {
    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        mBaseTranslationY = 0;

        Fragment fragment = getCurrentFragment();
        if (fragment == null) {
            return;
        }
        View view = fragment.getView();
        if (view == null) {
            return;
        }

        // ObservableXxxViews have same API
        // but currently they don't have any common interfaces.
        adjustToolbar(scrollState, view);
    }

    private void adjustToolbar(ScrollState scrollState, View view) {
        int toolbarHeight = mToolbarView.getHeight();
        final Scrollable scrollView = (Scrollable) view.findViewById(R.id.scroll);
        if (scrollView == null) {
            return;
        }
        int scrollY = scrollView.getCurrentScrollY();
        if (scrollState == ScrollState.DOWN) {
            showToolbar();
        } else if (scrollState == ScrollState.UP) {
            if (toolbarHeight <= scrollY) {
                hideToolbar();
            } else {
                showToolbar();
            }
        } else {
            // Even if onScrollChanged occurs without scrollY changing, toolbar should be adjusted
            if (toolbarIsShown() || toolbarIsHidden()) {
                // Toolbar is completely moved, so just keep its state
                // and propagate it to other pages
                propagateToolbarState(toolbarIsShown());
            } else {
                // Toolbar is moving but doesn't know which to move:
                // you can change this to hideToolbar()
                showToolbar();
            }
        }
    }

    private Fragment getCurrentFragment() {
        return mPagerAdapter.getItemAt(mPager.getCurrentItem());
    }

    private void propagateToolbarState(boolean isShown) {
        int toolbarHeight = mToolbarView.getHeight();

        // Set scrollY for the fragments that are not created yet
        mPagerAdapter.setScrollY(isShown ? 0 : toolbarHeight);

        // Set scrollY for the active fragments
        for (int i = 0; i < mPagerAdapter.getCount(); i++) {
            // Skip current item
            if (i == mPager.getCurrentItem()) {
                continue;
            }

            // Skip destroyed or not created item
            Fragment f = mPagerAdapter.getItemAt(i);
            if (f == null) {
                continue;
            }

            View view = f.getView();
            if (view == null) {
                continue;
            }
            propagateToolbarState(isShown, view, toolbarHeight);
        }
    }

    private void propagateToolbarState(boolean isShown, View view, int toolbarHeight) {
        Scrollable scrollView = (Scrollable) view.findViewById(R.id.scroll);
        if (scrollView == null) {
            return;
        }
        if (isShown) {
            // Scroll up
            if (0 < scrollView.getCurrentScrollY()) {
                scrollView.scrollVerticallyTo(0);
            }
        } else {
            // Scroll down (to hide padding)
            if (scrollView.getCurrentScrollY() < toolbarHeight) {
                scrollView.scrollVerticallyTo(toolbarHeight);
            }
        }
    }

    private boolean toolbarIsShown() {
        return ViewHelper.getTranslationY(mHeaderView) == 0;
    }

    private boolean toolbarIsHidden() {
        return ViewHelper.getTranslationY(mHeaderView) == -mToolbarView.getHeight();
    }

    private void showToolbar() {
        float headerTranslationY = ViewHelper.getTranslationY(mHeaderView);
        if (headerTranslationY != 0) {
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewPropertyAnimator.animate(mHeaderView).translationY(0).setDuration(200).start();
        }
        propagateToolbarState(true);
    }

    private void hideToolbar() {
        float headerTranslationY = ViewHelper.getTranslationY(mHeaderView);
        int toolbarHeight = mToolbarView.getHeight();
        if (headerTranslationY != -toolbarHeight) {
            ViewPropertyAnimator.animate(mHeaderView).cancel();
            ViewPropertyAnimator.animate(mHeaderView).translationY(-toolbarHeight).setDuration(200).start();
        }
        propagateToolbarState(false);
    }

    /**
     * This adapter provides two types of fragments as an example.
     * {@linkplain #createItem(int)} should be modified if you use this example for your app.
     */


}


