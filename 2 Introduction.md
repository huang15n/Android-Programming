
it is full of new concepts and moving parts required to build an android app 

why do not we get started now?  good to see you until super recently. I was on break. there is a little more into that, influences how many people we are gonna accept 
we seem have enough room.  who sign up. on Friday at the latest 
get them off from the waiting list 
step out to the bathroom, explain main important things 
for millenials to pay attention to many things 
i will be mindful. go through syllabus, i hate copiers  
bookmark something 

a reasonable background knowledge of java.  CS106A equivalent 
plus their contact info. in terms of what i expect from you guys. prior experience aces a java quiz, it bcomes back really quickly. 
spend a ton of time today reminding you how java works 
you get a little rusty. certain number of data structures. you build a lot of muscles. muscular students to handle it. 
that is an emulator system where you can run your app on a computer, you do not need to own a device.  
any quick questions about it? 

I will get to what you said just in a sec. 
the quality is medicore and complete shit. it is recorded in the microphone. you have a schedule conflict. 
to gauge how crap the experience is
let me go back to your questions
this is the first offering 
you did pretty reasonable amount of work. we check you off. you can get partial grade on. this is not your killer class 
put that down in your transcirpt 
not brutally crash all of you. ruin your quarter  

skim through those slides. you are ready to party this 
philosophy. do not get me in trouble here. memorization is not important. 

a few more things i can go through. no grade points are given for attendance or participation    

in general not as quite strictly as your style 
there is a lot of surprises you do not know ahead of time. slightly a bit less strigent. 
lenient grade. do not bother. slop days for lateness of your its original due dates 
perform a small amount of effort   
chasing after people. litteraly take your solution to somebody 
you blatantly take from somewhere 
just in general, presumbly it is fun. i want it to reflect that 
open them up and follow along. it is kinda redundant 
you come straight to here. increased reliance peer help 
spread them out over the week 
adjust a little to that. the rest of that is repeat. 
I do not require that 


# what is Android? 
mobile OS owned and maintained by Google. originally purchased from Android in 2005 
based on Java -- dev language and Linux -- Kernel 
a lot of guts of it built by startups 
the #1 mobile OS worldwide it depends on how you count these things. Some other brands have more popular recognition 
Code is released as open source periodically. easier to customize, license, pirate than IOS 
they dump all code except some proprietary parts, encrypted code. fork it and change it..


# Why develop for android? 
snappier UI with a more consistent user experience 
scroll and it is all choppy. mobile websites are awful 
widgets look neater 
actually apps for the device is appealing 
more direct access to device's hardware. user highly prefer apps over mobile web browsing that keeps going down over time 
more liberated app store can make an app and put on your phone. 
various other things. lower barrier for android 
build their infrascture
a little bumpier and throw-ons together 


# Android architecture 
Android OS provides libraries for many system features like contacts, phone dialing, notification, 2D/3D graphics, dataabse access, multimedia, security / encryption, camera, audio, input and output  
a whole bunch of stuff 
those are true in some sense 

one thing that is interesting about android is that it does not compile your code into class files 
the code is compiled into a special Dalvik binary format. Google does not want get sued by Oracle.  



there are different version over time. they name it after dessert 
android version have desending order. self-potrait 
it is always fun to see. 
one of the trick things is not every phone has the newest version 

long story short! if you app is compatible with certain versions. 


# Version issues 
check your phone's versions of android : 
Settings -> Systems -> About Device -> Android version 

handset makers/manufacturer; service provider release updates on your model 
several companies affect whether your device is up to date
occasionally your phone is not powerful enough 
hold on to that thing 
push out an update for your device. it can become out of date 
that is a sweet pot for crappy old phones 
jump back to that 


# Installing android studio 
1 install JDK oracle java development kit JDK 
2 andoid studio SDK 
get one thing worked or the other 
the sooner you can get the help the better 
go figure this out as soon as you can 

through visually design app 
a fewer strokes 


# Project Structure 
## AndroidManifest.xml : overall project config and settings 

## src/java/... source code for your java class 
when you use the editor, it will put the classes in there 

## res/.. = resource files (many are XML)
### drawable/ = images 
### layout/ = descriptions of GUI layout 
### menu/ = overall app menu options 
### values/ constant values and arrays 
### strings/ = location datat
### styles/ = general apeprance setting 


## gradle
### a build/compile management system 
### build.gradle = main build config file 
gradle is kind like make file system.


in terms of making projects, the structure can be a little intimidating a bit 
different attributes of the project. 



