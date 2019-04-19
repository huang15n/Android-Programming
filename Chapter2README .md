# Android-Programming

## Android and Model-View-Controller

##### Creating a New Class. In the project tool window, right-click the com.bignerdranch.android.geoquiz package and select New → Java Class. 

Why is mTextResId an int and not a String? The mTextResId variable will hold the resource ID (always an int) of a string resource for the question. 


##### Generating getters and setters
Open Android Studio’s preferences (from the Android Studio menu on Mac and from File → Settings on Windows). Expand Editor and then expand Code Style. Select Java, then choose the Code Generation tab. In a moment, you will modify QuizActivity to work with Question.
##### command + N 


#### Model-View-Controller and Android

##### Android applications are designed around an architecture called Model-View-Controller, or MVC. In MVC, all objects in your application must be a model object, a view object, or a controller object.

##### • A model object holds the application’s data and “business logic.” Model classes are typically designed to model the things your app is concerned with, such as a user, a product in a store, a photo on a server, a television show – or a true-false question. Model objects have no knowledge of the UI; their sole purpose is holding and managing data.
##### In Android applications, model classes are generally custom classes you create. All of the model objects in your application compose its model layer.

##### • View objects know how to draw themselves on the screen and how to respond to user input, like touches. A simple rule of thumb is that if you can see it on screen, then it is a view.
##### Android provides a wealth of configurable view classes. You can also create custom view classes. An application’s view objects make up its view layer.


##### • Controller objects tie the view and model objects together. They contain “application logic.” Controllers are designed to respond to various events triggered by view objects and to manage the flow of data to and from model objects and the view layer.
##### In Android, a controller is typically a subclass of Activity, Fragment, or Service.



##### the flow of control between objects in response to a user event, like a press of a button. Notice that model and view objects do not talk to each other directly; controllers sit squarely in the middle of everything, receiving messages from some objects and dispatching instructions to others


##### Benefits of MVC
An application can accumulate features until it is too complicated to understand. Separating code into classes helps you design and understand the application as a whole; you can think in terms of classes instead of individual variables and methods.
##### Similarly, separating classes into model, view, and controller layers helps you design and understand an application; you can think in terms of layers instead of individual classes.
MVC also makes classes easier to reuse. A class with restricted responsibilities is more reusable than one with its fingers in every pie.

##### Updating the View Layer
Notice that you use the escape sequence \' in the last value to get an apostrophe in your string. You
can use all the usual escape sequences in your string resources, such as \n for a new line.


#### Updating the Controller Layer
Now that you have multiple questions to retrieve and display, Activity will have to work harder to tie the model and view layers together.
Open Activity.java. Add variables for the TextView and the new Button. Also, create an array of Question objects and an index for the array.

Now that you have the questions behaving appropriately, it is time to turn to the answers
### You must assign to the Widget class that you declared in the Controller Layer, otherwise the program get crashed 


##### Configuring your device for development
Developer options is not visible by default. To enable it, go to Settings → About Tablet/Phone and press Build Number seven times. Then you can return to Settings, see Developer options, and enable USB debugging.
The options vary considerably across devices. If you are having problems enabling your device


#### Adding an Icon
The suffixes on these directory names refer to the screen pixel density of a device:
mdpi medium-density screens (~160dpi)
hdpi high-density screens (~240dpi)
xhdpi extra-high-density screens (~320dpi) xxhdpi extra-extra-high-density screens (~480dpi)
(There are a few other density categories that are omitted from the solutions, including ldpi and xxxhdpi.)



When the app runs, the OS will choose the best image file for the specific device running the app. Note that by duplicating the images multiple times, you increase the size of your application. 


##### Adding resources to a project
Expand the contents of Application/app/src/main/res.

Including images in your app is as simple as that. Any .png, .jpg, or .gif file you add to a res/ drawable folder will be automatically assigned a resource ID. 


These resource IDs are not qualified by screen density, so you do not need to determine the device’s screen density at runtime. All you have to do is use this resource ID in your code. When the app runs, the OS will determine the appropriate image to display on that particular device.


##### Referencing resources in XML
retrace many of the steps


