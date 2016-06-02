package com.ducnv57.accountmanager;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ducnv57.accountmanager.Fragment.Account;
import com.ducnv57.accountmanager.Fragment.History;
import com.ducnv57.accountmanager.Fragment.Stats;
import com.ducnv57.accountmanager.introApp.Intro;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo 1 biến boolean, kiểm tra xem có phải lần đầu tiên mở app hay không để show Intro
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", false);
        if (isFirstRun == false) {
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", true).commit();
            Intent intro = new Intent(getBaseContext(), Intro.class);
            startActivity(intro);
            finish();
        }
        // SỬ DỤNG VIEWPAGER + TABHOST
        // SỬ DỤNG LIB https://github.com/ogaclejapan/SmartTabLayout

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add(R.string.account, Account.class)
                .add(R.string.history, History.class)
                .add(R.string.stats, Stats.class)
                .create());

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);

    }
}
