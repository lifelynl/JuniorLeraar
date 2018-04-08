package com.hva.tsse.juniorleraar.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Melanie on 21-2-2018.
 */

public class SectionsPagerAdapter extends FragmentPagerAdapter
{
    private final List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private final List<String> mFragmentTitleList = new ArrayList<String>();

    /**
     * Constructor
     * @param fm FragmentManager
     */
    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    /**
     * This method you can add a fragment to the list of tabs
     * @param fragment The fragment you want to add
     * @param title The title of the fragment you want to add
     */
    public void addFragment(Fragment fragment, String title){
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    /**
     * @param position This is the position of the tabs
     * @return the title of the fragment depending on the tab that is selected (position)
     */
    @Override
    public CharSequence getPageTitle(int position){
        return mFragmentTitleList.get(position);
    }

    /**
     * @param position the tab that is selected
     * @return the Fragment which must be loaded depending on the tab that is selected (position)
     */
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    /**
     * @return How many tabs there are
     */
    @Override
    public int getCount() {
        return mFragmentList.size();
    }
}
