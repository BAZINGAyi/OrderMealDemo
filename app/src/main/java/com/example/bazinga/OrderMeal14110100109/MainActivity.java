package com.example.bazinga.OrderMeal14110100109;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.fragment.IndexFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.PersonalFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.PreferenceDataFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.SearchFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.bing_pic_img)
    ImageView bingPicImg;
    @BindView(R.id.nav_button)
    Button navButton;
    @BindView(R.id.Restaurant_name)
    TextView RestaurantName;
    @BindView(R.id.title_update_time)
    TextView titleUpdateTime;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navView;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setInternalSystemState();

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initEvent();

        Glide.with(this).load("http://cn.bing.com/az/hprichbg/rb/HenequenCactus_ZH-CN11794616839_1920x1080.jpg").into(bingPicImg);

        navButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        setSelect(0);

    }

    private void initEvent() {

        navView.setNavigationItemSelectedListener(this);
    }


    private void setSelect(int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i) {
            case 0:
                if (mTab01 == null) {
                    mTab01 = new IndexFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else {
                    transaction.show(mTab01);
                }

                break;
            case 1:
                if (mTab02 == null) {
                    mTab02 = new SearchFragment();
                    transaction.add(R.id.id_content, mTab02);
                } else {
                    transaction.show(mTab02);

                }


                break;
            case 2:

                if (mTab03 == null) {
                    mTab03 = new PreferenceDataFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else {
                    transaction.show(mTab03);
                }


                break;
            case 3:
                if (mTab04 == null) {
                    mTab04 = new PersonalFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else {
                    transaction.show(mTab04);
                }

                break;

            default:
                break;
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (mTab01 != null) {
            transaction.hide(mTab01);
        }
        if (mTab02 != null) {
            transaction.hide(mTab02);
        }
        if (mTab03 != null) {
            transaction.hide(mTab03);
        }
        if (mTab04 != null) {
            transaction.hide(mTab04);
        }
    }


    private void setInternalSystemState() {

        if (Build.VERSION.SDK_INT >= 21) {

            View decorView = getWindow().getDecorView();

            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

            getWindow().setStatusBarColor(Color.TRANSPARENT);
        } else {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            //全屏
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_index) {

            item.setChecked(true);

            setSelect(0);

        } else if (id == R.id.nav_search) {

            item.setChecked(true);

            setSelect(1);

        } else if (id == R.id.nav_collection) {

            item.setChecked(true);

            setSelect(2);

        } else if (id == R.id.nav_my) {

            item.setChecked(true);

            setSelect(3);

        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
