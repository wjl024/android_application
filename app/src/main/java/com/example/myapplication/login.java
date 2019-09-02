package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.EditText;

public class login extends AppCompatActivity {
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editText.findViewById(R.id.user_name);
        Drawable left = getResources().getDrawable(R.drawable.see_user);
        left.setBounds(0,0,40,40);
        editText.setCompoundDrawables(left,null,null,null);
    }
}
