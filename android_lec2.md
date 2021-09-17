






the definite answer is this will suit most people, work on exercises. show of hands. run into issues along the way. Know that off the top of your head and work in pairs 


# Review 
the whole screen is called activity 

the UI elements are called widgets or called views. positioning or sizing things 

clicking buttons is an event, so we made a function to handle it. onClick attribute here and you choose the function. 


you refer to the widgets by R.id.  and it will return you a variable that you can use to represent that widget. It deduces as an int. It is taking away points 

```java
findViewById<TextView>(R.id.element).setText = "";
```
this refers to this view and then immediately set dot something. I mushed it together it is totally up to you 


something out of our code called onCreate to create it so we cannot make it private. Somehow wiring things together between layout and the wedget doodled on the screen mostly working 


## Toast 
toast: a pop-up message that appears for a short time. 
it pops up and fade away 
useful for display short updates in response to events 
it is a big mumbo jumbo you have to do it 
should not be relied upon extensively for important info 
length can be Toast LENGTH_LONG 

```java
toast.makeText(this, "text", Toast.LENGTH_SHORT).show() ;
```


why is there a (View view) parameter, the short answer is android requires every onclick event handler pass the widget that you clicked on. We are fitting into the framework 
the unified handler function 

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
        android:onClick="eitherButtonClicked"
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
        android:onClick="eitherButtonClicked"
        android:text="@string/button_number"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

    <TextView
        android:id="@+id/point"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Points:0"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/leftButton"
        app:layout_constraintVertical_bias="0.508" />

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






    public void eitherButtonClicked(View view){
        int leftValue = Integer.parseInt((String) leftButton.getText());
        int rightValue = Integer.parseInt((String) rightButton.getText());
        if(view == leftButton){
            if(leftValue > rightValue){
                point ++;
                Toast.makeText(getApplicationContext(),"you rock!!!!", Toast.LENGTH_SHORT).show();
            }else{
                point --;
                Toast.makeText(getApplicationContext(),"suck it" , Toast.LENGTH_SHORT).show();
            }


        }

        if(view == rightButton) {
            if (rightValue > leftValue) {
                point++;
                Toast.makeText(getApplicationContext(), "you rock!!!!", Toast.LENGTH_SHORT).show();
            } else {
                point--;
                Toast.makeText(getApplicationContext(), "suck it", Toast.LENGTH_SHORT).show();
            }
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

the new version of android make the id to be magical name appear for you 




##  Laying out the UI
expand app/res/layout and double click activity_main.xml to open the file 

the default activity layout defines two Views: a ConstraintLayout and a TextView 
Views are the building blocks you use to compose a UI. everything you see on the screen is a view. views that the user can see or interact with are called widgets. Some widgets show text. some widgets how graphics 

every widget is an instance of the View class or one of its subclasses such as TextView or Button
A ViewGRoup is a kind of View that contains and arranges other views. A ViewGRoup does not display content itself. rather, it orchestrates where other view's content is displayed. ViewGroups are often referred to as layouts 
In the default activity layout, ConstraintLayout is the ViewGRoup responsible for laying out its sole child, a TextView widet 



 your widges exist in a hierachy of View objects called the view hierachy

the root element of this layout's view hierachy is a LinearLayout 
as the root element, the LinearLayout must specify the Android resource XML namespace 


## Sizing and positioning

how does the prorgammer specify where each component appears, how big each component should be , etc 

 
**Absolute positioning  (C,C#)**
 
 programmer specifies exact pixel coordinates of every component
 put this button at xx and make it xx px in size, it does not generalize well 



 
 



**Layout manager (java, Android, Kotlin)**
 
 Objects that decide where to position each component based on some general roles or criteria. Abstract layout system
 put these buttons into a xxx by xx grid and put these textboxes in a horizontal flow in the south part of the app, like aligment and strethching or not stretching or things 
 more flexible and general with a variety of devices and intuitive 









## ViewGroup as layout

ViewGroup superclass represents containers of views. 



**ViewGroup superclass repressents containers of views**



layouts are described in XML and mirrored in java code 

android provides serveral pre-exisiting layout managers; you can define your own custom layouts if needed
layouts can be nested to achieve cmobination of features 








 

**in the java code and xml** 

an Activity is a ViewGroup
various layout classes are also ViewGroups
Widgets can be added to a ViewGroup , which will then manage that widget's position/size behaviour





## XML, in breift 
XML: a language for describing hierarchical text data. a data markup language
<ol>
uses tags that consists of elements and attributes. tags can be nested

 some tags are opened and closed; others self-closed
</ol>

```xml
<elment attr="value" attr="value"> <element>

<elment attr="value" attr="value" /> 
```



## changing layout
go to the Text view for your layout xml file 
change open/close tags to new layout type. LinearLayout 
now go back to Design view and add widgets 


there are different strategies to do layouts 



# LinearLayout
lays out widgets/views in a single line 
orientation of horizontal or vertical 
items do not wrap if they reach edge of screen 



LineaLayout inherits from ViewGroup, which, as we said earlier, is a subclass of View that contains and araranges other views. You use a LinearLayout when you want views arranged in a single column or row. Other ViewGroup subclasses that you will meet later include ConstraintLayout and FrameLayout 

When a view is contained by a ViewGroup, that view is said to be a child of the ViewGroup. the root LinearLayout has two children; a TextView and another LinearLayout. thie child LinearLayout has children of its own 



```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical">
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="24dp"
        android:text="@string/question_text" />
    <LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal">
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/true_button"
            android:layout_marginRight="20sp"/>
        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="@string/false_button"
            android:layout_marginLeft="20sp"/>
    </LinearLayout>
</LinearLayout>

```


the widgets exist in a hierachy of View objects called the view hierachy 


the root element of this layout view hierachy is a LinearLayout 

as the root element, the LinearLayout must specifify the android resource XML namespace at 

http://schemas.android.com/
LinearLayout must
apk/res/android .

what we alluded to is sort of true, real coders like to do it in the xml. noobs know that. let's get wild. See it out of its comfort zone 


there is more than that 
we will use .. when omitting boilerplate code is autogenerated by android studio and not relevant to the specific example at hand 

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <Button
        android:id="@+id/button4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        tools:layout_editor_absoluteX="84dp"
        tools:layout_editor_absoluteY="433dp" />

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        tools:layout_editor_absoluteX="84dp"
        tools:layout_editor_absoluteY="341dp" />

    <Button
        android:id="@+id/button2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        tools:layout_editor_absoluteX="84dp"
        tools:layout_editor_absoluteY="248dp" />

    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        tools:layout_editor_absoluteX="84dp"
        tools:layout_editor_absoluteY="159dp" />
</LinearLayout>

```


## Gravity
gravity: alignment direction that widgets are pulled 

1 top bottom, left, right , center 
2 combine muple with | 
3 set gravity on the layout to adjust all widgets ; set layout_gravity on an individual widget 

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="horizontal"
    android:gravity="center|right">

<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content">

    <Button
        android:id="@+id/button3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        />
</LinearLayout>

</LinearLayout>
```


## Weight 
weight: relative element sizes by integers 
1 widget with weigth K gets K/total fraction of total size 
2 cooking analogy 


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



    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_weight="1"
        />

    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_weight="3"
        />
    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_weight="1"
        />

    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_weight="1"
        />



</LinearLayout>

```


android studio has a nice autocompletiion suggesting the things 
that is weight for sizing and stretching 


## Widget Box Model 


content: size of widget itself 

padding : artificial increase to widget size outside of contente 

border: outside padding, a line around edge of widget 

margin: invisible separation from neighbouring widgets 




padding would be inside the border
margin would be outside the border 

it takes up amount of space then the widget can have padding where the widget stretched larger than that 

things that contribute the size of a widget 



```xml 
<Button 
android:padding="10sp"
android:margin="10sp"
>

```



## Sizing an individual widget

**width and height of a widget can be**
wrap_content: exactly large enough to fit the widget's content 
match_parent: as wide or tall as 100% of the sreen or layout 
a specific fixed width such as dp , not usally recommended 
dp = device pixels 
dip - device indepdent pixels 
sp = scaling pixels 

fit its stuf to fit its content all the way down and around 
that is the dimension of the linear layout 


how to mush over the right edge of the screen 
the inner container shrank to this big and then the layout gravity of outer container pushed the inner container over to the right 

```java
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >



    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_gravity="left"
        android:layout_weight="1"
        />

    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_gravity="center"
        android:layout_weight="3"
        />
    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
        android:layout_weight="1"
        android:layout_gravity="right"
        />
 


</LinearLayout>

```




## padding 
padding: extra space inside 
set padding to adjust all sides; 
paddingTop, Bottom, Left, Right for one side 
usually set to specific values like dp, some widgets have a default value 16dp 

## margin 
margin: extra blank space outside widget 
set layout_margin to adjust all sides 
layout_marginTop, Bottom, Left, Right 
usually set to specific values like dp set dfeaults in res/values/dimens.xml 


## GridLayout 
lays out widgets, views in lines of rows and colums 
orientation attribute defines row/column-major order 
introduced in android 4, replace order TableLayout 
each widget placed into next available row/column unless given a layout_row and layout_colum attribute 

it is identical to linear layout except it has rows and colums so instead of just one line vertically or horizontally 

```xml
<?xml version="1.0" encoding="utf-8"?>
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:rowCount="2"
    android:columnCount="2"
    tools:context=".MainActivity"
    android:orientation="vertical"
    >



    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"


        />

    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"


        />
    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"

        />

    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"
      

        />




</LinearLayout>

```


## TableLayout
Similar to GridLayout, but each widget must be put into a row 

```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"

    tools:context=".MainActivity"
    android:orientation="vertical"
    >


<TableRow>
    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"


        />

    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"


        />
    
</TableRow>
    <TableRow>
    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"

        />

    <Button

        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Button"


        />
    
    </TableRow>




</TableLayout>
```




## Nested Layout 

***nested layout: layouts inside other layouts***
useful to produce more complicated apperance 
```xml
<OuterLayout>
<InnerLayout> 
<Widgets .../>
</InnerLayout> 

<InnerLayout> 
<Widgets .../>
</InnerLayout> 
</OuterLayout>
```

## ConstraintLayout 
default layout; tightly integrated with android studio visual designer 
widget's corners are connected to other widgets or screen edges 

every view must have at least two constraints : one horizontal and one vertical 

stretchy, springy. Android felt like the editor was clunky and part of the reason the layout did not every well match the dragging and dropping that the person was doing 

it is the mostly officially recommended layout nowadays 



## ConstraintLayout anchor points
attach sides of one widget to sides of another or parent 
it is easier to fiddle around here 

```xml 
app:layout_constraintSide_toSide="@+id/id"
```
Horizontal sides: left, right can substitute Start/End for Left/Right to work better than RTL languges. mostly from left to right , top to bottom 


vertical sides : Top, Bottom, Baseline, want things to line up or something

```xml 
app:layout_constraintSide_toLeftOf="@+id/id"
app:layout_constraintSide_toBottomOf="@+id/id"
```

you basically attach the constrain a widget by attaching this edge to that edge of another edge 

two springs pulling from each end 


ConstraintLayout requires every widget has to have its vertical and horizontal attached to something 
if it has a red line, it says this view has not been constrained, you have to anchor it otherwise it won't compile and it won't run. you have to drag and drop let go 





##  Widget attributes 

### android:layout_width and android:layout_height 


the anrdoid:layout_width and android:layout_height attribtues are required for almsot every type of widget 
they are typically set to either match_parent or wrap_content 


match_parent view will be as big as its parent</li>


wrap_content view will be as big as its contents require</li>




### android:orientation  

the android:orientation attribute on the two LinearLayout widgets determines whether their children will appear vertically or horizontally. the root LinearLayout is vertical; it is child LinearLayout is horizontala
 the order in which children are defined determines the order in which they appear onscreen. 

In a vertical LinearLayout, the first child defined will appear topmost. In a horizontal LinearLayout, the first child defined with be leftmost 



### android:text

the TextView and Button widgets have android:text attributes. this attribute tells the widgt when text to display 


notice that the values of these attribtues are not literal strings. they are ferences to string resources. as denoted by the @string/ syntax 



a string resource is a string that lives in a separate XML file called a string file. you can give a widget a hardcoded string, but it is usually not a good idea. placing strings into a separate file and then referencing them is better because it makes localization easy </i>





##  String sources 

every project includes a default strings file named res/values/strings.xml 
open res/values/strings.xml 

the template already added one string resource for you . you will get the literal string at runtime 

depending on your vesion, you may have additional strings. do not delete them. deleting them could cause cascading errors in other files 

although the default strings file is named strings.xml, you can name a strings file anything you want 

you can also have multiple strings files in a project 
as long as the file is located in res/values/. has a resources root element, and contains child string elements, your strings will be found and used 



## Layout XML to view objects 


How do XML elements in activity_main.xml become View objects. the answer starts in MainActivity class 



the class file for MainActivity is the app/java directory of your project 




a quick aside about the directory name before we get into how layout become views: this directory is called java because Android originally supported only java code. 




the file has one Acitiy function, onCreate(Bundle?)

the onCreate(Bundle?) funciton is called when an instance of the activity subclass is created. when an activity is created, it needs a UI to manage. to give the activity its UI, you can call Activity.setContentView(layoutResID)

this function inflates a layout and puts its onscreen. 
when a layout is inflated, each widget in the layout file is instantiated as defined by its attributes. you specify which layout to inflate by passing in layout's resource ID 



##  Resources and resource IDs
a layout is a resource. a resource is a piece of your app that is not code -- things like images files, audio files, and XML files 

resources for your project live in a subdirectory of the app/res directory. 
you string file, which contains string resources, lives in res/values 



to access a resource in code, you use its resource ID. the resource ID for your layout is R.layout.activity_main 
/app/build/generated/not_namespaced_r_class_sources/debug/
processDebugResources/r/ .

by the way, you may not see this file instantly update after making a change to your resources. 
android studio maintains a hidden R.java file that your code builds against 

the R.java file in listing is one that is generated for your app just before its installed on a device or emulator 


this is where the R.layout.activity_main comes from -- it is an integer constant named activity_main without the lyaout inner class of R 


android generated a resource ID for the entire layout and for each string, but it did not generate resource IDs for individual widgets in activity_main.xml 
not every widget needs a resource ID 


notice that there is a + sign in the values for android:id but not in the valuesfor android:tex. this is because you are creating the resource IDs and only referencing the strings 
before moving on, change the project tool window from Project view to Android view 






##  wiring up widgets 


 Get references to the inflated View objects </li>
 set listeners on those objects to respond to user actions </li>


you can access them in MainAcitivyt.. 

rather than return it as a View, it is cast to the expected subtype of View 


you use the resource IDs of your buttons to retrieve the inflated objects and assign them to your properties. 
since the view objects are not inflated into and available in memory until after setContentView() is called in onCreate() , you use lateinit on your property declarations to indicate the compiler that you will provide a non null view value before you attempt to use the contents of the properties 


<h5> press option-return or alt - enter to let the magic under the hood amaze you. the ne import statement now appears with the others at the top of the file </h5>







##  setting listeners 

android apps are typically **event driven**   
unlike command line programs or scripts, event driven applications start and then wait for an event, such as the user presssing a button. events can also be initiated by the OS or another app, but user initiated events are the most obvious 

when your app is waiting for a specific event, we say that is listening for that event. the obejct that you create to respond to an event is called a listener, and the listener implements a listener interface for that event </i>

if you have an Unresolved reference: View error, try using option-return / alt-enter to import the class 



```java
package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }




}
```


##  using anonymous inner classes 


this listener is implemnted as an anonymous innerclass.the syntax is a little tricky, but it helps to remeber that everything wihtin the outermost set of parentheses is passed into setOnClickListener(OnClickListener).within these parentheses, you carete a new , nameless class and pass its entire implementation 


all of the listeneres will be implemented as anonymous inner classes. doing so puts the implementations of the listener's methods right where you want to see them. and there is no need for the overhead of a named class because the class will be used in one place only 

your anonymous class implements OnClickListener, it must implement that interface's sole method, onClick(View) 
you have left the implementation of onClick(view) empty fro now , and the compiler is Ok with taht. a listner interface requries you to implement onClick(view), but it makes no rules about how to implement it.


```java
//you need to pass a Context to the makeText method. Here this is not a context. It is just a reference of your AboutMeActivity class which is not an activity
package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mTrueButton;
    private Button mFalseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = findViewById(R.id.true_button);
        mFalseButton = findViewById(R.id.false_button);

        mTrueButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(MainActivity.this, R.string.trueToast, Toast.LENGTH_SHORT).show();

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
             Toast.makeText(MainActivity.this, R.string.falseToast, Toast.LENGTH_SHORT).show();

        }

        });

    }
    
}
```


A toast provides simple feedback about an operation in a small popup. It only fills the amount of space required for the message and the current activity remains visible and interactive. Toasts automatically disappear after a timeout.
to create a toast, you call the following method from the Toast clas: 
```java 
public static Toast makeText(Context context, int resId, int duration);

