package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by juanlabrador on 15/09/15.
 */
public class TextLayout extends LinearLayout {

    private LayoutInflater mLayoutInflater;
    private TextView mLabel;
    private TextView mContent;
    private View mSeparator;


    public TextLayout(Context context) {
        super(context);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
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

    public String getLabel() {
        return mLabel.getText().toString();
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
        mLayoutInflater.inflate(R.layout.text_layout, this);
        mLabel = (TextView) findViewById(R.id.text_label);
        mContent = (TextView) findViewById(R.id.text_content);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof TextLayout)){
            return false;
        } else {
            return true;
        }
    }
}
