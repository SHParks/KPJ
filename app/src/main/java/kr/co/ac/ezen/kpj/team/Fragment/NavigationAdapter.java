package kr.co.ac.ezen.kpj.team.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.github.ksoichiro.android.observablescrollview.CacheFragmentStatePagerAdapter;

import kr.co.ac.ezen.kpj.team.Fragment.QnA.Index;


/**
 * Created by Administrator on 2018-02-07.
 */

public class NavigationAdapter extends CacheFragmentStatePagerAdapter {

    private static final String[] TITLES = new String[]{"목록", "따라하기","QnA","추천앱"};
    private static final String[] Icons = new String[]{"kakaotalk","kakaomap","naver","metro"};

    private int mScrollY;

    public NavigationAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setScrollY(int scrollY) {
        mScrollY = scrollY;
    }

    @Override
    protected Fragment createItem(int position) {
        // Initialize fragments.
        // Please be sure to pass scroll position to each fragments using setArguments.
        Fragment f;

        final int pattern = position % 4;
        switch (pattern) {
            case 0: {
                f = new ItemList();
                if (0 <= mScrollY) {
                    Bundle args = new Bundle();
                }
                break;
            }
            case 1: {
                f = new Follow();
                if (0 < mScrollY) {
                    Bundle args = new Bundle();
                }
                break;
            }
            case 2: {
                f = new Index();
                if (0 < mScrollY) {
                    Bundle args = new Bundle();
                }
                break;
            }

            case 3:
            default: {
                f = new RecommendApp();
                if (0 < mScrollY) {
                    Bundle args = new Bundle();
                }
                break;
            }
        }
        return f;
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    public CharSequence getPageImage(int position) {
        return Icons[position];
    }

}
