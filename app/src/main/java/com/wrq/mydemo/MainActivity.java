package com.wrq.mydemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    ListView lvDemo;

    String[] demoNames;

    String[] demoComponentNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDemo = (ListView) findViewById(R.id.lvDemo);
        demoNames = getResources().getStringArray(R.array.demoNames);
        demoComponentNames = getResources().getStringArray(R.array.demoComponentNames);
        DemoListAdapter demoListAdapter = new DemoListAdapter();
        lvDemo.setAdapter(demoListAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    final class DemoListAdapter extends BaseAdapter {

        final class ViewHolder {
            Button btnDemo;
        }

        @Override
        public int getCount() {
            return demoNames.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(MainActivity.this).inflate
                        (R.layout.item_demo_list, parent, false);
                holder.btnDemo = (Button) convertView.findViewById(R.id.btnDemo);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            final int index = position;
            holder.btnDemo.setText(demoNames[position]);
            holder.btnDemo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setClassName(getPackageName(), demoComponentNames[index]);
                    startActivity(intent);
                }
            });
            return convertView;
        }
    }
}
