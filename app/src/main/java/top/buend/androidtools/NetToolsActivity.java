package top.buend.androidtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import top.buend.toolslibrary.NetTools;

public class NetToolsActivity extends AppCompatActivity {

    private TextView netState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_tools);
        netState = (TextView) findViewById(R.id.tv_net_state);

        initData();
    }

    private void initData() {
        if(NetTools.isNetConnected()){
            netState.setText("网络已连接");
        }else {
            netState.setText("网络已断开");
        }
    }
}
