# Files & Storage 


## Android Storage 

android can read/write files from two locations 
1. internal storage: private to your app
2. external storage: shared file system used by apps
both are persistent; data remains after power-off.reboot
internal versus external used to refer to whether data was stored on a removable SD card or not; this is no longer the case 

most data processed from external plaes comes from a website or a feed of data or data a qeury over data set 

you can store things in different places if you are reading from the internet that come from externally located on your devices

internal storage is like inside your app or resources and files you can read, and you can modify or change and stuff like that 
it is called internal because other apps can never see that or touch or modify it 
each app has its private lockbox are called internal stroage this means it is really important for security like if you have passwords or security stuff 



there are permissions of file systems those are things that would be shared across multiple apps potentially
if you google it, a lot of webs that have an outdated terminology here and it used to have external storage like a disk of memory was inside your phone. that is not how these two things anymore, that is not the distiction in , in fact both memory card and builtin memory could be either of these things 


## internal storage 
internal storage: built into your app, and private to your app
usually wiped out when the app is uninstalled 
more secure; visible only to a given app or user 
to put an input file into your app's internal storage, plae it into the project's res/raw folder 



```shell
~/AndroidStudioProjects/DictionaryApp/app/src/main/res$ ls 
drawable      layout             mipmap-hdpi  mipmap-xhdpi   mipmap-xxxhdpi  values-night
drawable-v24  mipmap-anydpi-v26  mipmap-mdpi  mipmap-xxhdpi  values
edhuang@BB4287382437:~/AndroidStudioProjects/DictionaryApp/app/src/main/res$ 

```

now it does not have a raw folder 

we have to create a folder called raw: 

```shell
~/AndroidStudioProjects/DictionaryApp/app/src/main/res$ mkdir raw 


```
then when you build the project and deploy it out onto the emulator this file will just be packed there and you can open it up and read it if you want to 



## external storage
external storage: global file system shared by all your apps 
1. example: photos, music, downloads 
2. read/writable by other apps and userse 
3. can be removed or transferred to another device if needed 
4. not wiped when the app is uninstalled, except in certain cases 





## File and Stream Objects 



File = object that represents a file or directory 
1. methods/proeprties: bufferedREader, canRead, canWrite, create, delete, exists, inputStream, isFile,isDirectory, lastModified, length, listFiles, mkdir, mkdirs, names, paret, path, readLines, readTet, renameTo 

2. InputStream, OutputSTream - flows of data bytes from/to a source or destination 
1. could come from a file, network, database, memory 
2. not directly used, they only read/write a byte a time from input
3. methods/ properties: bufferedReader

## Readers & Scanners 

Files and InputStream are not usually used directly. instead, you wrap them in a reader or scanner 

1. BufferedRead - I/O object for reading a line at a time 
methods/properties:readLine, ready, lineSequence, lose 
2. Scanner - I/O object for reading lines or tokens at a time 
methods/ properties: hasNextDouble, hasNextInt, hasNextLine, next, nextDouble, nextInt, nextLine 


not only because scanner allows allows to read lines but also you can read the nextIt or the nextDouble in token form 

when you call these methods, the stream values as the return value, but you can pass those parameter to a BufferedReader or a Scanner and the scanner will pull the data out 

an activity has methods you can call to read/write files: 


| methods  | description |
| ------------- | ------------- |
| InputStream fr = getResources().openRawResource(R.raw.words)  | this returns an inputStream |
| BufferedReader br = new BufferedReader(new InputStreamReader((fr)));  | buffer reader to read lines  |
|  Scanner sc = new Scanner(fr); | sc.hasNext()  |



#### BufferedReader Version 
```java


       try{
           InputStream fr = getResources().openRawResource(R.raw.words);
           BufferedReader br = new BufferedReader(new InputStreamReader((fr)));
           String line = br.readLine();

           while( line != null ){
               Log.v("what", line);

               mStrings.add (line);
               line = br.readLine();

           }

       }catch (IOException fe){

       }



```


#### Scanner Version

```java
   InputStream fr = getResources().openRawResource(R.raw.words);
        Scanner sc = new Scanner(fr);

        while(sc.hasNext()){
            mStrings.add(sc.nextLine());
        }

```




## Logging messages 

instead doing something like System.out.println, remember, or the println(). that is not how people typically send outputs

there are a thing called Log.xx() which takes two arguments 


Log.d("$line is:", your_variable_or_message) for debugging messages 
Log.v("$line is:", your_variable_or_message) for verbose messages 
Log.w("$line is:", your_variable_or_message) for warning messages 
Log.wtf("$line is:", your_variable_or_message) for what the heck is going on? 
it stood for lots of love 



the first thing is a tag, you can pepper with these messages 



