package com.example.a3d06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Buttonnext1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttonnext1);

        Button button=findViewById(R.id.buttonblack2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Buttonnext1.this,Button1page.class);
                startActivity(intent);

            }
        });

        Button button1=findViewById(R.id.buttonnext2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Buttonnext1.this,Buttonnext2.class);
                startActivity(intent);

            }
        });
    }
}