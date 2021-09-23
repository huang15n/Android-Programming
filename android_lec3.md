

# GUI Widgets and Lists 


 


## Cheatsheet 
the widgets you use the most 
```xml
<Button> </Button>
<CheckBox> </CheckBox>
<EditText></EditText>
<RadioButton> </RadioButton>
<TextView> </TextView>
<Switch> </Swtich>

<ScrollView>
<TextView> </TextView>
 </ScrollView> <!-- with long text in text view -->


 <ImageView>

 <ImageButton> </ImageButton>
 <!-- same as image view expect it is technically also clickable-->


<!-- radio group is more of a container over , indenting them to indicate they are inside of the groups 
-->
<RadioGroup
            android:layout_height="wrap_content"
            android:layout_width="match_parent"
            android:orientation="horizontal"> 
            
            <RadioButton> </RadioButton>
            <RadioButton> </RadioButton>
            </RadioGroup>





<!--static list-->
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


android:clickable = "bool"   <!--it will grey out if sets to false -->
android:id="@+id"
android:onClick = "function"
android:text = "text"


<!--EditText only -->

android:inputType = "type"
android:lines = "int"
android:maxLines = "int"
android:textSize = "size"

<!--EditText only -->

<!-- ImageView only -->
android:contentDescription = "string"
android:tag = "string"
android:scaleType = "type"
android:src = "@drawable/"
<!-- ImageView only -->


<!-- CheckBox only -->
android:checked="bool"
<!-- CheckBox only -->


<!-- Switch only -->
android:textOn = "text"
android:textOn = "off"
android:showText="bool"

<!-- Switch only -->

```


```java
view.getResourceId();
view.getResourceName();

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
there are different you can talk to widget, you can just refer to the id of the widget as if it was a variable and the code will understand that it is also a concept called data binding or widget binding 
you can go through the properties, break you out of the mindset presumbly that is everything you should know. you should rely on the editor to help you with attributes do not get overwhelmed, set you the expectations for what you should do or what you should not need to know 

find you way through if you just have little bit of instinct about it 

find your way through projects 

./build means that when it compiles a project it puts the output of binaries 
./graldes are the stuff like makefiles notes for how to compile 
./app/src/main/res/drawable is where you need to go to put images 



XML is the intial state when it first loads up. It is a little opque until you go play with it for a few mins once you have done one little app in it you sorta get the hang of that widget 









## Widgets Fundamentals 




there is a whole bunch of widgets 

<ol>
<li> AnalogClock</li>
<li> Button </li>
<li>CheckBox</li>
<li>DatePicker</li>
<li>DigitalClock</li>
<li>EditText</li>

<li>Gallery</li>
<li>ImageView/Button</li>

<li>MapView</li>
<li>ProgressBar</li>

<li>RadioButton</li>
<li>Spinner</li>
<li>TextView</li>
<li>TimePicker</li>
<li>WebView</li>
</ol>


the idea here is not to cover it comprehensive, we have a taste and move on, we do not cover stuff in exhaustive detail that can be unsatisfying sometimes

it is really a good time to get cracking on that. sorry that is the last minute . we put up the options. I am gonna walk through several things with you 

you can use a WebView and it pops up the link you can look at it but you are still in the app. that uses the guts of chrome or whatever browser that comes with your device 



we will see a lot of apps using MapView 



##  Adding a widget 

when you add widgets, you have two different ways one is thta you add some xml to the file that is describing the activities for the widget to appear 

sometimes you could do all of that in java/kotlin, but normally you want to do XML because it is cleaner and simpler and easier. could you think of some situation where you want to use java/kotlin to do that? like in response to an event and want a new widget or we hid widgets and I will make it appear 

you could extend an existing widget you could write your own widget 
or you want to do something at runtime involving the widgets that is rare and unpected . you have to create useres on the fly 

in general, you delcare the widge you create it and set a lot of its initial state in xml 









to put a widget you must do two things



<ol>

<li>
declare/position it in your layout XML files that describing the layout of your activity </li>


<li>add any event handling code to your code file </li>

</ol>




<em> technically you could write everything in java/Kotlin and set the size and the shape of the button </em>


could you think of a situation where you have to write code for buttons and stuff? 

in response to an event, we want a new widget. what if I make a widget hidden and appear on the other way. if you want to do something at runtime involving the widgets that is specific and rare and unexpected.

if you want to display images of all users but you do not know how many useres there are until the moment, you cannot 
you will have to create them on the fly. but in general, this is what we are gonna follow, you declare the widget you set a lot of initial state in xml and you interact with it or handle events on it 



##  Button 

common attributes, you give a button it, pointed out there are multiple ways to talk to a widget, the code to understand that, it is also a concept called data binding or widget binding 

<table>
<tr> 
<td>android:clickable="bool"</td><td>set to false to disable the button</td>
</tr>


<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>

<tr> 
<td>android:onClick="function"</td><td>function to call in acitivty when clicked must be public, void and take a View arg</td>
</tr>

<tr> 
<td>android:text="text"</td><td>text to put in the button</td>
</tr>

<tr> <td colspan="2"> 
Button b = (Button)findViewById(R.id.id);
</td> </tr>



</table>


<br/>






## TextView
<table>



<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:text="string"</td><td>stext to display</td>
</tr>
 


<tr> <td colspan="2"> 
TextView tv = (TextView)findViewById(R.id.id);

tv.text = "text";
</td> </tr>



</table>

it is simple to find in google about the attributes, do not break out your mindset, there are way more properties that textview has than like two of these here. We do not memorize names of these things because I just rely on the editor to help me 


you can detach the edge to the ends if I stopping attaching the edge, it should pull me over there 
we are remarkably bad at attributes 


it all gets jumbled up in here, this is not the point to remember all these different names. not so much to do with text view because it only displays texts 





## ScrollView
if you want a set of text in it you want it to be taller than the screen or maybe it has more text that it can fit in its area there is a widget called scroll view 

it is a bit counter intuitive because you might have thought 

you may think of use boolean values but that is the the way they decided to build the reason they did not do it that way is because they make you wrap it up in a separate widget called a ScrollView that like contains it has scroll bar 


why does it make separation like that, because that group of four I want all of that to scroll 
<em> the general principle here is there is all kinds of different widget and I might want any of them to have scrolling, if I make it is implemented through boolean stuff here that probably means whoever implements this code library has to make this scrollable and so every single widget they have to write logic in there for scrolling where this implements scrolling once as like a container of scrolling and then even if they make your own widgets it will know how to scroll too because it is separated out this way</em>


```xml
<<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
 <ScrollView android:layout_height="wrap_content"
     android:layout_width="wrap_content">
    <TextView
        android:layout_width="220dp"
        android:layout_height="220dp"
        android:text="Apple Inc. is an American multinational technology company  "
     />
    
    

