

the definite answer is this will suit most people, work on exercises. show of hands. run into issues along the way. Know that off the top of your head and work in pairs 


<h1> Rewivew </h1>
the whole screen is called activity 

the UI elements are called widgets or called views. positioning or sizing things 

clicking buttons is an event, so we made a function to handle it. onClick attribute here and you choose the function. 


you refer to the widgets by R.id.  and it will return you a variable that you can use to represent that widget. It deduces as an int. It is taking away points 

```java
findViewById<TextView>(R.id.element).setText = "";
```
this refers to this view and then immediately set dot something. I mushed it together it is totally up to you 


something out of our code called onCreate to create it so we cannot make it private. Somehow wiring things together between layout and the wedget doodled on the screen mostly working 


<h2> Toast </h2>
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


<h2> Sizing and positioning</h2>

how does the prorgammer specify where each component appears, how big each component should be , etc 
<ul>
 
**Absolute positioning  (C,C#)**
<ul> 
<li> programmer specifies exact pixel coordinates of every component</li>
<li> put this button at xx and make it xx px in size, it does not generalize well </li>


</ul>
 
 



**Layout manager (java, Android, Kotlin)**
<ul> 
<li> Objects that decide where to position each component based on some general roles or criteria. Abstract layout system</li>
<li> put these buttons into a xxx by xx grid and put these textboxes in a horizontal flow in the south part of the app, like aligment and strethching or not stretching or things </li>
<li> more flexible and general with a variety of devices and intuitive </li>
</ul>

</li>


</li>
</ul>


<h2> ViewGroup as layout</h2>

ViewGroup superclass represents containers of views. 

<ul>

**ViewGroup superclass repressents containers of views**


<li>
layouts are described in XML and mirrored in java code 
</li>
<li>android provides serveral pre-exisiting layout managers; you can define your own custom layouts if needed</li>
<li>layouts can be nested to achieve cmobination of features </li>




</ul>



<ul> 

**in the java code and xml** 

<li>an Activity is a ViewGroup</li>
<li>various layout classes are also ViewGroups</li>
<li>Widgets can be added to a ViewGroup , which will then manage that widget's position/size behaviour</li>

</ul>



<h2> XML, in breift </h2>
XML: a language for describing hierarchical text data. a data markup language
<ol>
<li>uses tags that consists of elements and attributes. tags can be nested</li>

<li> some tags are opened and closed; others self-closed</li>
</ol>

```xml
<elment attr="value" attr="value"> <element>

<elment attr="value" attr="value" /> 
```



<h2> changing layout</h2>
go to the Text view for your layout xml file 
change open/close tags to new layout type. LinearLayout 
now go back to Design view and add widgets 


there are different strategies to do layouts 



<h1> LinearLayout</h1>
lays out widgets/views in a single line 
orientation of horizontal or vertical 
items do not wrap if they reach edge of screen 

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


<h2> Gravity</h2>
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


<h2> Weight </h2>
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


<h2> Widget Box Model </h2>
<ul>
<li>
content: size of widget itself </li>
<li>
padding : artificial increase to widget size outside of contente </li>
<li>
border: outside padding, a line around edge of widget </li>
<li>
margin: invisible separation from neighbouring widgets 
</li>
</ul>


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



<h2> Sizing an individual widget</h2>

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




<h2> padding </h2>
padding: extra space inside 
set padding to adjust all sides; 
paddingTop, Bottom, Left, Right for one side 
usually set to specific values like dp, some widgets have a default value 16dp 

<h2> margin </h2>
margin: extra blank space outside widget 
set layout_margin to adjust all sides 
layout_marginTop, Bottom, Left, Right 
usually set to specific values like dp set dfeaults in res/values/dimens.xml 


<h2> GridLayout </h2>
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


<h2> TableLayout</h2>
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




<h2> Nested Layout </h2>

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

<h2> ConstraintLayout </h2>
default layout; tightly integrated with android studio visual designer 
widget's corners are connected to other widgets or screen edges 

every view must have at least two constraints : one horizontal and one vertical 

stretchy, springy. Android felt like the editor was clunky and part of the reason the layout did not every well match the dragging and dropping that the person was doing 

it is the mostly officially recommended layout nowadays 



<h2> ConstraintLayout anchor points</h2>
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













































