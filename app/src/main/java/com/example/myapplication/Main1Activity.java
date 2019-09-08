package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Main1Activity extends AppCompatActivity {
    private RadioButton rbHome;
    private RadioButton rbFind;
    private RadioButton rbMy;
    private RadioGroup rgNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        String nav;
        int id = rgNav.getCheckedRadioButtonId();
        if (id==R.id.rb_home){
            rbHome.setChecked(true);
            rbFind.setChecked(false);
            rbMy.setChecked(false);
        } else if (id == R.id.rb_find){
            rbFind.setChecked(false);
            rbHome.setChecked(true);
            rbMy.setChecked(false);
        } else if (id==R.id.rb_my){
            rbMy.setChecked(true);
            rbHome.setChecked(false);
            rbFind.setChecked(false);
        }
    }

    private void initView() {
        rbHome = findViewById(R.id.rb_home);
        rbFind = findViewById(R.id.rb_find);
        rbMy = findViewById(R.id.rb_my);
        rgNav = findViewById(R.id.radio_main);
    }
}