</LinearLayout>
```




in scrollview you will have to add a lot of different properties to it 










## EditText

 in the design mode, it does not say EditText, it only says PlainText, that is what you want 

the old way is you put a label there, but like new hotness is that you put the little label of what you want in the xml to type, that is called a hint in android



<table>



<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:hint="text"</td><td>gray placeholder text shown before user types</td>
</tr>


<tr> 
<td>android:inputType="type"</td><td>what kind of input is being typed; number, phone, data, time. it helps to validate the data on the wide while they are typing, this makes sure that users only type the right thing there, it pops up the keyboard </td>
</tr>
 


<tr> 
<td>android:lines="int"</td><td>number of visible lines / rows of input</td>
</tr>



<tr> 
<td>android:maxLines="int"</td><td>max lines to allow users to type in the box</td>
</tr>


<tr> 
<td>android:text="string"</td><td>initial text to put in box (default empty)</td>
</tr>


<tr> 
<td>android:textSize="size"</td><td>size of font to use e.g. 20dp</td>
</tr>


<tr> <td colspan="2"> 
EditText et = (EditText)findViewById(R.id.id);

String text = et.text.toString();
</td> </tr>



</table>





```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <EditText
        android:id="@+id/editText"
        android:layout_width="242dp"
        android:layout_height="75dp"
        android:layout_marginTop="76dp"
        android:hint="your iq"
        android:inputType="numberDecimal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:maxLines="2"
        android:textSize="10dp">

    </EditText>

    <EditText
        android:layout_width="254dp"
        android:layout_height="92dp"
        android:layout_marginTop="104dp"
        android:hint="please type your username"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.496"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/editText"
        app:layout_constraintVertical_bias="0.015"
        android:textSize="10dp">>

    </EditText>


