package com.example.a3d06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.graphics.ColorUtils;

public class Button2page extends AppCompatActivity implements View.OnClickListener {
    TextView TitleTextView;
    Button bl, gl, rl, wl;
    Button db, bb, gb, rb, wb;
    Button resultLight;
    Button submitBtn;

    int LightIndex  = 0;
    int BallIndex  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button2page);

        TitleTextView = findViewById(R.id.result);
        TitleTextView.setText("點選光源顏色及小球顏色, 便會出現物件呈現的顏色");
        bl = findViewById(R.id.bl);
        gl = findViewById(R.id.gl);
        rl = findViewById(R.id.rl);
        wl = findViewById(R.id.wl);

        db = findViewById(R.id.db);
        bb = findViewById(R.id.bb);
        gb = findViewById(R.id.gb);
        rb = findViewById(R.id.rb);
        wb = findViewById(R.id.wb);

        resultLight = findViewById(R.id.resultLight);
        resultLight.setText("物件呈現的顏色");

        submitBtn = findViewById(R.id.submit_btn);

        bl.setOnClickListener(this);
        gl.setOnClickListener(this);
        rl.setOnClickListener(this);
        wl.setOnClickListener(this);

        db.setOnClickListener(this);
        bb.setOnClickListener(this);
        gb.setOnClickListener(this);
        rb.setOnClickListener(this);
        wb.setOnClickListener(this);

        bl.setBackgroundColor(Color.BLUE);
        bl.setAlpha(.5f);

        gl.setBackgroundColor(Color.GREEN);
        rl.setBackgroundColor(Color.RED);
        wl.setBackgroundColor(Color.WHITE);

        db.setBackgroundColor(Color.BLACK);
        bb.setBackgroundColor(Color.BLUE);
        gb.setBackgroundColor(Color.GREEN);
        rb.setBackgroundColor(Color.RED);
        wb.setBackgroundColor(Color.WHITE);

        resultLight.setBackgroundColor(Color.BLACK);

        submitBtn.setOnClickListener(this);
        SetLight(0);
        SetBall(0);
    }

    protected void SetLight(int nIndex) {
        bl.setAlpha(nIndex == 1?1.0f:0.5f);
        gl.setAlpha(nIndex == 2?1.0f:0.5f);
        rl.setAlpha(nIndex == 3?1.0f:0.5f);
        wl.setAlpha(nIndex == 4?1.0f:0.5f);

        LightIndex  = nIndex;
    }
    protected void SetBall(int nIndex) {
        gb.setAlpha(nIndex == 1?1.0f:0.5f);
        bb.setAlpha(nIndex == 2?1.0f:0.5f);
        gb.setAlpha(nIndex == 3?1.0f:0.5f);
        rb.setAlpha(nIndex == 4?1.0f:0.5f);
        wb.setAlpha(nIndex == 5?1.0f:0.5f);

        BallIndex  = nIndex;
    }

    @Override
    public void onClick(View view) {

        Button clickedButton = (Button) view;
        if(clickedButton.getId()==R.id.submit_btn){
            Intent intent = new Intent(Button2page.this, MainActivity.class);
            startActivity(intent);
        }
        else if(clickedButton.getId()==R.id.bl){
            //單擊選擇按鈕
            SetLight(1);
        }
        else if(clickedButton.getId()==R.id.gl){
            //單擊選擇按鈕
            SetLight(2);
        }
        else if(clickedButton.getId()==R.id.rl){
            //單擊選擇按鈕
            SetLight(3);
        }
        else if(clickedButton.getId()==R.id.wl){
            //單擊選擇按鈕
            SetLight(4);
        }
        else if(clickedButton.getId()==R.id.db){
            //單擊選擇按鈕
            SetBall(1);
        }
        else if(clickedButton.getId()==R.id.bb){
            //單擊選擇按鈕
            SetBall(2);
        }
        else if(clickedButton.getId()==R.id.gb){
            //單擊選擇按鈕
            SetBall(3);
        }
        else if(clickedButton.getId()==R.id.rb){
            //單擊選擇按鈕
            SetBall(4);
        }
        else if(clickedButton.getId()==R.id.wb){
            //單擊選擇按鈕
            SetBall(5);
        }

        // set the result color
        if (LightIndex > 0 && BallIndex > 0) {
            int resultColor   = Color.BLACK;
            int resultColor2  = Color.BLACK;
            if (BallIndex != 1) {   // Dark ball always show no color
                if (LightIndex == 1) {
                    // Blue light
                    resultColor = Color.BLUE;
                }
                if (LightIndex == 2) {
                    resultColor = Color.GREEN;
                }
                if (LightIndex == 3) {
                    resultColor = Color.RED;
                }
                if (LightIndex == 4) {
                    resultColor = Color.WHITE;
                }

                if (BallIndex == 2)
                    resultColor2 = Color.BLUE;
                if (BallIndex == 3)
                    resultColor2 = Color.GREEN;
                if (BallIndex == 4)
                    resultColor2 = Color.RED;
                if (BallIndex == 5)
                    resultColor2 = Color.WHITE;

                if (resultColor == Color.WHITE)
                {
                    resultColor =resultColor2;
                }
                else if (resultColor2 != Color.WHITE)
                {
                    if (resultColor != resultColor2) {
                        resultColor = Color.BLACK;
                    }
                }
            }
            resultLight.setBackgroundColor(resultColor);
        }
    }
}