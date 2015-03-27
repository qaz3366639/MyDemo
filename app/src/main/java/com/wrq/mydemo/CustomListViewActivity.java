package com.wrq.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * User: WuRuiqiang(263454190@qq.com)
 * Date: 2015-03-27
 * Time: 10:43
 * Description：
 */
public class CustomListViewActivity extends Activity {

    private ArrayList<String> mArrayList = new ArrayList<>();

    private ImageView lvCustom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview);
        lvCustom = (ImageView) findViewById(R.id.lvCustom);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_expandable_list_item_1, getData());
        lvCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lvCustom.startAnimation(getScaleAnimation());
            }
        });
//        lvCustom.setAdapter(arrayAdapter);
//        lvCustom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                lvCustom.startAnimation(getScaleAnimation());
//            }
//        });
//        lvCustom.setLayoutAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//                lvCustom.layout(0, 0, lvCustom.getRight() / 2, lvCustom.getBottom());
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation) {
//
//            }
//        });
    }

    private ScaleAnimation getScaleAnimation() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.5f, 1.0f, 1.0f, Animation
                .RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setFillEnabled(true);
        return scaleAnimation;
    }

    private ArrayList<String> getData() {
        mArrayList.add("测试数据1");
        mArrayList.add("测试数据2");
        mArrayList.add("测试数据3");
        mArrayList.add("测试数据4");
        mArrayList.add("测试数据5");
        mArrayList.add("测试数据6");
        return mArrayList;
    }
}
