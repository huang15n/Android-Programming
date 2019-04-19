# Android-Programming

## Introduction 

For teaching you the value of hard work, for inspiring and encouraging me to pursue a career in computing 
It was polished enough to be presentable and give us many invaluable suggestions and corrections, with such a talented and entertaining crew 
Sanding away the remaining rough edges of this 
You face a steep learning curve 
It helps to have a guide through unfamiliar territory 



## Prequisite 
When there are rough spots, or when some things are tricky or obscure, you will face them head on 
If the concepts do not ring a bell, you will be in the weeds.
We will provide some brief reminder about java specifics 

It is goal is to get you over the initial hump to where you can get the most out of the reference. Added on unit testing, accessibility, the MVVM architectural style, and localization. 
Going off the beaten path and finding your way will solidify your learning and give you confidence 
Typographical conventions for all widely used version . there is a small amount of market share on older versions .keep track of the latest one 


## Convention

There are two areas where our choices differ from what you might see elsewhere 
1 We use anonymous inner classes for listeners. This is mostly a matter of opinion. We find it makes for cleaner code in the app because it puts the listener’s method implementation right where you want to see them 
In high-performance contexts or large applications, anonymous inner classes may cause problems, but for most circumstances , they work fine 

2 Fragments , we use them for user interface. 
Fragments are not an absolutely necessary tool, but we find that, when used correctly, they are a valuable tool in any toolkit. 
They are not that difficult to work with. 
Fragments have clear advantages over activities that make them worth the effort, including flexibility in building and presenting your user interface 

Android studio is an integrated development environment used for it that is based off the popular tool is under active development 
The emulator is useful for testing apps. However, it is no substitute for an actual device when measuring performance 





### Part1 
#### 1 your first android app 
It is full of new concepts and moving parts required to build an app , the app tests the user;s knowledge of geography 




#### An activity is an instance of Activity, a class in the android SDK. An activity is responsible for managing user interaction with a screen of information You write subclass of Activity to implement the functionality that your app requires. A simple application may need only one subclass; a complex application can have many 


#### A layout defines a set of UI objects and their positions on the screen. A layout is made up of definition written in XML. Each definition is used to create an object that appears on screen. 




##### Notice that the package name uses a reverse DNS convention: the domain name of your organization is reversed and suffixed with further identifier. 
This convention keeps package names unique and distinguishes application from each other on a device 


The lefthand view is the project tool window , from here you can view and manage the files associated with your project 
The main view is the editor.
You can toggle the visibility of the various tool windows by clicking on their names in the strips of tool buttons 



##### The default activity layout defines two widgets: a RelativeLayout and a TextView. 

##### Widgets are the building blocks you use to compose a UI. A widget can show text or graphics, interact with the user, or arrange other widgets on the screen. Buttons, text input controls, and checkboxes are all types of widgets. 

##### The Android SDK includes many widgets that you can configure to get the appearance and behavior you want. Every widget is an instance of the View class or one of its subclasses (such as TextView or Button). However, do be careful. Layout XML is not validated, and typos will cause problems sooner or later. 

##### Every widget has a corresponding XML element, and the name of the element is the type of the widget. Each element has a set of XML attributes. Each attribute is an instruction about how the widget should be configured. To understand how the elements and attributes work, it helps to look at the layout from a hierarchical perspective.


##### The root element of this layout’s view hierarchy is a LinearLayout. As the root element, the LinearLayout must specify the Android resource XML namespace at http://schemas.android.com/ apk/res/android.
LinearLayout inherits from a subclass of View named ViewGroup. A ViewGroup is a widget that contains and arranges other widgets. You use a LinearLayout when you want widgets arranged in a single column or row. Other ViewGroup subclasses are FrameLayout, TableLayout, and RelativeLayout.
When a widget is contained by a ViewGroup, that widget is said to be a child of the ViewGroup. The root LinearLayout has two children: a TextView and another LinearLayout. The child LinearLayout has two Button children of its own.


###### android:layout_width and android:layout_height 
The android:layout_width and android:layout_height attributes are required for almost every type of widget. They are typically set to either match_parent or wrap_content: 
match_parent view will be as big as its parent 
wrap_content view will be as big as its contents require



##### For the root LinearLayout, the value of both the height and width attributes is match_parent. The LinearLayout is the root element, but it still has a parent – the view that Android provides for your app’s view hierarchy to live in. 




