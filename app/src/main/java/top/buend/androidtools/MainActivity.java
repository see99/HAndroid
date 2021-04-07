package top.buend.androidtools;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button appMsgTools;
    private Button netTools;
    private Button deviceMsgTools;
    private Button sp_tools;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        appMsgTools = (Button) findViewById(R.id.app_msg_tools);
        netTools = (Button) findViewById(R.id.net_tools);
        deviceMsgTools = (Button) findViewById(R.id.device_msg_tools);
        sp_tools = (Button) findViewById(R.id.sp_tools);
        appMsgTools.setOnClickListener(this);
        netTools.setOnClickListener(this);
        deviceMsgTools.setOnClickListener(this);
        sp_tools.setOnClickListener(this);
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
            case R.id.sp_tools:
                startActivity(new Intent(this, SPToolsActivity.class));
                break;
        }
    }
}
