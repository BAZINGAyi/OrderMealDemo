package com.example.bazinga.OrderMeal14110100109.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bazinga.OrderMeal14110100109.MainActivity;
import com.example.bazinga.OrderMeal14110100109.R;
import com.example.bazinga.OrderMeal14110100109.base.MVPBaseActivity;
import com.example.bazinga.OrderMeal14110100109.hepler.IntentHelper;
import com.example.bazinga.OrderMeal14110100109.hepler.SecurityClass;
import com.example.bazinga.OrderMeal14110100109.presenter.reg_login.CheckUserLoginPersenter;
import com.example.bazinga.OrderMeal14110100109.view.IShowCheckResultView;

import java.util.Map;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MVPBaseActivity<IShowCheckResultView, CheckUserLoginPersenter> implements IShowCheckResultView {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.passaword)
    EditText passaword;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.registerInfo)
    Button registerInfo;
    @BindView(R.id.remember_switch)
    Switch rememberSwitch;
    private Map<String, Integer> chartData = new TreeMap<String, Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        isFindUserinfo();

        mPresenter.attach(this);

        mPresenter.setContext(getApplicationContext());

    }


    @Override
    protected CheckUserLoginPersenter createPresenter() {
        return new CheckUserLoginPersenter();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1 && resultCode == 2) {

            username.setText(data.getStringExtra("username"));

            passaword.setText(data.getStringExtra("password"));

        }
    }

    @OnClick({R.id.login, R.id.registerInfo})
    void onClickWithwidget(View view) {

        switch (view.getId()) {
            case R.id.login:

                mPresenter.check(username.getText().toString(), passaword.getText().toString(),
                        rememberSwitch.isChecked());

                break;

            case R.id.registerInfo:

                Intent intent1 = new Intent(LoginActivity.this, RegisterActivity.class);

                startActivityForResult(intent1, 1);

                break;

        }
    }


    @Override
    public void showCheckResult(Boolean success) {

        if (success == true) {

            IntentHelper intentHelper = IntentHelper.getIntents();

            intentHelper.startIntent(this, MainActivity.class, null);

            finish();

            Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_LONG).show();
        } else

            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();

    }

    private void isFindUserinfo() {

        rememberSwitch.setChecked(true);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        final String name = prefs.getString(getString(R.string.username), null);
        final String password = SecurityClass.convertMD5(prefs.getString(getString(R.string.password), null));

        if (name != null && passaword != null) {
            username.setText(name);
            passaword.setText(password);
        }
    }
}
