package top.buend.androidtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import top.buend.toolslibrary.SPTools;

public class SPToolsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_key;

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
        btRead = (Button) findViewById(R.id.bt_read);
        btSave = (Button) findViewById(R.id.bt_save);
        tvValue = (TextView) findViewById(R.id.tv_value);

        btRead.setOnClickListener(this);
        btSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_read:
                String gKey = et_key.getText().toString().trim();
                String stringByDf = SPTools.getStringByDf(gKey, "");
                tvValue.setText(stringByDf);
                break;
            case R.id.bt_save:
                String key = this.key.getText().toString().trim();
                String value = this.value.getText().toString().trim();

                SPTools.putByDf(key,value);
                break;
        }
    }
}
