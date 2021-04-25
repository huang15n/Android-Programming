
<h2> Laying out the UI</h2>
expand app/res/layout and double click activity_main.xml to open the file 

<em> the default activity layout defines two Views: a ConstraintLayout and a TextView </em>
Views are the building blocks you use to compose a UI. everything you see on the screen is a view. views that the user can see or interact with are called widgets. Some widgets show text. some widgets how graphics 

<em> every widget is an instance of the View class or one of its subclasses such as TextView or Button</em>
A ViewGRoup is a kind of View that contains and arranges other views. A ViewGRoup does not display content itself. rather, it orchestrates where other view's content is displayed. ViewGroups are often referred to as layouts 
In the default activity layout, ConstraintLayout is the ViewGRoup responsible for laying out its sole child, a TextView widet 



<em> your widges exist in a hierachy of View objects called the view hierachy</em>

the root element of this layout's view hierachy is a LinearLayout 
as the root element, the LinearLayout must specify the Android resource XML namespace 


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


<h2> Widget attributes </h2>

<h3> android:layout_width and android:layout_height </h3>


the anrdoid:layout_width and android:layout_height attribtues are required for almsot every type of widget 
they are typically set to either match_parent or wrap_content 
<ul>
<li>
match_parent view will be as big as its parent</li>

<li>
wrap_content view will be as big as its contents require</li>
</ul>



<h3> android:orientation  </h3>

the android:orientation attribute on the two LinearLayout widgets determines whether their children will appear vertically or horizontally. the root LinearLayout is vertical; it is child LinearLayout is horizontala
 the order in which children are defined determines the order in which they appear onscreen. 

In a vertical LinearLayout, the first child defined will appear topmost. In a horizontal LinearLayout, the first child defined with be leftmost 



<h3> android:text</h3>

the TextView and Button widgets have android:text attributes. this attribute tells the widgt when text to display 

<b>
notice that the values of these attribtues are not literal strings. they are ferences to string resources. as denoted by the @string/ syntax 
</b>

<i>
a string resource is a string that lives in a separate XML file called a string file. you can give a widget a hardcoded string, but it is usually not a good idea. placing strings into a separate file and then referencing them is better because it makes localization easy </i>





<h2> String sources </h2>

every project includes a default strings file named res/values/strings.xml 
open res/values/strings.xml 

the template already added one string resource for you . you will get the literal string at runtime 

depending on your vesion, you may have additional strings. do not delete them. deleting them could cause cascading errors in other files 

although the default strings file is named strings.xml, you can name a strings file anything you want 

you can also have multiple strings files in a project 
as long as the file is located in res/values/. has a resources root element, and contains child string elements, your strings will be found and used 



<h2>Layout XML to view objects </h2>


How do XML elements in activity_main.xml become View objects. the answer starts in MainActivity class 



the class file for MainActivity is the app/java directory of your project 




a quick aside about the directory name before we get into how layout become views: this directory is called java because Android originally supported only java code. 




the file has one Acitiy function, onCreate(Bundle?)

the onCreate(Bundle?) funciton is called when an instance of the activity subclass is created. when an activity is created, it needs a UI to manage. to give the activity its UI, you can call Activity.setContentView(layoutResID)

this function inflates a layout and puts its onscreen. 
when a layout is inflated, each widget in the layout file is instantiated as defined by its attributes. you specify which layout to inflate by passing in layout's resource ID 



<h2> Resources and resource IDs</h2>
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






<h2> wiring up widgets </h2>

<ol>
<li> Get references to the inflated View objects </li>
<li> set listeners on those objects to respond to user actions </li>
</ol>

you can access them in MainAcitivyt.. 

rather than return it as a View, it is cast to the expected subtype of View 


you use the resource IDs of your buttons to retrieve the inflated objects and assign them to your properties. 
since the view objects are not inflated into and available in memory until after setContentView() is called in onCreate() , you use lateinit on your property declarations to indicate the compiler that you will provide a non null view value before you attempt to use the contents of the properties 


<h5> press option-return or alt - enter to let the magic under the hood amaze you. the ne import statement now appears with the others at the top of the file </h5>







<h2> setting listeners </h2>

android apps are typically **event driven**   
unlike command line programs or scripts, event driven applications start and then wait for an event, such as the user presssing a button. events can also be initiated by the OS or another app, but user initiated events are the most obvious 

<i>when your app is waiting for a specific event, we say that is listening for that event. the obejct that you create to respond to an event is called a listener, and the listener implements a listener interface for that event </i>

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


<h2> using anonymous inner classes </h2>


this listener is implemnted as an anonymous innerclass.the syntax is a little tricky, but it helps to remeber that everything wihtin the outermost set of parentheses is passed into setOnClickListener(OnClickListener).within these parentheses, you carete a new , nameless class and pass its entire implementation 

<em>
all of the listeneres will be implemented as anonymous inner classes. doing so puts the implementations of the listener's methods right where you want to see them. and there is no need for the overhead of a named class because the class will be used in one place only </em>

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

<em>
A toast provides simple feedback about an operation in a small popup. It only fills the amount of space required for the message and the current activity remains visible and interactive. Toasts automatically disappear after a timeout.</em>

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


## Android Build Process 
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


as oart if the build process . app android asset packaging tools, compiled resources are packaged into .apk file 


then, when 





