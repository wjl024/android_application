package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.utils.MD5Utils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText lgUsername,lgPassword;
    private Button btnLogin;
    private TextView registerNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lgUsername = findViewById(R.id.login_user_name);
        lgPassword = findViewById(R.id.login_password);
        btnLogin = findViewById(R.id.login_btn);
        registerNow = findViewById(R.id.register_now);
        registerNow.setOnClickListener(this);
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        lgUsername.setText(username);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = lgUsername.getText().toString();
                String password = lgPassword.getText().toString();
                SharedPreferences pref = getSharedPreferences("data",MODE_PRIVATE);
                String mdPassword = pref.getString("password","");
                if (TextUtils.isEmpty(password)){
                    Toast.makeText(LoginActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
                } else if (!mdPassword.equals(MD5Utils.md5(password))){
                    Toast.makeText(LoginActivity.this,"密码或用户名无效",Toast.LENGTH_SHORT).show();
                } else {
                    final ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setMessage("登录中");
                    progressDialog.setCancelable(true);
                    progressDialog.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable(){
                        @Override
                        public void run(){
                            progressDialog.dismiss();
                            Intent intent1 = new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent1);
                        }
                    },5000);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        //处理register的监听
        Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(intent);
    }
}
