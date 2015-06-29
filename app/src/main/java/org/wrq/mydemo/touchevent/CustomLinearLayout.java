package org.wrq.mydemo.touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Description:
 * Author: WuRuiqiang(263454190@qq.com)
 * Date: 2015-06-29 15:28
 */
public class CustomLinearLayout extends LinearLayout {

    private boolean isIntercept = false;

    private boolean isConsumeEvent = false;

    private String TAG = "View";

    public CustomLinearLayout(Context context) {
        super(context);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(getContext(), TAG + ":onInterceptTouchEvent ACTION_DOWN ---"
                        + isIntercept, Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Toast.makeText(getContext(), TAG + ":onInterceptTouchEvent ACTION_MOVE ---"
                        + isIntercept, Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Toast.makeText(getContext(), TAG + ":onInterceptTouchEvent ACTION_UP ---"
                        + isIntercept, Toast.LENGTH_SHORT).show();
                break;
        }
        return isIntercept;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(getContext(), TAG + ":onTouchEvent ACTION_DOWN ---"
                        + isConsumeEvent, Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_MOVE:
                Toast.makeText(getContext(), TAG + ":onTouchEvent ACTION_MOVE ---"
                        + isConsumeEvent, Toast.LENGTH_SHORT).show();
                break;
            case MotionEvent.ACTION_UP:
                Toast.makeText(getContext(), TAG + ":onTouchEvent ACTION_UP ---"
                        + isConsumeEvent, Toast.LENGTH_SHORT).show();
                break;
        }
        return isConsumeEvent;
    }

    public boolean isIntercept() {
        return isIntercept;
    }

    public void setIsIntercept(boolean isIntercept) {
        this.isIntercept = isIntercept;
    }

    public boolean isConsumeEvent() {
        return isConsumeEvent;
    }

    public void setIsConsumeEvent(boolean isConsumeEvent) {
        this.isConsumeEvent = isConsumeEvent;
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG;
    }
}
