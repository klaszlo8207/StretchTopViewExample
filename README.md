# Tinder like ANDROID stretch top ScrollView 

or just

## Pull to zoom:

This is a **Tinder** like **android Stretch Top ScrollView** / **pull to zoom** custom View..
The Examples show you how can you use this type of view

## Gifs:


![Alt Text](http://x68.imgup.net/gif1a0b0.gif) ![Alt Text](http://q01.imgup.net/gif2dfbb.gif)

## Usage for a top ImageView in xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<hu.lacroix82.stretchtopviewlibrary.StretchTopScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:id="@+id/stretchTopView"
    >

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        >

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="200dp"
            android:id="@+id/topView"
            android:src="@drawable/img1"
            android:scaleType="centerCrop"
            />

       <include layout="@layout/view_bottom" />

    </LinearLayout>

</hu.lacroix82.stretchtopviewlibrary.StretchTopScrollView>
```

## Usage for a top ViewPager in xml:

```java
<?xml version="1.0" encoding="utf-8"?>
<hu.lacroix82.stretchtopviewlibrary.StretchTopScrollView
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:id="@+id/stretchTopView"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical">

        <FrameLayout
            android:layout_width="match_parent"
            android:layout_height="400dp"
            android:id="@+id/topView"
            >

            <android.support.v4.view.ViewPager
                android:layout_width="match_parent"
                android:layout_height="match_parent" />

            <com.viewpagerindicator.CirclePageIndicator
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_gravity="center|bottom"
                android:layout_marginBottom="20dp"
                android:id="@+id/indicator"
                />

        </FrameLayout>

        <include layout="@layout/view_bottom" />

    </LinearLayout>

</hu.lacroix82.stretchtopviewlibrary.StretchTopScrollView>
```

## after just use in code:

```java
        stretchTopView.setFactor(1.7f);

        stretchTopView.setChangeListener(new StretchTopScrollView.onOverScrollChanged() {
            @Override
            public void onChanged(float factor) {
                descriptionTextView.setAlpha(factor);
            }
        });

```

 **.setFactor(float v)** : a float factor for the stretch, between 1.0f and maybe 2.0f, optional, default is 1.6f

 **.setChangeListener(...)** : a simple callback that can return the animated factor in a float : 0-100%, between 0f and 1f
 
 
## Author:

**created** by Kozári László
