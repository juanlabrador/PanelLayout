package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by juanlabrador on 21/09/15.
 */
public class ExtendButtonLayout extends LinearLayout {

    private View mView;
    private LayoutInflater mInflater;
    private TextView mLabel;
    private TextView mContent;
    private ImageView mButton;
    private ImageView mIcon;
    private View mSeparator;

    public ExtendButtonLayout(Context context) {
        super(context);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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

    public void setContent(String text){
        mContent.setText(text);
    }

    public void setContent(int text){
        mContent.setText(text);
    }

    public String getContent() {
        return mContent.getText().toString();
    }

    public void setContentColor(int color) {
        mContent.setTextColor(color);
    }

    public void setTextSize(float size) {
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setColorSeparator(int color) {
        mSeparator.setBackgroundColor(color);
    }

    public void setIconButton(int image){
        mButton.setImageResource(image);
    }

    public void setIcon(int image){
        mIcon.setImageResource(image);
    }
    public void showSeparator(){
        mSeparator.setVisibility(View.VISIBLE);
    }

    private void initialize() {
        mInflater.inflate(R.layout.extend_button_layout, this);
        mView = findViewById(R.id.button_layout);
        mLabel = (TextView) findViewById(R.id.vertical_text_label);
        mContent = (TextView) findViewById(R.id.vertical_content_text);
        mButton = (ImageView) findViewById(R.id.icon_one_button);
        mIcon = (ImageView) findViewById(R.id.icon);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExtendButtonLayout)){
            return false;
        } else {
            return true;
        }
    }

    public void setOnClickListener(OnClickListener o) {
        mView.setOnClickListener(o);
    }
}
