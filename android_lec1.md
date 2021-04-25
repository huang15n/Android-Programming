<h1> Preface</h1>


My initial instinct and the whole spectrum is that programs are governed by the code. 
There is an explosion of complexity sometimes could be overwhelming compared to a confined topic and get stuff unstuck. This is not your killer tutorial 

Max out your coding and get these points, it is downhill here, it is less picky. Set this threshold generously, do not flunk it and there are some slacks then you are basically incapacitated and get busted. It does not count for anything. 


we will face a steep learning curve, get our head around requires new ideas and techniques, lead us through writing apps, some things are tricky or obscure, we will face them head on. 
This approach officially and frankly allows you to put what you have learned into pratcie in a working app right away rather than leanring a lot of theory and then having to figure out how to apply it all. 

if your java is a bit rusty, we will provide brief reminders about Java specifics. Skipping around is unproductive. You will have tenuous relationship with Android. As a result, extensions beyond the point will not generally be granted 


note: in Kotlin, everything is an object 

```java
// primitive types 
int i = 10;
bool b = true;
char c = 'c';
long l = 123213213123123;
double d = 2.32;
String s = "Hello";
i += 20;
final double constant = 1.5;

```

``` java 
// String 
String first = "Jack";
String last = "Sparrow";

String name = first + " . " + last; 


String message = "Hello \n" + " World \n";

```

```java 
//loops 
for(int i = 1; i < 10; i++){

}

for(String s : collection){

}

for(String key : map.keySet()){

}

```

```java
// functions 
public int foo(String text){
    if(text == null){
        return 0;
    }else {
        return 1;
    }
}


```


<h1> What is Android</h1>

<ul>
<li>android is mobile OS maintaind by Google 
originally purchased from Android in 2005. Technically speaking, android is the number 1 operating system in terms of the number device running on</li>
<li>runs on phones, tablets, watches, TVs, based on Kotli/ Java(Language) and Linux(Kernel), it is really a contrast to other operating system software 
</li>
<li> code is released as open source periodically, easier to customize, license , priate than IOS</li>
</ul>



<h1> Why Android? </h1>

<ul>
<li>
as a software developer, you should really learn how to write real apps for a real platform 
better, snapper UI with a more consistent user exprience 
able to use different kinds of widgets/controls than in a web page 
more direct access to the device hardware(camera,GPS)
users prefers apps over mobile web browsing </li>

<li>
android has a lower barrier to install apps as opposed to apple, and they carefullly look over all of it, ripping you and verify its quality checking, that appeals to you.
</li>

</ul>


<h1> Android architecture 
</h1>
<ul>
<li>
android os provides libraries for many sysytem features like contacts, phone dialing, notifcations, 2D/3d graphics, databse access, security / encryption, camera, audio, input/output </li>
<li> Android code is compild into a special Dalvik binary format</li>

<li> checking android version Settings -> System -> About Device -> Android version</li> 

<li> 
Several comanies affect whether your device is up-to-date. Google, phone manufacturer, service provider. It requires for horsepower , they do not bother to pack it up. Some of them have backward compatiblity. It is possible to root your phone and hack into it. It is like free of the restraints  
</li>

</ul>


<h1> Android Studio </h1>
it is basically an enhacned version of IntelliJ IDEA editor, free to down and use. Eclipse is an alternate. It is a decent fraction of you will run into this trouble. Install a minimal tool set from the command line and then build your app. It is a bit bulky other than that it is featureful 

<ol>
<li> Install JDK</li>
<li> Install Android Studio</li>
<li> Create a Vritual Device</li>
</ol>



<h1>
Project Structure
 </h1>


 <ul>
 <li> AndroidManifest.xml: 
overall project config and settings </li>

<li> src/ ... 
source code for your java classes </li>
<li>res/.. resource files many are xml 

drawable = images 
layout = descriptions of GUI layout 
strings = localizationdata 
styles = general appearance styling 


</li>