in the bottm of the Logcat, switch it to debug messages. I really encourage you to insert logging statements in your code to test whether stuff is working as a sanity check 


otherwise it is hard to track down why. somebody needs to do something plumbing to accomplish that, there is a little more to it than that 



we can make a private HashMap for Strings and Strings, we want to have words map to their definitions 
if I want to split apart two pieces I think you can do 
line.split("\t"); and that is going to yield two pieces 



```java 

 HashMap<String,String> mHashMap;

        while(sc.hasNext()){
           String line = sc.nextLine();
           String [] pieces = line.split("\\t");
           mHashMap.put(pieces[0],pieces[1]);
        }


```



I think there is probably a little cleaner way to do this to slender
you can pull apart array into multiple variables. this is fine for now 

I can also make things as separate strings 


```java
  ArrayList <String> words;
  ArrayList <String> definitions;

```
all things gets into a list, the reason you want that is that sort down here if you picking a random word, this is me picking a random element from. I will come back at a second 

for the wars defintions 
I can do 

```
words.clear();
for(String otherWords : words.subList(0,4)){

}

```

it is just like throwing this together quickly and shuffle that up 
I insisted it will be non null. I want to keep you late and we will call it a day 

## additional things 


we can use HashMap's keyset() method to get a set of keys and use java stream api to convert it to ArrayList for HashMap 






remember one thing: Android crashes regardless of the connection of UI, any misuses of your data structure might result in app not running 
the following example exibits how the hashmap key was not putting properly 
because the string.split("delimiter") part does not comply with our rule
 which is "-", another thing         mHashMap = new HashMap<>(); has to be initialized 
also, the below statement does not work to convert HashMap keyset 
but 90% of the bootup crash was rooted by objects not initialized at the beginning !!!!


```java
 ArrayList <String> dictionaryKeys = (ArrayList<String>) mHashMap.keySet().stream().collect(Collectors.toList());
       // mHashMap.put(pieces[0],pieces[1]); not working
```


```java
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
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
  ListView lv;
  ArrayList <String> mStrings;
  HashMap<String,String> mHashMap;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.listview);
        mStrings = new ArrayList<>();


        InputStream fr = getResources().openRawResource(R.raw.words);
        Scanner sc = new Scanner(fr);


        while(sc.hasNext()){
           String line = sc.nextLine();
//           String [] pieces = line.split("");
//           mHashMap.put(pieces[0],pieces[1]);
           mStrings.add(line);
        }

      //  ArrayList <String> dictionaryKeys = (ArrayList<String>) mHashMap.keySet().stream().collect(Collectors.toList());


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mStrings);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mStrings.add("new one");
                adapter.notifyDataSetChanged();
            }
        });




    }
}

```



another thing to note is you can not do this when linking to your TextView object, if you do not have id, you mess up the entire thing 
```xml
   <TextView
        android:id="@+id/vocDefinition" this one 
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="56dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/word" this one   
               android:text="words"
        android:layout_marginLeft="150dp"/>
```


```java
        int indexOfDictionary = rand.nextInt(keys.size());
        //tv.setText("" + keys.size());
//   Caused by: java.lang.NullPointerException: Attempt to invoke virtual method 'void android.widget.TextView.setText(java.lang.CharSequence)' on a null object reference
       // at com.example.dictionaryapp.MainActivity.onCreate(MainActivity.java:62)

```






fixes below: 


```java 
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

```




## write a new file 

```java
//write a short text file to the internal storage 

PrintStream outSream = PrintStream(openFileOutput("out.txt",MODE_PRIVATE));
outStream.println("hello");
outSream.cloes();

// read the same file, and put its contents into a TextView 

Scanner scan = new Scanner(openFileInput("out.txt"));
String emptyText = "";
while(scan.hasNextLine()){
    String line = scan.nextLine();
    emptyText += line;
}



textView.text = emptyText;
scan.close();


```


PrintSream is just a java object and it also exists in Kotlin 
if you read the file later you can make a scanner or buffer reader and you will say openFileInput
so it is not super hard to do, i would say the hardes thing about dealing with android is when it does not work, it is hard to go diagnose because it is hard to just open up a directory tree and look at the file like file's name like the file is buried inside your emulator somewhere 

it does test your eye so you have to have careful make sure you do not write the code wrong 
if this is wrong, you have to insert debugging or logging code to kinda track down what is wrong and what is not working. hopefully we can get this work 


```java
  try {
      PrintStream outStream = new PrintStream(openFileOutput("out.txt", MODE_PRIVATE));
      outStream.println("hello word");
      outStream.close();

  }catch (FileNotFoundException fe) {
      Log.v("what", "file not found");

  }


```

##### once you open a file and you have close a file, if you do not close the file , sometimes it does not save the data properly or whatever 
it will not automatically close it for you 





