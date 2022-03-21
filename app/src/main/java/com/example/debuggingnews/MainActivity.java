package com.example.debuggingnews;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome,msports,mhealth,mscience,mentertainment,mtech;
    PagerAdapter pagerAdapter;
     Toolbar mtoolbar;

    String api="c36f30fe760f4d8b8b4e271b92ac3a46";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       setSupportActionBar(findViewById(R.id.toolbar));

        mhome=findViewById(R.id.Home);
        msports=findViewById(R.id.Sports);
        mhealth=findViewById(R.id.Health);
        mscience=findViewById(R.id.Science);
        mentertainment=findViewById(R.id.Entertain);
        mtech=findViewById(R.id.Technology);

        ViewPager viewPager=findViewById(R.id.fragmentcontainer);
        tabLayout=findViewById(R.id.include);

        pagerAdapter=new PageAdapter(getSupportFragmentManager(),6);
              viewPager.setAdapter(pagerAdapter);


              tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                  @Override
                  public void onTabSelected(TabLayout.Tab tab) {
                      viewPager.setCurrentItem(tab.getPosition());
                      if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5){
                          pagerAdapter.notifyDataSetChanged();
                      }
                  }

                  @Override
                  public void onTabUnselected(TabLayout.Tab tab) {

                  }

                  @Override
                  public void onTabReselected(TabLayout.Tab tab) {

                  }
              });
           viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            }


}