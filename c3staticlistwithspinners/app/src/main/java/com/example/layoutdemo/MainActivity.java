package com.example.layoutdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Spinner sp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.turtle_image);
        sp = findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), position + ": clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {


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