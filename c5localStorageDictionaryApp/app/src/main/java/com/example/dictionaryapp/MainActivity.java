package com.example.dictionaryapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
  ListView lv;
  ArrayList <String> mStrings;
  HashMap<String,String> mHashMap;
  TextView tv;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHashMap = new HashMap<>();
        tv = (TextView) findViewById(R.id.word);


        lv = findViewById(R.id.listview);
        mStrings = new ArrayList<>();


        InputStream fr = getResources().openRawResource(R.raw.words);
        Scanner sc = new Scanner(fr);


        while(sc.hasNext()){
           String line = sc.nextLine();
         String [] pieces = line.split("-");
          mHashMap.put(pieces[0],pieces[1]);
        }




            ArrayList<String> keys = (ArrayList<String>) mHashMap.keySet().stream().collect(Collectors.toList());
        ArrayList<String> defs = (ArrayList<String>) mHashMap.values().stream().collect(Collectors.toList());
        Random rand = new Random();

        tv.setText(keys.get(rand.nextInt(keys.size())));





        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defs);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                defs.add("new one");
                adapter.notifyDataSetChanged();
            }
        });




    }
}