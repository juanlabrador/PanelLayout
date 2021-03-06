# PanelLayout  [ ![Download](https://api.bintray.com/packages/juanlabrador/maven/PanelLayout/images/download.svg) ](https://bintray.com/juanlabrador/maven/PanelLayout/_latestVersion)
A group of view in container to style iOS 7. For API 19+

![PanelLayout](screen/demo.png)

How to use
----------
```groovy
compile 'com.github.juanlabrador:panellayout:2.6@aar'
```

In your xml
-----------
```xml
  <com.github.juanlabrador.panellayout.PanelLayout
      android:id="@+id/group"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"/>
```

If you want to customize it, applies these attributes supported:

```xml
  <attr name="labelTextColor" format="color"/>
  <attr name="contentTextColor" format="color"/>
  <attr name="separatorColor" format="color"/>
  <attr name="textSizeLayout" format="dimension"/>
  <attr name="panelRadius" format="dimension"/>
  <attr name="panelElevation" format="dimension"/>
```

Then, you must add this line to apply them

```xml
  xmlns:panel="http://schemas.android.com/apk/res-auto"
```
```xml
  <com.github.juanlabrador.panellayout.PanelLayout
      android:id="@+id/group"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      panel:textSizeLayout="16sp"/>
```

By default:

- SeparatorColor is LTGRAY
- LabelTextColor is BLACK
- ContentTextColor is GRAY
- TextSizeLayout is 14sp
- panelElevation is 4dp
- panelRadius is 4dp

In your class java
------------------
You declare a PanelLayout object:

```java
  private PanelLayout mPanelLayout;
  ...
  ...
  mPanelLayout = (PanelLayout) findViewById(R.id.group);

```
Add TextLayout
--------------
![TextLayout](screen/TextLayout.png)

You can use values String or Text as parameters.

```java
  mPanelLayout.addTextLayout("Name", "Juan Labrador");
  mPanelLayout.addTextLayout(R.string.age, "23");
  mPanelLayout.addTextLayout("Develop by", "Juan Labrador");
```

To edit the label or content, you need to declare a TextLayout object:

```java
  private TextLayout mName;
  ...
  mName = mPanelLayout.addTextLayout("Name", "Juan Labrador");
  ...
  mName.setLabel("Last Name");
  mName.setContent("Labrador");
```
Add EditTextLayout
-----------------
![EditTextLayout](screen/EditTextLayout.png)

You can use values String or Text as parameters, add too a InputType.

```java
  mPanelLayout.addEditTextLayout("Username");
  mPanelLayout.addEditTextLayout("Password");
```

To edit the label or content, you need to declare a EditTextLayout object:

```java
  EditTextLayout mPassword = mPanelLayout.addEditTextLayout("Password");

  mPassword.isPassword(true);  // Change input type to password

  mPhone.isNumber(true);   // Change input type to number
  mEmail.isEmail(true);   // Change input type to email
```
Add MultiTextLayout
-------------------
![MultiTextLayout](screen/MultiTextLayout.png)

```java
  mPanelLayout.addMultiTextLayout(R.string.description);

```

When you do to long press, you copy content to Clipboard.

Add MultiEditTextLayout
-----------------------
![MultiEditTextLayoutEmpty](screen/MultiEditTextLayoutEmpty.png)
![MultiEditTextLayoutFull](screen/MultiEditTextLayoutFull.png)

- First parameter is for the hint text.
- Second parameter is for the content text.

```java
  mPanelLayout.addMultiEditTextLayout(R.string.description);
```
Add PopupLayout
---------------
![PopupLayoutEmpty](screen/PopupLayoutEmpty.png)
![PopupLayoutShowMenu](screen/PopupLayoutShowMenu.png)
![PopupLayoutFull](screen/PopupLayoutFull.png)

You can use values String or Text. Add a menu of res, or String[] or ArrayList<String>. You can use our standards icons or add your icon.

