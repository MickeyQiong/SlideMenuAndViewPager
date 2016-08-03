package com.eure.citrus.ui.main_fragment;

import com.eure.citrus.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

import static butterknife.ButterKnife.findById;

/**
 * Created by katsuyagoto on 15/06/19.
 */
public class GroupsFragment extends Fragment {

    public GroupsFragment() {
    }

    public static GroupsFragment newInstance() {
        return new GroupsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

}
