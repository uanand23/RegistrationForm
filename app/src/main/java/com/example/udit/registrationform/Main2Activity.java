package com.example.udit.registrationform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;


public class Main2Activity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String msg = i.getStringExtra("mess");

        tv = findViewById(R.id.tv);
        tv.setText(msg);
    }
    public void back(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
