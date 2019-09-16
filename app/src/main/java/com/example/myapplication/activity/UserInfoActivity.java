package com.example.myapplication.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.myapplication.R;

public class UserInfoActivity extends AppCompatActivity {
    private String username;
    private Toolbar toolbar;
    private LinearLayout fLayout,sLayout,tLayout,forthLayout,fifthLayout;
    private TextView usernameContent,nicknameContent,sexContent,signatureContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        final String[] sexArr = new String[]{"男","女"};
        initView();
        initToolbar();
        //从数据库，网络或上一个界面的数据
        initData();
        tLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfoActivity.this,ModifyNicknameActivity.class);
                startActivity(intent);
            }
        });
        forthLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(UserInfoActivity.this);
                dialog.setTitle("性别");
                dialog.setCancelable(false);
                dialog.setSingleChoiceItems(sexArr, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sexContent.setText(sexArr[i]);
                        dialogInterface.dismiss();
                    }
                });
                dialog.show();
            }
        });
        fifthLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserInfoActivity.this,ModifySignatureActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        fLayout =findViewById(R.id.first_layout);
        sLayout = findViewById(R.id.second_layout);
        tLayout = findViewById(R.id.third_layout);
        forthLayout = findViewById(R.id.forth_layout);
        fifthLayout = findViewById(R.id.fifth_layout);
        usernameContent = findViewById(R.id.username_content);
        nicknameContent = findViewById(R.id.nickname_content);
        sexContent = findViewById(R.id.sex_content);
        signatureContent = findViewById(R.id.signature_content);
    }

    private void initToolbar() {
        toolbar = findViewById(R.id.title_bar);
        toolbar.setTitle("个人信息");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserInfoActivity.this.finish();
            }
        });
    }

    private void initData() {

    }
}
