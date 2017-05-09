package com.example.bazinga.OrderMeal14110100109.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.MainActivity;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.MVPBaseActivity;
import com.example.bazinga.OrderMeal14110100109.hepler.FileterHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.IntentHelper;
import com.example.bazinga.OrderMeal14110100109.presenter.reg_login.CheckUserRegisterPresenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowCheckResultView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RegisterActivity extends MVPBaseActivity<IShowCheckResultView, CheckUserRegisterPresenter>
        implements IShowCheckResultView {


    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.passaword)
    EditText passaword;
    @BindView(R.id.passawordTwo)
    EditText passawordTwo;
    @BindView(R.id.edit_phone)
    EditText editPhone;
    @BindView(R.id.edit_comment)
    EditText editComment;
    @BindView(R.id.registerButton)
    Button registerButton;
    @BindView(R.id.edit_address)
    EditText editAddress;
    @BindView(R.id.activity_login)
    RelativeLayout activityLogin;

    Map<String,String> usersInfo = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ButterKnife.bind(this);

        mPresenter.attach(this);

        mPresenter.attchView(this);

        mPresenter.setMyContext(this);

        initClick();
    }

    @Override
    protected CheckUserRegisterPresenter createPresenter() {
        return new CheckUserRegisterPresenter();
    }


    private void initClick() {

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usersInfo.put(getString(R.string.reg_name_key),(username.getText().toString()));

                usersInfo.put(getString(R.string.reg_password_key),(passaword.getText().toString()));

                usersInfo.put(getString(R.string.reg_twopassword_key),(passawordTwo.getText().toString()));

                usersInfo.put(getString(R.string.reg_address_key),(editAddress.getText().toString()));

                usersInfo.put(getString(R.string.reg_comment_key),(editComment.getText().toString()));

                usersInfo.put(getString(R.string.reg_phone_key),(editPhone.getText().toString()));

                mPresenter.register(usersInfo);
            }
        });
    }


    @Override
    public void showCheckResult(Boolean success) {

        if (success == true) {

            Toast.makeText(RegisterActivity.this, getString(R.string.success_info), Toast.LENGTH_LONG).show();

            finish();
        } else

            Toast.makeText(RegisterActivity.this, getString(R.string.error_info), Toast.LENGTH_LONG).show();

    }
}
