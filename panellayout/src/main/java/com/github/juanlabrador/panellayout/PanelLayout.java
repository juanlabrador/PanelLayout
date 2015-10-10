package com.github.juanlabrador.panellayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by juanlabrador on 15/09/15.
 */
public class PanelLayout extends RelativeLayout {

    private static String TAG = "GroupLayout";
    private Context mContext;
    private TypedArray mTypedArray;
    private LayoutInflater mLayoutInflater;
    private CardView mGroupContent;
    private LinearLayout mItemContent;

    // Background Attributes

    private int mDefaultBackgroundBorderColor = Color.TRANSPARENT;
    private int mDefaultBackgroundColor = Color.WHITE;
    private int mDefaultSeparatorColor = Color.LTGRAY;
    private boolean mDefaultBorder = true;
    private int mDefaultCornerRadius = 4;
    private int mDefaultElevation = 4;

    // Text Attributes

    private int mDefaultLabelTextColor = Color.BLACK;
    private int mDefaultContentTextColor = Color.GRAY;
    private int mDefaultTextSize = 14;

    // Extend Text Attributes
    private int mDefaultExtendLabelTextColor = Color.GRAY;
    private int mDefaultExtendContentTextColor = Color.BLACK;

    public PanelLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        mTypedArray = context.obtainStyledAttributes(attrs, R.styleable.GroupLayoutAttrs);
        initialize();
        initializeAttrs(mTypedArray);
    }

    private void initialize() {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayoutInflater.inflate(R.layout.panel_layout, this);
        mGroupContent = (CardView) findViewById(R.id.group_layout);
        mItemContent = (LinearLayout) findViewById(R.id.item_layout);
        mItemContent.setVisibility(View.GONE);
    }

    private void initializeAttrs(TypedArray attrsArray) {
        mDefaultBackgroundColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_backgroundColor, mDefaultBackgroundColor);
        mDefaultBackgroundBorderColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_backgroundBorderColor, mDefaultBackgroundBorderColor);

        mDefaultBorder = attrsArray.getBoolean(R.styleable.GroupLayoutAttrs_withBorder, mDefaultBorder);
        mDefaultSeparatorColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_separatorColor, mDefaultSeparatorColor);

        mDefaultLabelTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_labelTextColor, mDefaultLabelTextColor);
        mDefaultContentTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_contentTextColor, mDefaultContentTextColor);

        mDefaultExtendLabelTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_labelTextColor, mDefaultExtendLabelTextColor);
        mDefaultExtendContentTextColor = attrsArray.getColor(R.styleable.GroupLayoutAttrs_contentTextColor, mDefaultExtendContentTextColor);


        mDefaultTextSize = attrsArray.getDimensionPixelSize(R.styleable.GroupLayoutAttrs_textSizeLayout,
                getResources().getDimensionPixelSize(R.dimen.size_text));

        mDefaultCornerRadius = attrsArray.getDimensionPixelSize(R.styleable.GroupLayoutAttrs_panelRadius, 4);

        mDefaultElevation = attrsArray.getDimensionPixelSize(R.styleable.GroupLayoutAttrs_panelElevation, 4);


        setBackgroundColor();
        setBackgroundBorderColor();
    }

    public void setBackgroundColor() {
        GradientDrawable mDrawable = new GradientDrawable();
        mDrawable.setColor(mDefaultBackgroundColor);

        // With border
        /*if (mDefaultBorder != false) {
            mDrawable.setCornerRadius(mDefaultCornerRadius);
        }*/
        mDrawable.setCornerRadius(mDefaultCornerRadius);
        mItemContent.setBackground(mDrawable);
    }

    public void setBackgroundBorderColor() {
        GradientDrawable mDrawable = new GradientDrawable();
        mDrawable.setColor(mDefaultBackgroundBorderColor);

        // With border
        /*if (mDefaultBorder != false) {
            mDrawable.setCornerRadius(mDefaultCornerRadius);
            mDrawable.setColor(mDefaultBackgroundBorderColor);
            mGroupContent.setPadding(1, 1, 1, 1);
        } else { // Without border
            mDrawable.setColor(mDefaultBackgroundBorderColor);
            mGroupContent.setPadding(0, 1, 0, 1);
        }*/

        mGroupContent.setUseCompatPadding(true);
        mGroupContent.setPreventCornerOverlap(false);
        mGroupContent.setRadius(mDefaultCornerRadius);
        mGroupContent.setCardElevation(mDefaultElevation);

    }

    /**-------------------------------------------------------------------------------------*/
    /**--------------------------------TEXT LAYOUT------------------------------------------*/

    /**
     *
     * @param label label
     * @return TextLayout
     */
    public TextLayout addTextLayout(int label) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label label
     * @return TextLayout
     */
    public TextLayout addTextLayout(String label) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label label
     * @param content content
     * @return TextLayout
     */
    public TextLayout addTextLayout(String label, String content) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setContent(content);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label label
     * @param content content
     * @return TextLayout
     */
    public TextLayout addTextLayout(int label, String content) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setContent(content);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**
     *
     * @param label label
     * @param content content
     * @return TextLayout
     */
    public TextLayout addTextLayout(int label, int content) {
        TextLayout mTextLayout = new TextLayout(mContext);
        mTextLayout.setLabel(label);
        mTextLayout.setContent(content);
        mTextLayout.setLabelColor(mDefaultLabelTextColor);
        mTextLayout.setContentColor(mDefaultContentTextColor);
        mTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mTextLayout);

        return mTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EDIT TEXT LAYOUT---------------------------------*/

    /**
     *
     * @param label label
     * @param content content
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(String label, String content) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setContent(content);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**
     *
     * @param label label
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(String label) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**
     *
     * @param label label
     * @param content content
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(int label, String content) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setContent(content);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**
     *
     * @param label label
     * @return EditTextLayout
     */
    public EditTextLayout addEditTextLayout(int label) {
        EditTextLayout mEditTextLayout = new EditTextLayout(mContext);
        mEditTextLayout.setLabel(label);
        mEditTextLayout.setLabelColor(mDefaultLabelTextColor);
        mEditTextLayout.setContentColor(mDefaultContentTextColor);
        mEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mEditTextLayout);

        return mEditTextLayout;
    }

    /**--------------------------------------------------------------------------*/
    /**------------------------MULTI TEXT LAYOUT---------------------------------*/

    /**
     *
     * @param content content
     * @return MultiTextLayout
     */
    public MultiTextLayout addMultiTextLayout(int content) {
        MultiTextLayout mMultiTextLayout = new MultiTextLayout(mContext);
        mMultiTextLayout.setContent(content);
        mMultiTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiTextLayout);

        return mMultiTextLayout;
    }

    /**
     *
     * @param content content
     * @return MultiTextLayout
     */
    public MultiTextLayout addMultiTextLayout(String content) {
        MultiTextLayout mMultiTextLayout = new MultiTextLayout(mContext);
        mMultiTextLayout.setContent(content);
        mMultiTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiTextLayout);

        return mMultiTextLayout;
    }

    /**-------------------------------------------------------------------------------*/
    /**------------------------MULTI EDIT TEXT LAYOUT---------------------------------*/

    /**
     * Create MultiEditText
     * @param hint hint
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(int hint) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     * Create MultiEditText
     * @param hint hint
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(String hint) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     *
     * @param hint hint
     * @param content content
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(int hint, int content) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContent(content);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     *
     * @param hint hint
     * @param content content
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(String hint, int content) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContent(content);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**
     *
     * @param hint hint
     * @param content content
     * @return MultiEditTextLayout
     */
    public MultiEditTextLayout addMultiEditTextLayout(int hint, String content) {
        MultiEditTextLayout mMultiEditTextLayout = new MultiEditTextLayout(mContext);
        mMultiEditTextLayout.setHint(hint);
        mMultiEditTextLayout.setContent(content);
        mMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mMultiEditTextLayout);

        return mMultiEditTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------POPUP LAYOUT-------------------------------------*/

    /**
     * Show popup
     * @param label label
     * @param content content
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String content, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param content content
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String content, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param content content
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param content content
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param content content
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, ArrayList<String> menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param content content
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String content, String[] menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setContent(content);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, int menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, ArrayList<String> menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, ArrayList<String> menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, ArrayList<String> menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, int menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(int label, String[] menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String[] menu) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setIcon(R.drawable.next_gray);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**
     * Show popup
     * @param label label
     * @param menu menu
     * @param icon icon
     * @return PopupLayout
     */
    public PopupLayout addPopupLayout(String label, String[] menu, int icon) {
        PopupLayout mPopupLayout = new PopupLayout(mContext);
        mPopupLayout.setLabel(label);
        mPopupLayout.setIcon(icon);
        mPopupLayout.setCustomMenu(menu);
        mPopupLayout.setLabelColor(mDefaultLabelTextColor);
        mPopupLayout.setContentColor(mDefaultContentTextColor);
        mPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mPopupLayout);

        return mPopupLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------BUTTON LAYOUT-------------------------------------*/

    /**
     *
     * @param label label
     * @param content content
     * @param icon icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(String label, String content, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setContent(content);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label label
     * @param content content
     * @param icon icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(int label, int content, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setContent(content);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label label
     * @param content content
     * @param icon icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(int label, String content, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setContent(content);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label label
     * @param icon icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(int label, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**
     *
     * @param label label
     * @param icon icon
     * @return ButtonLayout
     */
    public ButtonLayout addButtonLayout(String label, int icon) {
        ButtonLayout mButtonLayout = new ButtonLayout(mContext);
        mButtonLayout.setLabel(label);
        mButtonLayout.setIcon(icon);
        mButtonLayout.setLabelColor(mDefaultLabelTextColor);
        mButtonLayout.setContentColor(mDefaultContentTextColor);
        mButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mButtonLayout);

        return mButtonLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------SWITCH LAYOUT-------------------------------------*/

    /**
     *
     * @param label label
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label label
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label label
     * @param check check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label label
     * @param check check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label label
     * @param color color
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label, int color) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     * @param label label
     * @param color color
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label, int color) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     *
     * @param label label
     * @param color color
     * @param check check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(String label, int color, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**
     * @param label label
     * @param color color
     * @param check check
     * @return SwitchLayout
     */
    public SwitchLayout addSwitchLayout(int label, int color, boolean check) {
        SwitchLayout mSwitchLayout = new SwitchLayout(mContext);
        mSwitchLayout.setLabel(label);
        mSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mSwitchLayout.setLabelSize(mDefaultTextSize);
        mSwitchLayout.setSwitchColor(color);
        mSwitchLayout.setChecked(check);

        identifyObject();
        addField(mSwitchLayout);

        return mSwitchLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------VALIDATOR TEXT LAYOUT-------------------------------------*/

    /**
     *
     * @param label label text
     * @param content content text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(String label, String content) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setContent(content);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);


        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**
     *
     * @param label label text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(String label) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**
     *
     * @param label label text
     * @param content content text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(int label, String content) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setContent(content);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**
     *
     * @param label label text
     * @return ValidatorTextLayout
     */
    public ValidatorTextLayout addValidatorLayout(int label) {
        ValidatorTextLayout mValidatorTextLayout = new ValidatorTextLayout(mContext);
        mValidatorTextLayout.setLabel(label);
        mValidatorTextLayout.setLabelColor(mDefaultLabelTextColor);
        mValidatorTextLayout.setContentColor(mDefaultContentTextColor);
        mValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mValidatorTextLayout);

        return mValidatorTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND TEXT LAYOUT-------------------------------------*/

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @return ExtendTextLayout
     */
    public ExtendTextLayout addExtendTextLayout(int icon, String label, String content) {
        ExtendTextLayout mExtendTextLayout = new ExtendTextLayout(mContext);
        mExtendTextLayout.setLabel(label);
        mExtendTextLayout.setIcon(icon);
        mExtendTextLayout.setContent(content);
        mExtendTextLayout.setLabelColor(mDefaultExtendLabelTextColor);
        mExtendTextLayout.setContentColor(mDefaultExtendContentTextColor);
        mExtendTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendTextLayout);

        return mExtendTextLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @return ExtendTextLayout
     */
    public ExtendTextLayout addExtendTextLayout(int icon, int label, String content) {
        ExtendTextLayout mExtendTextLayout = new ExtendTextLayout(mContext);
        mExtendTextLayout.setLabel(label);
        mExtendTextLayout.setIcon(icon);
        mExtendTextLayout.setContent(content);
        mExtendTextLayout.setLabelColor(mDefaultExtendLabelTextColor);
        mExtendTextLayout.setContentColor(mDefaultExtendContentTextColor);
        mExtendTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendTextLayout);

        return mExtendTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND EDIT TEXT LAYOUT-------------------------------------*/

    /**
     *
     * @param icon icon
     * @param label label
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, String label) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, int label) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, String label, String content) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setContent(content);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @return ExtendEditTextLayout
     */
    public ExtendEditTextLayout addExtendEditTextLayout(int icon, int label, String content) {
        ExtendEditTextLayout mExtendEditTextLayout = new ExtendEditTextLayout(mContext);
        mExtendEditTextLayout.setLabel(label);
        mExtendEditTextLayout.setIcon(icon);
        mExtendEditTextLayout.setContent(content);
        mExtendEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendEditTextLayout);

        return mExtendEditTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND VALIDATOR TEXT LAYOUT-------------------------------------*/

    /**
     *
     * @param icon icon
     * @param label label
     * @return ExtendValidatorTextLayout
     */
    public ExtendValidatorTextLayout addExtendValidatorLayout(int icon, String label) {
        ExtendValidatorTextLayout mExtendValidatorTextLayout = new ExtendValidatorTextLayout(mContext);
        mExtendValidatorTextLayout.setLabel(label);
        mExtendValidatorTextLayout.setIcon(icon);
        mExtendValidatorTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendValidatorTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendValidatorTextLayout);

        return mExtendValidatorTextLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @return ExtendValidatorTextLayout
     */
    public ExtendValidatorTextLayout addExtendValidatorLayout(int icon, int label) {
        ExtendValidatorTextLayout mExtendValidatorTextLayout = new ExtendValidatorTextLayout(mContext);
        mExtendValidatorTextLayout.setLabel(label);
        mExtendValidatorTextLayout.setIcon(icon);
        mExtendValidatorTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendValidatorTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendValidatorTextLayout);

        return mExtendValidatorTextLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @return ExtendValidatorTextLayout
     */
    public ExtendValidatorTextLayout addExtendValidatorLayout(int icon, int label, String content) {
        ExtendValidatorTextLayout mExtendValidatorTextLayout = new ExtendValidatorTextLayout(mContext);
        mExtendValidatorTextLayout.setLabel(label);
        mExtendValidatorTextLayout.setIcon(icon);
        mExtendValidatorTextLayout.setContent(content);
        mExtendValidatorTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendValidatorTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendValidatorTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendValidatorTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendValidatorTextLayout);

        return mExtendValidatorTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND POPUP LAYOUT-------------------------------------*/

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @param menu menu
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, int label, String content, int menu) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setContent(content);
        mExtendPopupLayout.setMenu(menu);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setIconButton(R.drawable.next_gray);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @param menu menu
     * @param iconButton iconButton
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, int label, String content, int menu, int iconButton) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setContent(content);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setIconButton(iconButton);
        mExtendPopupLayout.setMenu(menu);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param menu menu
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, int label, int menu) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setMenu(menu);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setIconButton(R.drawable.next_gray);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param menu menu
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, String label, int menu) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setMenu(menu);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setIconButton(R.drawable.next_gray);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param menu menu
     * @param iconButton iconButton
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, int label, int menu, int iconButton) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setIconButton(iconButton);
        mExtendPopupLayout.setMenu(menu);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @param menu menu
     * @param iconButton iconButton
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, int label, String content, ArrayList<String> menu, int iconButton) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setContent(content);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setIconButton(iconButton);
        mExtendPopupLayout.setCustomMenu(menu);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param menu menu
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, int label, ArrayList<String> menu) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setCustomMenu(menu);
        mExtendPopupLayout.setIconButton(R.drawable.next_gray);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param menu menu
     * @param iconButton iconButton
     * @return ExtendPopupLayout
     */
    public ExtendPopupLayout addExtendPopupLayout(int icon, int label, ArrayList<String> menu, int iconButton) {
        ExtendPopupLayout mExtendPopupLayout = new ExtendPopupLayout(mContext);
        mExtendPopupLayout.setLabel(label);
        mExtendPopupLayout.setIcon(icon);
        mExtendPopupLayout.setIconButton(iconButton);
        mExtendPopupLayout.setCustomMenu(menu);
        mExtendPopupLayout.setLabelColor(mDefaultContentTextColor);
        mExtendPopupLayout.setContentColor(mDefaultLabelTextColor);
        mExtendPopupLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendPopupLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendPopupLayout);

        return mExtendPopupLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND BUTTON LAYOUT-------------------------------------*/

    /**
     *
     * @param icon icon
     * @param label label
     * @param content content
     * @param iconButton button
     * @return ExtendButtonLayout
     */
    public ExtendButtonLayout addExtendButtonLayout(int icon, int label, String content, int iconButton) {
        ExtendButtonLayout mExtendButtonLayout = new ExtendButtonLayout(mContext);
        mExtendButtonLayout.setLabel(label);
        mExtendButtonLayout.setContent(content);
        mExtendButtonLayout.setIcon(icon);
        mExtendButtonLayout.setIconButton(iconButton);
        mExtendButtonLayout.setLabelColor(mDefaultContentTextColor);
        mExtendButtonLayout.setContentColor(mDefaultLabelTextColor);
        mExtendButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendButtonLayout);

        return mExtendButtonLayout;
    }

    /**
     *
     * @param icon icon
     * @param label label
     * @param iconButton button
     * @return ExtendButtonLayout
     */
    public ExtendButtonLayout addExtendButtonLayout(int icon, int label, int iconButton) {
        ExtendButtonLayout mExtendButtonLayout = new ExtendButtonLayout(mContext);
        mExtendButtonLayout.setLabel(label);
        mExtendButtonLayout.setIcon(icon);
        mExtendButtonLayout.setIconButton(iconButton);
        mExtendButtonLayout.setLabelColor(mDefaultContentTextColor);
        mExtendButtonLayout.setContentColor(mDefaultLabelTextColor);
        mExtendButtonLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendButtonLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendButtonLayout);

        return mExtendButtonLayout;
    }


    /**-------------------------------------------------------------------------*/
    /**------------------------EXTEND MULTI TEXT LAYOUT-------------------------------------*/

    public ExtendMultiEditTextLayout addExtendMultiEditTextLayout(int icon, String label) {
        ExtendMultiEditTextLayout mExtendMultiEditTextLayout = new ExtendMultiEditTextLayout(mContext);
        mExtendMultiEditTextLayout.setLabel(label);
        mExtendMultiEditTextLayout.setIcon(icon);
        mExtendMultiEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendMultiEditTextLayout);

        return mExtendMultiEditTextLayout;
    }

    public ExtendMultiEditTextLayout addExtendMultiEditTextLayout(int icon, int label) {
        ExtendMultiEditTextLayout mExtendMultiEditTextLayout = new ExtendMultiEditTextLayout(mContext);
        mExtendMultiEditTextLayout.setLabel(label);
        mExtendMultiEditTextLayout.setIcon(icon);
        mExtendMultiEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendMultiEditTextLayout);

        return mExtendMultiEditTextLayout;
    }

    public ExtendMultiEditTextLayout addExtendMultiEditTextLayout(int icon, int label, String content) {
        ExtendMultiEditTextLayout mExtendMultiEditTextLayout = new ExtendMultiEditTextLayout(mContext);
        mExtendMultiEditTextLayout.setLabel(label);
        mExtendMultiEditTextLayout.setIcon(icon);
        mExtendMultiEditTextLayout.setContent(content);
        mExtendMultiEditTextLayout.setLabelColor(mDefaultContentTextColor);
        mExtendMultiEditTextLayout.setContentColor(mDefaultLabelTextColor);
        mExtendMultiEditTextLayout.setColorSeparator(mDefaultSeparatorColor);
        mExtendMultiEditTextLayout.setTextSize(mDefaultTextSize);

        identifyObject();
        addField(mExtendMultiEditTextLayout);

        return mExtendMultiEditTextLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------ICON SWITCH LAYOUT-------------------------------------*/

    /**
     *
     * @param label label
     * @return SwitchLayout
     */
    public IconSwitchLayout addIconSwitchLayout(int icon, String label) {
        IconSwitchLayout mIconSwitchLayout = new IconSwitchLayout(mContext);
        mIconSwitchLayout.setLabel(label);
        mIconSwitchLayout.setIcon(icon);
        mIconSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mIconSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mIconSwitchLayout.setLabelSize(mDefaultTextSize);
        mIconSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mIconSwitchLayout);

        return mIconSwitchLayout;
    }

    /**
     *
     * @param label label
     * @return SwitchLayout
     */
    public IconSwitchLayout addIconSwitchLayout(int icon, int label) {
        IconSwitchLayout mIconSwitchLayout = new IconSwitchLayout(mContext);
        mIconSwitchLayout.setLabel(label);
        mIconSwitchLayout.setIcon(icon);
        mIconSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mIconSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mIconSwitchLayout.setLabelSize(mDefaultTextSize);
        mIconSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mIconSwitchLayout);

        return mIconSwitchLayout;
    }

    /**
     *
     * @param label label
     * @return SwitchLayout
     */
    public IconSwitchLayout addIconSwitchLayout(Drawable icon, String label) {
        IconSwitchLayout mIconSwitchLayout = new IconSwitchLayout(mContext);
        mIconSwitchLayout.setLabel(label);
        mIconSwitchLayout.setIcon(icon);
        mIconSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mIconSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mIconSwitchLayout.setLabelSize(mDefaultTextSize);
        mIconSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mIconSwitchLayout);

        return mIconSwitchLayout;
    }

    /**
     *
     * @param label label
     * @return SwitchLayout
     */
    public IconSwitchLayout addIconSwitchLayout(Drawable icon, int label) {
        IconSwitchLayout mIconSwitchLayout = new IconSwitchLayout(mContext);
        mIconSwitchLayout.setLabel(label);
        mIconSwitchLayout.setIcon(icon);
        mIconSwitchLayout.setLabelColor(mDefaultLabelTextColor);
        mIconSwitchLayout.setColorSeparator(mDefaultSeparatorColor);
        mIconSwitchLayout.setLabelSize(mDefaultTextSize);
        mIconSwitchLayout.setSwitchColor(Color.parseColor("#43D95D"));

        identifyObject();
        addField(mIconSwitchLayout);

        return mIconSwitchLayout;
    }

    /**-------------------------------------------------------------------------*/
    /**------------------------GROUP LAYOUT-------------------------------------*/


    /**
     *
     * @return View
     */
    public View getLastField() {
        View view = null;
        if (!isEmpty()){
            view =  mItemContent.getChildAt(mItemContent.getChildCount() - 1);
        }
        return view;
    }

    private void identifyObject() {
        if (isEmpty()) {
            mItemContent.setVisibility(View.VISIBLE);
        } else if (getLastField() instanceof TextLayout) {
            ((TextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof EditTextLayout) {
            ((EditTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof MultiTextLayout) {
            ((MultiTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof MultiEditTextLayout) {
            ((MultiEditTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof PopupLayout) {
            ((PopupLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ButtonLayout) {
            ((ButtonLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof SwitchLayout) {
            ((SwitchLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ValidatorTextLayout) {
            ((ValidatorTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendTextLayout) {
            ((ExtendTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendEditTextLayout) {
            ((ExtendEditTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendValidatorTextLayout) {
            ((ExtendValidatorTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendButtonLayout) {
            ((ExtendButtonLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendMultiEditTextLayout) {
            ((ExtendMultiEditTextLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof ExtendPopupLayout) {
            ((ExtendPopupLayout) getLastField()).showSeparator();
        } else if (getLastField() instanceof IconSwitchLayout) {
            ((IconSwitchLayout) getLastField()).showSeparator();
        }
    }

    public void addField(View v) {
        mItemContent.addView(v);
    }

    public void clear() {
        mItemContent.removeAllViewsInLayout();
    }

    /**
     *
     * @return size panel
     */
    public int size() {
        return mItemContent.getChildCount();
    }

    /**
     *
     * @return true if is empty
     */
    public boolean isEmpty() {
        return mItemContent.getChildCount() == 0;
    }

}

