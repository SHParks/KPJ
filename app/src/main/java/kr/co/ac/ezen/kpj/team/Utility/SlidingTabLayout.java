package kr.co.ac.ezen.kpj.team.Utility;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.ac.ezen.kpj.team.MainActivity;
import kr.co.ac.ezen.kpj.team.R;

/**
 * Created by Administrator on 2018-02-07.
 */


public class SlidingTabLayout extends HorizontalScrollView {

    public interface TabColorizer {

        /**
         * @return return the color of the indicator used when {@code position} is selected.
         */
        int getIndicatorColor(int position);

    }


    private static final int TITLE_OFFSET_DIPS = 24;
    private static final int TAB_VIEW_PADDING_DIPS = 16;
    private static final int TAB_VIEW_TEXT_SIZE_SP = 12;

    private int mTitleOffset;

    private int mTabViewLayoutId;
    private int mTabViewTextViewId;
    private int mTabViewImageViewId; //내가 만드는 이미지뷰 추가중
    private boolean mDistributeEvenly;

    private ViewPager mViewPager;
    private SparseArray<String> mContentDescriptions = new SparseArray<String>();
    private ViewPager.OnPageChangeListener mViewPagerPageChangeListener;

    ImageView tabTitleIcon[]  = new ImageView[4];

    private final SlidingTabStrip mTabStrip;

    public SlidingTabLayout(Context context) {
        this(context, null);
    }

    public SlidingTabLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        // Disable the Scroll Bar
        setHorizontalScrollBarEnabled(false);
        // Make sure that the Tab Strips fills this View
        setFillViewport(true);

        mTitleOffset = (int) (TITLE_OFFSET_DIPS * getResources().getDisplayMetrics().density);

        mTabStrip = new SlidingTabStrip(context);
        addView(mTabStrip, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
    }

//    /**
//     * Set the custom {@link com.google.samples.apps.iosched.ui.widget.SlidingTabLayout.TabColorizer} to be used.
//     *
//     * If you only require simple custmisation then you can use
//     * {@link #setSelectedIndicatorColors(int...)} to achieve
//     * similar effects.
//     */
    public void setCustomTabColorizer(TabColorizer tabColorizer) {
        mTabStrip.setCustomTabColorizer(tabColorizer);
    }

    public void setDistributeEvenly(boolean distributeEvenly) {
        mDistributeEvenly = distributeEvenly;
    }