</androidx.constraintlayout.widget.ConstraintLayout>


```

you can set the textbox to have max number of lines.  you will detect that with your keyboard listener. there is a lot variations based on what keys to the keyboard 







<h3> ImageView</h3> 
<em> displays an image without being clickable </em>
<table>
<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:src="@drawable/img"</td><td>image to put in the view must correspond to an image resource</td>
</tr>






<tr> 
<td>android:contentDescription="string"</td><td>text to describe the image for blind users</td>
</tr>


<tr> 
<td>android:tag="string"</td><td>a text tag to associate with the image</td>
</tr>


<tr> 
<td>android:scaleType="type"</td><td>causes the image to grow/shrink; can be center, centerCrop, fitCenter, matrix</td>
</tr>

</table>


```java
ImageView iv = (ImageView)findViewById(R.id.id);
iv.setImageResource(R.drawable.filename);
```

<em> I will walk you through the steps in a second, you have to get some images files to put them in your project. it is gonna make your way to be a bit difficult to find through them  </em> 


<strong> there is folder called build, it means when you compile a project, it puts the output of binaries ,app is the actual code you write for you app, gradle is some sort of like makefile stuff note how to prepare and how to build how to compile an app, it is stretched to fit  </strong>


<h3> ImageButton</h3>
 a clickable widget with an image label
<table>

<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:clickable="bool"</td><td>set to false to disable the button</td>
</tr>


<tr> 
<td>android:onClick="function"</td><td>function to call in activity when clicked , must be public, void, and take a View arg</td>
</tr>



<tr> 
<td>android:src="@drawable/img"</td><td>image to put in the button(must correspond to an image resource)</td>
</tr>


</table>


<em>to set up an image resource </em>
<ul>
<li> put image file in project folder app/src/main/res/drawable(use app/src/main/res/drawable-xxhdpi if image is very large)</li>
<li> use @drawable /foo to refer to foo.png</li>
<li> use simplefile names with only letters and numbers</li>
</ul>


when you use the app, it sort of bundles up all the necessary files inside the app and so you do not have to worry about copying over these files. move other widgets out of the way and just here in the middle to set up a way to look at these  

<i> the moment when you drop it, it shows what image you want to display. you will have to them with alphabets!!!!! so it just pops up, you can lay out by attaching it to the other things on the screen </i>

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <ImageView
        android:id="@+id/imageView"
        android:layout_width="188dp"
        android:layout_height="356dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:src="@drawable/one" />
</androidx.constraintlayout.widget.ConstraintLayout>

```

<strong> baiscally just means you have got to give your files unique name prefixes for it to work properly</strong>
<i> there are some wired part of android where they changed the names of some of the properties, so they will be more compatible with different versions of android or whatever. when you refer to something in android with @ type and then alsh and then a name so like this identifier here is you are saying i want to refer to one of my drawable images whose name is xxx. we made this images in natural size </i>

 If I set the width of the size of these images wrap parents and I go back to the editor, you can change how you want that to look. if I would like to allow this app to pick different turtles there is a lot of different ways you could do that now, 1 you can type a name  2 what are the other ways you can do that? do not give them options, pick one from them you won'get get overwhelmed, give you a constrainted, we should make it clear and represent them, we should not make them type





<h3> CheckBox</h3>
an individual toggleable boolean on/off checkbox
<table>

<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:clickable="bool"</td><td>set to false to disable the checkbox</td>
</tr>

<tr> 
<td>android:checked="bool"</td><td>whether box is initally check default false</td>
</tr>





<tr> 
<td>android:onClick="function"</td><td>function to call in activity when clicked , must be public, void, and take a View arg</td>
</tr>




<tr> 
<td>android:text="text"</td><td>text to put next to the checkbox</td>
</tr>


</table>



```xml
CheckBox cb = (CheckBox) FindViewById(R.id.id);
cb.toggle();
cb.checked = true;
cb.performClick();

```

<em> these are mutually exclusive you only want one on the sreen at a time, check boxes are not usually mutaully exclsuively,. this is when you put on your seitain stuff, for toppings , you check boxes as many as  </em>









<h3> Switch</h3>
an individual toggleable boolean on/off swtich
<table>

<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>



<tr> 
<td>android:textOn="text"</td><td>text show next to on right side</td>
</tr>

