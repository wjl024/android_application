package com.example.myapplication.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.R;

public class ModifyNicknameActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editNickname;
    private ImageView clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_nickname);
        initToolbar();
        initView();
        String nickname = editNickname.getText().toString();
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNickname.setText("");
            }
        });
    }

    private void initView() {
        editNickname = findViewById(R.id.edit_nickname);
        clear = findViewById(R.id.clear_nickname);
    }

    private void initToolbar(){
        toolbar = findViewById(R.id.title_bar);
        toolbar.setTitle("设置昵称");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModifyNicknameActivity.this.finish();
            }
        });
    }
}
