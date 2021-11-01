# Dynamic UI 

fragments are tough and it took me a whole lecture of cutting and pasting and editing to get that to work but you know you get something pretty powerful 
when you use fragments, you get these recomposable units of UI that you can interact with it 

but I will constrast today which is we are going to a little bit smaller scale dynamic user interface stuff so 


you get a ui with the different widgets and layouts but it also responds to events and it has behaviour. it is kinda self-contained thing that kind of contains both of those sides it contains sort of UI and layout and appearance and it also contains somewhat complicated event handling stuff. it kind of just all operates as its own little components in that way 

by constrast what if you wanted to have like a little chunk of ui that you want to reuse ?  but it was not really quite enough of a thing to make a whole fragment for,, it did not really need a lot of event handling per se, it was just kinda a little simple thing 

but it was enough of a thing that you wanted to sort of repeat or abstract it out or something like that 


that is kind of the spectrum of recomposable UI 




## generating dynamic UI 



### generating a UI at runtime 
sometimes your app's UI cannot be fully specified in XML, you do not know how many widgets you will need until the user gives input or until a file is downloaded 
in these cases, your app needs to be able to generate UI widgets dynamically in java code 

there are sometimes which might be that the ui depends on something that you do not actually know until the app starts running, such as app grabs from data and display that data. you do not know that number of images or a certain number of buttons that you did not know how many apps there were going to be until the app started up, maybe you want something more dynamic based on the data source or based on whatever 

in such case, you might want to write java code that creates UI widgets 

any UI widget class from XML has a corresponding java class 
you already used these when you find a view by ID 


```java
WidgetTtype widgetName = new WidgetType(this);

     Button butt = new Button(this);
```

you can actually write android with no xml if you want to, no XML, you can just have 


in your activity: 

```java

package com.example.dynamicuiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

```


setContentView(R.layout.activity_main);
you are basically telling android please go to this xml and read all that and turn that widget that appear on screen 
but designre of android felt it is easier and better to specify your layout this way rather than do it in java code 
a lot of people like what you call declarative user interfaces as opposed to what you would call a procedural user interface 
a procedureal interface is do this and do that 
a declarative user interface is here is what I want to go to make it happen 

if you want to create UI like this, you just say you want construct an object of whatever type widget type like Button, Textview, EditText, Spinner .... all the classes the different types you have learnt 
you refer to these widget by findViewById
if you are a little rusty on it or whatever this line of code is, I am calling a constructor in java, just constructor a widget does not put it on screen yet, 
you have to set properties and you have to tell android where to put it on and that is how you can add 

### adding widget to layout 

you can add a widget to an onscreen container ViewGroup such as a layout 
1. add a widget to a container using the addView method 
2. you must give the container an ID
```xml
<LinearLayout android:id="@+id/mainlayout" ////>

```
```java
TextView tv = new TextView(this);
mainlayout.addView(tv);
```
so if you want to do that dynamically, add a widget to a layout, you should make it so that there is a way for you to talk to the layout so that code represents that theme 
so layout objects has a method call addView(widget), it is like the super class of the textview 

### ViewGroup methods 

| ViewGroup methods | Description |
| ------------- | ------------- |
| addView(view);  | add a view to this container  |
| addView(view,index);  |    |
| addView(view,params);  |    |
| bringChildToFront(view);  | move view to top of z order   |
| getChildAt(index);  | return a view   |
|childCount  | return number of children   |
| removeAllViews();  | remove ll children   |
|removeView(view)  |  remove a particular child    |
|removeViewAt(index)  | remove child at given index    |


I had to loop over all of widgets to add a event lsitenr to them and i had to use this to talk to the layout of the activity too or the fragment 

help me out, what is the return policy on this thing? 

```xml
<?xml version="1.0" encoding="utf-8"?>
<GridLayout android:layout_gravity="center" xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:id="@+id/grid_of_things">





</GridLayout>

```
```java
package com.example.dynamicuiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button butt = new Button(this);
    butt.setText("this is hello");
        GridLayout grid_of_things = findViewById(R.id.grid_of_things);

        grid_of_things.addView(butt);



    }
}
```

I want to add something on the screen, you know you would do it depends on what I want to add n the screen
you have to set some properties for this thing otherwise i would not look nice then you will add on the screen 

