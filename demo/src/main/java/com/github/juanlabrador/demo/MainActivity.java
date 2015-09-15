package com.github.juanlabrador.demo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Toast;

import com.github.juanlabrador.panellayout.EditTextLayout;
import com.github.juanlabrador.panellayout.GroupLayout;
import com.github.juanlabrador.panellayout.TextLayout;

public class MainActivity extends Activity {

    private GroupLayout mGroupLayout;
    private GroupLayout mGroupLayout2;
    private EditTextLayout mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mGroupLayout = (GroupLayout) findViewById(R.id.group);
        mGroupLayout.addTextLayout("Name", "Juan Labrador");
        mGroupLayout.addTextLayout("Age", "23");
        mGroupLayout.addTextLayout("Developed by", "Juan Labrador");

        mGroupLayout2 = (GroupLayout) findViewById(R.id.group2);
        mGroupLayout2.addEditTextLayout("Username");
        mPassword = mGroupLayout2.addEditTextLayout("Password");
        //mPassword.isPassword(true);
        //mPassword.isNumber(true);
    }
}
