package com.example.onclick;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    ImageButton imgbtn;
    ImageView imgbtn2;
    public static ImageView rank;
    public static int count = 0;
    public static int woodsword = 1; // 나무검 기본제공
    public static int stonesword = 0;
    public static int ironsword = 0;
    public static int goldsword = 0;
    public static int diamondsword = 0;
    public static int sword = 1;
    int count_num = 0;
    int point_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rank = (ImageView)findViewById(R.id.rank);
        imgbtn = (ImageButton)findViewById(R.id.monster);
        TextView count_num = (TextView) findViewById(R.id.point);


        // 가장 강한거 자동 장착
        Toast.makeText(MainActivity.this, "검 자동 장착 중...", Toast.LENGTH_SHORT).show();
        if (diamondsword == 1) {
            sword = 5;
            rank.setImageResource(R.drawable.diamond);
        }
        else if (goldsword == 1) {
            sword = 4;
            rank.setImageResource(R.drawable.gold);
        }
        else if (ironsword == 1) {
            sword = 3;
            rank.setImageResource(R.drawable.iron);
        }
        else if (stonesword == 1) {
            sword = 2;
            rank.setImageResource(R.drawable.stone);
        }
        else if (woodsword == 1) {
            sword = 1;
        }

        imgbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(sword == 1) {
                    count = count + 1;
                }
                else if(sword == 2) {
                    count = count + 2;
                }
                else if(sword == 3) {
                    count = count + 3;
                }
                else if(sword == 4) {
                    count = count + 4;
                }
                else if(sword == 5) {
                    count = count + 5;
                }

                count_num.setText(""+count);

                if(count >= 400) {
                    Toast.makeText(MainActivity.this, "400점을 획득하여 클리어 하셨습니다!", Toast.LENGTH_SHORT).show();
                    imgbtn.setImageResource(R.drawable.mumu);
                }
            }
        });

        imgbtn2 = (ImageView) findViewById(R.id.goto_shop);
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);

                finish();
            }
        });
    }
}
