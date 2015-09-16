package com.github.juanlabrador.panellayout;

import android.content.ClipboardManager;
import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by juanlabrador on 15/09/15.
 */
public class MultiTextLayout extends LinearLayout implements View.OnLongClickListener {

    private LayoutInflater mLayoutInflater;
    private TextView mContent;
    private View mSeparator;
    private Context mContext;

    public MultiTextLayout(Context context) {
        super(context);
        mContext = context;
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
        mLayoutInflater.inflate(R.layout.multi_text_layout, this);
        mContent = (TextView) findViewById(R.id.multi_text);
        mContent.setOnLongClickListener(this);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MultiTextLayout)){
            return false;
        } else {
            return true;
        }
    }


    @SuppressWarnings("deprecation")
    @Override
    public boolean onLongClick(View view) {
        ((ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE))
                .setText(getContent());
        //Toast.makeText(mContext, "Text copied.", Toast.LENGTH_SHORT).show();
        return true;
    }
}
