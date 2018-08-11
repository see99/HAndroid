package top.buend.androidtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import top.buend.toolslibrary.SPTools;

public class SPToolsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_key;
    private Button setFlieName;
    private EditText fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sptools);

        assignViews();
    }

    private EditText key;
    private EditText value;
    private Button btRead;
    private Button btSave;
    private TextView tvValue;

    private void assignViews() {
        key = (EditText) findViewById(R.id.key);
        value = (EditText) findViewById(R.id.value);
        et_key = (EditText) findViewById(R.id.et_key);
        fileName = (EditText) findViewById(R.id.et_flie_name);
        btRead = (Button) findViewById(R.id.bt_read);
        btSave = (Button) findViewById(R.id.bt_save);
        setFlieName = (Button) findViewById(R.id.bt_set_flie_name);
        tvValue = (TextView) findViewById(R.id.tv_value);

        btRead.setOnClickListener(this);
        btSave.setOnClickListener(this);
        setFlieName.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_read:
                String gKey = et_key.getText().toString().trim();
                String stringByDf = SPTools.getString(gKey, "");
                tvValue.setText(stringByDf);
                break;
            case R.id.bt_save:
                String key = this.key.getText().toString().trim();
                String value = this.value.getText().toString().trim();

                SPTools.put(key,value);
                break;
            case R.id.bt_set_flie_name:
                String name = fileName.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(this, "文件名为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                SPTools.setCustomName(name);
                break;
        }
    }
}
