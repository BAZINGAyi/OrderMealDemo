package com.example.bazinga.OrderMeal14110100109.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.base.MVPBaseActivity;
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

    Map<String, String> usersInfo = new HashMap<>();
    // 返回给 LoginActivity 的返回值
    public static int RETURN_Register_Success = 2;
    @BindView(R.id.bing_pic_img)
    ImageView bingPicImg;
    @BindView(R.id.content_main)
    FrameLayout contentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);

        mPresenter.attach(this);

        mPresenter.attchView(this);

        mPresenter.setContext(this);

        initClick();

        Glide.with(this).
                load(Constants.BG_URL)
                .into(bingPicImg);
    }

    @Override
    protected CheckUserRegisterPresenter createPresenter() {
        return new CheckUserRegisterPresenter();
    }


    private void initClick() {

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersInfo.put(getString(R.string.reg_name_key), (username.getText().toString()));
                usersInfo.put(getString(R.string.reg_password_key), (passaword.getText().toString()));
                usersInfo.put(getString(R.string.reg_twopassword_key), (passawordTwo.getText().toString()));
                usersInfo.put(getString(R.string.reg_address_key), (editAddress.getText().toString()));
                usersInfo.put(getString(R.string.reg_comment_key), (editComment.getText().toString()));
                usersInfo.put(getString(R.string.reg_phone_key), (editPhone.getText().toString()));
                mPresenter.register(usersInfo);

            }
        });
    }


    @Override
    public void showCheckResult(Boolean success) {

        if (success == true) {
            Toast.makeText(RegisterActivity.this, getString(R.string.success_info), Toast.LENGTH_LONG).show();
            Intent returnIntent = new Intent();
            returnIntent.putExtra(getString(R.string.name), username.getText().toString());
            returnIntent.putExtra(getString(R.string.password), passaword.getText().toString());
            setResult(RETURN_Register_Success, returnIntent);
            finish();
        } else {
            Toast.makeText(RegisterActivity.this, getString(R.string.error_info), Toast.LENGTH_LONG).show();

        }
    }
}
