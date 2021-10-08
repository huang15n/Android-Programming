package com.example.dictionaryapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    ArrayList<String> keys;
    ArrayList<String> defs;
    ArrayAdapter<String> adapter;

    private final static int STUPID_CODE= 123;

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




           keys = (ArrayList<String>) mHashMap.keySet().stream().collect(Collectors.toList());
       defs = (ArrayList<String>) mHashMap.values().stream().collect(Collectors.toList());
        Random rand = new Random();

        tv.setText(keys.get(rand.nextInt(keys.size())));
  try {
      PrintStream outStream = new PrintStream(openFileOutput("out.txt", MODE_PRIVATE));
      outStream.println("hello word");
      outStream.close();

  }catch (FileNotFoundException fe) {
      Log.v("what", "file not found");

  }


         adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defs);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                defs.remove(position);
                adapter.notifyDataSetChanged();
            }
        });




    }

    public void addWordFunction(View view) {
        Intent myIntent = new Intent(this, add_word.class);
        startActivityForResult(myIntent, STUPID_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == STUPID_CODE){
            String word = data.getStringExtra("word");
            String definition = data.getStringExtra("definition");
            mHashMap.put(word,definition);
            keys.add(word);
            defs.add(definition);
            adapter.notifyDataSetChanged();
        }
    }
}