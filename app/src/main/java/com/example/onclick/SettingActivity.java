package com.example.onclick;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {

    Switch sound;
    Button reset;
    Button return_;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        sound = (Switch)findViewById(R.id.soundsetting);
        reset = (Button)findViewById(R.id.reset);
        return_ = (Button)findViewById(R.id.return_);


    }

}

