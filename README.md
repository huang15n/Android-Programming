# Android-Programming


## Introduction 
there are some rough spots, a steep learning curve, you will be in weed, a little rusty getting your head around. This requires leanring new ideas and techniques, have a guide through unfamiliar territory lead you through several applications 
learn into pratices right away, ring a bell, brief reminderes 


this repository is to get you over the initial hump to where you can get the most out of the reference and recipe 

going off the beaten path and finding your way will soify your learning and give you confidence with your projects 
differ from what you might see elsewhere with typographical conventions for widely used versions 
revisiting these ideas in greater detail as you proceed through the course of development 


## 1 First Android Application 

### Basic Concepts: 
##### an activity is an instance of Activity, a class in the Android SDK, an activity is responsible for managing user interaction with a screen of information 
##### You write subclasses of Activity to implement the functionality that your app requires. A simple application may need only one subclass; a complex application can have many.


##### A layout defines a set of UI objects and their positions on the screen. A layout is made up of definitions written in XML. Each definition is used to create an object that appears on screen, like a button or some text.

Open app/res/layout/activity_quiz.xml. Currently, activity_quiz.xml defines the default activity layout.
The default activity layout defines two widgets: a RelativeLayout and a TextView.

##### Widgets are the building blocks you use to compose a UI. A widget can show text or graphics, interact with the user, or arrange other widgets on the screen. Buttons, text input controls, and checkboxes are all types of widgets.
The Android SDK includes many widgets that you can configure to get the appearance and behavior you want. 

##### activity_quiz.xml, View hierarchy. Your widgets exist in a hierarchy of View objects called the view hierarchy. 
#####  The root element of this layout’s view hierarchy is a LinearLayout. As the root element, the LinearLayout must specify the Android resource XML namespace at http://schemas.android.com/ apk/res/android. LinearLayout inherits from a subclass of View named ViewGroup. A ViewGroup is a widget that contains and arranges other widgets. You use a LinearLayout when you want widgets arranged in a single column or row. Other ViewGroup subclasses are FrameLayout, TableLayout, and RelativeLayout.

#####  When a widget is contained by a ViewGroup, that widget is said to be a child of the ViewGroup. The root LinearLayout has two children: a TextView and another LinearLayout. The child LinearLayout has two Button children of its own.


### Widget attributes
### android:layout_width and android:layout_height
The android:layout_width and android:layout_height attributes are required for almost every type of widget. They are typically set to either match_parent or wrap_content:
#####  match_parent view will be as big as its parent
##### wrap_content view will be as big as its contents require
For the root LinearLayout, the value of both the height and width attributes is match_parent. The LinearLayout is the root element, but it still has a parent – the view that Android provides for your app’s view hierarchy to live in.





### android:orientation
##### The android:orientation attribute on the two LinearLayout widgets determines whether their children will appear vertically or horizontally. The root LinearLayout is vertical; its child LinearLayout is horizontal.
###### The order in which children are defined determines the order in which they appear on screen. In a vertical LinearLayout, the first child defined will appear topmost. In a horizontal LinearLayout, the first child defined will be leftmost. (Unless the device is set to a language that runs right to left, such as Arabic or Hebrew. In that case, the first child will be rightmost.)


### android:text
##### The TextView and Button widgets have android:text attributes. This attribute tells the widget what text to display.
Notice that the values of these attributes are not literal strings. They are references to string resources.
A string resource is a string that lives in a separate XML file called a strings file. 
###### You can give a widget a hardcoded string,  Placing strings into a separate file and then referencing them is better because it makes localization easy.
##### Every project includes a default strings file named strings.xml
<resources>
    <string name="app_name">QuizGame</string>
    <string name ="question_text1"> This is a greater from my side </string>
    <string name ="true_button"> True </string>
    <string name = "false_button"> False </string>
</resources>

###### Although the default strings file is named strings.xml, you can name a strings file anything you want. You can also have multiple strings files in a project. As long as the file is located in res/values/, has a resources root element, and contains child string elements, your strings will be found and used.


'<'?xml version="1.0" encoding="utf-8"?'>'
'<'LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"'>'

    '<'TextView
       android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:padding="24dp"
        android:text="@string/app_name"
        /'>'

    '<'LinearLayout
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"'>'
        '<'Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" 
            android:text="@string/true_button"/'>'
        '<'Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" 
            android:text="@string/false_button"/'>'
        



    '<'/LinearLayout'>'


'<'/LinearLayout'>'


When you created a project, a subclass of Activity was created for you. The class file for that activity is in the app/java directory of your project. The java directory is where the Java code for your project lives. reveal the contents of the app/java directory and then the contents of the com.bignerdranch.android.xxxx package. Open the XXXActivity.java file and take a look at its contents.
(Wondering what AppCompatActivity is? It is a subclass of Android’s Activity class that provides compatibility support for older versions of Android.) 





### Resources and resource IDs
##### A layout is a resource. A resource is a piece of your application that is not code – things like image files, audio files, and XML files.
Resources for your project live in a subdirectory of the app/res directory. In the project tool window, you can see that activity_quiz.xml lives in res/layout/. Your strings file, which contains string resources, lives in res/values/.
To access a resource in code, you use its resource ID. The resource ID for your layout is R.layout.activity_something
reveal the contents of the app/build/generated/source/r/debug directory. In this directory, find your project’s package name and open R.java within that package. Because this file is generated by the Android build process, you should not change it, as you are subtly warned at the top of the file.
After making a change to your resources, you may not see this file instantly update. Android Studio maintains a hidden R.java that your code builds against. 


Android generated a resource ID for the entire layout and for each string, but it did not generate IDs for the individual widgets in activity_quiz.xml. Not every widget needs a resource ID. 


#### Notice that there is a + sign in the values for android:id but not in the values for android:text. This is because you are creating the IDs and only referencing the strings.

### Wiring Up Widgets

Just press Option+Return (or Alt +Enter) to let the IntelliJ magic under the hood amaze you.  
The new import statement now appears with the others at the top of the file. This shortcut is generally useful when something is not correct with your code. 
First, notice the m prefix on the two member (instance) variable
names. This prefix is an Android naming convention 

Now you can wire up your button widgets. This is a two-step process:
• get references to the inflated View objects
• set listeners on those objects to respond to user actions


The onCreate(Bundle) method is called when an instance of the activity subclass is created. When an activity is created, it needs a UI to manage. To get the activity its UI, you call the following Activity method:
    public void setContentView(int layoutResID)
This method inflates a layout and puts it on screen. When a layout is inflated, each widget in the layout file is instantiated as defined by its attributes. You specify which layout to inflate by passing in the layout’s resource ID.