# Virtual Devices AVDs / Emulator 
you generally must set this up. simulate the phone .
alternative: install your app on your actual android device 
emulator/ software simulation of an android device 
use the USB cord plugged into your dev PC. they do not want spammy apps 
it sorts of boots up look like a computer, it is cool for testing. 
virtual device is slow. you computer is running on another computer, and it is slow !!!




# Creating your first app 
bigger number gae, user is shown two numbers 
click button to choose which one is bigger 
correct / incorrect message after each guess
each points for each correct answer 

you need to learn how to create and position graphical widget and how to respond to user events 

a little tiny bit of logic 
it is reasonable for our first example 


# creating a new project 
click Start a New Android Studio Project 
click Next through most of the menus 
choose Empty Activity instead of Blank Activity 
you are prompted to choose a template for the screen. you want the most basic tempate available. Choose Empty Activity 


you can get a real startup without involving too much code 
i want empty, i want nothing. so next, and it works for a minute 
it is a little slow. 
#### you can put other languages into android, mostly java 
if you want to write some really low level high performance code you want C 
if you are writing video rendering. I have not used very much 
if you click run, it says what is your target
let us take how long it takes 
sits here and wait , chunky and choppy thing, these emulators are pretty slow 
i will be honest with you. Apple has sleek developer system. Android is lawless or broken 
we do not know enough to do anything yet 

# Android terminology and App Basics 
# activity: a single screen of UI in app. the fundamental unit of Graphical User Interface 
## An activity is an instance of Activity. a class in the Android SDK. an activity is responsible for managing user interaction with a screen of information 
#### you write subclasses of Activity to implement the functionality that you app requires. A simple application may need only one subclass; a complex application can have many 
a screen of an app, sometimes an app might have just one activity/screen 
when you jump to another screen. 

# View : visible onscreen items. 
## widget: GUI control such as a button 
## layout: invisible container to position/size widget 
## a layout defines a set of UI objects and their positions on the screen. A layout is made up of defitions writtem in XML. each defitnion is used to create an obejct that appears on screen. 
you specify rules, this one goes underneath. what if i switch it to landscape mode, how was everything supposed to fit into that orientaiton 


# event : action that occurs when user interacts with widgets 
some widgets are interative. those user interactions. 
e.g. clicks, typing, scrolling 

# action bar: top menu of common actions 
the bar underneath notification area 

# notification area: top system menu 
the top black area. 


# Android widgets 
how a lot of common ones, you can write a lot of apps. 
Most of their names are within the view

# Desiging a UI 

on the left side, under res/layout/ 
there is a file represent UI layout 
you use this language XML
##### XML is a declarative markup language 
open XML file for your layout e.g. content_main.xml 
drag widgets from left Palette to the previe image 
set their properties in lower right properties panels 

the design view, you can drag and drop i can click on widgets.you do not really have to know what is going on
it sticks to something. 
it anchors to the middle 
if you dig through this, you probably know what you like 
it is causing XML to change, you could type all these in. 
we just visually do it, it is neat for now 

if you click the widget here, it means XML there .


# Event: an external stimulus your program can response 
it is initiation of the users 
common kinds of events include : mouse motion/tapping, keys pressed 
timer expiring, network data available 
sometimes it is not user initated , redraw animation, you can start out by thinking that is a user initation 
event driven programming: overall execution of your program is largely dictated bu user events 
commonly used in graphical programs 
## the key idea is you do not write a main method! you sort write event handling functions , and you code sits there and wait. those codes running constitutes the execution.

### to respond to events in a program, you must 
write methods to handle each kind of event (listener methods)
attach those methods to particular GUI widgets 

i have not told android how to respond to these events so it does nothing 
we have to write a method so it calls that method if you want to handle events 


# setting an event listener 
select the widget in the Design View 
scroll down its properties until you find onClick 
type the name of a method you will write to handle the click 
switch to the TextView and find the XML for that button
click the Light Bulb and choose to Create the method 
if you click that it says do you want to create that method 
in there you type a name which identifies that, so it declares that for me 
it will just type in for , i will just filled in the code 

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >

    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        android:layout_marginTop="200dp"
        android:layout_marginLeft="100dp">
    <TextView
        android:id="@+id/menuId"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Pick Bigger Number"
        android:textAllCaps="true"
        android:textSize="24sp"
        android:textStyle="bold|italic"
        />
    </LinearLayout>

<LinearLayout
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:layout_marginTop="20dp"
    android:layout_marginLeft="100dp"
    >
    <Button
        android:id="@+id/rightButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:layout_marginLeft="50dp"
        android:onClick="leftButtonEvent"

 />

    <Button
        android:id="@+id/leftButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="0"
        android:onClick="rightButtonEvent"
    />
