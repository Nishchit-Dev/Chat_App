package com.boxaffects.chat_app.MainActivity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter  extends FragmentPagerAdapter {
    private Fragment frag[] ;
    private String Title [] = {"Chats","Call History"};

    public ViewPagerAdapter(FragmentManager fm){
        super(fm);
        frag = new Fragment[]{
                new Chats_frag(),
                new Call_History()
        };
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return Title[position];
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return frag[position];
    }

    @Override
    public int getCount() {
        return Title.length;
    }
}
