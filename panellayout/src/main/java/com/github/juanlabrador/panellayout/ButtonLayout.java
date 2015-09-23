package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.juanlabrador.panellayout.interfaces.OnEmptyContentListener;

/**
 * Created by juanlabrador on 16/09/15.
 */
public class ButtonLayout extends LinearLayout {

    private OnEmptyContentListener onEmptyContentListener = null;
    private View mView;
    private LayoutInflater mInflater;
    private TextView mLabel;
    private TextView mContent;
    private ImageView mButton;
    private View mSeparator;

    public ButtonLayout(Context context) {
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

    public void setIcon(int image){
        mButton.setImageResource(image);
    }


    public void showSeparator(){
        mSeparator.setVisibility(View.VISIBLE);
    }

    private void initialize() {
        mInflater.inflate(R.layout.button_layout, this);
        mView = findViewById(R.id.button_layout);
        mLabel = (TextView) findViewById(R.id.button_label);
        mContent = (TextView) findViewById(R.id.button_content);
        mButton = (ImageView) findViewById(R.id.button);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);

        dataChanged();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ButtonLayout)){
            return false;
        } else {
            return true;
        }
    }

    public void setOnClickListener(OnClickListener o) {
        mView.setOnClickListener(o);
    }

    public int hashCode() {
        return mContent.hashCode();
    }

    /**
     * Listener for know if content is empty or not
     * @param listener onChangeContentListener
     */
    public void setOnEmptyContentListener(OnEmptyContentListener listener) {
        onEmptyContentListener = listener;
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
                if (!getContent().isEmpty()) {
                    if (onEmptyContentListener != null) {
                        onEmptyContentListener.isContentEmpty(mContent.hashCode(), false);
                    }
                } else {
                    if (onEmptyContentListener != null) {
                        onEmptyContentListener.isContentEmpty(mContent.hashCode(), true);
                    }
                }
            }
        });
    }
}
