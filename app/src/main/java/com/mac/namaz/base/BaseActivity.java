package com.mac.namaz.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    abstract int getLayout();

    protected void beforeInit(@Nullable Bundle savedInstanceState){}
    protected void init(@Nullable Bundle savedInstanceState){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        beforeInit(savedInstanceState);

        setContentView(getLayout());

        init(savedInstanceState);

    }
}