##### android:orientation 
The android:orientation attribute on the two LinearLayout widgets determines whether their children will appear vertically or horizontally. The root LinearLayout is vertical; its child LinearLayout is horizontal. 
The order in which children are defined determines the order in which they appear on screen. In a vertical LinearLayout, the first child defined will appear topmost. In a horizontal LinearLayout, the first child defined will be leftmost. (Unless the device is set to a language that runs right to left, such as Arabic or Hebrew. In that case, the first child will be rightmost.) 



##### android:text 
The TextView and Button widgets have android:text attributes. This attribute tells the widget what text to display. 
Notice that the values of these attributes are not literal strings. They are references to string resources. 
A string resource is a string that lives in a separate XML file called a strings file. You can give a widget a hardcoded string, like android:text="True", but it is usually not a good idea. Placing strings into a separate file and then referencing them is better because it makes localization easy. 

##### Creating string resources 
Every project includes a default strings file named strings.xml.
Open res/values/strings.xml. The template has already added one string resource for you. Add the 
three new strings that your layout requires. Although the default strings file is named strings.xml, you can name a strings file anything you want. You can also have multiple strings files in a project. As long as the file is located in res/values/, has a resources root element, and contains child string elements, your strings will be found and used 


##### From Layout XML to View Objects

When you created the a project, a subclass of Activity named ativity was created for you. The class file for is in the app/java directory of your project. The java directory is where the Java code for your project lives.
In the project tool window, reveal the contents of the app/java directory and then the contents of the com.bignerdranch.android.geoquiz package
It is a subclass of Android’s Activity class that provides compatibility support for older versions of Android.

##### If you are not seeing all of the import statements, click the symbol to the left of the first import statement to reveal the others. 
##### This file has one Activity method: onCreate(Bundle).
(If your file has onCreateOptionsMenu(Menu) and onOptionsItemSelected(MenuItem) methods,
ignore them for now. You will return to menus in detail in Chapter 13.)
The onCreate(Bundle) method is called when an instance of the activity subclass is created. When an activity is created, it needs a UI to manage. To get the activity its UI, you call the following Activity method:
    public void setContentView(int layoutResID)
This method inflates a layout and puts it on screen. When a layout is inflated, each widget in the layout file is instantiated as defined by its attributes. You specify which layout to inflate by passing in the layout’s resource ID.


##### Resources and resource IDs
##### A layout is a resource. A resource is a piece of your application that is not code – things like image files, audio files, and XML files.

##### Resources for your project live in a subdirectory of the app/res directory. In the project tool window, you can see that activity_quiz.xml lives in res/layout/. Your strings file, which contains string resources, lives in res/values/.
To access a resource in code, you use its resource ID. The resource ID for your layout is R.layout.activity_name.
Locate the dropdown at the top of the project tool window and change from the Android view to the Project view. The Project view will show you the files and folders in your project as they actually are
To see the resources for it, reveal the contents of the app/build/generated/source/r/debug directory.
In this directory, find your project’s package name and open R.java within that package. Because this file is generated by the Android build process, you should not change it, as you are subtly warned at the top of the file.


After making a change to your resources, you may not see this file instantly update. Android Studio maintains a hidden R.java that your code builds against. The R.java file is the one that is generated for your app just before it is installed on a device or emulator. You will see this file update when you run your app.



Your strings also have resource IDs. You have not yet referred to a string in code, but if you did, it would look like this:
    setTitle(R.string.app_name);

Android generated a resource ID for the entire layout and for each string, but it did not generate IDs for the individual widgets in activity_name.xml. Not every widget needs a resource ID.
Before generating the resource IDs, switch back to the Android project view. Throughout this book, the Android project view will be used – but feel free to use the Project version if you prefer.
To generate a resource ID for a widget, you include an android:id attribute in the widget’s definition. In activity_name.xml, add an android:id attribute to each button.



##### Notice that there is a + sign in the values for android:id but not in the values for android:text. This is because you are creating the IDs and only referencing the strings.


#### Wiring Up Widgets
#### Now mouse over the red error indicators. They report the same problem: Cannot resolve symbol 'Button'. You will fix the errors in just a second. First, notice the m prefix on the two member (instance) variable names. This prefix is an Android naming convention that we will follow throughout
You could type the following import statement at the top of the file: import android.widget.Button;
Or you can do it the easy way and let Android Studio do it for you. Just press Option+Return (or Alt +Enter) to let the IntelliJ magic under the hood amaze you. The new import statement now appears with the others at the top of the file. This shortcut is generally useful when something is not correct with your code. 