I am such a cheese ball I always like my own posts, bump it up or whatever 

if I want to move around and center it whatever like it is different, let's go further with this 


### widget parameters 
what about the attributes that would have been in the xml tag? 
many are properties or set methods on the widget object 


```java
widgetObject.id = "";
widgetObject.layout_height = "";
```

you can actually look up the google android java API you can scroll the stuff up for every single properties 

sometimes it says it does not conform to the specified type you can change to float, sometimes it is not completely straightword 


## layout parameters 

sometimes stuff are not straightfoward 

1. attribute that start with layout_ are for the layout 
2. these are packaged into an internal LayoutParams object 


I guess the rule of thumbs is if the property would have said like layout string or something 

```xml
<WidgetName
    android:layout_width="wrap_coontent"
    android:layout_height="wrap_coontent"

/>

```
```java

package com.example.dynamicuiexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button butt = new Button(this);
    butt.setText("this is hello");
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
    butt.setLayoutParams(params);
        GridLayout grid_of_things = findViewById(R.id.grid_of_things);

        grid_of_things.addView(butt);

  // there is no widget.set_layout_height() like methods
// width and height

    }
}

```

### layout-specific params 

1. each layout type has its own LayoutParams inner classes : contains attributes and methods used by thta kind of layout 

```java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button butt = new Button(this);
    butt.setText("this is hello");
        GridLayout grid_of_things = findViewById(R.id.grid_of_things);

        grid_of_things.addView(butt);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    params.weight = 1;
    params.height = 1;
    params.gravity = Gravity.TOP ;


    }
}

```
that allows you to set the widget the view that you want, but a lot of code gets messy


I think what you would find though is that it is not that bad to do this kind of stuff, it is pretty tedious if you are making multiple widgets 


### constraintlayout-specific params 

1. set the constraitnAtoB xml attribute by setting AtoBproperty 



### setting widget size 
most comon sizes are wrap-content and match_parent 
ViewGroup.LayoutParams.WRAP_CONTENT
ViewGroup.LayoutParams.MATCH_PARENT

if you want to set widt htaht is relative to the screen size 


### layout inflter 

layout inflate: converts layout xml into java/kotlin widget objects 
manual creation of widgets works, but it is pretty painful if you are creating a lot of them, or a complex nested structure of widgets 
there might be multiple pieces to it you might not really want to write java/ kotlin code, it is long and bloated and ugly. you can make a small layout file that just describe sthat little pieces of UI you want. and then you can tell kotlin to read that xml file and inflate it and turn it to java/kotlin object widgets for you. so you are sort of doing manually what an activity does as a whole 

these things seem kind of antithetical to each other or in contradiction 
I thought the whole java file is dynamic and the layout xml file is static 
it is not xml files are always static, it is just we have thought xml file as whole piece of activity 



a layout inflate lets you specify an entire chunk of layout, perhaps a complex subcomponent, as xml and then load it in java/kotlin as need 
similar to a fragment but without its own evens and lifecyles 

layout xml -> layout inflate -> java widgets 

is that what a fragment is? fragmetn you can stick it here on screen and make another piece of an activity and stick it here? 

a fragment is even beefier of a thing than gizmo as a widget, it is just you would want to write all the java code to create it from scrach. 
a fragment could be really big and elborate and has a bunch of events, a fragment is just soft of a beefier thing in it 
the difference is a bit blurry, they have different margin for that , I want to make a thingy like that 

they often dock stuff, and it pops up 

this is a situtional layout that should be used in certain cases it is just one that i want as a utility 
I want to write out the ui here just do this thing before I do anything else, that is the start for this thing 


right click res/layout -> new layout resource file 
this activity will not use that layout yet 


```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello"
        android:textSize="100sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.314"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.107" />
</androidx.constraintlayout.widget.ConstraintLayout>

```


```xml
<?xml version="1.0" encoding="utf-8"?>
<GridLayout android:layout_gravity="center" xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:id="@+id/grid_of_things">





</GridLayout>

```


you would not see what is up for your screen right now 


let's see how we inflate it 

### using the layout inflater 

inside an acitivity 

```java
    LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.single, mainLayout, false);


         mainLayout.addView(myLayout);

```
when not in an acitivyt 

```java


Inflater inflater = activity.getSystemService(Context.LAYOUT_INFLATER_SERVER); 
View name = inflater.inflate(R.lyout.name, parent);
// getLayoutInflater()

```

