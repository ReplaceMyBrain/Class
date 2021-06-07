package com.aoslec.tablayouttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab1 Item <<<<").setIcon(android.R.drawable.ic_dialog_email));
        tabLayout.addTab(tabLayout.newTab().setText("Tab2 Item <<<<").setIcon(android.R.drawable.ic_dialog_dialer));
        tabLayout.addTab(tabLayout.newTab().setText("Tab3 Item <<<<").setIcon(android.R.drawable.ic_dialog_map));
        tabLayout.addTab(tabLayout.newTab().setText("Tab4 Item <<<<").setIcon(android.R.drawable.ic_dialog_info));

        ViewPager viewPager = findViewById(R.id.pager);
        PagerAdapter pagerAdapter = new TabPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());

        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}