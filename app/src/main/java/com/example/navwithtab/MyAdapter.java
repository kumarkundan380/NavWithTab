package com.example.navwithtab;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static com.example.navwithtab.TabFragment.int_item;

public class MyAdapter extends FragmentPagerAdapter
{
    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new NoticeFragment();
            case 1:
                return new PdfFragment();
            case 2:
                return new JobFragment();
        }
        return null;
    }

    @Override
    public int getCount() {

        return int_item;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "Notice";
            case 1:
                return "PDF'S";
            case 2:
                return "JOBS";
        }
        return null;
    }
}
