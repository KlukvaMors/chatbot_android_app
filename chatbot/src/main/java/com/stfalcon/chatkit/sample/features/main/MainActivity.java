package com.stfalcon.chatkit.sample.features.main;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.stfalcon.chatkit.sample.R;
import com.stfalcon.chatkit.sample.features.demo.def.DefaultMessagesActivity;
import com.stfalcon.chatkit.sample.features.main.adapter.DemoCardFragment;
import com.stfalcon.chatkit.sample.features.main.adapter.MainActivityPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/*
 * Created by troy379 on 04.04.17.
 */
public class MainActivity extends AppCompatActivity
        implements DemoCardFragment.OnActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MainActivityPagerAdapter(this, getSupportFragmentManager()));
        pager.setPageMargin((int) getResources().getDimension(R.dimen.card_padding) / 4);
        pager.setOffscreenPageLimit(3);

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);

    }

    @Override
    public void onAction(String token) {
        DefaultMessagesActivity.open(this, token);
    }
}
