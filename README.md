# PanelLayout  [ ![Download](https://api.bintray.com/packages/juanlabrador/maven/PanelLayout/images/download.svg) ](https://bintray.com/juanlabrador/maven/PanelLayout/_latestVersion)
A group of view in container to style iOS 7. For API 21+


Description
-----------

- TextLayout: Consisting of two TextView to display content.
- EditTextLayout: Consisting of one TextView and one EditText.
- MultiTextLayout: Consisting of one TextView to display large text.
- MultiEditTextLayout: Consisting of one EditText to write large text.

How to use
----------

```groovy
compile 'com.github.juanlabrador:panellayout:1.3@aar'
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
  <attr name="backgroundColor" format="color"/>
  <attr name="backgroundBorderColor" format="color"/>
  <attr name="labelTextColor" format="color"/>
  <attr name="contentTextColor" format="color"/>
  <attr name="separatorColor" format="color"/>
  <attr name="textSizeLayout" format="dimension"/>
  <attr name="withBorder" format="boolean"/>
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
      panel:textSizeLayout="16sp"
      panel:withBorder="true"/>
```

By default:

- BorderBackgroundColor is TRANSPARENT
- BackgroundColor is WHITE
- SeparatorColor is LTGRAY
- LabelTextColor is BLACK
- ContentTextColor is GRAY
- TextSizeLayout is 14sp
- WithBorder is true

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

  mPassword.isPassword(true);  // Change input type

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

Log
----
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