```



the Context parameter is typically an instance of Activty(Activity is a subclass of Context). The second parameter is resource ID of the string that the toast should display. The context is needed by the Toast class to be able to find and use the string's resource ID. the third parameter is one of two Toast, constants that specify how long the toast should be visible. 




after you have created a toast, you call Toast.show() on it to get it on screen 





# using code completion 
code completion can save you a lot of time, so it is good to become familiar with it early 

start typing the code addition shown. when you get to the period after the Toast class, a popup window will appear with a list of suggested methods and constants from the Toast class. 

to choose one of the suggestions, use the up and down arrow keys to select it. if you wanted to ignore code completion, you could just keep typing. It will not complete anything for you if you do not press the Tab key, press the Return/Enter key, or clicking on the pop-up windows 

see it in action 


##  Android Build Process 
your probably have some burning questions about how android process works. You have already seen that builds your project automatically as you modify it rather than on command.


during the build process, the tools take your resources, code, and AndroidManifest.xml file which contains metadata about the app abd turn them into .apk file to the masses, you have to sign it with a release key 




res/ activity_quiz.xml or strings.xml | AndroidManifest.xml 
  |
 \ /
 asset packaging tool aapt -> gen /- R.java | src /- Activity.java -> compile java  -> java bytecode .class -> cross compile to dalvik 

  |                           |
compiled resources    dalvik bytecode .dex 
                  |
             build and sign apk 
                | 
        android package .apk 
                | 
            install and run 


as part if the build process . app android asset packaging tools, compiled resources are packaged into .apk file 


then, when 







## Model View Controller 


<em> sections are separated into three sections labeled Model, View, Controller. android apps are designed around an architecture called Model-View-Controller, or MVC for short, all objects in your app must be a model object, a view object, or a controller object</em>

<strong>
a model object holds the app's data and business logic. model classes are typically designed to model the thigns you app is connected with. model objects have no knowledge of the user interface; their sole purpose of holding and managing data. In andoroid apps, model classes are generally custom classes you create. all of the model objects in your app compose its model layer</strong>




<strong> view objects know how to draw themseleves on the screen and how to respond to user input, like touches. a simple rule of thumb is that if you can see it on screen, then it is a view. android provides a wealth of configuratble view classes. you can also create custom view classes. an app's view objects make up its view layer. the view layer consists of the widgets that are inflated from activity_xxx.xml</strong>



<strong> controller objects tie the view and model objects together. they contain application logic. contrllers are desigend to respond to varius events triggerred by view objects and to manage the flow of data to and from model objects and the view layer, in android, a controller is typically a subclass of Activity, Fragment, or Service</strong>


##  Benefits of MVC
an app can accumulate features until it is too complciated to understand 

separating code into classes helps you design and understand the app as a whole; you can think in terms of classes instead of individual variables and methods 


similarly, separating classes intomodel, view, and controller layers helps you design and understand an app; you can think in terms of layers instead of individual classes 

MVC also makes classes easiser to resue. a class with restricted responsibilities in more reusable than one with its fingers in every pie 

```xml 
<!-- string.xml -->
<resources>
    <string name="app_name">QuizApp</string>
    <string name="question_one">Are you dumb?</string>
    <string name="question_two">Are you smart?</string>
    <string name="question_three">Are you pretty?</string>
    <string name="question_four">Are you ugly?</string>
    <string name="true_button">true</string>
    <string name="false_button">false</string>
    <string name="trueToast">the true button is clicked</string>
    <string name="falseToast">false toast </string>
    <string name="next">Next</string>
    <string name="toast_true">Left button clicked</string>
    <string name="toast_false">right button clicked</string>
