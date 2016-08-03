package com.eure.citrus.ui.main_fragment;

import com.eure.citrus.R;
import com.eure.citrus.helper.GroupHelper;
import com.eure.citrus.ui.adapter.GroupsPagerAdapter;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

import static butterknife.ButterKnife.findById;

/**
 * Created by katsuyagoto on 15/06/18.
 */
public class HomeFragment extends Fragment  {

    public HomeFragment() {
    }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = findById(view, R.id.tab_layout);
        ViewPager viewPager = findById(view, R.id.groups_viewpager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        final GroupsPagerAdapter adapter = new GroupsPagerAdapter(getChildFragmentManager());
        adapter.addCategory(GroupHelper.INTORDUCTION);
        adapter.addCategory(GroupHelper.FAMOUS_PERSON);
        adapter.addCategory(GroupHelper.INFOMATION);
        adapter.addCategory(GroupHelper.INTERACTION);
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
