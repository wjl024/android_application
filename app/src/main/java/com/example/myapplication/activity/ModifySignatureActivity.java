package com.example.myapplication.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.R;

public class ModifySignatureActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText editSignature;
    private ImageView clearImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_signature);
        initView();
        initToolBar();
        String signature = editSignature.getText().toString();
        clearImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editSignature.setText("");
            }
        });
    }

    private void initToolBar() {
        toolbar = findViewById(R.id.title_bar);
        toolbar.setTitle("设置签名");
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ModifySignatureActivity.this.finish();
            }
        });
    }

    private void initView() {
        editSignature = findViewById(R.id.edit_signature);
        clearImage = findViewById(R.id.clear_signature);
    }
}
