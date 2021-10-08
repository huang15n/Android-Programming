# List and Files 



## Cheat Sheet 


one thing strange about the list is if you want to specify the items that are in the list, you have to say entries="@array/name" and array itself it is a string.xml that is something called static list where you know all the contents of the list ahead of time 
```xml 
<resources>
<array-name name=""> <item> </item> <array-name>
</resources>
```



```xml


<!--static list string-array -->
<resources>
<string name = "name"> value </string>
<string-array name = "name">
<item>value </item>
<item>value </item>
<item>value </item>

</string-array>
<resources>

  <ListView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:entries="@array/xxx" />

<!-- listview clicking do not use onCick -->


    <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:entries="@array/characters"/>


```



```java
// setOnItemClickListener
// new AdapterView.OnItemClickListener

// static list view click event 
lv = findViewById(R.id.listview);
  lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),position + "",Toast.LENGTH_SHORT).show();
            }
        });

// spinner item select event 


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

```


```java 
// listview adapter 

ArrayList<String> string = new ArrayList<>();


lv = findViewById(R.id.listview);

ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,string);

lv.setAdapter(adapter);

// adapter.notifyDataSetChanged();
 lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mStrings.remove(position);
                adapter.notifyDataSetChanged();
            }
        });




```

##  ListView
<i> a visible vertical meanu of selectable choices</i>

 lists are more complicated , we separate it out
 it is a usually vertical collection of choices a person can either look at or click on or something like that 
it is hard to specify what kind of choices are 









<h3> ListView</h3> 
<em> an ordered collection of selectable choices </em>
<table>
<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:entries="@array/name"</td><td>set of options to appear in the list/ must match an array in strings.xml</td>
</tr>






<tr> 
<td>android:clickable="bool"</td><td>set to false to disable clicking</td>
</tr>

</table>

if you have to specify something in the list, you have to say the entries of the list come from this array and array itself is put in a totally separate file called string.xml 
you can refer to that array that is something called static list where you know all the contents of the list ahead of time 

it is a little different if your list is dynamic or comes from some external places 


 if you want to set the list , the people who made android development they hate you and so that, you have <strong> set this thing called entries</strong>  

<h3> Static list</h3>

<ol> 
<li> static list: you know ahead of time what the contents are, content is fixed and known before the apop runs . declare the list elements in the string.xml resource file</li>
<li> dynamic list: you download from the internet, content is read or generated as the program runs. comes from a data file, or from the internet, etc. must be set in the java code . you display them or something like that </li>

</ol>



## String resources


<strong> declare constant strings and arrays in res/values/string.xml : </strong>

```xml
<resources> 
<string name ="name"> value</string>

<string-array name = "name"> 

<item> value </item>
<item> value </item>
<item> value </item>
<item> value </item>
<item> value </item>
</string-array>




</resources>


```


refer to them in java code: as a resource ID: R.string.name, R.array.name

 as a string or array: resources.getString(R.string.name), resources.getStringArray(R.array.name)


 this is really janky 

<ol> 
<li> as a resource ID. R.string.name, R.array.name</li>


<li> as a string or array : resource.getString(R.string.name);</li>


<li> resources.getStringrray(R.array.name);</li>
</ol>


```xml

  <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:entries="@array/staticList"
        tools:layout_editor_absoluteX="102dp"
        tools:layout_editor_absoluteY="45dp" />


        <resources>
    <string name="app_name">Example</string>

    <string-array name = "staticList">
        <item> Splinter</item>
        <item> Shredder</item>
        <item> Krang</item>
        <item> Bebop</item>

    </string-array>
</resources>

```

 that will update itself to show that, it is a bit dumb , another good thing about list is you can interact with it. there is a view called recyclerview that some apps want to use , there is a ton of these in the wild like most apps that shows lists of stuff are using this, this is crappier, come out and look up,  this constantly fools me . you are paying attention you have learned some stuff about android already, 

there are still a ton in the wild 



if you want to do a dynamic list, and I have to apologize on behalf of android because this is one of the many places where I just do not they designed this very well. you have to use an object called an adapter 


<h3> list adapter </h3>

<strong> adapter:helps turn list data into lsit view items</strong>
common adapters:

1. ArrayAdapter: items come from an array or list 
2. CursorAdapter: items come from a database query

 syntax for creating an adapter 