##### This should get rid of the errors. (If you still have errors, check for typos in your code and XML.) Now you can wire up your button widgets. This is a two-step process:
• get references to the inflated View objects
• set listeners on those objects to respond to user actions

##### Getting references to widgets
In an activity, you can get a reference to an inflated widget by calling the following Activity method: public View findViewById(int id)
This method accepts a resource ID of a widget and returns a View object.
In NameActivity.java, use the resource IDs of your buttons to retrieve the inflated objects and assign them to your member variables. Note that you must cast the returned View to Button before assigning it.




##### Setting listeners. Android applications are typically event driven. Unlike command-line programs or scripts, event- driven applications start and then wait for an event, such as the user pressing a button. (Events can also be initiated by the OS or another application, but user-initiated events are the most obvious.)
##### When your application is waiting for a specific event, we say that it is “listening for” that event. The object that you create to respond to an event is called a listener, and the listener implements a listener interface for that event.
##### The Android SDK comes with listener interfaces for various events, so you do not have to write your own. In this case, the event you want to listen for is a button being pressed (or “clicked”), so your listener will implement the View.OnClickListener interface.

(If you have a View cannot be resolved to a type error, try using Option+Return (Alt+Enter) to import the View class.)
you set a listener to inform you when the Button known as mTrueButton has been pressed. The setOnClickListener(OnClickListener) method takes a listener as its argument. In particular, it takes an object that implements OnClickListener.

##### Using anonymous inner classes
This listener is implemented as an anonymous inner class. The syntax is a little tricky, but it helps to remember that everything within the outermost set of parentheses is passed into setOnClickListener(OnClickListener). Within these parentheses, you create a new, nameless class and pass its entire implementation.


#### All of the listeners will be implemented as anonymous inner classes. Doing so puts the implementations of the listeners’ methods right where you want to see them. And there is no need for the overhead of a named class because the class will be used in one place only.

Because your anonymous class implements OnClickListener, it must implement that interface’s sole method, onClick(View). You have left the implementation of onClick(View) empty for now, and the compiler is OK with that. A listener interface requires you to implement onClick(View), but it makes no rules about how you implement it.
(If your knowledge of anonymous inner classes, listeners, or interfaces is rusty, you may want to review some Java before continuing or at least keep a reference nearby.)



##### Making Toasts
Now to make the buttons fully armed and operational. You are going to have a press of each button trigger a pop-up message called a toast. A toast is a short message that informs the user of something but does not require any input or action. You are going to make toasts that announce whether the user answered correctly or incorrectly

###### To create a toast, you call the following method from the Toast class:
public static Toast makeText(Context context, int resId, int duration)


The Context parameter is typically an instance of Activity (Activity is a subclass of Context). The second parameter is the resource ID of the string that the toast should display. The Context is needed by the Toast class to be able to find and use the string’s resource ID. The third parameter is one of two Toast constants that specify how long the toast should be visible.
After you have created a toast, you call Toast.show() on it to get it on screen.

Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_LONG).show();


 you are going to call makeText(...) in each button’s listener. Instead of typing
everything in, try using Android Studio’s code completion feature to add these calls.




##### Using code completion
When you get to the period after the Toast class,
a pop-up window will appear with a list of suggested methods and constants from the Toast class.
To choose one of the suggestions, use the up and down arrow keys to select it. (If you wanted to ignore code completion, you could just keep typing. It will not complete anything for you if you do not press the Tab key, press the Return key, or click on the pop-up window.)


In makeText(...), you pass the instance of QuizActivity as the Context argument. However, you cannot simply pass the variable this as you might expect. At this point in the code, you are defining the anonymous class where this refers to the View.OnClickListener.
Because you used code completion, you do not have to do anything to import the Toast class. When you accept a code completion suggestion, the necessary classes are imported automatically.



##### For the More Curious: Android Build Process
By now, you probably have some burning questions about how the Android build process works.
You have already seen that Android Studio builds your project automatically as you modify it rather than on command.

How do the contents of activity.xml turn into View objects in an application? As part of the build process, aapt (Android Asset Packaging Tool) compiles layout file resources into a more compact format. These compiled resources are packaged into the .apk file. Then, when setContentView(...) is called in the QuizActivity’s onCreate(Bundle) method, the QuizActivity uses the LayoutInflater class to instantiate each of the View objects as defined in the layout file

You can also create your view classes programmatically in the activity instead of defining them in XML. But there are benefits to separating your presentation from the logic of the application. The main one is taking advantage of configuration changes built into the SDK


To protect the integrity of your current project, we recommend you make a copy and work on challenges in the new copy.
