


<h2>Model View Controller </h2>


<em> sections are separated into three sections labeled Model, View, Controller. android apps are designed around an architecture called Model-View-Controller, or MVC for short, all objects in your app must be a model object, a view object, or a controller object</em>

<strong>
a model object holds the app's data and business logic. model classes are typically designed to model the thigns you app is connected with. model objects have no knowledge of the user interface; their sole purpose of holding and managing data. In andoroid apps, model classes are generally custom classes you create. all of the model objects in your app compose its model layer</strong>




<strong> view objects know how to draw themseleves on the screen and how to respond to user input, like touches. a simple rule of thumb is that if you can see it on screen, then it is a view. android provides a wealth of configuratble view classes. you can also create custom view classes. an app's view objects make up its view layer. the view layer consists of the widgets that are inflated from activity_xxx.xml</strong>



<strong> controller objects tie the view and model objects together. they contain application logic. contrllers are desigend to respond to varius events triggerred by view objects and to manage the flow of data to and from model objects and the view layer, in android, a controller is typically a subclass of Activity, Fragment, or Service</strong>


<h2> Benefits of MVC</h2>
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







<h2> Generating getters and setters </h2>


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
edhuang@BB4287382437:~/AndroidStudioProjects/QuizApp/app/src/main/java/com/example/quizapp$ ls -al 
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