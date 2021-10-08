# Multiple Activities and Intents




we are getting the rooms settled and just be mindful about that. we want to talk about bigger apps have more than one activity and you want to jump around between two. 


we got the app in a point where you can read file and you can pick a random defition and it would show them.you want to have a add new word button 


## cheat sheat 

```java 
// main activity:

 private final static int STUPID_CODE= 123;

  public void addWordFunction(View view) {
        Intent myIntent = new Intent(this, add_word.class);
        startActivityForResult(myIntent, STUPID_CODE);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == STUPID_CODE){
            String word = data.getStringExtra("word");
            String definition = data.getStringExtra("definition");
            mHashMap.put(word,definition);
            keys.add(word);
            defs.add(definition);
            adapter.notifyDataSetChanged();
        }
    }


// the other activity
        Intent myIntent = new Intent();
        myIntent.putExtra("word",wordVariable);
        myIntent.putExtra("definition",definitionVariable);
        setResult(RESULT_OK, myIntent);
        finish();


```


## Multiple activities 
1. many apps have multiple activities 
example: address book apps, main activity = contact list; clicking a contact goes to another activity for viewing details 
2. activity A can launch Activity B in response to an event
data params can be passed and "returned" between them 

Activity A      -> Activity B 
Item list           Item Details 


the main activity has a list of thigns that you can click on them, if you open up an email, it shows you the message itself and the text file of that messages 
you can imagine when you tap on a list like the list and then we make two activities for that layouts, and interact with each other 

sometimes we have an event in activity A and you click on something or whatever, and then in response to that event you kotlin code says you want to jump to that activity 





## Adding an activity 
in android studio, right click "app" at left : New -> Activity (empty) 
1. create a new .xml file in res/layouts 
2. create a new .java or .kt class in src/java 
3. adds information to AndroidManifest.xml about the activity without this information, the app will not allow the activity 




btw I want to mention over you might have noticed there are a thing called android test ~/AndroidStudioProjects/XXX/app/src/test/java. every project when you first create it, it has kinda made these folders for testing and that is literally like if you want to write testing code like unit test try to test pass in parameters and see if it behaves properly 

this is like automated tests for your app. I do not see why it goes to toruble of making all these files, I have nothing against testing. They try to encourage you to test it because it is a good practice but you get confused what are the files here, but you do not have my permission to delete this or it goes away. but you have to delete them twice they sorta come back in a zombie form 


if you create the activity, it sets up the xml here and you can kind of edit the layout for this thing. what I am picturing is you will go to the main app playing and then maybe down here there is a button says add word, you click it and it jumps to other activity, and the other activity says what is the word that you are adding and what is the defintion, you type those in and then you say and it goes back to the main game 


```shell
~/AndroidStudioProjects/DictionaryApp/app$ ls src/main/java/com/example/dictionaryapp/
add_word.java  FirstFragment.java  MainActivity.java  SecondFragment.java


ls src/main/res/layout/
activity_add_word.xml  activity_main.xml  content_add_word.xml  fragment_first.xml  fragment_second.xml


```


get these attached, we do a EditText to type in, and it has a hint on it, let's attach them and it fills the frame and lets attach this to the bottom here. let's give alignment and attach the layout properly. we also want some ok buttons when we are done 

basically you set all that up you get it looking the way you want. it is I am only making it worse, help. I hae not quite set enough properties here, what is missing? 


```xml
<!-- this is the main activity -->
<?xml version="1.0" encoding="utf-8"?>
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:rowCount="4"
    android:columnCount="1"
    android:layout_gravity="center">

    <TextView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Vocabulary Builder"
        android:textSize="30sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.115"
        android:layout_marginLeft="70dp"/>

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="56dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
       android:id="@+id/word"
        android:text="words"
        android:layout_marginLeft="150dp"/>

    <ListView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        tools:layout_editor_absoluteX="110dp"
        tools:layout_editor_absoluteY="362dp"
        android:id="@+id/listview"/>

    <Button
        android:layout_height="100px"
        android:layout_width="500px"
        android:text="Add Word"
        android:id="@+id/add_word">

    </Button>


</GridLayout>

```


