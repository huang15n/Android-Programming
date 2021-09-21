package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.turtle_image);
        sw = findViewById(R.id.switcher);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                   Toast.makeText(getApplicationContext(), "this is checked", Toast.LENGTH_SHORT).show();
               }
            else{
                Toast.makeText(getApplicationContext(), "this is unchecked", Toast.LENGTH_SHORT).show();

            }
            }
        });
    }

    public void swtichImage(View view) {
        switch(view.getId()){
            case R.id.turtle1:
                iv.setImageResource(R.drawable.turtle1);
                break;
                case R.id.turtle2:
                    iv.setImageResource(R.drawable.turtle2);
                    break;
            case R.id.turtle3:
                iv.setImageResource(R.drawable.turtle3);
                break;
            case R.id.turtle4:
                iv.setImageResource(R.drawable.turtle4);
                break;



        }


    }
}