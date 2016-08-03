package com.eure.citrus.ui;

import com.eure.citrus.R;
import com.eure.citrus.Utils;
import com.eure.citrus.helper.GroupHelper;
import com.eure.citrus.listener.OnCanSetLayoutParamsListener;
import com.eure.citrus.ui.main_fragment.ListsFragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.OnClick;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

import static butterknife.ButterKnife.findById;

public class GroupDetailActivity extends AppCompatActivity {

    private static final String KEY_GROUP_NAME = "key_group_name";

    private static final int REQUEST_CREATE_TASK_ACTIVITY = 1000;

    private String mGroupName;

    private ListsFragment mListsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_detail);
        ButterKnife.bind(this);
        Toolbar toolbar = findById(this, R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent intent = getIntent();
        mGroupName = intent.getStringExtra(KEY_GROUP_NAME);

        CollapsingToolbarLayout collapsingToolbar = findById(this, R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(mGroupName);
        collapsingToolbar.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));
        collapsingToolbar.setExpandedTitleColor(getResources().getColor(android.R.color.white));

        ImageView headerImageView = findById(this, R.id.backdrop);
        GroupHelper.setupDefaultGroupImage(mGroupName, headerImageView);

        mListsFragment = ListsFragment.newInstance(mGroupName);
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction()
                .replace(R.id.group_detail_container, mListsFragment)
                .commit();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent createIntent(Context context, String groupName) {
        Intent intent = new Intent(context, GroupDetailActivity.class);
        intent.putExtra(KEY_GROUP_NAME, groupName);
        return intent;
    }
}
