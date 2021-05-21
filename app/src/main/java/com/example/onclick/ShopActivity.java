package com.example.onclick;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
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

import org.w3c.dom.Text;

public class ShopActivity extends AppCompatActivity {

    Button wood_buy;
    Button stone_buy;
    Button iron_buy;
    Button gold_buy;
    Button diamond_buy;
    Button wood_sell;
    Button stone_sell;
    Button iron_sell;
    Button gold_sell;
    Button diamond_sell;
    Button back;
    TextView PointText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);


        PointText = (TextView)findViewById(R.id.shoppoint);
        PointText.setText(MainActivity.count + "");

        wood_buy = (Button)findViewById(R.id.wood_buy);
        wood_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.woodsword == 1) {
                    Toast.makeText(ShopActivity.this, "이미 보유중입니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        stone_buy = (Button)findViewById(R.id.stone_buy);
        stone_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.count >= 20) {
                    if(MainActivity.stonesword == 1) {
                        Toast.makeText(ShopActivity.this, "이미 보유중입니다!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ShopActivity.this, "20점을 사용하여 돌검 구매 완료!", Toast.LENGTH_SHORT).show();
                        MainActivity.stonesword = 1;
                        MainActivity.count -= 20;
                        PointText.setText(MainActivity.count + "");
                    }
                }
                else {
                    Toast.makeText(ShopActivity.this, "돈이 부족합니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        iron_buy = (Button)findViewById(R.id.iron_buy);
        iron_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.count >= 30) {
                    if(MainActivity.ironsword == 1) {
                        Toast.makeText(ShopActivity.this, "이미 보유중입니다!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ShopActivity.this, "30점을 사용하여 철검 구매 완료!", Toast.LENGTH_SHORT).show();
                        MainActivity.ironsword = 1;
                        MainActivity.count -= 30;
                        PointText.setText(MainActivity.count + "");
                    }
                }
                else {
                    Toast.makeText(ShopActivity.this, "돈이 부족합니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        gold_buy = (Button)findViewById(R.id.gold_buy);
        gold_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.count >= 40) {
                    if(MainActivity.goldsword == 1) {
                        Toast.makeText(ShopActivity.this, "이미 보유중입니다!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ShopActivity.this, "40점을 사용하여 금검 구매 완료!", Toast.LENGTH_SHORT).show();
                        MainActivity.goldsword = 1;
                        MainActivity.count -= 40;
                        PointText.setText(MainActivity.count + "");
                    }
                }
                else {
                    Toast.makeText(ShopActivity.this, "돈이 부족합니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        diamond_buy = (Button)findViewById(R.id.diamond_buy);
        diamond_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.count >= 50) {
                    if(MainActivity.diamondsword == 1) {
                        Toast.makeText(ShopActivity.this, "이미 보유중입니다!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(ShopActivity.this, "50점을 사용하여 다이아검 구매 완료!", Toast.LENGTH_SHORT).show();
                        MainActivity.diamondsword = 1;
                        MainActivity.count -= 50;
                        PointText.setText(MainActivity.count + "");
                    }
                }
                else {
                    Toast.makeText(ShopActivity.this, "돈이 부족합니다!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(ShopActivity.this, MainActivity.class);
                //startActivity(intent);

                finish();
            }
        });

        // 판매
        wood_sell = (Button)findViewById(R.id.wood_sell);
        wood_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ShopActivity.this, "기본 검은 판매가 불가능합니다.", Toast.LENGTH_SHORT).show();
            }
        });
        stone_sell = (Button)findViewById(R.id.stone_sell);
        stone_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.stonesword == 1) {
                    Toast.makeText(ShopActivity.this, "판매 완료!", Toast.LENGTH_SHORT).show();
                    MainActivity.stonesword = 0;
                    MainActivity.count += 20;
                    PointText.setText(MainActivity.count + "");
                }
                else {
                    Toast.makeText(ShopActivity.this, "보유하고 있지 않습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        iron_sell = (Button)findViewById(R.id.iron_sell);
        iron_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.ironsword == 1) {
                    Toast.makeText(ShopActivity.this, "판매 완료!", Toast.LENGTH_SHORT).show();
                    MainActivity.ironsword = 0;
                    MainActivity.count += 20;
                    PointText.setText(MainActivity.count + "");
                }
                else {
                    Toast.makeText(ShopActivity.this, "보유하고 있지 않습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        gold_sell = (Button)findViewById(R.id.gold_sell);
        gold_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.goldsword == 1) {
                    Toast.makeText(ShopActivity.this, "판매 완료!", Toast.LENGTH_SHORT).show();
                    MainActivity.goldsword = 0;
                    MainActivity.count += 20;
                    PointText.setText(MainActivity.count + "");
                }
                else {
                    Toast.makeText(ShopActivity.this, "보유하고 있지 않습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        diamond_sell = (Button)findViewById(R.id.diamond_sell);
        diamond_sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(MainActivity.diamondsword == 1) {
                    Toast.makeText(ShopActivity.this, "판매 완료!", Toast.LENGTH_SHORT).show();
                    MainActivity.diamondsword = 0;
                    MainActivity.count += 20;
                    PointText.setText(MainActivity.count + "");
                }
                else {
                    Toast.makeText(ShopActivity.this, "보유하고 있지 않습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}