in both cases, parents can be null 
if parent is not nullm new view is automatically added to parents. then you pass all R.layout. whatever that layout is 



they stack on top of each other, you are basically on the right track 

it is pulled to match the parent's size, they are asking to take up the whole screen, you can set those margins and resize, that is more than today's topic 


it is like an investmetn if you want to do fragments 

if we just doing this much repeated ui, maybe we do not want to do fragments stuff 

cautin, you know your usual UI techniques for like how do we refer to a widget , you just refers to the same widget thta has the same id, you cannot really do it here, because those are sort like activity scope ids these are inside those xml things we just inflated, if you want to refer to something 
that is part of clump of the ui, you kind say: 

```java

inflaterObject.findViewById<WidgetType>(R.id.xxxx);
```

it is just not the part of your activity and htat is part of some ohter activity or other gizmo inside your activity for this syntax 

we need to customize this thing to make it work 

if you want to refer to a resource such as image by dynamic names you will have to do this, and it is case sensitive and no spaces and that will clean up 
```java
stringName.toLowerCase().replace(" ", "");

```



```java
int id = resources.getIdentifier(name, "drawable", packageName);
image.setImageResource(id);

// there is no way to do this setImage(R.drawable."name")


```
https://stackoverflow.com/questions/3477422/what-does-layoutinflater-in-android-do
what I would like to do is to create it and set the stuff up and do not like make it appear yet set all up and put all on the screen 



sometimes if you have little stamps custom ui like this, you do sometimes want to add some kind of event interaction on them, you will have to decide the threshold here but you have maybe like one or two events you want to respond to, we can work more that way up 


image buttons will be better because it allows you to switch on that, and you have to add a event listener on the java code 


that is the basically id how you wire up event handle with these basic widgets on these dynamic gizmo 




if a tree falls down in the woods and no one hears it or something, yeah, does it makes a sound? 

if you just created a widget or you just inflated a layout in kotlink code but you never add it to any container or view group or activity or layout then it just never shows up on screen 

essentially it will just be a waste of memory and when you get to the end of the function or whatever, java will notice that these widget objects are not attached to anything and I think garbage collection will just kinda throw those away so the net effect will be nothing shows up and you do not see anything 

different UI has different logic about this sort of stuff, you tell then i will add it for you otherwise i won't put it anywhere 


what you could imagine I might not be doing this is instead having this constant array, the internal resources that are packed in your project, there is no like a super easy way to do a for loop over them. it is pretty icky and I do not want you show you how to do it 

frankly you do not have a set of resources baked into your app that you loop over what you normally do is connect to some other data source like a database or a website, or query it for the data and then loop over that 
the part of this is a bit unrealistic is where did the data come from part 



# Dialogs

dialog boxes I mean they can be complicated, mostly you learn the simplest version of this it is good enough for like 90% of your usage and you can google it the other times 



## motivation 

dialog: a pop up UI that interrupts your activity
1. not a different activity itself; sits on top of the activity 
2. meant to briefly display information or ask for a bit of nput 
3. once the user is done interacting with the dialog, it cloes and app resumse activity it was on before 


it does not cover the whole screen and it maybe blurs the activity underneath it, it is temporary maybe you say yes or no you interact with it a little, you click on a choice or something and then it goes away and you go back to where you came from. so you know i want to show you how to pop up dialogues like this 

and for its worth you know in terms of the like activity lifecyle, if this activity 

you could just pop up another activity and then ask the user the equestion or show them the messag and then when they are done you could go back to the original activity but that is considered more disruptive to let the users to see what they are working on is still there underneath 



there are different types of dialogs
1. adnroid has  a dialog class with subclass 
AlertDialog 
CharacterPickerDialog
DatePickerDialog 
ProgressDialog 
TimePickerDialog 

I have never ran into some of those things, mostly i just either want to pop up a message like here is something that happened or i want to ask them a quick quesiton which of these two things do you want 


there is a lot of different pieces in dialogs 
parts of a dialog 

1. icon 
2. title 
3. message 
4. negative/neutral/positive buttons 

I want to use a more vague name


in yet another example of questionable design 

### building a dialog 
1. create a dialog in your activity class with a dialog builder
2. the builder has many set methods to customize the dialog 
3. when ready, create () the dialog and show() it 

