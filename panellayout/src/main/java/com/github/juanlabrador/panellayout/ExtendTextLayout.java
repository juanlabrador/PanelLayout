package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Extend Layout is a view with label above of content and icon left
 * Created by juanlabrador on 16/09/15.
 */
public class ExtendTextLayout extends LinearLayout {

    private LayoutInflater mLayoutInflater;
    private TextView mLabel;
    private TextView mContent;
    private ImageView mIcon;
    private View mSeparator;


    public ExtendTextLayout(Context context) {
        super(context);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
    }

    public void setIcon(int icon) {
        mIcon.setBackgroundResource(icon);
    }

    public void setLabel(String text){
        mLabel.setText(text);
    }

    public void setLabel(int text) {
        mLabel.setText(text);
    }

    public void setLabelColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setContent(String text){
        mContent.setText(text);
    }

    public void setContent(int text){
        mContent.setText(text);
    }

    public void setContentColor(int color) {
        mContent.setTextColor(color);
    }

    public String getContent() {
        return mContent.getText().toString();
    }

    public void showSeparator(){
        mSeparator.setVisibility(View.VISIBLE);
    }

    public void setColorSeparator(int color) {
        mSeparator.setBackgroundColor(color);
    }

    public void setTextSize(float size) {
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    private void initialize() {
        mLayoutInflater.inflate(R.layout.extend_text_layout, this);
        mLabel = (TextView) findViewById(R.id.extend_text_label);
        mContent = (TextView) findViewById(R.id.extend_content_text);
        mIcon = (ImageView) findViewById(R.id.icon);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExtendTextLayout)){
            return false;
        } else {
            return true;
        }
    }
}

