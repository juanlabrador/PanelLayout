package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.juanlabrador.panellayout.interfaces.OnChangedContentListener;

/**
 * Created by juanlabrador on 15/09/15.
 */
public class EditTextLayout extends LinearLayout implements View.OnFocusChangeListener {

    private OnChangedContentListener onChangedContentListener = null;
    private LayoutInflater mInflater;
    private TextView mLabel;
    private EditText mContent;
    private View mSeparator;

    public EditTextLayout(Context context) {
        super(context);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
    }

    public void setLabel(String text){
        mLabel.setText(text);
    }

    public void setLabelColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setContent(String text){
        mContent.setText(text);
    }

    public void setLabel(int label) {
        mLabel.setText(label);
    }

    public void setContentColor(int color) {
        mContent.setTextColor(color);
    }

    public void setTextSize(float size) {
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    public void setInputType(int input) {
        mContent.setInputType(input);
    }

    public void setMaxLength(int max) {
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(max);
        mContent.setFilters(filterArray);
    }

    public void showSeparator(){
        mSeparator.setVisibility(View.VISIBLE);
    }

    public void setColorSeparator(int color) {
        mSeparator.setBackgroundColor(color);
    }

    private void initialize() {
        mInflater.inflate(R.layout.edit_text_layout, this);
        mLabel = (TextView) findViewById(R.id.edit_text_label);
        mContent = (EditText) findViewById(R.id.edit_text_content);
        mContent.setOnFocusChangeListener(this);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);

        dataChanged();
    }

    public String getContent() {
        return mContent.getText().toString();
    }

    public void isPassword(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void isNumber(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_CLASS_NUMBER);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void isEmail(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    public void isURL(boolean b) {
        if (b)
            mContent.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_EDIT_TEXT);
        else
            mContent.setInputType(InputType.TYPE_CLASS_TEXT);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EditTextLayout)){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onFocusChange(View view, boolean b) {
        if (!b) {
            mContent.setGravity(Gravity.RIGHT | Gravity.CENTER_VERTICAL);
        } else {
            mContent.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
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
        dataChanged();
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
                    onChangedContentListener.textChanged(editable);
                }
            }
        });
    }
}