<i> ArrayAdapter<T> name = ArrayAdapter<T>(activity,layout,array); </i>



you have to tell what data that you want o show in your list and then you have to give that adapter to your list as a property and then it will appear on the screen 



it is what you think of as the data itself and the GUI visualization of that data 





<ul>

<li>  the activity is usually this</li>
<li>  the default layout for lists is android.R.layout.simple_list_item_1  </li>
<li>get the array/list by reading your file or data source of choice </li>


 
</ul>

 attach it by setting adapter properly of ListView



##  handling list events 


<ol>
<li> Lists do not use the onClick event</li>
<li> event listeners must be attached in java, not XML </li>
<li>you must use java annoymous inner class, lambda functions, a function with a name written inline between {} braces </li>
<li> the lambda function will be called when events occur on the list </li>
</ol>


```java
<button : android:id = "@+id/myButton">


Button button = (Button)findViewById(R.id.myButton);
button.setOnClickListener(new View.OnClickListener() {
    public void onClick(View v){

    }

});




```

 in java code, when the list is created, we refer to that list . I am writing a function, that function will notify that is the function I want to run. this anoymous function takes four parameteres . java is cynical 


```java 

lv = (ListView) findViewById(R.id.listview);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 

            }
        });


        @Override
protected void onListItemClick(ListView l, View v, int position, long id) {

    Log.i("Hello!", "Clicked! YAY!");

}


```



```java 


    <ListView
        android:id="@+id/listview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:entries="@array/staticList"
        tools:layout_editor_absoluteX="102dp"
        tools:layout_editor_absoluteY="45dp" />
   private ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.imageView);
        lv = (ListView) findViewById(R.id.listview);
        lv.setClickable(true);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"hello", Toast.LENGTH_SHORT).show();

            }
        });




    }

```



<h3> Spinner</h3> 
<em> a drop-down menu of selectable choices </em>
<table>
<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:entries="@array/name"</td><td>set of options to appear in the spinner/ must match an array in strings.xml</td>
</tr>






<tr> 
<td>android:clickable="bool"</td><td>set to false to disable clicking</td>
</tr>


<tr> 
<td>android:prompt="@string/text"</td><td>title text when dialog of choices pops up</td>
</tr>


</table>

```java
Spinner spin = (Spinner) findViewById<Spinner>(R.id.id);

spin.setOnItemSelectedListener{

}

```


```xml
<resources> 
<string name ="name"> name </string>

<string-array name = "name">
<item> </item>
<item> </item>
<item> </item>
<item> </item>
</string-array>

</resources>

<LinearLayout ...>
<Spinner ... android:id="@+id/xxx" android:entries="@array/xxx" android:prompt="@string/xxx">
<TextView android:id="@+id/result"... />

</LinearLayout>

```

 a lot of times you do not want to eat up a lot fo screen sapce so you can make it dropdown list 

```xml

    <Spinner
        android:id="@+id/listview"
        android:layout_width="151dp"
        android:layout_height="169dp"
        android:layout_marginTop="4dp"
        android:entries="@array/staticList"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />



```


```xml 

 <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```



```java
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

```

 come up on sessions, it is a temporary holding spot to have the right mindset, run sections and make you do it a little bit more often. have a partner in mind to work in a pair. or awkardly hang out here 

 standard disclaimers not enforce sort of ways thta you could work together. it does not seem like much point to that so 



the more of the material that you arenot work on the more you are going to be lost later on some other things. In such a way that they nicely decomposes into you do this half 






```xml 
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Vocabulary Builder"
        android:textSize="30sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.115" />

    <TextView
        android:id="@+id/vocDefinition"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="56dp"
        android:text="TextView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/title" />

    <ListView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:layout_editor_absoluteX="110dp"
        tools:layout_editor_absoluteY="362dp" />

</androidx.constraintlayout.widget.ConstraintLayout>

```




if you want to talk to the widget in java, 
I sort of want to randomly pick from a set of choices well. 
let's just make an ArrayList and randomly pick one of its elements and then we could use a file later I think that code will mostly be reusable

what do we do so we always get unique ones 
you can use a set, or you can jump up the first element and you are done 


```java
int [] array = {1,2,3,4};
ArrayList<Type> name = new ArrayList<>();
name.add();
 
name.subList(start, end); // slices the list out 

for(type variable : name){
    
}

int num = num[0];
String word = words.get(1);
if(words.contains("Hello")){

}

```


