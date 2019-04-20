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

#####  View hierarchy. Your widgets exist in a hierarchy of View objects called the view hierarchy. 
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
###### You can give a widget a hardcoded string, like android:text="True", but it is usually not a good idea. Placing strings into a separate file and then referencing them is better because it makes localization easy.