<li>gradle 
a build/ compile management system 
buil.gradle = main build config file  </li>

<h1> Virtual Devices AVDs </h1>

emulator / software simulations of an android device 
when you click run in android studio, it builds your app, installs it on the virtual device 
must set up virtual device first in Android Studio 
alternative: install your app on actual android . pro: app runs faster, better real test 
con: need device plugged into dev PC. We will not do fancy schmancy and we have kind gone out of our way to pick things  You will look ahead 



<h1> First Android App </h1>

<ol>
<li> click Start A new Android Studio Project</li>
<li> Check the support box </li>
<li> click Next through most of the menus 
</li>


<li> choose empty activity instead of Basic Activity 
acitivity is basically a screen of UI in an android app, it takes longer to load things up </li>
</ol>




<h1> Android Terminology</h1>
<ul>
<li> activity: a single screen of UI in app, the fundamental unit of a GUI </li>


<li>view:visible onscreen item, widget: GUI control such as a button
layout:invisible container to position/size widgets</li>

<li>event: action that occurs when user interacts with widgets, clicks , typing, scrolling</li>
<li>action bar: top menu of communications </li>
<li>notification area: top system menu</li>
</ul>

these are interchangeable terms in android, how to position things, all sorts of events 

AnalogClock 
Button
CheckBox
DatePicker
DigitalClock
EditText 
Gallery 
ImageView/Button 
MapView 
ProgressBar 
RadioButton 
Spinner 
TextView 
TimePicker 
WebView 





<h1> Doodling / Desigining a UI </h1>


open xml file for your layout 
drag widgets from left Palette to the preview image 
set their properties in right side attributes panel 
it will pop on the emulator device 



over the right it has the attribute/property panel of different aspects of this 


lock it to the top middle of the screen, this is called constraint based layout 

by contrast to this thing around here. let the left edge lock into the edge of the screen 
we linked to each other, like attach corners to corners of things. Need the anchor 



<h1> Events </h1>

event: an external stimulus your program can respond to . mouse motion/ tapping. keys pressed 
timer expiring, ntework data available 



event driven programming : overall execution of your program is largely dicated by user events. GUIs 
to respond to events, you must 
write methods to handle each kind of devent listener methods 
attach those methods to particular GUI widgets 

that consititues the code of your app 




<h1> Setting an event listener </h1>
write a function in your java class accepts View parameters 
go to xml layout and select widget in Design view 
scroll down its attribtues until you find onClick 
type the name of your new function. This is unsatisfyingly brief

it turns out to be .class files which is the binary format used by java 
java is a statically typed prorgamming language that runs on the java vm, can interoperate with java code and libraries seamlessly and that is neat and backward compatibility 


in the java file , inside your class of MainActivity 

View is the super function for any view subclasses 
hover over the View annd import the View class 

we want a way to randomly choose numbers on it


<h1> Interacting with widgets </h1>
<ol>
<li>1 in Design VIew, give that view a unique ID property value </li>

