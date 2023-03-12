package com.example.a3d06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class Button1page extends AppCompatActivity {

    protected int item_no   = 0;
    protected List<String> item_title;
    protected List<String> item_image;
    protected List<String> item_detail;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        if (getIntent().getIntExtra("ITEM_NO", 0) > 0) {
            item_no = getIntent().getIntExtra("ITEM_NO", 0);
        }

        //putExtra("", Button1page.this.item_no);
        /*Get
        Intent it = getParentActivityIntent();
        it.ghe
        String cn = it.getComponent().getClassName();
        if (cn == "") {
        }
        }*/


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button1page);

        Button button=findViewById(R.id.BackButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button1page.this.item_no--;
                if (Button1page.this.item_no < 0)
                {
                    Intent intent = new Intent(Button1page.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent=new Intent(Button1page.this, Button1page.class);
                    intent.putExtra("ITEM_NO", Button1page.this.item_no);
                    startActivity(intent);
                }
            }
        });

        Button button1=findViewById(R.id.NextButton);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Button1page.this.item_no++;
                if (Button1page.this.item_no == item_title.size()) {
                    // this is the last one
                    Intent intent = new Intent(Button1page.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Button1page.this, Button1page.class);
                    intent.putExtra("ITEM_NO", Button1page.this.item_no);
                    startActivity(intent);
                }
            }
        });

        // Load the data
        item_title = new ArrayList<>();
        item_detail = new ArrayList<>();

        item_title.add(new String("什麼是折射?"));
        item_title.add(new String("什麼是折射2?"));
        item_title.add(new String("什麼是折射3?"));
        //item_image.add();
        item_detail.add(new String("在物理學中，折射（refraction）是指波在穿越介質或經歷介質的漸次變化時傳播方向上的改變；在視光學中，又稱屈光。透過眼睛去看，光的折射的例子最為明顯，是容易觀察的折射現象，不過其他像是聲音和海浪也都會有折射的性質。而一個波的折射程度取決於波速的變化量，還有初始行進方向及波速變化方向間的夾角。"));
        item_detail.add(new String("2在物理學中，折射（refraction）是指波在穿越介質或經歷介質的漸次變化時傳播方向上的改變；在視光學中，又稱屈光。透過眼睛去看，光的折射的例子最為明顯，是容易觀察的折射現象，不過其他像是聲音和海浪也都會有折射的性質。而一個波的折射程度取決於波速的變化量，還有初始行進方向及波速變化方向間的夾角。"));
        item_detail.add(new String("3在物理學中，折射（refraction）是指波在穿越介質或經歷介質的漸次變化時傳播方向上的改變；在視光學中，又稱屈光。透過眼睛去看，光的折射的例子最為明顯，是容易觀察的折射現象，不過其他像是聲音和海浪也都會有折射的性質。而一個波的折射程度取決於波速的變化量，還有初始行進方向及波速變化方向間的夾角。"));


        if (item_title.size() > item_no)
        {
            EditText t = findViewById(R.id.textTitle);
            t.setText(item_title.get(item_no));
            EditText td = findViewById(R.id.textDetail);
            td.setText(item_detail.get(item_no));

            if (Button1page.this.item_no == item_title.size()-1) {
                button1.setText("完成");
            }
        }
    }
}