The reason they are doing ArrayAdapter versus CursorAdapter is because there is different places that data can be coming from for your ListView it could be coming from just a file, you could be connecting to database or website 
they provide different adapter thing for different sources that data came from 


```java
ArrayAdapter<T> name = ArrayAdapter<T>(activity, layout, array);

```

if we want to use array adapter, we have to tell it: 
1. what activity is gonna use adapter 
2. what layout were we going to use to draw the individual list the item on screen: R.layout.simple_list_item_1 
3. get the array/arraylist you want to appear now 

```java
package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listview);
        ArrayList defs = new ArrayList<String>();
        defs.add("business magnate");
        defs.add("industry designer");
        defs.add("media proprietor");
        defs.add("investor");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defs);


    }
}

```
 
this does not cause anything to happen in the screen yet, we have to tell the list view to pull its data from that adapter 
how do you feel about your life choices now? a long round trip 

```java
      ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defs);
        lv.setAdapter(adapter);


```

they all shuffled up, the whole point of this is to be dynamic, where is the dynamism 




if you want to make changes, you are dealing with remove or add element from wherever, that is going to notifyDataChanged();
the idea is that you call that method it is gona tell the ListView there was a change and then the ListView will redraw on the screen 

why does not it redraw on the screen when we change the arraylist? 
it is kinda hard for it to watch the ArraList and notice if it changes 
anyways, you will have to do this 
otherwise you won't be able to see the changes on the screen, a more realistic example is to have some sort of event hat caused a change to the ArrayList 

let's make some changes when tapping on defintions 
in the code, you need to say that you are gonna set a listener for clicking of items 




List Event example 

```java
listView.setOnItemClickListener()

```


```java

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                
            }
        });

```

### Lambda function 
a lambda is an anonymous function passed as a parameter, 



when you tap on it, it changes the the content of the list so that we could see that change on the screen 
kotlin allows you to get the widgets by their IDs as if those IDs were variables, android studio will suggest that autocompletion and it will wire up these extensions. it just makes these magical variables based on the ID that we gave the widget in XML file 
the list cues from this adapter that is reading its data from, you do not want to talk to the adapter, you want to talk to the underlying widgets so it makes changes here 


it has to be set outside the scope 
 

now it wont change what is displayed on the screen, we have to use the adapter.notifyDataSetChanged(), you get almost everything right and you tap it and nothing happens and so, just give you another pair of eyes. For an ArrayAdapter, notifyDataSetChanged only works if you use the add(), insert(), remove(), and clear() on the Adapter.

```java
package com.example.dictionaryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private ArrayList defs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.listview);
        defs = new ArrayList<String>();
        defs.add("business magnate");
        defs.add("industry designer");
        defs.add("media proprietor");
        defs.add("investor");


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defs);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 defs.remove(position);
                 adapter.notifyDataSetChanged();
            }
        });

        



    }
}

```

that is not objectively wrong, let's celebrate failures and crashes 



## Stack Trace 

there is a stack trace but it just does not pop up on the screen for you to see, it is intentional 
we have figured out this very developre focused mindset 


use Logcat and descriptive stack trace and hunt down 

in this logcat tab, it prints out these messages from your app 
the problem with this thing is it just spam dumps a bunch of messages in as you can get overwhelmed by all that stuff, you want to find things may came from your code like main activity 


these private variables get initialized that the instant your activity gets constructed the object for your activity 
after your activity gets constructed it runs this onCreate method that like actually lays out all the widgets on the screen and stuff like that. if you really have an eagle-eye spy that.


we can declare the variable up there and set the value after the app has been created, until our app is created itself, that widget is not ready to talk in that way subtler 

however, we are kind of tripping over some kotlin stuff now, it leads to a cascade of confusions here. Kotlin is a bit persnickety about null types. wnt to hear you articulate. null is an empty object that lacks an object, you do not necessarily have to put up with such a creature 
if you call on a null object, the program crashes, you get a segmentation crash, it is not delightful. it is supposed to be backward compataible with java code Variable? if you do not say a type the type will be inferred or deduced from the code around 


the nullness 

```java
String name = null;
int length = name.length(); // crash at runtime 
if(name != null){
    int length = name.length(); // ok
}


```

we write event handlers we took a prameter of type view if we leave a question mark it would never be negative. all the flaws here to say 


































