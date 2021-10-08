package com.example.dictionaryapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

public class add_word extends AppCompatActivity {
    EditText word;
    EditText defintions;
    final String WORDS_FILE_NAME = "extrawords.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        word = findViewById(R.id.wordEditText);
        defintions = findViewById(R.id.definitionEditText);








    }

    public void addAWord(View view) {


        String wordVariable = word.getText().toString();
        String definitionVariable = defintions.getText().toString();
        String line = wordVariable + "-" + definitionVariable;


        Intent myIntent = new Intent();
        myIntent.putExtra("word",wordVariable);
        myIntent.putExtra("definition",definitionVariable);
        setResult(RESULT_OK, myIntent);
        finish();

//        try {
//           // not this one  OutputStream outputStream = new OutputStream(context.openFileOutput(WORDS_FILE_NAME,MODE_PRIVATE));
//            PrintStream outStream = new PrintStream(openFileOutput(WORDS_FILE_NAME, MODE_PRIVATE));
//
//            outStream.println(line);
//          outStream.close();
//          //go back to the main actvitiy
//
//            Intent myIntent = new Intent();
//            myIntent.putExtra("word",wordVariable);
//            myIntent.putExtra("definition",definitionVariable);
//            setResult(RESULT_OK, myIntent);
//            finish();
//
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

    }
}