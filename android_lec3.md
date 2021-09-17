\# GUI Widgets and Lists there is a whole bunch of widgets

1.  AnalogClock
2.  Button
3.  CheckBox
4.  DatePicker
5.  DigitalClock
6.  EditText
7.  Gallery
8.  ImageView/Button
9.  MapView
10. ProgressBar
11. RadioButton
12. Spinner
13. TextView
14. TimePicker
15. WebView

the idea here is not to cover it comprehensive, we have a taste and move, we do not cover stuff in exhaustive detail that can be unsatisfying sometimes it is really a good time to get cracking on that. sorry that is the last minute . we put up the options you can use a WebView and it pops up the link you can look at it but you are still in the app we will see a lot of apps using MapView ## Adding a widget to put a widget you must do two things

1.  declare/position it in your layout XML files that describing the layout of your activity
2.  add any event handling code to your code file

_technically you could write everything in java/Kotlin and set the size and the shape of the button_ could you think of a situation where you have to write code for buttons and stuff? in response to an event, we want a new widget. what if I make a widget hidden and appear on the other way. if you want to do something at runtime involving the widgets that is specific and rare and unexpected. if you want to display images of all users but you do not know how many useres there are until the moment, you cannot you will have to create them on the fly. but in general, this is what we are gonna follow, you declare the widget you set a lot of initial state in xml and you interact with it or handle events on it ## Button common attributes, you give a button it, pointed out there are multiple ways to talk to a widget, the code to understand that, it is also a concept called data binding or widget binding

|     |     |
| --- | --- |
| android:clickable="bool" | set to false to disable the button |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:onClick="function" | function to call in acitivty when clicked must be public, void and take a View arg |
| android:text="text" | text to put in the button |
| Button b = (Button)findViewById(R.id.id); |     |

  
\## TextView

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:text="string" | stext to display |
| TextView tv = (TextView)findViewById(R.id.id); tv.text = "text"; |     |

it is simple to find in google about the attributes, do not break out your mindset, there are way more properties that textview has than like two of these here. We do not memorize names of these things because I just rely on the editor to help me you can detach the edge to the ends if I stopping attaching the edge, it should pull me over there we are remarkably bad at attributes it all gets jumbled up in here, this is not the point to remember all these different names. not so much to do with text view because it only displays texts ## ScrollView if you want a set of text in it you want it to be taller than the screen or maybe it has more text that it can fit in its area there is a widget called scroll view it is a bit counter intuitive because you might have thought you may think of use boolean values but that is the the way they decided to build the reason they did not do it that way is because they make you wrap it up in a separate widget called a ScrollView that like contains it has scroll bar why does it make separation like that, because that group of four I want all of that to scroll _the general principle here is there is all kinds of different widget and I might want any of them to have scrolling, if I make it is implemented through boolean stuff here that probably means whoever implements this code library has to make this scrollable and so every single widget they have to write logic in there for scrolling where this implements scrolling once as like a container of scrolling and then even if they make your own widgets it will know how to scroll too because it is separated out this way_ ```xml < ``` in scrollview you will have to add a lot of different properties to it ## EditTExt _in the design mode, it does not say EditText, it only says PlainText, that is what you want the old way is you put a label there, but like new hotness is that you put the little label of what you want in the xml to type, that is called a hint in android_

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:hint="text" | gray placeholder text shown before user types |
| android:inputType="type" | what kind of input is being typed; number, phone, data, time. it helps to validate the data on the wide while they are typing, this makes sure that users only type the right thing there, it pops up the keyboard |
| android:lines="int" | number of visible lines / rows of input |
| android:maxLines="int" | max lines to allow users to type in the box |
| android:text="string" | initial text to put in box (default empty) |
| android:textSize="size" | size of font to use e.g. 20dp |
| EditText et = (EditText)findViewById(R.id.id); String text = et.text.toString(); |     |

```xml \> ``` you can set the textbox to have max number of lines. you will detect that with your keyboard listener. there is a lot variations based on what keys to the keyboard

### ImageView

_displays an image without being clickable_

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:src="@drawable/img" | image to put in the view must correspond to an image resource |
| android:contentDescription="string" | text to describe the image for blind users |
| android:tag="string" | a text tag to associate with the image |
| android:scaleType="type" | causes the image to grow/shrink; can be center, centerCrop, fitCenter, matrix |

