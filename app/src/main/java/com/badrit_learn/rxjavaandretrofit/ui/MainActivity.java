package com.badrit_learn.rxjavaandretrofit.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.badrit_learn.rxjavaandretrofit.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new MyFragment())
                .commit();
    }
}
