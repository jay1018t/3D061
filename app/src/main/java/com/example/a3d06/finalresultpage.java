package com.example.a3d06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class finalresultpage extends AppCompatActivity implements View.OnClickListener{
    Button submitBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String scoreMessage = "";
        if (getIntent().getStringExtra("scoreMessage") != null) {
            scoreMessage = getIntent().getStringExtra("scoreMessage");
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalresultpage);

        TextView resultTextView   = findViewById(R.id.result);
        resultTextView.setText(scoreMessage);

        submitBtn = findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(this);
    }


    public void onClick(View view)
    {

        Button clickedButton = (Button) view;
        if (clickedButton.getId() == R.id.submit_btn) {

            Intent intent = new Intent(finalresultpage.this, MainActivity.class);
            startActivity(intent);
        }
    }
}