```java
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
builder.setMessage("this is the message of the body ").setTitle("this is the title");

                 AlertDialog dialog = builder.create();
                 dialog.show();


```


you have to make a Dialog.Builder object and then you have to tell it a bunch of stuff and then when you are done, and then when you are done doing that you ask the builder to build 


then you have a dialog show itself archer that is a typo, that should say this is actually how you make a dialgoue 




in software development, this is actually called a builder pattern and a lot of developers think this is a really elegant way to create and initialize some complicated objects that needs a lot settings or initializations flags before you can run it. I think it kinda of blows but whatever 


when that appears, the activity pauses underneath. that is kinda the idea 



## Dialog Builder mehtods 

there is a whole bunch of those set methods 


| Method | Description |
| ------------- | ------------- |
| setCancelable(bool)  | whether cancel button sould show  |
| setIcon(id)  | drawable icon on the dialog  |
| setItems(items{})  | items to display as a list  |
| setMessage("text")  | text to display in dialog  |
| setMultiChoiceItems(items,checkedItems){}  | items to display as checkboxes  |
| setNegativeButton("text") {...} | text/ event handler for no button  |
| setPositiveButton("text"){...}  | text/ event handler for yes button  |
| setSingleChoiceItems(items, checkedIndex){....}  | items to display as radio buttons |
| setTitle("text")  | title text on top of dialog  |
| setView(view)  | defines a custom dialog layout  |
| create()  | builds and returns the dialog  |
| show()  | builds/returns dialogs and shows   |



## attaching listenres 

```java
builder.setPositiveButton("OK"){}

builder.setNegativeButton("Cancel"){}

```




```java


package com.example.dynamicuiexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridLayout mainLayout = findViewById(R.id.grid_of_things);

        LayoutInflater inflater = getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.single, mainLayout, false);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);


        // mainLayout.addView(myLayout);

         Button butt = new Button(this);
         butt.setText("click me");
         butt.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 builder.setMessage("this is the message of the body ").setTitle("this is the title");

                 builder.setMessage("do you want to see message?").
                         setCancelable(false).
                         setPositiveButton("yes",
                                 new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {

                         Toast.makeText(getApplicationContext(),"you chose yes", Toast.LENGTH_SHORT).show();

                     }
                 }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Toast.makeText(getApplicationContext(),"you chose no", Toast.LENGTH_SHORT).show();

                     }
                 });
                 AlertDialog dialog = builder.create();
                 dialog.show();

             }
         });

         mainLayout.addView(butt);







    }
}
```




you set he text you want to appear on the button and then you write a set of curly braces that indicate the function like the event handling that you want to call when the button gets clicked and the function takes two parameters, the dialog and the id number of the button that got clicked, honestly you do not need either of these parameters 


if I want to read the contents of that file and put that up on the dialog boxes, you can say resources.openRawResource(textFileID).bufferReader().readText();

if I whiz through that I am just bascially grabbing their contents of them 


### listening to a list of items 

```java
AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

builder.setItems(R.array.xxx, new DialogInterface.OnClickListener() {
               public void onClick(DialogInterface dialog, int which) {
               // The 'which' argument contains the index position
               // of the selected item
           }
    });



```



by far I think the most common thing I want is like information messages 
how this is better than a toast? a toast is just a little trim on the bottom and then it automatically fades after 5 secs 


# Multimedia features: MediaPlayer, text to speech 



a lot of stuff here does not take a ton of time to learn about, 

if you want to play sounds like mp3 and stuff, it is not that hard 


## playing sound effects
1. find sound files such as .wav, .mp3
2. put sound files in project folder res/raw really app/src/main/res/raw 
3. in java code, refer to audio file.raw.filename 
do not include the extension raw.filename for filename.mp3
use simple file names with only letters and numbers 


load and play clips using android's mediaplayer class 


```java
MediaPlayer mediaPlayer = MediaPlayer.create(context,R.raw.soundfile);
mediaPlayer.start();
mediaPlayer.stop();

```

it becomes a little more complicated if it is like what if you are making a little jukebox or game and there is background music playing what if the user jumps out of your app an goes to aother app 
what do you think you do to accomplish that? 
those lifecyle methods, you say onpause or on stop then I want my music to stop 








































































