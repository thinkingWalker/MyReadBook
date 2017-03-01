package com.lxr.myreadbook.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lxr.myreadbook.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/3/1  12:39
 *
 * @desc
 */

public class SplashActivity extends AppCompatActivity {

    @Bind(R.id.tvSkip)
    TextView tvSkip;
    private Runnable runnable;
    private boolean flag;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);

        runnable = new Runnable() {
            @Override
            public void run() {
                goHome();
            }
        };


        tvSkip.postDelayed(runnable, 2000);


        tvSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goHome();
            }
        });
    }

    private void goHome() {
        if (!flag) {
            flag = true;
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flag = true;
        tvSkip.removeCallbacks(runnable);
        ButterKnife.unbind(this);
    }
}
