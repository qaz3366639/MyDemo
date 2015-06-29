package org.wrq.mydemo.touchevent;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import org.wrq.mydemo.R;

/**
 * Description:
 * Author: WuRuiqiang(263454190@qq.com)
 * Date: 2015-06-29 14:32
 */
public class TouchEventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event);

        final CustomLinearLayout view1 = (CustomLinearLayout) findViewById(R.id.cllView1);
        final CustomLinearLayout view2 = (CustomLinearLayout) findViewById(R.id.cllView2);
        Switch        sIntercept       = (Switch) findViewById(R.id.sIntercept);
        Switch        sIntercept2      = (Switch) findViewById(R.id.sIntercept2);
        Switch        sEvent           = (Switch) findViewById(R.id.sEvent);
        Switch        sEvent2          = (Switch) findViewById(R.id.sEvent2);

        view1.setTAG("view1");
        view2.setTAG("view2");
        sIntercept.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                view1.setIsIntercept(isChecked);
            }
        });

        sIntercept2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                view2.setIsIntercept(isChecked);
            }
        });

        sEvent.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                view1.setIsConsumeEvent(isChecked);
            }
        });

        sEvent2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                view2.setIsConsumeEvent(isChecked);
            }
        });
    }

}