```xml
<!-- this is the new activity we added -->
<?xml version="1.0" encoding="utf-8"?>
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".add_word"

    android:rowCount="5"
    android:orientation="vertical">


    <include layout="@layout/content_add_word" />

    <TextView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="please enter a new word to add"
        android:layout_gravity="center"/>

    <EditText
        android:id="@+id/wordEditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="please enter  word to add"
        android:layout_gravity="center"/>

    <EditText
        android:id="@+id/definitionEditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="please enter defintion to add"
        android:layout_gravity="center"/>


    <Button
        android:id="@+id/addButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Add"
        android:layout_gravity="center"/>








</GridLayout>

```


I feel good about myself add a new word and then. When I hit this button, it will open up second activity that we are starting create 

we got glue pieces together 




## Activities in Manifest 

every activity has an entry in project's AndroidManifest.xml added automatically by android studio 



```xml
<manifest>
<application> 
<activity android:name=".MainActivity"
android:label="@string/app_name">
....
</activity>
<activity android:name=".SecondActivity"
android:label="@string/title_activity_second">
....
</activity>
</application>
</manifest>

```

just you know you do not have to do this, when you add an activity to your project, there is a file that is the part of your project that is called a manifest file and it kinda describes some attributes about that project 
it tells the the name of your project and it has a list of every activity that is the part of that project, when you add an actvity to your android studio, it updates this file to the list of activity that you have added 
the reason I am telling you about this. in theory you do not need to know this file at all because you do not have to do anything here. but the reason I am telling you is when you download some jpg files off the internent and then ou put them in your project in your folder, when you launch your app, you would not recognize those activities you would not be able to run them or see them or whatever because they would not be listed in here so the app is super strict only lets you use activities that are listed in the manifest 

why do you think android is so picky about that and does not just let random activities in the folder and run themselves as the part of their activity? any guesses? 
you can incorporate or adjust them or change stuff about the files maybe there is a security concern. those are good points, the primary motivator is security aspects, there is a danger where if you have an app you trust, a banking app, you sort of trusting that whoever wrote the code for that good code won't hack or steal your personal information or whatever. if someone maliciously insert another piece of code and another activity 
that was not supposed to be there and it would trick you into clicking on it or something like that 

 
/app/src/main/AndroidManifest.xml 

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.example.dictionaryapp">

    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.DictionaryApp">
        <activity
            android:name=".add_word"
            android:label="@string/title_activity_add_word"
            android:theme="@style/Theme.DictionaryApp.NoActionBar"></activity>
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

```

.Main activity is here you should start with and then the other activities we include in our project 


## Intents 

*intents*: an object representing a desired action: 
1. used as a bridge between activities, for one to invoke another
2. the activity can be in the same app or in a different app
3. can store extra data to pass parameters to that activity 
4. second activity can return information abck to the caller if needed 
_______________________________


android application(main activity) = intent => another activity => intent => another activity => android app(main activity) 
______________________________




if you want to have multiple activities and you want one of them to launch another one the mechanism for doing that is called intent 

intent is an object that you can create and it represents your intention to perform an action. it is a little confusing concept, this is like an object you can use whenever your activity wants to fire up some other things and that other thing could be another activity and it can also be used when you want to launch certain system services when you want to initiate the phone dialer or sending a text message or launching the browser you can access various system services using these intents. for how dumb this is an intense thing. lol. that is appropriate amount of launghter 

the short answer is you create an intent object optionally you can then insert some info into the intent which would be parameters if activity a is going to launch activity b, you may want to send info over to b about what it should do and that information can be bundled inside of the intent and send along that information, i will show you how it works 


## uses of intent 
1. to start an activity from another activity in the same app 
e.g. Activity1 launches Activity2 

2. to start a service 
seen later, a service is a long running app with no GUI 
system services include camera, phone dialer, music player 
it runs in the background, whatapps, you can still receive notifications and messages. these sits idle without a user interface but still running code for messages  


3. to broadcast a message to another app or service 
other apps can listen and respond to messages 

4. types of intents 
explicit: names a particular activity to launch (run Activity2)
implicit: descirbes task to perform; one of many apps could potentially handle it. launch web browser 

the strenght of it i do like about if anything is that once you learn how it works you can use it to do a lot of different stuff 


## Creating an intent 
1. to launch another activity (usually in response to an event), create an Intent object and call StartActivity with it 

```java
Intent myIntent = new Intent(this(getApplicationContext()), ActivityName.class)
myIntent.putExtra("Value1", "This value one for ActivityTwo ");
myIntent.putExtra("Value2", "This value two ActivityTwo");
startActivity(intent);