</resources>


```

notice that you can use the escape sequence '\ toget an apostrophe in your string. you can use all the usual escape sequences in your string resources 







##  Generating getters and setters 


the first step is to configure android studio to recognize the m Prefix for member variables .


File -> Settings, editor -> code style -> code generation tab 

naming -> file and add m prefix in project. 

static for s 

what is the point of setting these? 


Step 1: Create a new Android Project for MVC Example

Start your Android-Studio and create a new Project to build a simple Login Validation using MVC pattern.

File -> New -> New Project -> Select Empty Activity -> Next -> Give a name to your project as MVC EXAMPLE -> finish.

Step 2: Creating 3 MVC Components Package Folder in your project

So you know that we are here to work and learn about how to implement MVC in android,

We will create 3 package in our android project
 
Just Checkout above Project Structure we have 3 package, in each package we have 1 – 2 files ( java class or interface ).




Step 3: Creating Interface and Classes  and Coding it.


```shell
$$:~/AndroidStudioProjects/QuizApp/app/src/main/java/com/example/quizapp$ ls -al 
total 24
drwxr-xr-x 5 edhuang domusers 4096 Apr 15 12:47 .
drwxr-xr-x 3 edhuang domusers 4096 Apr 10 13:32 ..
drwxr-xr-x 2 edhuang domusers 4096 Apr 15 12:46 Controller
-rw-r--r-- 1 edhuang domusers 1118 Apr 14 17:02 MainActivity.java
drwxr-xr-x 2 edhuang domusers 4096 Apr 15 12:47 Model
drwxr-xr-x 2 edhuang domusers 4096 Apr 15 12:47 View


