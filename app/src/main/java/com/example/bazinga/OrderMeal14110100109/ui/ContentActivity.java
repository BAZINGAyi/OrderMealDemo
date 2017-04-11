package com.example.bazinga.OrderMeal14110100109.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.bazinga.OrderMeal14110100109.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContentActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.passaword)
    EditText passaword;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);

        initClick();


    }

    private void initClick() {

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();

                intent.putExtra("username",username.getText().toString());

                intent.putExtra("password",passaword.getText().toString());

                setResult(2,intent);

                finish();
            }
        });
    }

    private void getUserInfo() {

        String name = username.getText().toString();

        String pass = passaword.getText().toString();

    }
}
