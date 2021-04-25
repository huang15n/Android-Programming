

<h1> GUI Widgets and Lists </h1>








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


the idea here is not to cover it comprehensive, we have a taste and move, we do not cover stuff in exhaustive detail that can be unsatisfying sometimes

it is really a good time to get cracking on that. sorry that is the last minute . we put up the options 

you can use a WebView and it pops up the link you can look at it but you are still in the app 


we will see a lot of apps using MapView 



<h2> Adding a widget </h2>
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



<h2> Button </h2>

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






<h2>TextView</h2>
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





<h2>ScrollView</h2>
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










<h2>EditTExt</h2>
<table>



<tr> 
<td>android:id="@+id/id"</td><td>unique id for use in java/kotin code</td>
</tr>


<tr> 
<td>android:hint="text"</td><td>gray placeholder text shown before user types</td>
</tr>


<tr> 
<td>android:inputType="type"</td><td>what kind of input is being typed; number, phone, data, time </td>
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



















































