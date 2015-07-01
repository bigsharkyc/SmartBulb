package com.mod.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

import com.mod.smartbulb.R;

/**
 * Created by yangc on 2015/6/30.
 */
public class EditDelText extends EditText {

    Drawable[] drawables;
    Drawable drawableDel;

    public boolean bShowDel = false;

    public EditDelText(Context context) {
        super(context);
    }

    public EditDelText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EditDelText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        drawables = getCompoundDrawables();
        drawableDel = getResources().getDrawable(R.drawable.ic_del);
        setOnFocusChangeListener(new View.OnFocusChangeListener() {

            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideDelAll();
                } else {
                    if (getText().length() > 0) {
                        showDelAll();
                    }
                }
            }
        });
        addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {

            }

            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            public void afterTextChanged(Editable s) {
                if (!hasFocus()) {
                    return;
                }
                if (s.length() > 0) {
                    showDelAll();
                } else {
                    hideDelAll();
                }
            }
        });

    }

    public void showDelAll() {
        if( bShowDel == false )
        {
            setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawableDel,
                    drawables[3]);
            bShowDel = true;
        }
    }

    protected void hideDelAll() {
        if( bShowDel == true)
        {
            setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], null, drawables[3]);
            bShowDel = false;
        }
    }

    public boolean onTouchEvent(MotionEvent event) {
        if( this.isEnabled() == false)
        {
            return true;
        }

        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                Drawable[] drawables = getCompoundDrawables();
                Drawable right = drawables[2];
                if (right == null) {
                    break;
                }
                Rect rect = right.getBounds();
                if (rect.contains(
                        getWidth() - getPaddingRight() - (int) event.getX(),
                        getHeight() - getPaddingBottom() - (int) event.getY())) {
                    setText("");
                }
                break;
        }
        return super.onTouchEvent(event);
    }

}