```java
  PopupLayout mPopupLayout = mPanelLayout.addPopupLayout("Gender", R.menu.menu_gender);

  mPopupLayout.getContent();  // Get content selected
  mPopupLayout.getItemPosition();  // Get position item menu
  ...
  ...
  mPanelLayout.addPopupLayout("Country", country);  // With String[]
  mPanelLayout.addPopupLayout("Age", age);  // With ArrayList
  mPanelLayout.addPopupLayout("Gender", R.menu.menu_main, R.drawable.youricon);
```
It's important that when you create a menu res, add tag "orderInCategory" starting from 0, because with this, you can detect the position of item.
```xml
  <menu
      xmlns:android="http://schemas.android.com/apk/res/android">
      <item android:title="Male"
          android:orderInCategory="0"/>

      <item android:title="Female"
          android:orderInCategory="1"/>
  </menu>
```
Add ButtonLayout
----------------
![ButtonLayout](screen/ButtonLayout.png)

You can use values String or Text as parameters, add a text of content and a icon.

```java
  mPanelLayout.addButtonLayout("Phone", "+ 58 424 0000000", R.mipmap.phone);
  ButtonLayout mEmail = mPanelLayout.addButtonLayout("Email", "juanjavierlabrador@gmail.com", R.mipmap.message);
  mEmail.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
            // Intent call phone
      }
  });
  ...
  ...
  mEmail.getContent();

```
Add SwitchLayout
----------------
![SwitchLayout](screen/SwitchLayout.png)

You can use values String or Text as parameters, indicate a color when check on, and assign a status to the switch.

```java
  mPanelLayout.addSwitchLayout("Switch ON Default", true);
  SwitchLayout mSwitch = mPanelLayout.addSwitchLayout("Switch OFF Default");
  mPanelLayout.addSwitchLayout("Switch ON Other Color", Color.CYAN, true);
  ...
  ...
  mSwitch.isChecked();
  mSwitch.setChecked(true);
```
Add ValidatorTextLayout
-------------------
Use the icons:

- dataProgress(); Working validation view
![ValidatorTextLayoutProgress](screen/ValidatorTextLayoutProgress.png)

- dataCheck(); Check text
![ValidatorTextLayoutCheck](screen/ValidatorTextLayoutCheck.png)

- dataError(); Error in text input
![ValidatorTextLayoutError](screen/ValidatorTextLayoutError.png)

- dataError("Email invalidate!");  Show message with popup
![ValidatorTextLayoutPopup](screen/ValidatorTextLayoutPopup.png)

You can use values String or Text. Use it to validate a search.

```java
  final ValidatorTextLayout mValidator = mPanelLayout2.addValidatorLayout("Email");
  mValidator.setOnChangedContentListener(new OnChangedContentListener() {
    @Override
    public void afterTextChanged(Editable editable) {
        if (Condition correct) {
            mValidator.dataCheck();
        } else if (Condition error) {
            mValidator.dataError();
        } else {
            mValidator.dataProgress();
        }
      }
});
```
Add ExtendTextLayout
--------------------
![ExtendTextLayout](screen/ExtendTextLayout.png)

```java
  mPanelLayout.addExtendTextLayout(R.mipmap.marker, "Address", "Caracas, VZLA");
```
Add ExtendEditTextLayout
-----------------

![ExtendEditTextLayout](screen/ExtendEditTextLayout.png)

```java
  mPanelLayout.addExtendEditTextLayout(R.mipmap.marker, "Address");
```
Add ExtendValidatorTextLayout
-------------------
![ExtendValidatorTextLayout](screen/ExtendValidatorTextLayout.png)

```java
  final ExtendValidatorTextLayout mValidator = mPanelLayout.addExtendValidatorLayout(R.mipmap.message, "Email");
  mValidator.setOnChangedContentListener(new OnChangedContentListener() {
        @Override
        public void afterTextChanged(Editable editable) {
              if (mValidator.getContent().equals("juan@email.com")) {
                  mValidator.dataCheck();
              } else if (mValidator.getContent().equals("juan@dd.e")) {
                  mValidator.dataError();
              } else {
                  mValidator.dataProgress();
              }
          }
    });
```
Add ExtendPopupLayout
---------------
![ExtendPopupLayout](screen/ExtendPopupLayout.png)

