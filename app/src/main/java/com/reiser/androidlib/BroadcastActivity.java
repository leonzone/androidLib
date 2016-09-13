package com.reiser.androidlib;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.reiser.androidlib.receiver.NetworkChangeReceiver;

/**
 * 动态注册广播,静态注册在AndroidManifest.xml查看
 */
public class BroadcastActivity extends AppCompatActivity {

    IntentFilter intentFilter;
    NetworkChangeReceiver networkChangeReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkChangeReceiver = new NetworkChangeReceiver();
        //注册监听广播
        registerReceiver(networkChangeReceiver, intentFilter);

        Button button = new Button(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcasttest. MY_BROADCAST");
                // 发送广播
                sendBroadcast(intent);
            }
        });


        // 本地广播
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

    }

    @Override
    protected void onDestroy() {
        //取消监听广播
        unregisterReceiver(networkChangeReceiver);
        super.onDestroy();
    }
}