```

2. if you need pass any parameters or data to the second activity, call putExtra on the intent 


if you have trouble reading some of this code sometimes, now I am constructing object like basically after that equal sign. there is like i am creating an object of type intent i am storing it a variable. you pass parameters you pass like your activity as the first parameter, the second parameter is the name of the other activity you want to start to start up 
but you do not just write this name activity you write the name of the activity followed by ActivityName.java in kotlin it is Activity::class.java 

startActivity(myIntent) is actually a method inside an activity class. you will automatically jump you to the other activity 

this looks like a hashmap that maps from keys to values so you can store some arbitrary number of key value pairs inside that intent before you launch the other activity 
let's play with this a little bit 

```xml

    <Button
        android:layout_height="100px"
        android:layout_width="500px"
        android:text="Add Word"
        android:onClick="addWordFunction"
        android:id="@+id/add_word">

    </Button>

```

```java

 Intent myIntent = new Intent(this,  add_word.class);
        startActivity(myIntent);

```

what a mess, that is pretty reprehensible 

or you can do this in one line, I do not personally like that:


```java 
   public void addWordFunction(View view) {
        Intent myIntent = new Intent(this,  add_word.class);
        startActivity(myIntent);

    }

```
is there a reason why we would use anothre package context other than this? it is hinting the name of the parameter passing to me. if you have a piece of code that is not your activity that launches an activity. maybe you have a helper class that helps you to write this code and that helper wants to launch an activity, you would not have a helper says this because the person you pass there has to be like an activity object so that helper class would need to have a reference to the actitity to that method they would have to pass that, it is in a different context when you do pass this 



```java 
   public void addWordFunction(View view) {
        
        startActivity(new Intent(this,  add_word.class));

    }

