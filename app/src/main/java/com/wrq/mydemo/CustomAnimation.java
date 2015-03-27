package com.wrq.mydemo;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

/**
 * User: WuRuiqiang(263454190@qq.com)
 * Date: 2015-03-27
 * Time: 15:08
 * Description：
 */
public class CustomAnimation extends Animation {

    int halfWidth;

    int halfHeight;

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);

        setFillAfter(true);
        setDuration(2000);
        halfWidth = width / 2;
        halfHeight = height / 2;
        setInterpolator(new LinearInterpolator());
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        Matrix matrix = t.getMatrix();
        matrix.preScale(interpolatedTime, interpolatedTime);
        matrix.preRotate(interpolatedTime * 360);
        matrix.preTranslate(-halfWidth, -halfHeight);
        matrix.postTranslate(halfWidth, halfHeight);
    }
}
