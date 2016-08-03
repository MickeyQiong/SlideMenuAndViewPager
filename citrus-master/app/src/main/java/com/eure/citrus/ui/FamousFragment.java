package com.eure.citrus.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.eure.citrus.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016-8-3.
 */
public class FamousFragment extends Fragment {

    @Bind(R.id.createtask)
    Button button;

    public FamousFragment() {
    }

    public static FamousFragment newInstance(){
        return new FamousFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_famous,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick(R.id.createtask)
    public void createTask(){
        Intent intent = new Intent(getActivity(),CreateNewTaskActivity.class);
        startActivity(intent);
    }
}
