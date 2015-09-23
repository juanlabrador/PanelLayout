package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.github.juanlabrador.panellayout.interfaces.OnChangedContentListener;

/**
 * Created by juanlabrador on 15/09/15.
 */
public class MultiEditTextLayout extends LinearLayout {

    private OnChangedContentListener onChangedContentListener = null;
    private LayoutInflater mLayoutInflater;
    private EditText mContent;
    private View mSeparator;

    public MultiEditTextLayout(Context context) {
        super(context);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
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

    public void setHint(String text) {
        mContent.setHint(text);
    }

    public void setHint(int text) {
        mContent.setHint(text);
    }

    public void setInputType(int input) {
        mContent.setInputType(input);
    }

    public void setMaxLength(int max) {
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(max);
        mContent.setFilters(filterArray);
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
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void initialize() {
        mLayoutInflater.inflate(R.layout.multi_edit_text_layout, this);
        mContent = (EditText) findViewById(R.id.multi_edit_text_content);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);

        dataChanged();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MultiEditTextLayout)){
            return false;
        } else {
            return true;
        }
    }

    /**
     *
     * @return num
     */
    public int hashCode() {
        return mContent.hashCode();
    }

    /**
     * Listener when text type is changed
     * @param listener
     */
    public void setOnChangedContentListener(OnChangedContentListener listener) {
        onChangedContentListener = listener;
    }
    private void dataChanged() {
        mContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (onChangedContentListener != null) {
                    onChangedContentListener.afterTextChanged(editable);
                }
            }
        });
    }
}
