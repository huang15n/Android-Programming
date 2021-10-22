package com.example.dictionaryactivitylifecycle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.i("eddie", "onStart() was called");
//        tv.setText("onStart()");
//
//    }
//
//    @Override
//    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        Log.i("eddie", "onRestoredInstanceState() was called");
//        tv.setText("onRestoredInstanceState() ");
//
//       ArrayList<String> newDictionary = savedInstanceState.getStringArrayList("dictionary");
//
//     //   Log.v("what",newDictionary.get(0));
//    //  adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,newDictionary);
//
//       if(newDictionary == null){
//           Log.v("edhuang","this is null");
//       }else{
//           Log.v("edhuang","this is not null");
//       }
//        // this cannot work adapter.notifyDataSetChanged();
//
//
//    }
//
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
//        super.onSaveInstanceState(outState, outPersistentState);
//        Log.i("eddie", "onSaveInstanceState() was called");
//        tv.setText("onSaveInstanceState() ");
//        outState.putStringArrayList("dictionary",dictionary);
//    }
//
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        Log.i("eddie", "onResume() was called");
//        tv.setText("onResume() ");
//    }
//
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        Log.i("eddie", "onPause() was called");
//        tv.setText("onPause() ");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.i("eddie", "onStop() was called");
//        tv.setText("onStop()");
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Log.i("eddie", "onDestroy() was called");
//        tv.setText("onDestroy()");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        Log.i("eddie", "onRestart()  was called");
//        tv.setText("onRestart()");
//
//
//    }
}