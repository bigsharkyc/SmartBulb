package com.mod.smartbulb;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.mod.utils.BitmapUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangc on 2015/6/30.
 */
public class WelcomeActivity extends Activity implements ViewPager.OnPageChangeListener, View.OnClickListener{

    ViewPager mViewPager;
    MyApdapter myApdapter;
    int[] mPic = null;
    List<View> mViews = null;
    View view = null;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.welcome_layout, null);
        setContentView(view);
        mButton = (Button)view.findViewById(R.id.btn_enter);
        mButton.setOnClickListener(this);
        mViewPager = (ViewPager)view.findViewById(R.id.welcome_viewpage);
        mViewPager.setOnPageChangeListener(this);

        if (mPic == null){
            mPic = new int[]{R.drawable.welcome1, R.drawable.welcome2, R.drawable.welcome3};
        }
        mViews = new ArrayList<>();

        for (int i = 0; i < mPic.length; i++){
            ImageView img = new ImageView(this);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            Bitmap bp = BitmapUtils.readBitMap(this, mPic[i]);
            img.setImageBitmap(bp);

            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            img.setLayoutParams(params);
            mViews.add(img);
        }
        myApdapter = new MyApdapter(mViews);
        mViewPager.setAdapter(myApdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mViews != null){
            for (int k = 0; k < mViews.size(); k++){
                ((ImageView)mViews.get(k)).setImageBitmap(null);
            }
        }
        if (mViewPager != null){
            mViewPager.removeAllViews();
        }
        System.gc();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        if (position == mViews.size() -1){
            mButton.setVisibility(View.VISIBLE);
        }else {
            mButton.setVisibility(View.GONE);
        }
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_enter){
            finish();
        }
    }

    private class MyApdapter extends PagerAdapter{
        public List<View> mViews;

        public MyApdapter(List<View> mViews) {
            this.mViews = mViews;
        }

        @Override
        public int getCount() {
            return mViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(mViews.get(position), 0);
            return mViews.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager)container).removeView(mViews.get(position));
        }


    }
}