</LinearLayout>
    <LinearLayout
        android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        >

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="20dp"
            android:id="@+id/pointText"
            android:fontFamily="sans-serif-black"
            />
            

    </LinearLayout>

</LinearLayout>
```




this editor kinda help you out as you go along 
fill this in with code 
i scroll up and down 
there is a few things, let us figure out what this app is supposed to do what are the aspects there ? 
1 pick random numbers 

so far we have three piece of code. some of the code is greek to us 
when the app loads up is the construction of the code 
there would probably some place to do that 
i want to put those random numbers 
# you hit alt enter to import that class 


# View Objects 
there is a corresponding way to talk to java. it represents an object 
## each widget has an associated java object you can access 
###  they are subclass of parent class View , example Button, TextView, EditText /// /
## View objects get/set methods -> Design Properties :
background , bottom, ID, left, margin, padding, right, text, textAlign 
textSize,top, typeface , visibility 
## find list of properties in Design view, or type .get on a button code 

# all the list, there is a java method , that is your thought process !!!! 
get hold of these object 

# interacting with widgets
1 in Design view, give that view a unique ID property value 
2 in java code, call findViewById to access its view object 
pass it a parameter of R.id.your_unique_ID
cast the retuend value to the appropraite type 
# Note to convert between various data types in java 
String to int Integer.valueOf(s)
int to String : String.valueOf(n)
object to String o.toString() or ("" + o)

it is similar content , you tag all these widgets have thse IDs 
that is a crappy it. 

if you have to put 
findViewById(R.id.the_id_you_put)
the problem of this, its return type is view. 
View is the super class, this method needs to return any of them 
to make it work and compile, you have to cast it into that 
now i have an object refer to it 
(Button)findViewById(R.id.the_id_you_put)

in the java code, i will set button 
there is a couple different ways , or hack ways 
empty string concatenate with the string 
it pretty sketch me through 

it is the scope of OnCreate(), i can make it private way 
i can ask the number to get its text , they live throughout the lifetime of the activity 


if you get it correct, points ++ , -- otherwise 
i still miss some ingredients 

now i need to update these points 
now i am talking to these numbers , i need to update random numbers on that 
that is a good instinct , but wrong approach 
how can you write a piece of code that could run multiple times ? run a function 
let see what happens , this is the core essences of android app 






it is almost the same code but it is another way around 
i leave it to you to figure out what is the proper way to do that 

we can use our java muscles 
it is supposed to rewrite the methods too 
it is mostly working 
have some events they respond to 

do not leave it that way, some variation of that will be pretty quick fix 
they are equivalene, Integer.parseInt(number);

for various reasons it is good to minimize private variables in the app 

one last thing, we will call it a day 


# Displaying toast 
Toast.makeText(this, "text", Toast.LENGTH_SHORT).show() 
toast: a pop up message that appears for a short time 
useful for dispalying short updates in responses to events 
should not be relied upon extensively for important info 
length can also be Toast.LENGTH_LONG

that is how you do it .


```java 
package comq.example.eddiehuang.introduction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button leftButt;
    private Button rightButt;
    private TextView pointView;
    private int rand1 = 0;
    private int rand2 = 0;
    private int points = 0;
    private Random randy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randy = new Random();

        pointView = (TextView) findViewById(R.id.pointText);

        updateNumber();


    }

    public void rightButtonEvent(View view) {
        if (rand1 >= rand2){
            points++;
            Toast.makeText(this,"Good job", Toast.LENGTH_LONG );
        }else {
            points--;
            Toast.makeText(this,"You Suck", Toast.LENGTH_LONG );

        }
        pointView.setText("points" + points);
        updateNumber();


    }

    public void leftButtonEvent(View view) {
        if (rand1 < rand2){
            points++;
            Toast.makeText(this,"Good job", Toast.LENGTH_LONG );

        }else {
            points--;
            Toast.makeText(this,"You Suck", Toast.LENGTH_LONG );

        }
        pointView.setText("points:" + points);
        updateNumber();
    }

    public void updateNumber(){
        rand1 = randy.nextInt(10);
        rand2 = randy.nextInt(10);
        leftButt = (Button) findViewById(R.id.leftButton);
        rightButt = (Button) findViewById(R.id.rightButton);
        leftButt.setText(Integer.toString(rand1));
        rightButt.setText(Integer.toString(rand2));

    }
}


```

could I set the same function for different widgets? 
the function takes the parameter view. 


# An Android project contains the files that make up an application 









