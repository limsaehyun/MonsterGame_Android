package com.example.onclick;

import android.content.SharedPreferences;
import android.media.SoundPool;
import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.media.MediaPlayer;


public class SettingActivity extends AppCompatActivity {

    Switch soundsw;
    Switch musicsw;
    Button reset;
    Button return_;
    int sw_mc = 1;
    int sw_sd = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);


        // 스위치 저장
        soundsw = (Switch)findViewById(R.id.soundsetting);
        musicsw = (Switch)findViewById(R.id.music);

        SharedPreferences musicpref = getSharedPreferences("music_save", MODE_PRIVATE);
        sw_mc = musicpref.getInt("music_boolean", 1);
        if(sw_mc == 1) {
            musicsw.setChecked(true);
        }
        else {
            musicsw.setChecked(false);
        }

        SharedPreferences soundpref = getSharedPreferences("sound_save", MODE_PRIVATE);
        sw_sd = soundpref.getInt("sound_boolean", 1);
        if(sw_sd == 1) {
            soundsw.setChecked(true);
        }
        else {
            soundsw.setChecked(false);
        }

        soundsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    SharedPreferences.Editor editor = getSharedPreferences("sound_save", MODE_PRIVATE).edit();
                    editor.putInt("sound_boolean", 1);
                    MainActivity.soundcheck = 1;

                    editor.commit();
                }
                else {
                    SharedPreferences.Editor editor = getSharedPreferences("sound_save", MODE_PRIVATE).edit();
                    editor.putInt("sound_boolean", 0);
                    MainActivity.soundcheck = 0;

                    editor.commit();
                }
            }
        });

        musicsw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    SharedPreferences.Editor editor = getSharedPreferences("music_save", MODE_PRIVATE).edit();
                    editor.putInt("music_boolean", 1);

                    editor.commit();
                } else {
                    SharedPreferences.Editor editor = getSharedPreferences("music_save", MODE_PRIVATE).edit();
                    editor.putInt("music_boolean", 0);

                    editor.commit();
                }
            }
        });

        reset = (Button)findViewById(R.id.reset);
        return_ = (Button)findViewById(R.id.return_);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.clear = 1;
                {
                    SharedPreferences.Editor editor = getSharedPreferences("sound_save", MODE_PRIVATE).edit();
                    editor.putInt("sound_boolean", 1);
                    editor.commit();
                }
                {
                    SharedPreferences.Editor editor = getSharedPreferences("music_save", MODE_PRIVATE).edit();
                    editor.putInt("music_boolean", 1);
                    editor.commit();
                }

                finish();
            }
        });

        // 메인 이동
        return_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
    }

}