<tr> 
<td>android:textOff="text"</td><td>text show next to off left side</td>
</tr>

<tr> 
<td>android:showText="bool"</td><td>whether to show text on L/R sides default false</td>
</tr>



<tr> 
<td>android:onClick="function"</td><td>function to call in activity when clicked , must be public, void, and take a View arg</td>
</tr>




<tr> 
<td>android:text="text"</td><td>text to put next to the checkbox</td>
</tr>


</table>


```xml

    <Switch android:layout_height="wrap_content"
            android:layout_width="wrap_content"
            android:textOn="on"
             android:textOff="off"
            android:id="@+id/switcher"
           />


```

```java

Switch sw = findViewById(R.id.id);
if(sw.checked){
   .... 
}

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                
            }
        });
    }




   sw = findViewById(R.id.switcher);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               if(isChecked) {
                   Toast.makeText(getApplicationContext(), "this is checked", Toast.LENGTH_SHORT).show();
               }
            else{
                Toast.makeText(getApplicationContext(), "this is checked", Toast.LENGTH_SHORT).show();

            }
            }
        });
```
<em> it is using apps have these check box which have different looks to it </em>













<h3> RadioButton</h3>
a toggleable on/off switch; part of a group
<table>

<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:clickable="bool"</td><td>set to false to disable the checkbox</td>
</tr>

<tr> 
<td>android:checked="bool"</td><td>whether box is initally check default false</td>
</tr>





<tr> 
<td>android:onClick="function"</td><td>function to call in activity when clicked , must be public, void, and take a View arg</td>
</tr>




<tr> 
<td>android:text="text"</td><td>text to put next to the checkbox</td>
</tr>


</table>

<strong> need to be nested inside a RadioGroup tag in XML so that only one can selected at a time </strong>


```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <ImageView
        android:id="@+id/imageView"
        android:layout_width="188dp"
        android:layout_height="356dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        android:src="@drawable/one" />

    <RadioButton
        android:id="@+id/radioButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="16dp"
        android:checked="true"
        android:text="Leo"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView"
        app:layout_constraintVertical_bias="0.13" />

    <RadioButton
        android:id="@+id/radioButton2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginLeft="16dp"
        android:layout_marginTop="32dp"
        android:text="Michelango"
        app:layout_constraintStart_toEndOf="@+id/radioButton"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

    <RadioButton
        android:id="@+id/radioButton3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="12dp"
        android:layout_marginLeft="12dp"
        android:layout_marginTop="32dp"
        android:text="Danotelo"
        app:layout_constraintStart_toEndOf="@+id/radioButton2"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />

    <RadioButton
        android:id="@+id/radioButton4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginLeft="20dp"
        android:layout_marginTop="32dp"
        android:text="Raphel"
        app:layout_constraintStart_toEndOf="@+id/radioButton3"
        app:layout_constraintTop_toBottomOf="@+id/imageView" />
</androidx.constraintlayout.widget.ConstraintLayout>

```



 you dock to him, it will not make the buttons to be mutually exclusive to each other, you can imagine the user interface where you have multiple different groups of radio buttons 


<strong> you can drag and drop radio group, it is not really a widget, it is more of a container , you drag and drop radio buttons on the group</strong>


```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <ImageView
        android:id="@+id/imageView"
        android:layout_width="188dp"
        android:layout_height="356dp"
        android:src="@drawable/one"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.497"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.384" />

    <RadioGroup
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginEnd="168dp"
        android:layout_marginRight="168dp"
        android:orientation="vertical"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/imageView">

        <RadioButton
            android:id="@+id/one"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:checked="true"
            android:onClick="radioButtonClick"
            android:text="Leo" />

        <RadioButton
            android:id="@+id/two"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="radioButtonClick"
            android:text="Michelango" />

        <RadioButton
            android:id="@+id/three"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="radioButtonClick"
            android:text="Danotelo" />

        <RadioButton
            android:id="@+id/four"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:onClick="radioButtonClick"
            android:text="Raphel" />

    </RadioGroup>

</androidx.constraintlayout.widget.ConstraintLayout>

```

 you know how to like indenting them to indicate that they are inside a group there, only one of these should be clickable at a time 
<strong> if you want it to scroll vertical, choose orientation, the radio does not a visual apperance to it </strong>


 let's write a listener in the code, I will show you a style here yo ucan set the same onCLick for all four functions , I want to refer to which one is clicked on  