```

lets go and try it out see if it works in the emulator 

I get a few minutes get a few gals I do not think that is cool

it is important to understand kind of the context what is going on here
you get a bunch of apps running but one of them is active a time and when a given you are running, you always looking at a given activity within that app 

you cannot have an activity that takes up half othe screen and then some other activity 
you always in an activity that like fills your screen but even though i am in this activity the other one is like underneath it 


an activity could be in different states like active on screen, it could be pause, it can be stopped, it can be running and it could be doing all these different things. the other things underneath there is just waiting and actually there is like a back buttun usually on most phones or most devices.

 there is a button in android (<| triangle) where it can take back to the activity where you can come. so technically there is something called activity stack, activity a launches activity b and activity b launches activity c and then you have a cba like a stack 

so typically that cloess or pops off the stack and you go back to b where you came from and stuff like that, you can customize that maybe you go a goes to b goes to c and c jumps all the way back to a like you could do stuff like that . just the default is you sort of pop off one level at a time when it is done 



there are a few pieces of plumbing here, lets talk about some of kind of actually get it to work 
at this point a lot of what is left to do is stuff we have done before 

let's talk about of some actually get it to work now once we click that we start a new activity the activity launches and layout this widgets on the screen and then for any behaviour to occur that event behaviour would in the new activity's .java file 

*note*: View.OnClickListener is an interface, which defines the onClick(View) method. If you have a class which intends to listen for clicks, you should both implement the interface (if not already extending a class that does), and implement this method too. You have to use both; they're not somehow alternatives.OnClickListener is the interface you need to implement and can be set to a view in java code.

Lately android added a xml attribute to views called android:onclick, that can be used to handle clicks directly in the view's activity without need to implement any interface.

Both function the same way, just that one gets set through java code and the other through xml code.




do do that work we need to write data out to a file 


#### the raw/ folder has .txt file. one thing really counterintutitive is that even we want to add something to our app, we cannot add to this file, because the file itself is frozen and baked into the app's binary itself, so like you cannot really reach in there and modify that!  
what you used to do is like append it to the end of this file a new line with thta stuff.  but that is not possible for us to modify that file so given that is the case, how do we add words to the dictionary? since the file is fixed
we can duplicate a file, i mean that is kinda unclear. you can still make a file in your app and you can modify the content of a file but you just cannot modify this file 

then the app runs we read both of them and merge them 

in the app, the code you read in get put into a hashmap or a map, what you could do is instead of modify the file, you could take the new word you had typed and put it into that map 

and when you play the game, the new word would appear as a choice be there for all purpose for this new word added to it. but that persistent is a problem, you wait until the app is closed if you run it again tomorrow, the new word would be forgottten because the app would reload itself from the memory. that is another thing we are gonna talk 
if I am in the app, I jump away and I have forgotten what I was doing and answer is maybe. he gets messed up after a few seconds 


if you want to write a file, refer to lec5



```java
//write a short text file to the internal storage 

PrintStream outSream = PrintStream(openFileOutput("out.txt",MODE_PRIVATE));
outStream.println("hello");
outSream.cloes();

// read the same file, and put its contents into a TextView 

Scanner scan = new Scanner(openFileInput("out.txt"));
String emptyText = "";
while(scan.hasNextLine()){
    String line = scan.nextLine();
    emptyText += line;
}



textView.text = emptyText;
scan.close();


```


how do we get hold onto the word in the defintion in my code here 

and then you put like a tab or "-" to pass in the original so we kinda match that 

now I want to put the line into a file 
this does not append, and it overwrites the file, we do not want to replace the file 


you would think I know my own stuff here. you google and try different ways to do stuff 





```java
package com.example.dictionaryapp;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

