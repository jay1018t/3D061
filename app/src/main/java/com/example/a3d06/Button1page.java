package com.example.a3d06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;


public class Button1page extends AppCompatActivity {

    protected int item_no   = 0;
    protected List<String> item_title;
    protected List<Drawable> item_image;
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
        item_image = new ArrayList<>();

        item_title.add(new String("什麼是折射?"));
        item_title.add(new String("屈光的原因?"));
        item_title.add(new String("水面的折射"));
        item_title.add(new String("視深"));
        item_title.add(new String("大氣折射"));

        item_image.add(getResources().getDrawable(R.drawable.photo1));
        item_image.add(getResources().getDrawable(R.drawable.prism));
        item_image.add(getResources().getDrawable(R.drawable.peninwater));
        item_image.add(getResources().getDrawable(R.drawable.pencilinabowlofwater));
        item_image.add(getResources().getDrawable(R.drawable.sunrise));

        item_detail.add(new String("在物理學中，折射（refraction）是指波在穿越介質或經歷介質的漸次變化時傳播方向上的改變；在視光學中，又稱屈光。透過眼睛去看，光的折射的例子最為明顯，是容易觀察的折射現象，不過其他像是聲音和海浪也都會有折射的性質。而一個波的折射程度取決於波速的變化量，還有初始行進方向及波速變化方向間的夾角。"));
        item_detail.add(new String("當光線以一定角度進入具有不同折射率的介質時，光線會發生折射。這種速度的變化導致方向的變化。例如，考慮空氣進入水中。光速隨著它繼續以不同的角度行進而降低,光在玻璃中的折射如上圖所示。當光從空氣傳播到玻璃中時，光會減慢並稍微改變方向。當光從密度較小的物質傳播到密度較大的物質時，折射光會更多地向法線彎曲。如果光波以垂直方向接近邊界，則儘管速度發生變化，光線也不會發生折射。"));
        item_detail.add(new String("當光線穿過水面時會產生折射，這是由於水的折射率為1.33而空氣的折射率是1的緣故。如果注視着一個筆直的物件，例如圖中的鉛筆，傾斜的插在水中，部分位於水面下，則物體看起來像在水面處彎曲了，這是因為光線從水進到空氣時彎曲了。當光抵達眼睛時，人眼會認為他走的是直線來回推（視線），而這兩條視線（圖中虛線）在比光線實際產生位置要高的地方交會，這便導致鉛筆看起來較高和水目測比實際還要淺的現象。"));
        item_detail.add(new String("從水面上觀察認為的水深被稱為視深，這個認知對於用魚叉捕魚非常重要，因為他會使得目標魚看起來跟實際上在不同位置，所以漁夫需要瞄準低一點的地方才能抓到魚。反過來說，在水下觀察時，水面上的物件會有較高的視高，因此射水魚在射擊水面上的目標時需要做出相反的修正。"));
        item_detail.add(new String("空氣的折射率和其密度有關，因此會隨着氣溫和氣壓而改變。由於在高海拔地區的氣壓較低，折射率也較小，使得光線經大氣長途傳播時向地表折射，這會讓接近地平線的星星看起來的位置有些許偏移，也讓我們在日出時能先看見太陽，即便它在幾何上來說仍未升上地平線。"));


        if (item_title.size() > item_no)
        {
            EditText t = findViewById(R.id.textTitle);
            t.setText(item_title.get(item_no));
            //t.setInputType(InputType.TYPE_NULL);
            t.setKeyListener(null);

            EditText td = findViewById(R.id.textDetail);
            td.setText(item_detail.get(item_no));
            //td.setInputType(InputType.TYPE_NULL);
            td.setKeyListener(null);

            ImageView i = findViewById(R.id.textImage);
            i.setImageDrawable(item_image.get(item_no));

            if (Button1page.this.item_no == item_title.size()-1) {
                button1.setText("完成");
            }
        }
    }
}