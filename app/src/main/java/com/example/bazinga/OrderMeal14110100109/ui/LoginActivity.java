package com.example.bazinga.OrderMeal14110100109.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.bazinga.OrderMeal14110100109.MainActivity;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.Constants;
import com.example.bazinga.OrderMeal14110100109.base.MVPBaseActivity;
import com.example.bazinga.OrderMeal14110100109.hepler.DialogHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.IntentHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.ResourceHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.SecurityClass;
import com.example.bazinga.OrderMeal14110100109.presenter.reg_login.CheckUserLoginPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowCheckResultView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MVPBaseActivity<IShowCheckResultView, CheckUserLoginPersenter> implements IShowCheckResultView {
    // 开启 Intent 的注册参数
    private static final int REIGISTER_SUCCESS = 1;

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.passaword)
    EditText passaword;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.registerInfo)
    Button registerInfo;
    @BindView(R.id.remember_switch)
    Switch rememberSwitch;
    @BindView(R.id.bing_pic_img)
    ImageView bingPicImg;
    @BindView(R.id.content_main)
    FrameLayout contentMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        isFindUserinfo();

        mPresenter.attach(this);

        mPresenter.setContext(getApplicationContext());

        Glide.with(this).
                load(Constants.BG_URL)
                .into(bingPicImg);

    }


    @Override
    protected CheckUserLoginPersenter createPresenter() {
        return new CheckUserLoginPersenter();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REIGISTER_SUCCESS && resultCode == RegisterActivity.RETURN_Register_Success) {
            if (data != null) {
                username.setText(data.getStringExtra(getString(R.string.name)));
                passaword.setText(data.getStringExtra(getString(R.string.password)));
            }
        }
    }

    @OnClick({R.id.login, R.id.registerInfo})
    void onClickWithwidget(View view) {

        switch (view.getId()) {
            case R.id.login:

                mPresenter.check(username.getText().toString(), passaword.getText().toString(),
                        rememberSwitch.isChecked());
                // 开启对话框
                setDialog(getString(R.string.loading));
                break;

            case R.id.registerInfo:

                Intent intentStartActivity = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(intentStartActivity, REIGISTER_SUCCESS);
                break;

        }
    }


    @Override
    public void showCheckResult(Boolean success) {
        // 关闭对话框
        closeDialog();

        if (success == true) {
            IntentHelper intentHelper = IntentHelper.getIntents();
            intentHelper.startIntent(this, MainActivity.class, null);
            finish();
            Toast.makeText(LoginActivity.this, getString(R.string.LoginSuccessHint), Toast.LENGTH_LONG).show();
        } else{
            Toast.makeText(LoginActivity.this, getString(R.string.LoginFailHint), Toast.LENGTH_LONG).show();

        }

    }

    private void isFindUserinfo() {

        rememberSwitch.setChecked(true);

        SharedPreferences prefs = ResourceHelper.getSharePreferences(this);
        final String name = prefs.getString(getString(R.string.username), null);
        final String password = SecurityClass.convertMD5(prefs.getString(getString(R.string.password), null));

        if (name != null && passaword != null) {
            username.setText(name);
            passaword.setText(password);

        }
    }
}