    /**
     * Sets the colors to be used for indicating the selected tab. These colors are treated as a
     * circular array. Providing one color will mean that all tabs are indicated with the same color.
     */
    public void setSelectedIndicatorColors(int... colors) {
        mTabStrip.setSelectedIndicatorColors(colors);
    }

//    /**
//     * Set the {@link android.support.v4.view.ViewPager.OnPageChangeListener}. When using {@link com.google.samples.apps.iosched.ui.widget.SlidingTabLayout} you are
//     * required to set any {@link android.support.v4.view.ViewPager.OnPageChangeListener} through this method. This is so
//     * that the layout can update it's scroll position correctly.
//     *
//     * @see android.support.v4.view.ViewPager#setOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener)
//     */
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener listener) {
        mViewPagerPageChangeListener = listener;
    }

    /**
     * Set the custom layout to be inflated for the tab views.
     *
     * @param layoutResId Layout id to be inflated
     * @param textViewId id of the {@link android.widget.TextView} in the inflated view
     */
    public void setCustomTabView(int layoutResId, int textViewId, int imageViewId) {
        mTabViewLayoutId = layoutResId;
        mTabViewTextViewId = textViewId;
        mTabViewImageViewId = imageViewId;
    }

    /**
     * Sets the associated view pager. Note that the assumption here is that the pager content
     * (number of tabs and tab titles) does not change after this call has been made.
     */
    public void setViewPager(ViewPager viewPager) {
        mTabStrip.removeAllViews();

        mViewPager = viewPager;
        if (viewPager != null) {
            viewPager.setOnPageChangeListener(new InternalViewPagerListener());
            populateTabStrip();
        }
    }

    /**
     * Create a default view to be used for tabs. This is called if a custom tab view is not set via
     * {@link #setCustomTabView(int, int, int)}.
     */
    protected TextView createDefaultTabView(Context context) {
        TextView textView = new TextView(context);
        textView.setGravity(Gravity.CENTER);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, TAB_VIEW_TEXT_SIZE_SP);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        TypedValue outValue = new TypedValue();
        getContext().getTheme().resolveAttribute(android.R.attr.selectableItemBackground,
                outValue, true);
        textView.setBackgroundResource(outValue.resourceId);
        textView.setAllCaps(true);

        int padding = (int) (TAB_VIEW_PADDING_DIPS * getResources().getDisplayMetrics().density);
        textView.setPadding(padding, padding, padding, padding);

        return textView;
    }

    String[] Icons = {"list1","follow1","question1","recommend1"};
    String[] ClickIcons = {"list2","follow2","question2","recommend2"};
    String packName="kr.co.ac.ezen.kpj.team";
    private void populateTabStrip() {
        final PagerAdapter adapter = mViewPager.getAdapter();
        final OnClickListener tabClickListener = new TabClickListener();

        for (int i = 0; i < adapter.getCount(); i++) {
            View tabView = null;
            TextView tabTitleView = null;


            if (mTabViewLayoutId != 0) {
                // If there is a custom tab view layout id set, try and inflate it
                tabView = LayoutInflater.from(getContext()).inflate(mTabViewLayoutId, mTabStrip,
                        false);
                tabTitleView = (TextView) tabView.findViewById(mTabViewTextViewId);
                //tabTitleView.setBackgroundResource(getResources().getIdentifier(Icons[i],"drawable", packName));

                tabTitleIcon[i] = (ImageView) tabView.findViewById(mTabViewImageViewId);
                //tabTitleIcon.setImageResource(getResources().getIdentifier(Icons[i],"drawable", packName));
            }

            if (tabView == null) {
                tabView = createDefaultTabView(getContext());
            }

            if (tabTitleView == null && TextView.class.isInstance(tabView)) {
                tabTitleView = (TextView) tabView;
                tabTitleIcon[i] = (ImageView) tabView;
            }


            if (mDistributeEvenly) {
                LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                lp.width = 0;
                lp.weight = 1;
            }

            if (mTabViewLayoutId != 0) {
                //tabTitleView.setText(adapter.getPageTitle(i));
                tabTitleIcon[i].setImageResource(getResources().getIdentifier(Icons[i], "drawable", packName));
                tabTitleIcon[0].setImageResource(getResources().getIdentifier(ClickIcons[0], "drawable", packName));
            }

            tabView.setOnClickListener(tabClickListener);
//            tabView.setOnClickListener(new OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
//                        if (v == mTabStrip.getChildAt(i)) {
//                            mViewPager.setCurrentItem(i);
//                            for (int j = 0 ; j<mTabStrip.getChildCount() ; j++){
//                                tabTitleIcon[j].setImageResource(getResources().getIdentifier(Icons[j], "drawable", packName));
//                            }
//                            tabTitleIcon[i].setImageResource(getResources().getIdentifier(ClickIcons[i], "drawable", packName));
//
//                            Log.d("shb 클릭한 번째 : ",i+"");
//                            return;
//                        }
//                    }
//                }
//            });


            String desc = mContentDescriptions.get(i, null);
            if (desc != null) {
                tabView.setContentDescription(desc);
            }

            mTabStrip.addView(tabView);
            if (i == mViewPager.getCurrentItem()) {
                tabView.setSelected(true);
            }
        }
    }

    public void setContentDescription(int i, String desc) {
        mContentDescriptions.put(i, desc);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (mViewPager != null) {
            scrollToTab(mViewPager.getCurrentItem(), 0);
        }
    }

    private void scrollToTab(int tabIndex, int positionOffset) {
        final int tabStripChildCount = mTabStrip.getChildCount();
        if (tabStripChildCount == 0 || tabIndex < 0 || tabIndex >= tabStripChildCount) {
            return;
        }


        tabTitleIcon[tabIndex].setImageResource(getResources().getIdentifier(ClickIcons[tabIndex], "drawable", packName));
        for (int j = 0 ; j<mTabStrip.getChildCount() ; j++){
            if (j!=tabIndex){
                tabTitleIcon[j].setImageResource(getResources().getIdentifier(Icons[j], "drawable", packName));
            }
        }


        View selectedChild = mTabStrip.getChildAt(tabIndex);
        if (selectedChild != null) {
            int targetScrollX = selectedChild.getLeft() + positionOffset;

            if (tabIndex > 0 || positionOffset > 0) {
                // If we're not at the first child and are mid-scroll, make sure we obey the offset
                targetScrollX -= mTitleOffset;
            }

            scrollTo(targetScrollX, 0);
        }
    }




    private class InternalViewPagerListener implements ViewPager.OnPageChangeListener {
        private int mScrollState;

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int tabStripChildCount = mTabStrip.getChildCount();
            if ((tabStripChildCount == 0) || (position < 0) || (position >= tabStripChildCount)) {
                return;
            }

            mTabStrip.onViewPagerPageChanged(position, positionOffset);


            View selectedTitle = mTabStrip.getChildAt(position);
            int extraOffset = (selectedTitle != null)
                    ? (int) (positionOffset * selectedTitle.getWidth())
                    : 0;
            scrollToTab(position, extraOffset);

            if (mViewPagerPageChangeListener != null) {
                mViewPagerPageChangeListener.onPageScrolled(position, positionOffset,
                        positionOffsetPixels);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {
            mScrollState = state;

            if (mViewPagerPageChangeListener != null) {
                mViewPagerPageChangeListener.onPageScrollStateChanged(state);

            }

        }

        @Override
        public void onPageSelected(int position) {
            if (mScrollState == ViewPager.SCROLL_STATE_IDLE) {
                mTabStrip.onViewPagerPageChanged(position, 0f);
                scrollToTab(position, 0);
            }
            for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                mTabStrip.getChildAt(i).setSelected(position == i);
            }
            if (mViewPagerPageChangeListener != null) {
                mViewPagerPageChangeListener.onPageSelected(position);
            }
            switch (position){
                case 0:
                    Toast list =  Toast.makeText(getContext(), "목록", Toast.LENGTH_SHORT);
                    list.show();
                    break;
                case 1:
                    Toast.makeText(getContext(), "A to Z", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(getContext(), "Q & A", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(getContext(), "추천 앱", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

    }

    private class TabClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                if (v == mTabStrip.getChildAt(i)) {
                    mViewPager.setCurrentItem(i);
                    //tabTitleIcon.setImageResource(getResources().getIdentifier(ClickIcons[i], "drawable", packName));

                    Log.d("shb 클릭한 번째 : ",i+"");
                    return;
                }
            }
        }
    }

}
