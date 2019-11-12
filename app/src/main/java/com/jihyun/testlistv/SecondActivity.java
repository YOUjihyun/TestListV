package com.jihyun.testlistv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvA;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        this.tvA = findViewById(R.id.textA);
        String nameA =  getIntent().getStringExtra("keyA");
        this.tvA.setText(nameA);
    }

    public void confirm(View V){

        Intent intentA = new Intent();
        intentA.putExtra("keyB","1234567890");

        setResult(500, intentA);  //데이터를 옮기고 전달해주는 즉 데이터 옮겨야해  코드가 500이고
        finish();

    }
}
