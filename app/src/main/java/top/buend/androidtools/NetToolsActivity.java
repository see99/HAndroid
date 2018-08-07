package top.buend.androidtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import top.buend.toolslibrary.NetTools;

public class NetToolsActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView netState;
    private Button openNetworkSetting;
    private TextView netType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_tools);
        netState = (TextView) findViewById(R.id.tv_net_state);
        netType = (TextView) findViewById(R.id.tv_net_type);
        openNetworkSetting = (Button) findViewById(R.id.bt_open_network_setting);
        openNetworkSetting.setOnClickListener(this);
        initData();
    }

    private void initData() {
        if(NetTools.isNetConnected()){
            if(NetTools.isAvailable()){
                netState.setText("网络已连接  可用");
            }else {
                netState.setText("网络已连接  不可用");
            }

        }else {
            netState.setText("网络已断开");
        }

        String netTypeConnection = "";

        if(NetTools.isWifiConnection()){
            netTypeConnection+="Wifi 已连接";
        }else {
            netTypeConnection+="Wifi 未连接";
        }

        if(NetTools.isGPRSConnection()){
            netTypeConnection+="  移动网络 已连接";
        }else {
            netTypeConnection+="  移动网络 未连接";
        }
        netType.setText(netTypeConnection);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_open_network_setting:
                NetTools.openNetworkSettion();
                break;
        }
    }
}
