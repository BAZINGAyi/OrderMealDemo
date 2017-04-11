package com.example.bazinga.OrderMeal14110100109;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.bazinga.OrderMeal14110100109.fragment.SearchFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.IndexFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.PersonalFragment;
import com.example.bazinga.OrderMeal14110100109.fragment.PreferenceDataFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout index_LinearLayout;
    private LinearLayout search_LinearLayout;
    private LinearLayout collectionData_LinearLayout;
    private LinearLayout personal_LinearLaout;

    private ImageButton mImgIndex;
    private ImageButton mImgSearch;
    private ImageButton mImgCollectionData;
    private ImageButton mImgPersonal;

    private Fragment mTab01;
    private Fragment mTab02;
    private Fragment mTab03;
    private Fragment mTab04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        initView();

        initEvent();

        setSelect(0);

    }

    private void initEvent()
    {
        index_LinearLayout.setOnClickListener(this);

        search_LinearLayout.setOnClickListener(this);

        collectionData_LinearLayout.setOnClickListener(this);

        personal_LinearLaout.setOnClickListener(this);
    }

    private void initView()
    {
        index_LinearLayout = (LinearLayout) findViewById(R.id.id_tab_index);

        search_LinearLayout = (LinearLayout) findViewById(R.id.id_tab_search);

        collectionData_LinearLayout = (LinearLayout) findViewById(R.id.id_tab_collectiondata);

        personal_LinearLaout = (LinearLayout) findViewById(R.id.id_tab_personal);

        mImgIndex = (ImageButton)  findViewById(R.id.id_tab_index_img);

        mImgSearch = (ImageButton) findViewById(R.id.id_tab_search_img);

        mImgCollectionData = (ImageButton) findViewById(R.id.id_tab_collectiondata_img);

        mImgPersonal = (ImageButton) findViewById(R.id.id_tab_persional_img);

    }

    private void setSelect(int i)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);

        switch (i)
        {
            case 0:
                if (mTab01 == null)
                {
                    mTab01 = new IndexFragment();
                    transaction.add(R.id.id_content, mTab01);
                } else
                {
                    transaction.show(mTab01);
                }

                mImgIndex.setImageResource(R.drawable.tab_index_pressed);

                break;
            case 1:
                if (mTab02 == null)
                {
                    mTab02 = new SearchFragment();transaction.add(R.id.id_content, mTab02);
                } else
                {
                    transaction.show(mTab02);

                }

                mImgSearch.setImageResource(R.drawable.tab_collectiondata_pressed);

                break;
            case 2:
                if (mTab03 == null)
                {
                    mTab03 = new PreferenceDataFragment();
                    transaction.add(R.id.id_content, mTab03);
                } else
                {
                    transaction.show(mTab03);
                }

                mImgCollectionData.setImageResource(R.drawable.tab_personal_pressed);

                break;
            case 3:
                if (mTab04 == null)
                {
                    mTab04 = new PersonalFragment();
                    transaction.add(R.id.id_content, mTab04);
                } else
                {
                    transaction.show(mTab04);
                }

                mImgPersonal.setImageResource(R.drawable.tab_search_pressed);
                break;

            default:
                break;
        }

        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction)
    {
        if (mTab01 != null)
        {
            transaction.hide(mTab01);
        }
        if (mTab02 != null)
        {
            transaction.hide(mTab02);
        }
        if (mTab03 != null)
        {
            transaction.hide(mTab03);
        }
        if (mTab04 != null)
        {
            transaction.hide(mTab04);
        }
    }

    @Override
    public void onClick(View v)
    {
        resetImgs();
        switch (v.getId())
        {
            case R.id.id_tab_index:
                setSelect(0);
                break;
            case R.id.id_tab_search:
                setSelect(1);
                break;
            case R.id.id_tab_collectiondata:
                setSelect(2);
                break;
            case R.id.id_tab_personal:
                setSelect(3);
                break;

            default:
                break;
        }
    }


    private void resetImgs()
    {
        mImgIndex.setImageResource(R.drawable.tab_index_normal);

        mImgSearch.setImageResource(R.drawable.tab_collectiondata_normal);

        mImgCollectionData.setImageResource(R.drawable.tab_personal_normal);

        mImgPersonal.setImageResource(R.drawable.tab_search_normal);
    }

}