You can use values String or Text. Add a menu of res, or String[] or ArrayList<String>. You can use our standards icons or add your icon.

```java
  ExtendPopupLayout mPopupLayout = mPanelLayout.addExtendPopupLayout(R.mipmap.gender, "Gender", R.menu.menu_gender);

  mPopupLayout.getContent();  // Get content selected
  mPopupLayout.getItemPosition();  // Get position item menu
  ...
  ...
  mPanelLayout.addExtendPopupLayout(R.mipmap.gender, "Gender", gender);  // With String[]
  mPanelLayout.addExtendPopupLayout(R.mipmap.gender, "Gender", gender); // With ArrayList
  mPanelLayout.addExtendPopupLayout(R.mipmap.gender, "Gender", R.menu.menu_main, R.drawable.youricon);
```
It's important that when you create a menu res, add tag "orderInCategory" starting from 0, because with this, you can detect the position of item.
```xml
  <menu
      xmlns:android="http://schemas.android.com/apk/res/android">
      <item android:title="Male"
          android:orderInCategory="0"/>

      <item android:title="Female"
          android:orderInCategory="1"/>
  </menu>
```
Add IconSwitchLayout
----------------
![IconSwitchLayout](screen/IconSwitchLayout.png)

```java
  mPanelLayout.addIconSwitchLayout(R.mipmap.facebook, "Facebook");
  IconSwitchLayout mSwitch = mPanelLayout.addIconSwitchLayout(R.mipmap.twitter, "Twitter");
  ...
  ...
  mSwitch.isChecked();
  mSwitch.setChecked(true);
```
Log
----
v2.6
- Change View by CardView, add Radius and Elevation

v2.4.6
- Updated Listener

v2.4
- Added IconSwitchLayout

v2.2.3
- Added OnEmptyContentListener
- Added OnChangedContentListener

v2.2.2
- Added TextChangedListener on MultiTextLayout and ExtendMultiTextLayout
- Added InputType on ValidatorLayout and ExtendValidatorLayout

v2.2.1
- Change size icon
- PopupLayout and ButtonLayout, all container has OnClick.

v2.2
- Added ExtendButtonLayout
- Added ExtendMultiTextLayout

v2.1.4
- Fix bug PopupLayout and ExtendPopupLayout

V2.1.3
- Minor changes PopupLayout and ExtendPopupLayout

v2.1.2
- Added getItemTitle by position in PopupLayout

v2.1.1
- Minor changes ProgressBar

v2.1
- Added ExtendPopupLayout

v2.0
- Added ExtendValidatorTextLayout

v1.9
- Added ExtendEditTextLayout
    - Added isURL(boolean);

v1.8
- Added ExtendTextLayout

v1.7
- Added ValidatorTextLayout

v1.6.1
- Change Switch Style iOS

v1.6
- Added SwitchLayout

v1.5
- Added ButtonLayout

v1.4
- Added PopupLayout

v1.3
- Added MultiEditTextLayout

v1.2
- Added MultiTextLayout

v1.1.1
- Updated EditTextLayout
    - isNumber(boolean)
    - isEmail(boolean)

v1.1
- Added EditTextLayout
    - isPassword(boolean)

v1.0
- Added TextLayout

Developed by
------------

- Juan Labrador - <juanjavierlabrador@gmail.com>
- Twitter: <a href="https://twitter.com/juanlabrador">@JuanLabrador</a>

Inspiration in
--------------

<a href="https://github.com/vladexologija/GroupedTextView">GroupedTextView</a>

Libraries used in this project
-------
- <a href="https://github.com/kyleduo/SwitchButton">SwitchButton</a>
- <a href="https://github.com/pnikosis/materialish-progress">materialish-progress</a>