\`\`\`java ImageView iv = (ImageView)findViewById(R.id.id); iv.setImageResource(R.drawable.filename); \`\`\` _I will walk you through the steps in a second, you have to get some images files to put them in your project. it is gonna make your way to be a bit difficult to find through them_ **there is folder called build, it means when you compile a project, it puts the output of binaries ,app is the actual code you write for you app, gradle is some sort of like makefile stuff note how to prepare and how to build how to compile an app**

### ImageButton

a clickable widget with an image label

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:clickable="bool" | set to false to disable the button |
| android:onClick="function" | function to call in activity when clicked , must be public, void, and take a View arg |
| android:src="@drawable/img" | image to put in the button(must correspond to an image resource) |

_to set up an image resource_

* put image file in project folder app/src/main/res/drawable(use app/src/main/res/drawable-xxhdpi if image is very large)
* use @drawable /foo to refer to foo.png
* use simplefile names with only letters and numbers

when you use the app, it sort of bundles up all the necessary files inside the app and so you do not have to worry about copying over these files. move other widgets out of the way and just here in the middle to set up a way to look at these _the moment when you drop it, it shows what image you want to display. you will have to them with alphabets!!!!! so it just pops up, you can lay out by attaching it to the other things on the screen_ ```xml ``` **baiscally just means you have got to give your files unique name prefixes for it to work properly** _there are some wired part of android where they changed the names of some of the properties, so they will be more compatible with different versions of android or whatever. when you refer to something in android with @ type and then alsh and then a name so like this identifier here is you are saying i want to refer to one of my drawable images whose name is xxx. we made this images in natural size_ If I set the width of the size of these images wrap parents and I go back to the editor, you can change how you want that to look. if I would like to allow this app to pick different turtles there is a lot of different ways you could do that now, 1 you can type a name 2 what are the other ways you can do that? do not give them options, pick one from them you won'get get overwhelmed, give you a constrainted, we should make it clear and represent them, we should not make them type

### CheckBox

an individual toggleable boolean on/off checkbox

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:clickable="bool" | set to false to disable the checkbox |
| android:checked="bool" | whether box is initally check default false |
| android:onClick="function" | function to call in activity when clicked , must be public, void, and take a View arg |
| android:text="text" | text to put next to the checkbox |

\`\`\`xml CheckBox cb = (CheckBox) FindViewById(R.id.id); cb.toggle(); cb.checked = true; cb.performClick(); \`\`\` _these are mutually exclusive you only want one on the sreen at a time, check boxes are not usually mutaully exclsuively,. this is when you put on your seitain stuff, for toppings , you check boxes as many as_

### Switch

an individual toggleable boolean on/off swtich

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:textOn="text" | text show next to on right side |
| android:textOff="text" | text show next to off left side |
| android:showText="bool" | whether to show text on L/R sides default false |
| android:onClick="function" | function to call in activity when clicked , must be public, void, and take a View arg |
| android:text="text" | text to put next to the checkbox |

\`\`\`xml Switch sw = findViewById(R.id.id); if(sw.checked){ .... } \`\`\` _it is using apps have these check box which have different looks to it_

### RadioButton

a toggleable on/off switch; part of a group

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:clickable="bool" | set to false to disable the checkbox |
| android:checked="bool" | whether box is initally check default false |
| android:onClick="function" | function to call in activity when clicked , must be public, void, and take a View arg |
| android:text="text" | text to put next to the checkbox |

**need to be nested inside a RadioGroup tag in XML so that only one can selected at a time** ```xml ``` you dock to him, it will not make the buttons to be mutually exclusive to each other, you can imagine the user interface where you have multiple different groups of radio buttons **you can drag and drop radio group, it is not really a widget, it is more of a container , you drag and drop radio buttons on the group** ```xml ``` you know how to like indenting them to indicate that they are inside a group there, only one of these should be clickable at a time **if you want it to scroll vertical, choose orientation, the radio does not a visual apperance to it** let's write a listener in the code, I will show you a style here yo ucan set the same onCLick for all four functions , I want to refer to which one is clicked on **basically I guess it does just based on** \`\`\`java public void radioButtonClicked(View view){ if (view == radioButton1){ } } \`\`\` **another way you can say this, that is like the way of saying the same thing** \`\`\`java public void radioButtonClicked(View view){ if (view.id == R.id.radioButton1){ } } \`\`\` if you want to set images to be displayed on the screen, you can do that , you would set the src for it. the value you pass it here is the id here \`\`\`java imageView.setImageResource(R.drawable.filename); \`\`\` **they check the integer for reference the way that you refer to them is you write R.resource.id . that is the way to make the same event handler run on all different radio buttons** \`\`\`java package com.example.example; import androidx.appcompat.app.AppCompatActivity; import android.os.Bundle; import android.view.View; import android.widget.ImageView; public class MainActivity extends AppCompatActivity { private ImageView iv; @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main); iv = (ImageView) findViewById(R.id.imageView); } public void radioButtonClick(View view){ if(view.getId() == R.id.one){ iv.setImageResource(R.drawable.one); }else if(view.getId() == R.id.two){ iv.setImageResource(R.drawable.two); }else if(view.getId() == R.id.three){ iv.setImageResource(R.drawable.three); }else if(view.getId() == R.id.four){ iv.setImageResource(R.drawable.four); } } } \`\`\` the xml is like the initial declared state of the app when it first loads up, but then all that state is subject to change, it loads up the xml and uses it in java ,all that is subject to change on the screen , they are up there now . maybe I misclicked something I am kinda going out of my way not to teach you every little feature of java, somtimes the editor tries to hint to you maybe there is a better way of writing the same statement. if all the branches are checking the same variabels value like that, you can use switch , it is the shorthand of saying the same thing . click the buble thing on android studio. it tries to remove the redundancy you know , it is dependent on what view I got clicked , editor is underlining your code \`\`\`java public void radioButtonClick(View view) { switch (view.getId()) { case R.id.one: iv.setImageResource(R.drawable.one); break; case R.id.two: iv.setImageResource(R.drawable.two); break; case R.id.three: iv.setImageResource(R.drawable.three); break; case R.id.four: iv.setImageResource(R.drawable.four); break; } } \`\`\` ## convering resources id if you have a resource name and want its ID : this.getResources().getIdentifier("nameOfDrawable", "drawable", this.getPackageName())

### ImageButton

_a clickable widget with an image label_

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:src="@drawable/img" | image to put in the button (must correspond to an image resource) |
| android:onCLick="function" | function to call in activity when clicked (must be public, void, and take a View arg) |

1 to set up an image resource: put image file in project folder app/src/main/res/drawable use app/src/main/res/drawable-xxhdip if image is very large use @drawable /foo to refer to foo.png use simple fine names with only letters and numbers _if you switch to image view and you tap on the image, it won't do anything. that is useful if want to make know more.._ \## ListView _a visible vertical meanu of selectable choices_ lists are more complicated , we separate it out

### ListView

_an ordered collection of selectable choices_

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:entries="@array/name" | set of options to appear in the list/ must match an array in strings.xml |
| android:clickable="bool" | set to false to disable clicking |

if you want to set the list , the people who made android development they hate you and so that, you have **set this thing called entries**

### Static list

1.  static list: you know ahead of time what the contents are, content is fixed and known before the apop runs . declare the list elements in the string.xml resource file
2.  dynamic list: you download from the internet, content is read or generated as the program runs. comes from a data file, or from the internet, etc. must be set in the java code . you display them or something like that

\## String resources **declare contant strings and arrays in res/values/string.xml :** ```xml value value value value value value ``` refer to them in java code: as a resource ID: R.string.name, R.array.name as a string or array: resources.getString(R.string.name), resources.getStringArray(R.array.name) this is really janky

1.  as a resource ID. R.string.name, R.array.name
2.  as a string or array : resource.getString(R.string.name);
3.  resources.getStringrray(R.array.name);

```xml Example Splinter Shredder Krang Bebop ``` that will update itself to show that, it is a bit dumb , another good thing about list is you can interact with it. there is a view called recyclerview that some apps want to use , there is a ton of these in the wild like most apps that shows lists of stuff are using this, this is crappier, come out and look up, this constantly fools me . you are paying attention you have learned some stuff about android already,

### list adapter

**adapter:helps turn list data into lsit view items** common adapters: 1 ArrayAdapter: items come from an array or list 2 CursorAdapter: items come from a database query syntax for creating an adapter _ArrayAdapter name = ArrayAdapter(activity,layout,array);_

* the activity is usually this
* the default layout for lists is android.R.layout.simple\_list\_item_1
* get the array/list by reading your file or data source of choice

attach it by setting adapter properly of ListView ## handling list events

1.  Lists do not use the onClick event
2.  event listenres must be attached in java, not XML
3.  you must use java annoymous inner class, lambda functions, a function with a name written inline between {} braces
4.  the lambda function will be called when events occur on the list

```java Button button = (Button)findViewById(R.id.myButton); button.setOnClickListener(new View.OnClickListener() { public void onClick(View v){ } }); ``` in java code, when the list is created, we refer to that list . I am writing a function, that function will notify that is the function I want to run. this anoymous function takes four parameteres . java is cynical ```java lv = (ListView) findViewById(R.id.listview); lv.setClickable(true); lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { @Override public void onItemClick(AdapterView parent, View view, int position, long id) { } }); @Override protected void onListItemClick(ListView l, View v, int position, long id) { Log.i("Hello!", "Clicked! YAY!"); } ``` ```java private ListView lv; @Override protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main); iv = (ImageView) findViewById(R.id.imageView); lv = (ListView) findViewById(R.id.listview); lv.setClickable(true); lv.setOnItemClickListener(new AdapterView.OnItemClickListener() { @Override public void onItemClick(AdapterView parent, View view, int position, long id) { Toast.makeText(MainActivity.this,"hello", Toast.LENGTH_SHORT).show(); } }); } ```

### Spinner

_a drop-down menu of selectable choices_

|     |     |
| --- | --- |
| android:id="@+id/id" | unique id for use in java/kotin code |
| android:entries="@array/name" | set of options to appear in the spinner/ must match an array in strings.xml |
| android:clickable="bool" | set to false to disable clicking |
| android:prompt="@string/text" | title text when dialog of choices pops up |

```java Spinner spin = (Spinner) findViewById(R.id.id); spin.setOnItemSelectedListener{ } ``` ```xml name ``` a lot of times you do not want to eat up a lot fo screen sapce so you can make it dropdown list ```xml ``` come up on sessions, it is a temporary holding spot