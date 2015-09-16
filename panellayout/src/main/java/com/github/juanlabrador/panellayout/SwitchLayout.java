package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.juanlabrador.panellayout.switchbutton.Configuration;
import com.github.juanlabrador.panellayout.switchbutton.SwitchButton;


/**
 * Created by juanlabrador on 16/09/15.
 */
public class SwitchLayout extends LinearLayout {

    private LayoutInflater mLayoutInflater;
    private TextView mLabel;
    private SwitchButton mSwitch;
    private View separator;
    private Configuration mConfiguration;

    public SwitchLayout(Context context) {
        super(context);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
    }

    public void setLabel(String label){
        mLabel.setText(label);
    }

    public void setLabel(int text) {
        mLabel.setText(text);
    }

    public void setLabelColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setLabelSize(float size) {
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setSwitchColor(int color) {
        mConfiguration = mSwitch.getConfiguration();
        mConfiguration.setOnDrawable(getDrawableFromColor(color));
        mSwitch.setConfiguration(mConfiguration);
    }

    public void setChecked(boolean checked) {
        mSwitch.setChecked(checked);
    }

    public boolean isChecked() {
        return mSwitch.isChecked();
    }

    public void onCheckedChangeListener(CompoundButton.OnCheckedChangeListener o) {
        mSwitch.setOnCheckedChangeListener(o);
    }

    public void setColorSeparator(int color) {
        separator.setBackgroundColor(color);
    }

    public void showSeparator(){
        separator.setVisibility(View.VISIBLE);
    }

    private void initialize() {
        mLayoutInflater.inflate(R.layout.switch_layout, this);
        mLabel = (TextView) findViewById(R.id.switch_label);
        mSwitch = (SwitchButton) findViewById(R.id.switch_button);
        separator = findViewById(R.id.separator);
        separator.setVisibility(View.GONE);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SwitchLayout)){
            return false;
        } else {
            return true;
        }
    }

    private Drawable getDrawableFromColor(int color) {
        GradientDrawable tempDrawable = new GradientDrawable();
        tempDrawable.setCornerRadius(999);
        tempDrawable.setColor(color);
        return tempDrawable;
    }
}