<li>2 In java code, call findViewById(_type_) tp acces ots voew pnkect . pass ot a [ra,eter pf R.id.your_unique_ID </li>
Note: to convert between various data types in Java 


</ol>

```xml 
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <Button
        android:id="@+id/rightButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="60dp"
        android:layout_marginRight="60dp"
        android:layout_marginBottom="308dp"
        android:onClick="rightButtonClicked"
        android:text="@string/button_number"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toEndOf="@+id/leftButton" />

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="60dp"
        android:layout_marginLeft="60dp"
        android:fontFamily="sans-serif-black"
        android:text="@string/number_guess_game"
        android:textSize="30sp"
        app:autoSizeTextType="uniform"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.149" />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="44dp"
        android:fontFamily="sans-serif-black"

        android:text="@string/please_click_the_button_if_you_find_it_idea_for_larger_number"
        app:layout_constraintBottom_toTopOf="@+id/rightButton"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <Button
        android:id="@+id/leftButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="60dp"
        android:layout_marginLeft="60dp"
        android:layout_marginBottom="308dp"
        android:onClick="leftButtonClicked"
        android:text="@string/button_number"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>

```


```java
package com.example.numberquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button leftButton;
    private Button rightButton;
    private TextView pointText;
    private Random rand;
    private int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);
        pointText = (TextView) findViewById(R.id.point);
        point = 0;
        rand = new Random();
        generateRandomNumber();
    }




    public void leftButtonClicked(View view) {

        int leftValue = Integer.parseInt((String) leftButton.getText());
        int rightValue = Integer.parseInt((String) rightButton.getText());
        if(leftValue > rightValue){
            point ++;
            Toast.makeText(getApplicationContext(),"you rock!!!!", Toast.LENGTH_LONG).show();
        }else{
            point --;
            Toast.makeText(getApplicationContext(),"suck it" , Toast.LENGTH_LONG).show();
        }
        pointText.setText("Points:" + point);
        generateRandomNumber();




    }

    public void rightButtonClicked(View view) {

        int leftValue = Integer.parseInt((String) leftButton.getText());
        int rightValue = Integer.parseInt((String) rightButton.getText());
        if(rightValue > leftValue){
            point ++;
            Toast.makeText(getApplicationContext(),"you rock!!!!", Toast.LENGTH_LONG).show();
        }else{
            point --;
            Toast.makeText(getApplicationContext(),"suck it", Toast.LENGTH_LONG).show();
        }
        pointText.setText("Points:" + point);
        generateRandomNumber();

    }

    public void generateRandomNumber(){

        leftButton.setText(Integer.toString(rand.nextInt(100)));
        rightButton.setText(Integer.toString(rand.nextInt(100)));

    }
}

```
note: use the android studio tocreate the button functions 
we will extrapolate this 




```java 

//refactor 
package com.example.numberquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button leftButton;
    private Button rightButton;
    private TextView pointText;
    private Random rand;
    private int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftButton = (Button) findViewById(R.id.leftButton);
        rightButton = (Button) findViewById(R.id.rightButton);
        pointText = (TextView) findViewById(R.id.point);
        point = 0;
        rand = new Random();
        generateRandomNumber(0);
    }




    public void leftButtonClicked(View view) {

        generateRandomNumber(1);


    }

    public void rightButtonClicked(View view) {


        generateRandomNumber(2);

    }

    public void generateRandomNumber(int flag){
        int leftValue = Integer.parseInt((String) leftButton.getText());
        int rightValue = Integer.parseInt((String) rightButton.getText());
        if(flag == 1){
            if(leftValue > rightValue){
                point ++;
                Toast.makeText(getApplicationContext(),"you rock!!!!", Toast.LENGTH_SHORT).show();
            }else{
                point --;
                Toast.makeText(getApplicationContext(),"suck it" , Toast.LENGTH_SHORT).show();
            }


        }

        if(flag == 2) {
            if (rightValue > leftValue) {
                point++;
                Toast.makeText(getApplicationContext(), "you rock!!!!", Toast.LENGTH_SHORT).show();
            } else {
                point--;
                Toast.makeText(getApplicationContext(), "suck it", Toast.LENGTH_SHORT).show();
            }
        }
        pointText.setText("Points:" + point);

        leftButton.setText(Integer.toString(rand.nextInt(100)));
        rightButton.setText(Integer.toString(rand.nextInt(100)));

    }
}

```















































<h2> Anexe: Code Style </h2>

<ol>
<li> use anonymous inner class for listeners for cleaner code. It puts the listener's implementaiton right where you want to see them. In high performance contexts, they may cause problems, but for most circumstances they work fine </li>

<li> fragements for all user interfaces, feel strong about. Challenge that pratice write activity based code. Fragments have clear advantages over activties that make them worth the effort, including flexibility in building and present user interfaces  </li>

<li> write apps to be compatible with deliciously-named versions. We intentionally take you through the difficulties involved that are backwards-compatible with them  

</li>





</ol>








