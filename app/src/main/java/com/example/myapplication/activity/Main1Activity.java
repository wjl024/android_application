package com.example.myapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myapplication.fragment.CoursesFragment;
import com.example.myapplication.fragment.ExerciseFragment;
import com.example.myapplication.fragment.GridViewCoursesFragment;
import com.example.myapplication.fragment.MySettingFragment;
import com.example.myapplication.R;
import com.example.myapplication.fragment.PractiseFragment;

import java.security.acl.Group;

import static android.media.CamcorderProfile.get;

public class Main1Activity extends AppCompatActivity {
    private Toolbar toolbar;
    private RadioButton rbHome;
    private RadioButton rbFind;
    private RadioButton rbMy;
    private RadioButton rbWeb;
    private RadioGroup rgNav;
    private SparseArray<String> titles;
    private SparseArray<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initTitles();
        initFragments();

    }

    /**
     * 根据按钮的id设置界面的标题
     * @param checkedId
     */
    private void setToolbar(int checkedId){
        if (checkedId == R.id.rb_my){
            toolbar.setVisibility(View.GONE);
        } else {
            toolbar.setVisibility(View.VISIBLE);
            toolbar.setTitle(titles.get(checkedId));
        }
    }

    private void initFragments() {
        //1.创建fragment列表
        fragments = new SparseArray<>();
        fragments.put(R.id.rb_my, MySettingFragment.newInstance());
        fragments.put(R.id.rb_find, ExerciseFragment.newInstance("Activity向Fragment传值"));
        fragments.put(R.id.rb_home, GridViewCoursesFragment.newInstance());
        //加载默认的fragment
        replaceFragment(fragments.get(R.id.rb_my));
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fragment_main,fragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void initView() {
        rbHome = findViewById(R.id.rb_home);
        rbFind = findViewById(R.id.rb_find);
        rbMy = findViewById(R.id.rb_my);
        rbWeb = findViewById(R.id.rb_web);
        rgNav = findViewById(R.id.radio_main);
        toolbar = findViewById(R.id.title_bar);
        setToolbar(rgNav.getCheckedRadioButtonId());

        //RadioGroup的选项改变事件的监听
        rgNav.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                Toast.makeText(Main1Activity.this,titles.get(i),Toast.LENGTH_SHORT);
                setToolbar(i);
                replaceFragment(fragments.get(i));
            }
        });
    }

    private void initTitles(){
        titles = new SparseArray<>();
        titles.put(R.id.rb_home,"课程");
        titles.put(R.id.rb_find,"习题");
        titles.put(R.id.rb_web,"资讯");
        titles.put(R.id.rb_my,"我的");
    }
}
