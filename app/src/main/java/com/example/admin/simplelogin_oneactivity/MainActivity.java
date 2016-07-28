package com.example.admin.simplelogin_oneactivity;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            return;
        }

        FragmentManager fragment = getSupportFragmentManager();
        fragment.beginTransaction()
                .add(R.id.a_main_frame, new LogIn())
                .commit();
    }
}
