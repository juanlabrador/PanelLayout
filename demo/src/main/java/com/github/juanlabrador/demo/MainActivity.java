package com.github.juanlabrador.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.github.juanlabrador.panellayout.GroupLayout;
import com.github.juanlabrador.panellayout.TextLayout;

public class MainActivity extends Activity {

    private GroupLayout mGroupLayout;
    private TextLayout mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mGroupLayout = (GroupLayout) findViewById(R.id.group);
        mName = mGroupLayout.addTextLayout("Name", "Juan Labrador");
        mGroupLayout.addTextLayout("Age", "23");
        mGroupLayout.addTextLayout("Developed by", "Juan Labrador");

        mName.setLabel("Last Name");
        mName.setContent("Labrador");
    }
}
