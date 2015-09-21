package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.github.juanlabrador.panellayout.progressbar.ProgressWheel;

/**
 * Created by juanlabrador on 16/09/15.
 */
public class ExtendValidatorTextLayout extends LinearLayout {

    private final WindowManager mWindowManager;
    private View mItem;
    private LayoutInflater mInflater;
    private LayoutInflater mInflaterPopup;
    private EditText mContent;
    private TextView mLabel;
    private ImageView mIcon;
    private ImageView mIconValidate;
    private View mSeparator;
    private boolean mState = false;
    private ProgressWheel mProgress;
    private Context mContext;
    private TextView mMessageError;
    private View mPopupView;
    private PopupWindow mPopupWindow;
    private View mContainerPopup;
    private float mTextSize;

    public ExtendValidatorTextLayout(Context context) {
        super(context);
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        mContext = context;
        mInflaterPopup = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
    }

    public void setLabel(String label){
        mLabel.setText(label);
    }

    public void setLabel(int label) {
        mLabel.setText(label);
    }

    public void setLabelColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setContent(String text) {
        mContent.setText(text);
    }

    public void setContentColor(int color) {
        mContent.setTextColor(color);
    }

    public void setTextSize(float size) {
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mTextSize = size;
    }

    public void setIcon(int icon){
        mIcon.setBackgroundResource(icon);
    }

    public void setInputType(int input) {
        mContent.setInputType(input);
    }

    public void showSeparator(){
        mSeparator.setVisibility(View.VISIBLE);
    }

    public void setColorSeparator(int color) {
        mSeparator.setBackgroundColor(color);
    }

    public void setMaxLength(int max) {
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(max);
        mContent.setFilters(filterArray);
    }

    public String getContent() {
        return mContent.getText().toString();
    }

    public EditText getEditText() {
        return mContent;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        mContent.addTextChangedListener(textWatcher);
    }

    public void changeColorProgress(int color) {
        mProgress.setBarColor(color);
    }

    private void initialize() {
        mItem = mInflater.inflate(R.layout.extend_validator_text_layout, this);
        mLabel = (TextView) mItem.findViewById(R.id.extend_text_label_validator);
        mContent = (EditText) mItem.findViewById(R.id.extend_edit_text_validator);
        mIcon = (ImageView) mItem.findViewById(R.id.icon);
        mIconValidate = (ImageView) mItem.findViewById(R.id.icon_extend_edit_text_validator);
        mProgress = (ProgressWheel) mItem.findViewById(R.id.progress);
        mSeparator = mItem.findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);
    }

    public void dataRetry(OnClickListener onClickListener) {
        mProgress.cancelLongPress();
        mProgress.setVisibility(GONE);
        mIconValidate.setVisibility(VISIBLE);
        mIconValidate.setImageResource(R.drawable.ic_network);
        mIconValidate.setOnClickListener(onClickListener);
        mState = false;
    }

    public void dataError() {
        mProgress.cancelLongPress();
        mProgress.setVisibility(GONE);
        mIconValidate.setVisibility(VISIBLE);
        mIconValidate.setImageResource(R.drawable.error);
        mState = false;
    }

    public void dataError(int message) {
        mProgress.cancelLongPress();
        mProgress.setVisibility(GONE);
        mIconValidate.setVisibility(VISIBLE);
        mIconValidate.setImageResource(R.drawable.error);
        mState = false;
        displayPopupWindow(mIconValidate, getResources().getString(message));
    }

    public void dataError(String message) {
        mProgress.cancelLongPress();
        mProgress.setVisibility(GONE);
        mIconValidate.setVisibility(VISIBLE);
        mIconValidate.setImageResource(R.drawable.error);
        mState = false;
        displayPopupWindow(mIconValidate, message);
    }

    public boolean isCheck() {
        return mState;
    }

    public void dataCheck() {
        if (mPopupWindow != null) {
            mMessageError.setVisibility(GONE);
            mPopupWindow.dismiss();
        }
        mProgress.cancelLongPress();
        mProgress.setVisibility(GONE);
        mIconValidate.setVisibility(VISIBLE);
        mIconValidate.setImageResource(R.drawable.check);
        mState = true;
    }

    public void dataProgress() {
        if (mPopupWindow != null) {
            mMessageError.setVisibility(GONE);
            mPopupWindow.dismiss();
        }
        mIconValidate.setVisibility(GONE);
        mProgress.setVisibility(VISIBLE);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExtendValidatorTextLayout)){
            return false;
        } else {
            return true;
        }
    }

    private void displayPopupWindow(View anchor, String message) {
        mPopupView = null;
        mPopupWindow = new PopupWindow(mContext);
        mPopupView = mInflaterPopup.inflate(R.layout.popup_message, null);
        mContainerPopup = mPopupView.findViewById(R.id.container_popup);
        mMessageError = (TextView) mPopupView.findViewById(R.id.popup_message);
        mMessageError.setText(message);
        mMessageError.setTextSize(TypedValue.COMPLEX_UNIT_PX, (mTextSize - 6));
        mPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        mPopupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);

        Rect rc = new Rect();
        anchor.getWindowVisibleDisplayFrame(rc);
        int[] xy = new int[2];
        anchor.getLocationInWindow(xy);
        rc.offset(xy[0], xy[1]);
        int x = rc.left;
        int y = rc.top - 5;
        int[] location = new int[2];
        anchor.getLocationInWindow(location);
        Display mDisplay = mWindowManager.getDefaultDisplay();
        Point mdispSize = new Point();
        mDisplay.getSize(mdispSize);
        int screenWidth = mdispSize.x;
        int screenHeight = mdispSize.y;
        int xPos = ((screenWidth - location[0]) - anchor.getWidth() - 8);  // 8 is margin right
        Log.i("TAG", "Anchor location: x: " + x + " y: " + y + " xPos: " + xPos);
        if (y < screenHeight && y > (screenHeight - 100)){
            y = rc.top - (anchor.getHeight() * 2) - 10;
            Log.i("TAG", "Anchor location: x: " + x + " y: " + y + " xPos: " + xPos);
            mContainerPopup.setBackgroundResource(R.drawable.popup_background_up);
            mPopupWindow.setContentView(mPopupView);
        } else {
            mContainerPopup.setBackgroundResource(R.drawable.popup_background_down);
            mPopupWindow.setContentView(mPopupView);
        }
        mPopupWindow.showAtLocation(mIconValidate, Gravity.TOP | Gravity.RIGHT, xPos, y);
    }

    public void destroyPopup() {
        if (mPopupWindow != null) {
            mPopupWindow.dismiss();
        }
    }
}
