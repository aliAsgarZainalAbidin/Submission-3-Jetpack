package com.example.sub2jetpack.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.sub2jetpack.R;
import com.example.sub2jetpack.ui.HomeFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, new HomeFragment(), HomeFragment.class.getSimpleName())
                .commit();
    }

}