public class add_word extends AppCompatActivity {
    EditText word;
    EditText defintions;
    final String WORDS_FILE_NAME = "extrawords.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        word = findViewById(R.id.wordEditText);
        defintions = findViewById(R.id.definitionEditText);








    }

    public void addAWord(View view) {


        String wordVariable = word.getText().toString();
        String definitionVariable = defintions.getText().toString();
        String line = wordVariable + "-" + definitionVariable;

        try {
           // not this one  OutputStream outputStream = new OutputStream(context.openFileOutput(WORDS_FILE_NAME,MODE_PRIVATE));
            PrintStream outStream = new PrintStream(openFileOutput(WORDS_FILE_NAME, MODE_PRIVATE));
          
            outStream.println(line);
          outStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
```



```xml 

<?xml version="1.0" encoding="utf-8"?>
<GridLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".add_word"

    android:rowCount="5"
    android:orientation="vertical">


    <include layout="@layout/content_add_word" />

    <TextView
        android:id="@+id/title"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="please enter a new word to add"
        android:layout_gravity="center"/>

    <EditText
        android:id="@+id/wordEditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="please enter  word to add"

        android:layout_gravity="center"/>

    <EditText
        android:id="@+id/definitionEditText"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="please enter defintion to add"
        android:layout_gravity="center"/>


    <Button
        android:id="@+id/addButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Add"
        android:layout_gravity="center"
        android:onClick="addAWord"
        />








</GridLayout>
```




there are a few things we can do here, one thing is like when we add a word, we have to read the new words that we just added 

the other thing is like there is initial app startup when it first loads up the app, I want to notice the new words has been added here like right now and I am using the app now 
I want to get immediately as opposed to the next time when I launch the app I want it to show up to ues new words 

so there is a couple ways you can do this, I think this really gets into data flow data ownership issues, I really want the guy to get to the old activity 

how does this guy add a new app to another guy? 


## sending back a result 
in the second activity that was invoked, send data back: 
1. need to create a Intent to go back
2. store any extra data in thta intent; call setResult and finish 

now we are in the situation where activity A has launched activity B 
and activity B has sort of completion when they are done 
they want to go back to activity A 
the way you do that is you call a method finish 
the finish method closes your activity and goes back where you respond from 
it must be my java flashback

but kind of in the same way that intents can pass information 
you can also use intents to return information
I think this is a situation where you might want to do that where you know the list of words  popped up the other activity where you could add a new word to do it so it can incorporate the game 

you setRresult(Result_OK,intent); and finish();




```java
class SecondActivity : AppCompatActivity(){
        onClick(view : View){
            Intent myIntent = new Intent();
            myIntent.putExtra("name1",value1);
            setResult(RESULT_OK,intent);
            finsh();
        }


}

```

this will send back to the person who really responded me 

```java 
 package com.example.dictionaryapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

public class add_word extends AppCompatActivity {
    EditText word;
    EditText defintions;
    final String WORDS_FILE_NAME = "extrawords.txt";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);
        word = findViewById(R.id.wordEditText);
        defintions = findViewById(R.id.definitionEditText);








    }

    public void addAWord(View view) {


        String wordVariable = word.getText().toString();
        String definitionVariable = defintions.getText().toString();
        String line = wordVariable + "-" + definitionVariable;

        try {
           // not this one  OutputStream outputStream = new OutputStream(context.openFileOutput(WORDS_FILE_NAME,MODE_PRIVATE));
            PrintStream outStream = new PrintStream(openFileOutput(WORDS_FILE_NAME, MODE_PRIVATE));

            outStream.println(line);
          outStream.close();
          //go back to the main actvitiy

            Intent myIntent = new Intent();
            myIntent.putExtra("word",wordVariable);
            myIntent.putExtra("definition",definitionVariable);
            setResult(RESULT_OK, myIntent);
            finish();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

```
how do I want this intent to launch  the other guy start activity?
 I think you might imagine the stuff he sends back it is like returned here 

 it will be way to simple if you do result = startActivity(myIntent) which makes a lot of sense  of course this is not what android does, this comes into this sort of return 
versus callback programming  dichotomy 

so basically what happens is startActivity launches the other one 

the one for adding a new word but it does not just like sit there adn wait it does not have a return 

if the other guy sends info back to here to the original first activity 
it will give the information to this guy by calling a certain method 

if I want to look at that information, I have to write that method 
it is a bit like event handler 



## Waiting for a result 
1. if calling activity wants to wait for a result from called activity 
calll startActivityForResult rather than startActivity 
startActivityForResult requires you to pass a unique ID number to represent the actin being performed 
by convention, you declare a final int consant with a value of your choice
the call to startActivityForResult will not wait; it wil return immediately 

2. write an onActivityResult method that will be called when the second activity is done 
check for your unique ID as was passed to startActivityForResult 
if you see your unique ID, you can ask the intent for any extra data 


3. modify the called activity to send a result back 
use its setResult and finish functions to end the called activity 


## grabing the result 

it also passed in because nothing is simple in android 
you not only pass in intent but you pass in some magical integer code 


the reason why that do this i mean i am critizing this topic 
you could start different things and maybe different might come back with different message and you wanna be able to disambiguate whose reslt is back 
this particular app does not have such an issue because we only start one thing and wait for another one to come back. 
but a more complicated app you may be siting here sending out internet messages  and waiting for different responses 
so this is meant to be versatile for different resutls come in 

so you make up code, pass in code, you write a metohd onActivityResult 
and on that code you look for that code to come back to you 

you get an intent and you can unpack the intent to see what is inside of it 
let me try to put these pieces together 


```java 
class FirstActivity extends AppCompatActivity(){
    private static final CODE = 123;  // must be 0-65535
    void myOnClick(View view){
        startActivityForResult(myIntent, CODE);
    }

    override void onActivityRresult(int requestCode, int resultCode, Intent intent){
super.onActivityResult(requestCode, resultCode, intent);

if(requestCode == CODE){
    String data = intent.getSTringExtra("name");
}

    }
}


```


you go to main activity, I dicovered it can basically be any number you want as long as it is consistent 

I was bullshiting around , i discovered that the hard way so 


```java 
  private final static int STUPID_CODE= 123;


    public void addWordFunction(View view) {
        Intent myIntent = new Intent(this,  add_word.class);
        startActivityForResult(myIntent, STUPID_CODE);

    }

```
I wait for the other activity to come back to me, that is the method 

that onActiyResult accpets three parameters: requestCode, resultCOde, intent 

I think the best code to write htis in editor , from a blank white space to start typing : onAc .... boom .. present which write the whole thing out for you  so you can fill in 


```java
    public void addWordFunction(View view) {
        Intent myIntent = new Intent(this,  add_word.class);
        startActivityForResult(myIntent, STUPID_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

```

when the second activity comes back to me, I can respond to the returning from the second activity 

the requestCode is the stupid code we passed in 
the resultCode is if this guy wants to send back any integer status, he is sending back result ok, that is like a result status code, I do not worry too much about that 
I think what you are supposed to do here is supposed to say 



```java
@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == STUPID_CODE){
            // unpack the word and defintion from the onward
           //  String word = myIntent.getStringExtra("word");
            // String definition = myIntent.getStringExtra("definition");


        }


```


there is a tinny tiny syntax here which does not like this dot 

the general design philosophy of kotlin is to try to restrict nullness and not having nullness, so we do not have to worry about it as much as possible 


it is possible that we do not do any of the stuff say finish(), use finish will never allow you to put anything in it so then what is this guy doing? 

how do we get around this? 

```java
 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == STUPID_CODE){
            // unpack the word and defintion from the onward
          String word = data.getStringExtra("word");
          String definition = data.getStringExtra("definition");
          mHashMap.put(word,definition);


        }


    }

```

let's put strength and weakness together so you can deal with this crap
let's give it a try and see if this works, it sorts entirely possible that it might not work but let's find out what happens 
this does not notify the new word which i think functionally will suffice for that 

it is really not seeing here. that is one of the two chances happening 

I did it and you got it 



```java 

package com.example.dictionaryapp;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {
  ListView lv;
  ArrayList <String> mStrings;
  HashMap<String,String> mHashMap;
  TextView tv;
    ArrayList<String> keys;
    ArrayList<String> defs;
    ArrayAdapter<String> adapter;

    private final static int STUPID_CODE= 123;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHashMap = new HashMap<>();
        tv = (TextView) findViewById(R.id.word);


        lv = findViewById(R.id.listview);
        mStrings = new ArrayList<>();


        InputStream fr = getResources().openRawResource(R.raw.words);
        Scanner sc = new Scanner(fr);


        while(sc.hasNext()){
           String line = sc.nextLine();
         String [] pieces = line.split("-");
          mHashMap.put(pieces[0],pieces[1]);
        }




           keys = (ArrayList<String>) mHashMap.keySet().stream().collect(Collectors.toList());
       defs = (ArrayList<String>) mHashMap.values().stream().collect(Collectors.toList());
        Random rand = new Random();

        tv.setText(keys.get(rand.nextInt(keys.size())));
  try {
      PrintStream outStream = new PrintStream(openFileOutput("out.txt", MODE_PRIVATE));
      outStream.println("hello word");
      outStream.close();

  }catch (FileNotFoundException fe) {
      Log.v("what", "file not found");

  }


         adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, defs);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                defs.add("new one");
                adapter.notifyDataSetChanged();
            }
        });




    }

    public void addWordFunction(View view) {
        Intent myIntent = new Intent(this,  add_word.class);
        startActivityForResult(myIntent, STUPID_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode == STUPID_CODE){
            // unpack the word and defintion from the onward
          String word = data.getStringExtra("word");
          String definition = data.getStringExtra("definition");
          mHashMap.put(word,definition);
          keys.add(word);
          defs.add(definition);

          Log.v("what",word);
          adapter.notifyDataSetChanged();




        }


    }
}

