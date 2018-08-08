package top.buend.androidtools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import top.buend.toolslibrary.DeviceMsgTools;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button appMsgTools;
    private Button netTools;
    private Button deviceMsgTools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appMsgTools = (Button) findViewById(R.id.app_msg_tools);
        netTools = (Button) findViewById(R.id.net_tools);
        deviceMsgTools = (Button) findViewById(R.id.device_msg_tools);
        appMsgTools.setOnClickListener(this);
        netTools.setOnClickListener(this);
        deviceMsgTools.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.app_msg_tools:
                startActivity(new Intent(this, AppMsgToolsActivity.class));
                break;
            case R.id.net_tools:
                startActivity(new Intent(this, NetToolsActivity.class));
                break;
            case R.id.device_msg_tools:
                startActivity(new Intent(this, DeviceMsgToolsActivity.class));
                break;
        }
    }
}
