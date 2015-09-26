package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.github.juanlabrador.panellayout.interfaces.OnEmptyContentListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juanlabrador on 17/09/15.
 */
public class ExtendPopupLayout extends LinearLayout implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private static String TAG = "PopupLayout";
    private OnEmptyContentListener onEmptyContentListener = null;
    private View mView;
    private Context mContext;
    private LayoutInflater mInflater;
    private TextView mLabel;
    private TextView mContent;
    private ImageView mIcon;
    private ImageView mButton;
    private View mSeparator;
    private PopupMenu mPopup;

    // Menu content
    private int mMenu;
    private ArrayList<String> mCustomMenu;
    private String[] mCustomMenu2;

    // Get item
    private int mItemPosition;
    private String mItemTitle;
    private List<String> mMenuPos;

    public ExtendPopupLayout(Context context) {
        super(context);
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        initialize();
    }

    public void setLabel(String label){
        mLabel.setText(label);
    }

    public void setContent(String text) {
        mContent.setText(text);
    }

    public void setContent(int text) {
        mContent.setText(text);
    }

    public void setLabel(int label) {
        mLabel.setText(label);
    }

    public String getContent() {
        return mContent.getText().toString();
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

    public void setMenu(int menu) {
        mMenu = menu;
        showPopupMenu(mMenu);
    }

    public void setCustomMenu(ArrayList<String> customMenu) {
        mCustomMenu = customMenu;
        showPopupCustomMenu(mCustomMenu);
    }

    public void setCustomMenu(String[] customMenu) {
        mCustomMenu2 = customMenu;
        showPopupCustomMenu(mCustomMenu2);
    }

    private void initialize() {
        mInflater.inflate(R.layout.extend_popup_layout, this);
        mView = findViewById(R.id.popup_layout);
        mLabel = (TextView) findViewById(R.id.extend_text_label);
        mContent = (TextView) findViewById(R.id.extend_content_text);
        mButton = (ImageView) findViewById(R.id.icon_one_button);
        mIcon = (ImageView) findViewById(R.id.icon);
        mView.setOnClickListener(this);
        mSeparator = findViewById(R.id.separator);
        mSeparator.setVisibility(View.GONE);

        dataChange();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ExtendPopupLayout)){
            return false;
        } else {
            return true;
        }
    }

    private void showPopupMenu(View view, int menu) {
        mPopup = new PopupMenu(mContext, view, Gravity.RIGHT);
        mPopup.getMenuInflater().inflate(menu, mPopup.getMenu());
        mPopup.setOnMenuItemClickListener(this);
        mPopup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        mContent.setText(menuItem.getTitle().toString());
        mItemPosition = findItemPosition(menuItem);  // If is custom menu
        if (mItemPosition == -1) // If is menu res
            mItemPosition = menuItem.getOrder();
        mItemTitle = menuItem.getTitle().toString();
        return true;
    }

    public String getItemTitle(int position) {
        if (mPopup != null) {
            mItemTitle = (String) mPopup.getMenu().getItem(position).getTitle();
            return mItemTitle;
        }
        return null;
    }

    public int getItemPosition() {
        return mItemPosition;
    }

    /**
     * Get item select title
     * @return
     */
    public String getItemTitle() {
        return mItemTitle;
    }

    @Override
    public void onClick(View view) {
        Log.i(TAG, String.valueOf(mMenu));
        if (mMenu != 0) {
            showPopupMenu(view, mMenu);
        } else if (mCustomMenu != null) {
            showPopupCustomMenu(view, mCustomMenu);
        } else if (mCustomMenu2 != null) {   // If String[] not null
            showPopupCustomMenu(view, mCustomMenu2);
        }
    }

    public void setLabelColor(int color) {
        mLabel.setTextColor(color);
    }

    public void setContentColor(int color) {
        mContent.setTextColor(color);
    }

    public void setColorSeparator(int color) {
        mSeparator.setBackgroundColor(color);
    }

    public void setTextSize(int size) {
        mContent.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
        mLabel.setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
    }

    private void showPopupCustomMenu(View view, ArrayList<String> menu) {
        mCustomMenu = menu;
        mPopup = new PopupMenu(mContext, view, Gravity.RIGHT);
        mPopup.getMenu().clear();
        for (int i = 0; i < mCustomMenu.size(); i++) {
            mPopup.getMenu().add(0, 0, i, mCustomMenu.get(i));
        }
        mPopup.setOnMenuItemClickListener(this);
        mPopup.show();
    }

    /**
     * Show popup menu with String[] array
     * @param view
     * @param menu
     */
    private void showPopupCustomMenu(View view, String[] menu) {
        mCustomMenu2 = menu;
        mPopup = new PopupMenu(mContext, view, Gravity.RIGHT);
        mPopup.getMenu().clear();
        for (int i = 0; i < mCustomMenu2.length; i++) {
            mPopup.getMenu().add(0, 0, i, mCustomMenu2[i]);
        }
        mPopup.setOnMenuItemClickListener(this);
        mPopup.show();
    }

    /**
     * Show popup menu with resource
     * @param menu
     */
    private void showPopupMenu(int menu) {
        mPopup = new PopupMenu(mContext, null);
        mPopup.getMenuInflater().inflate(menu, mPopup.getMenu());
    }

    /**
     * Show popup menu with ArrayList
     * @param menu
     */
    private void showPopupCustomMenu(ArrayList<String> menu) {
        mMenuPos = new ArrayList<>();
        mPopup = new PopupMenu(mContext, null);
        mPopup.getMenu().clear();
        for (int i = 0; i < menu.size(); i++) {
            mPopup.getMenu().add(0, 0, i, menu.get(i));
            mMenuPos.add(mPopup.getMenu().getItem(i).getTitle().toString());
        }
    }

    /**
     * Show popup menu with String[] array
     * @param menu
     */
    private void showPopupCustomMenu(String[] menu) {
        mMenuPos = new ArrayList<>();
        mPopup = new PopupMenu(mContext, null);
        mPopup.getMenu().clear();
        for (int i = 0; i < menu.length; i++) {
            mPopup.getMenu().add(0, 0, i, menu[i]);
            mMenuPos.add(mPopup.getMenu().getItem(i).getTitle().toString());
        }
    }

    /**
     * Detected position for custom menu
     * @param item menuItem
     * @return position
     */
    private int findItemPosition(MenuItem item) {
        if (mMenuPos != null) {
            for (int i = 0; i < mMenuPos.size(); i++) {
                if (mMenuPos.get(i).equals(item.getItemId())) {
                    return i;
                }
            }
        }
        return -1;
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


    private void dataChange() {
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
            }
        });
    }
}
