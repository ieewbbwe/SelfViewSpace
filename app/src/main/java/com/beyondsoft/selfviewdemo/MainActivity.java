package com.beyondsoft.selfviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.beyondsoft.selfviewdemo.view.CustomerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CustomerView mCv = (CustomerView) findViewById(R.id.m_cv);
    }
}