```

## Creating a new class 
right click com.xxx.xx package and select New -> Java Class 





## Generating settters and getters 

the first step is to configure android to recognize the m prefix for member variables 

File-> Settings 
Editor -> Code Style -> Code Generation -> Naming table 



right click after the constructor and generate getter and setter 
```java
package com.example.quizapp.Model;

public class Question {

    private int mTextResId;
    private boolean mAnswerTrueOrFalse;


    public Question(int mTextResId, boolean mAnswerTrueOrFalse){
        this.mTextResId = mTextResId;
        this.mAnswerTrueOrFalse = mAnswerTrueOrFalse;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswerTrueOrFalse() {
        return mAnswerTrueOrFalse;
    }

    public void setAnswerTrueOrFalse(boolean answerTrueOrFalse) {
        mAnswerTrueOrFalse = answerTrueOrFalse;
    }
}




```

## updating the controller layer 

```java 
package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.Model.Question;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;

    private Question [] myQuestionList = new Question[] {
            new Question(R.string.question_one, true),
            new Question(R.string.question_two, false),
            new Question(R.string.question_three,true),
            new Question(R.string.question_four, false),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.questions);
        int questionNo = myQuestionList[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionNo);

        mNextButton = (Button) findViewById(R.id.next_button);





        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);

            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % myQuestionList.length;
                updateQuestion();

            }
        });

    }


    private void updateQuestion(){
        int questionNo = myQuestionList[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionNo);

    }

    private void checkAnswer(boolean userChoseAnswer){
        boolean answerIsCorrect = myQuestionList[mCurrentIndex].isAnswerTrueOrFalse();

        int messageResId = 0;

        if(userChoseAnswer == answerIsCorrect){
            messageResId = R.string.toast_true;
        }else{
            messageResId = R.string.toast_false;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }

}

