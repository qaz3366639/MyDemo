package org.wrq.mydemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Description:
 * Author: WuRuiqiang(263454190@qq.com)
 * Date: 2015-06-09 11:47
 */
public class HandlerActivity extends Activity {

    private TextView tvTest;

    private int iSendCount = 0;

    private MyHandler myHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        tvTest = (TextView) findViewById(R.id.tvTest);

        new Thread(new MyRunnable()).start();

    }

    public void send(View v) {
        Message msg = new Message();
        msg.what = 1;
        Message msg2 = new Message();
        msg2.what = 1;
        Message msg3 = new Message();
        msg3.what = 1;
        myHandler.sendMessage(msg);
        myHandler.sendMessage(msg2);
        myHandler.sendMessage(msg3);
    }

    private final class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Toast.makeText(HandlerActivity.this, "发送次数：" + iSendCount ++, Toast.LENGTH_SHORT).show();
        }
    }

    private final class MyRunnable implements Runnable {
        @Override
        public void run() {
            Looper.prepare();
            myHandler = new MyHandler();
            Looper.loop();
        }
    }
}
