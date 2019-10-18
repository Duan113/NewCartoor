package com.example.newcartoor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btbj,btz,btsx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btbj=findViewById(R.id.bt_bj);
        btz=findViewById(R.id.bt_z);
        btsx=findViewById(R.id.bt_sx);

        btbj.setOnClickListener(this);
        btz.setOnClickListener(this);
        btsx.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_bj:
                Intent intent=new Intent(MainActivity.this,TweenAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_z:
                intent=new Intent(MainActivity.this, FrameAnimationActivity.class);
                startActivity(intent);
                break;
            case R.id.bt_sx:
                intent=new Intent(MainActivity.this,ValueAnimationActivity.class);
                startActivity(intent);
                break;
        }
    }
}