```

##### in case you do not see Toast shows up, here are two possible causes. 
1. you need to put .show() after Toast.makeText() method to exhibit the Toast 
2. or you need the wipe the data for your emulator device 



## configuring your device for development 

on device running android, developer options is not visible by default. to enable it. go to Settings -> About Phone and press build number 7 times. then you can return to Settings, see developer options, and enable USB debugging 


run the app, android will offer a choice between running on the virtual device or the hardware device plugged into your system 



if android studio defaults to your emulator without offerign a choice of device to run the app on, rechck the steps above and make sure your device is plugged in 



## adding an icon 

the user interface would be spiffer if the button also displayed a right pointing arrow icon 



the suffixes on directory names refer to the screen pixels density of a device 
mdpi medium desnity screen 

hdpi high density screens 

xhdpi extra high density screens 

xxhdpi extra extra high desnity screen 

if an app runs on a device that has a screen desntiy not included in any of the app's screen density qualifiers. android will automatically scale the available image to appropriate size for the device 


it is not necessary to provide images for all of the pixel desnity buckets 


to reduce the size of your app, you can focus on one or a few of the higher resolution buckets and selectively optimize for lower resolutions when automatic scaling provides image with artifacts on those lower resolutions devices 





```java
package com.example.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.Model.Question;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreButton;
    private TextView mQuestionTextView;


    private Question [] myQuestionList = new Question[] {
            new Question(R.string.question_one, true),
            new Question(R.string.question_two, false),
            new Question(R.string.question_three,true),
            new Question(R.string.question_four, false),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mQuestionTextView = (TextView) findViewById(R.id.questions);
        int questionNo = myQuestionList[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionNo);

        mNextButton = (Button) findViewById(R.id.next_button);
        mPreButton = (Button) findViewById(R.id.prev_button);

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1 ) % myQuestionList.length;
                updateQuestion();

            }
        });





        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);

            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % myQuestionList.length;
                updateQuestion();

            }
        });

        mPreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mCurrentIndex != 0) {

                    mCurrentIndex = (mCurrentIndex - 1) % myQuestionList.length;
                    updateQuestion();

                }
            }
        });

    }




    private void updateQuestion(){
        int questionNo = myQuestionList[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(questionNo);

    }

    private void checkAnswer(boolean userChoseAnswer){
        boolean answerIsCorrect = myQuestionList[mCurrentIndex].isAnswerTrueOrFalse();

        int messageResId = 0;

        if(userChoseAnswer == answerIsCorrect){
            messageResId = R.string.toast_true;
        }else{
            messageResId = R.string.toast_false;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();

    }

}

```