```


we got two activities and two activities are taling to each other 
I did not show every single syntax aspect of the thing 

somtimes if A wants to launch B, A has to send information to B 
and between creating intent and starting a new intent 
you can put putExtra("nameTOActivity2", value);
I just want to show you all the pieces here so 

```java

 public void addWordFunction(View view) {
        Intent myIntent = new Intent(this,  add_word.class);
        myIntent.putExtra("nameTOActivity2", value);
        startActivityForResult(myIntent, STUPID_CODE);

    }

```


where will this data end up being? 
the answer to that is:


## Extracting extra data 

in the second activity was invoked, you can grab any extra data that was passed to it by the calling activity 
1. access the Intent that spawned you using the activity's Intent property 
2. the Intent has methods like getIntExtra, getStringExtra and etc to extract data that was stored inside the intent 





```java 
class SecondActivity extends AppCompatActivity(){
  override void onCreate(Bundle state){
      super.onCreate(savedState);
      setContentView(R.layout.activity_second);


      String data = intent.getStringExtra("name");
  } 
}


```

the second activity the one that receives the information . whatever you want to do with that 

in java, all the widgets you get to modify has the set and get method . you will see that convention all setup 
in kotlin, it has a thing call property 


these activities do not have variables that you can talk to each other 

you do not call methods on the class, you call object of the method 
so they do not actually have a reference to the object of that class 
android has a set of guidance, they do not want activity classes reaching over and calling each other's methods 
theyu want a little more isolation 


they do not want to reach in and mess with the methods of the phone dialer 
so for a lot of reasons of the communication in either direction between activities is typically done by them sending intents to each other 

it is kinda of like exposes too much of the state 

a companion object is kind like a static global object in a class 
there are some can versus should 


but you are not really supposed to do that because it also static and constant things that are talking to each other and they do not flush out very cleanly like if you edit your app, it can be like quickly relaunch the app. basically it is the black magic stuff it also does not play nicely with some of the stuff with forgetting and you leave the app and go somewhere 


#### and you get this weired like stale crusty data store in something like that and it does not work and crash 
and I protect you guys from stuff in general you should stick to the kind of Intent based system that is built for you 
it wants to send a parameter on the way as it is doing so 


that is a bit common sometimes than sending back out a parameter like that 
it is probably a little bit more commmon but I did both 

there is another pieces missing here, I want to patch up before we are kinda done with this 
one is when we are opening our file to write it , we are replacing the previous content 
the second is even worse even more significant is that it does not remember to load new words when I launch the app 

when I first launch the app, it reads all the words from original file, but we do not have any code that reads exta words file

we need to do that when the app loads, if you started with five words and you added more and you quit the app abd come back next time, it should reload all words, this does not.this gets us stuck here 


###### how would you being without too surgical and invasive make and load up when it launches here? 
I want to read in and load the data set 

it always reads from the same place, that pretty much solves the issue with reading in extra words 
you can pass through the file name for sure there is definitely more than way to do it 

I just want to point out that there is not a lot of left to patch up before this basically works 







































































































































