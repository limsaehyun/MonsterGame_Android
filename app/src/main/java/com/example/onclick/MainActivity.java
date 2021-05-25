package com.example.onclick;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Switch soundswitch;
    ImageButton imgbtn;
    ImageView imgbtn2;
    ImageView imgbtn3;

    public static MediaPlayer background;
    SoundPool sound_coin = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);

    ImageView rank;
    public static int soundcheck = 1;
    public static int count = 0;
    public static int woodsword = 1; // 나무검 기본제공
    public static int stonesword = 0;
    public static int ironsword = 0;
    public static int goldsword = 0;
    public static int diamondsword = 0;
    public static int sword = 1;
    public static int soundset = 1;
    public static int count_num;
    public static int point_num = 0;
    public static int clear = 0;
    static int save_check1 = 0;
    int temp = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        background = MediaPlayer.create(getBaseContext(), R.raw.background_music);

        // 한 번만 불러오기
        if (save_check1 == 0) {
            save_check1 = 1;
            SharedPreferences pref = getSharedPreferences("save", MODE_PRIVATE);
            count = pref.getInt("count", 0);
            stonesword = pref.getInt("stonesword", 0);
            ironsword = pref.getInt("ironsword", 0);
            goldsword = pref.getInt("goldsword", 0);
            diamondsword = pref.getInt("diamondsword", 0);
            point_num = pref.getInt("point_num", 0);
            count_num = count;
            Toast.makeText(MainActivity.this, "불러오기 중...", Toast.LENGTH_SHORT).show();
        }

        rank = (ImageView) findViewById(R.id.rank);
        imgbtn = (ImageButton) findViewById(R.id.monster);
        TextView count_num = (TextView) findViewById(R.id.point);

        if (clear == 1) { // 초기화
            clear = 0;
            soundcheck = 1;
            count = 0;
            woodsword = 1;
            stonesword = 0;
            ironsword = 0;
            goldsword = 0;
            diamondsword = 0;
            sword = 1;
            soundset = 1;
            point_num = 0;
            Toast.makeText(MainActivity.this, "초기화 중...", Toast.LENGTH_SHORT).show();
        }

        // 소리
        int soundld = sound_coin.load(this, R.raw.sound_coin, 1);


        // 가장 강한거 자동 장착
        if (diamondsword == 1) {
            sword = 5;
            rank.setImageResource(R.drawable.diamond);
        } else if (goldsword == 1) {
            sword = 4;
            rank.setImageResource(R.drawable.gold);
        } else if (ironsword == 1) {
            sword = 3;
            rank.setImageResource(R.drawable.iron);
        } else if (stonesword == 1) {
            sword = 2;
            rank.setImageResource(R.drawable.stone);
        } else if (woodsword == 1) {
            sword = 1;
            rank.setImageResource(R.drawable.wood);
        }

        imgbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // 칼에 따라 포인트 지급
                if (sword == 1) {
                    count = count + 1;
                } else if (sword == 2) {
                    count = count + 2;
                } else if (sword == 3) {
                    count = count + 3;
                } else if (sword == 4) {
                    count = count + 4;
                } else if (sword == 5) {
                    count = count + 5;
                }

                count_num.setText("" + count);

                if (soundcheck == 1) {
                    sound_coin.play(soundld, 1F, 1F, 0, 0, 1F);
                }

                // 엔딩
                if (count >= 400) {
                    Toast.makeText(MainActivity.this, "400점을 획득하여 클리어 하셨습니다!", Toast.LENGTH_SHORT).show();
                    imgbtn.setImageResource(R.drawable.mumu);
                }
            }
        });

        // 상점 이동
        imgbtn2 = (ImageView) findViewById(R.id.goto_shop);
        imgbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);
                startActivity(intent);

            }
        });

        // 설정 이동
        imgbtn3 = (ImageView) findViewById(R.id.settings);
        imgbtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        // 음악 체크
        SharedPreferences musicpref = getSharedPreferences("music_save", MODE_PRIVATE);
        int sw_mc = musicpref.getInt("music_boolean", 0);

        if (sw_mc == 1) {
            if (!background.isPlaying()) {
                background = MediaPlayer.create(getBaseContext(), R.raw.background_music);
                background.start();
                background.setLooping(true);
            }
        } else if (sw_mc == 0) {
            background.setLooping(false);
            background.stop();
            background.reset();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 저장
        SharedPreferences sharedPreferences = getSharedPreferences("save", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("count", count);
        editor.putInt("count_num", count_num);
        editor.putInt("pount_num", point_num);
        editor.putInt("stonesword", stonesword);
        editor.putInt("ironsword", ironsword);
        editor.putInt("goldsword", goldsword);
        editor.putInt("diamondsword", diamondsword);

        editor.commit();
    }


}