<strong> basically I guess it does just based on  </strong>

```java
public void radioButtonClicked(View view){
    if (view == radioButton1){

    }
}

```
<strong> another way you can say this, that is like the way of saying the same thing </strong>

```java
public void radioButtonClicked(View view){
    if (view.id == R.id.radioButton1){
        
    }
}

```

 if you want to set images to be displayed on the screen, you can do that , you would set the src for it.  the value you pass it here is the id here


```java 
imageView.setImageResource(R.drawable.filename);

```




<strong> they check the integer for reference the way that you refer to them is you write R.resource.id . that is the way to make the same event handler run on all different radio buttons  </strong>


```java

package com.example.example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView) findViewById(R.id.imageView);
    }

    public void radioButtonClick(View view){
        if(view.getId() == R.id.one){
            iv.setImageResource(R.drawable.one);
        }else if(view.getId() == R.id.two){
            iv.setImageResource(R.drawable.two);
        }else  if(view.getId() == R.id.three){
            iv.setImageResource(R.drawable.three);
        }else  if(view.getId() == R.id.four){
            iv.setImageResource(R.drawable.four);
        }




    }
}

```


 the xml is like the initial declared state of the app when it first loads up, but then all that state is subject to change, it loads up the xml and uses it in java ,all that is subject to change on the screen , they are up there now . maybe I misclicked something


 I am kinda going out of my way not to teach you every little feature of java, somtimes the editor tries to hint to you maybe there is a better way of writing the same statement. if all the branches are checking the same variabels value like that, you can use switch  , it is the shorthand of saying the same thing . click the buble thing on android studio. it tries to remove the redundancy you know , it is dependent on what view I got clicked , editor is underlining your code  


```java 
    public void radioButtonClick(View view) {
        switch (view.getId()) {
            case R.id.one:
                iv.setImageResource(R.drawable.one);

                break;
            case R.id.two:
                iv.setImageResource(R.drawable.two);


                break;
            case R.id.three:

                iv.setImageResource(R.drawable.three);
                break;
            case R.id.four:
                iv.setImageResource(R.drawable.four);


                break;
        }

    }

```


##  convering resources id 

 if you have a resource name and want its ID : this.getResources().getIdentifier("nameOfDrawable", "drawable", this.getPackageName())







<h3> ImageButton</h3> 
<em> a clickable widget with an image label </em>
<table>
<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:src="@drawable/img"</td><td>image to put in the button (must correspond to an image resource)</td>
</tr>






<tr> 
<td>android:onCLick="function"</td><td>function to call in activity when clicked (must be public, void, and take a View arg)</td>
</tr>


 
 

</table>


1 to set up an image resource: put image file in project folder app/src/main/res/drawable use app/src/main/res/drawable-xxhdip if image is very large 
 use @drawable /foo to refer to foo.png
 use simple fine names with only letters and numbers

<i> if you switch to image view and you tap on the image, it won't do anything. that is useful if want to make know more.. </i>




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

 if you want to set the list , the people who made android development they hate you and so that, you have <strong> set this thing called entries</strong>  

<h3> Static list</h3>

<ol> 
<li> static list: you know ahead of time what the contents are, content is fixed and known before the apop runs . declare the list elements in the string.xml resource file</li>
<li> dynamic list: you download from the internet, content is read or generated as the program runs. comes from a data file, or from the internet, etc. must be set in the java code . you display them or something like that </li>

</ol>



## String resources


<strong> declare contant strings and arrays in res/values/string.xml : </strong>

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



<h3> list adapter </h3>

<strong> adapter:helps turn list data into lsit view items</strong>
common adapters:
1 ArrayAdapter: items come from an array or list 
2 CursorAdapter: items come from a database query

 syntax for creating an adapter 

<i> ArrayAdapter name = ArrayAdapter<String>(activity,layout,array); </i>





<ul>

<li>  the activity is usually this</li>
<li>  the default layout for lists is android.R.layout.simple_list_item_1  </li>
<li>get the array/list by reading your file or data source of choice </li>


 
</ul>

 attach it by setting adapter properly of ListView



##  handling list events 


<ol>
<li> Lists do not use the onClick event</li>
<li> event listenres must be attached in java, not XML </li>
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

 come up on sessions, it is a temporary holding spot 