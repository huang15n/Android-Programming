# Fragments 




we have some schedule conflicts and we just didn ot have our exercises, it is our fault, I just kinda do not want to waste your time. I do not want you to work in haste 

sometimes it goes to spam filter but if you did not hear about it you cannot necessarily have a lot of gap between those two 

we will try to make it so that if you turn in next time and then you discover there was some mistake on the previous one that you would be able react to that feedback 
that is a different takeaway, it is trademarked 


fragments, the goal of that, the reason we are gong to learn about that is fragments is something that allows you to kinda of have a unit of UI. a unit of user interface of your app, that is a little bit smaller than an activity, an activity is a full screen worth of UI, a fragment is like a part of the screen UI 


and the reason you might want fragment is so that you can take chunks of the screen and recompose them and mix them and match them and in particular where that would be useful is if you have an app and you want a different layout when you rotate it to landscape mode versus when you have it in portrait mode and that is kinda of theme today and I have to admit that fragments are sort of complicated and so it will probably take me all to just go through this is write some code to show to you 


I think it is a little bit unfortunate that I think android programming is kinda a little bit more complex than it needs to be 

I feel fragements are pretty important topic in android coding so I think we have to learn about them 



## Situatina layouts 
your app can use different layout in different situations 
1. different device type tabelt versus phone versus watches 
2. different screen size 
3. different orientation portrait versus landscape 
4. different country or locale(langueg, etc)



frament is useful in different circumstances, the most important thing is portrait versus landscape i already mentioned that but somtimes it is not about that, sometimes it is about if you have different device or you have a really big screen like a tablet versus a little tiny screen like a small phone, it could be that you want to show a slightly different UI in certain countries or locations versus others.

I have not talked about localization or internationalization stuff at all, but certainly you not only would have to have different languages different words in the scren, you might also reorganize how things look, some countrie might have right to left reading and you might use that or there is lots of different reasons of a little bit different appearnce in your app under certain circumstances than others 

a common paradigm looks a little bit like these  
I mean it is just a generic looking picture
there is detail one of the element activity so the mai nand the mean and details or lists and details. that is a pretty common paradigm we talked about and if you app is in portrait mode tha tis what you would do if you have two activties for that. if you have a nice big screen 

maybe you want something like this where the list of stuff is 

the list stays there it does not go from the list to the details you see both but at all times you click look some details scroll a little click a different one now 
so suddenly the two things that used to be separated are all on the same screen at the same time, so you can totally do that 

you can do that sort of the dumb way or you can do it the less dumb way, the dumb way to do that is to redundantly have all the code for this twice, you know have this as an activity if this is an activity each of which has its own files and run another third activity that sort of copy paste all the code from both of these, you know what I mean like you just mush 

the joke i used to tell was there is only three things computer scientists do not like: redundancy, inefficiency and off by one bugs 

we do not want our app do this by redundancy repeating all the code of course 

lets us talk about this 


## situatoin-specific foldres 
- your app will look for resource folder names with suffixes:
1. screen desntiy e.g. drawable-hdpi 
xxhdpi:3.0 
xhdpi:2.0
hdpi:1.5
mdpi:1.0
1dpi:0.75

2. screen size e.g. layout-large 

3. orientation. e.g. layout-land 
portrait 
land: landscape 

you can specify these special foldres for your apps 

you can create a folder calle drawable-something or layout-something and depending on what the suffix is here it will use that resource or that info only in certain environment so one of the examples is that you hae these images that are drawable just put them in a folder called drawable but you can make a folder called drawable-hidpi how high those pixels are on the screen 

you have this kind of older device that you can see the little retangular pixels if you hold your face up to the screen versus if you have beautiful new retina or a brand new ipad the display screen is super shapr and even if you are up pretty close it is kind of hard to see little pixeles, you know that is the dots per inch the more the shapr it is more dpi you have 
it is optimal for someone 
if the device has low res and you put low resolution images the image will look blurry and blocky on their screen or if you put super duper high resolution image then someones' screen is wasting a lot of space and a lot of memory on those images who are too sharp looking too much detail so you know maybe if you have an app that is used by lots of people you want to put different images for different people 
there is also a lot of layouts you can have 
I want big screen for this layout and small screen of that layout that you can provide two different xml files and you actually do not need to put any code like in java to handle this, just by placing these files in these folders

android will detect what was going on with the device right now and it will use the right folder and the right file for the current circumstances if screen is large it will use the layout large file if the orientation is landscape , it will use the layout landscape file 

we are going to focus on this one if you want a separate layout for landscape versus landscape, you make a folder called layout-land 



we can spend lots of time talking about different variations of all these different folders but I just wanted to intro that so I could go to layout land so I could show you that we could have an alternate layout file and the picture here that is kinda showing you that I have a normal layout folder with an activity xml files that is my layout in tall portrait mode than I separately make a layout folder with this same name and that one will be used if I turn the app size 


this also kinda goes back to different activity state or activity lifecyle onPause(), onResume() onDestroy() all that kind of stuff. if you rotate tthe screen, the app gets kinda messed up, it will jumbled up, throw my hands and it is kind of badly designed 
the reason it reboots your thing is because it wants to reload your layout just in case you have a different layout for landscape mode and these things all kind of go together 


## Portrait versus landscape layout 
to create a different layout in landscape mode
1. create a folder in your project called res/layout-land
2. place another copy of your activity's layout xml file there 
3. modify it as needed to represent the difference 
4. the phone is rotate, activity reloads itself with layout-land version 



what you would do is you go copy and paste from the existing one and then make the changes that you want it to be different 
I really want to appeal to you guys generations by picking an exmaple that is relevant and cool 


I'm throwing you a bone here. we need an app with multiple activity so I can fiddle with it and stuff 

let me sknow you what I have got here, we do not have time to sit here and look at all of it in detail 
let me kinda familiarize you with what you have here 



the onClick button just opens up a new activity and we jump from one to another, so the main one is the one and the other particular one is the details activity 
the other activity has the name, details descriiption , image of him 

when detailed activity loads up and I read from intent.getStringExtra() for the name and then I look at the resource.getIdentifier(), resource.openRawResource() and then I set them to appear on the screen and then I see the details about that so that is kind of what we have coming into this. im.setImageResource(imageID)

this is not that different from some of the other stuff we did. most of the concepts we have done 

the goal is to reshape, it is the candidate of the app where you could imagine of a view in a landscape model, if I rotate the phone there, is should redraw, this is not too bad there, I am not saying it sucks in landscape mode 


this is our app to explore 

let's start out with this layout-land 
File-> new Layout 
the file name is identical for the layout of portrait layout 
it basically wants to know what condition I should use for this layout 
I will say orientation is landscape 

this is just a wizard make the file for me if i do not want to use this I will just go create the layout land folder and put a file in it and it works fine too 

so it creates a file for landscape one, but as a good starting point would be just to come over here and grab all of this and pste it you could do that. you could take up the whole screen and i can say the width is like 

I want to be careful because what i did here is what I said I did not want to do with my bad jokes 


see if the screen constrains the size of it when I rotate, that will tell us at least when using this new layout file we made 
~/AndroidStudioProjects/dictionaryActivityLifeCycle/app/src/main/res/layout$ 



## stop rotation layout reload 

a quick way to retain your activity UI state on rotation is to set the configChanges attribute to the activity in AndroidManifest.xml 

*won't reload layout from layout-land folder*

```xml
<activity android:name=".MainActivity"

android:configChanges="orientation|screenSize">



```

that is kind oppoiste of what we are doing 



## checking orientation in java 
- sometimes the java code of our activity wants to behave different in each orientation. 
- you can check the orientation with the following code 

```java

if(resource.configuration.orientation == Configuration.ORIENTATION_PORTRAIT){

}



if(resource.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
    
}
```



i said you do not need to write any java code to deal with what orientation you are in general just mkaing that new layout.xml file is all you need to do, android will detect that you are in landscape mode and it is the rest you know 

but you want to have some code that says hey I want to be in portrait mode draw this animation or so if you want to know what orientation mode you are in you can ask like that, and this code would go like in your activity. I could never remember what to type to find this, but anyways that is how you check for those things maybe we will use that later 



## problem: redundant layouts 
with situational layout you begin to encounter redudancy 
1. this layout in one case portrait or medium is very similar to the layout in another case, e.g. lanscape or large 
2. you do not want to represent the same xml or java code multipel times in multiple places 

you should want your code to behave situtionally, e.g.
in landscape mode, cliking a button should modify an existing view
in portrait mode, clicking a button should launch a new activity 


we did this thing where we constrained the size in landscape mode we made it narrower, well then if we want ed the details to be on the right we'd have to go to the details ones and copy and paste all of that, it just seems like a bad idea to copy and paste all this sutff right? we'd all copy paste all the event handling logic and all kind of that stuff 

where should you put your code? onCreate() or onClick() of a button, I will be doing surgery on the code I mean this kind of code could go anywhere 

something that might be a little hard to see about this problem 
in portrait mode we want whole activity that are completely separate from each other and in landscape mode we do not want two activity, we want all of it to be together as one activity 

##### activity is always a whole screen of a layout . you cannot make an actvitity as squish it and make it, you know not fill the screen and then fill the rest of the screen with another activity, that is not how android works 

if you resize this, so that it looks like that just is not going to happen, you have to restructure the code to allow two of those kinds o fthings to be on the screen at the same time as each other 


so the idea of doing is is fragement!!!!



## Fragments
*fragment*: a resuable segment of android UI that can appear in an actvity
1. can help handle different devices and screen sizes 
2. can reuse a common fragment across multiple activities 
tablet: 
selecting an item updates fragment b 
[   A ]   [   B  ]

handselt 
slecting an item starts activity B 


fragment is a sort of medium sized chunk of a user interface 

the smallest chunk of interfae is called a view or a widget

the largest chunk of a screen is an activity the whole screen 
somehwere between widget and screen is fragment, a fragment is a part of a screen a rectangular region that contains widgets in it and you can compose an activity by sticking one or more fragments into it 

I am going to convert my code so that the list of grids of pictures is a fragment 
so I recompose them in different ways and situations. so what i will do with those fragments is if you are in portrait mode, it will create activity that each just contain one of the two fragment only so it is like an activity with one fragment inside 
so the distcition is sort of lost between two 
but over here I will create one activity that has both of fragments insode android will let me do that 

they allow me to put two parts if they are both in the same activity

fragment is essentially kind of like an activity, it is like a xml tag that you can put widget inside of or you can put smaller things inside it 
so we can make a fragment that has a list view in it or a fragment that has buttons in it or whatever and then we can make another fragment that ha got a detail view of a image or textbox under it and we could make that a fragment and now those fragments are like recomposable units that you could put anywhere 

you could say this activity contains this fragment, and that activity contains that fragments. you can sorta mix and match them within activities fit, 
it is blasting at the maxium button, I got revenged by her 


## creating a fragment 

in android stuio, right-click app, click:new -> fragment-> fragment(blank)
1. uncheck boxes about include_method 
2. now create layout xml and java event code as in an activity 

you right click in place of your code you have your java files 


me reshaping refactory and modifying this code to work as fragments and that might work super exciting 

when you create a fragment, it might want to insert a bunch of useless crap that you do not need it ask if you want include frament or include interfae callback? I suggest you just do not check chose because it just inserts code that you do not need 


delete commends, yuck. code it is a lot like an activity although is not quite an activity, i will come back to that in a second 

you can basically copy  your activity content and paste it here. it works fine except it does not like the onClick method that is partly because in the fragment there is no function yet . it is a little more to it than that 

that is a start.  




```xml

<?xml version="1.0" encoding="utf-8"?>
<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".good">

    <TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity"


        android:orientation="horizontal"
        android:layout_gravity="center">




    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="this is landscape"
        android:gravity="center"
        android:id="@+id/tv"
        />
    <EditText
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="please enter a new item"
        android:id="@+id/et"
        />
    <Button android:layout_height="wrap_content"
        android:layout_width="wrap_content"
        android:text="click me to add item"
        android:id="@+id/butt">
    </Button>
    </TableLayout>

</FrameLayout>
```




now what you can do , i told you a second ago that fragments can be kind of recomposed by activities so what you will do is you will go back to your activities like the instead of all these stuff, I moved all that stuff into the fragment 

so here bascailly all I'm gonna say is i want to have a fragment in me 

activity is just a think wrapper around the fragment but we are going to chnange it up a little in landscape mode 


## using framgments 

activity layout xml can include fragments 

```xml 
<android.support....Layout>
<fragment....
android:id="@+id/id"
android:name="ClassName"
tools:layout="@layout/name"
/>

</android.support....Layout>
```


you have to supply certain attributes, you have to say the name of the fragment, which is the same as the class name ,you also give it an id, you also have to set what layout it uses so 
and it auto inserts stuff 


```xml
<?xml version="1.0" encoding="utf-8"?>
<TableLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"


    android:orientation="horizontal"
    android:layout_gravity="center">

<fragment android:layout_width="match_parent" android:layout_height="wrap_content"

    android:id="@+id/fragment_good"
    android:name="com.example.dictionaryactivitylifecycle.good"
    tools:layout="@layout/fragment_good"
    >



</fragment>



    <ListView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:id="@+id/dictionary"


        />




    <!-- android:entries="@array/dictionary" -->



</TableLayout>

```



basically what I do is I move all the code for the grid into a fragment and now I made the activity just only contain that fragment 

it is not that impressive because it just back how it was before, i am going somehre with, delete all the guts with it 


why do you think it is a little off? the overall layout of an activity is a constraint layout and if it is a constraint layout you have to attach things 
so the width and heights of these fragments 
we are thinking of the outter containers just filling the whole screen but now it does not necessarily fill the screen so when you have two or more fragments on the same screen together you need to like anchor them where they need to be located 


it is equivalent to me dragging and touching thoes ovals and stuff 

then the detail frament i will similar take this top and bottom and i will attach them to the parent. what does its left side constrain? 
attach it to thte right side of the fragment 
I do not know how to do a percent
I htink the goal of some of these units is to help avoid dealing with that 

if you say 1 inch that means 1 inch in the real world but then that would scale depending on device pixels 


if you say dps and sps i believe the difference is that sp are like scaling pixels and dps are device pixels, I get all mixed up to be honest with you, but I believe the scaling pixels will look more uniform from device to device 

i will capture that sort of ratio we have here and it will adjust it for different screens to do different things 
I would download a whole custom layout if you want to do stuff with percents which I think is a bit ridicoulous, I think we can spend more time on some of the nuances of layout and stuff but I just wanted to show you can make one of them one size and the other one the other size and you know you sometimes can just say wrap content if the widgets are a certain size it will just pack them to match their size but with some of these image buttons you can stretch them and scale them anyway 



I do not know if there is a little of muck here but you might say that are not done yet 

we have carried over all the xml all the layout that looks good, but we have not changed the java code to make it work and it is not as copy and paste over the java code 


## Fragment life cyle 
- fragments have a similar life cylce and events as activities 
1. onAttach to glue fragment to its surrounding activity 
2. onCreate when fragment is loading 
3. onCreateView method that must return fragment's root UI view
4. onActivityCreated method that indicates the enclosing activity is ready 
5. onPause when fragment is being left/exited 
6. onDetach just as fragment is being deleted 



fragments are a little bit like activities in a sense that they have a lifecyle you are like oh god not again. 

it has a lot of these on methods the way an activity does. however, they add in a vouplr more because they said why not 


the new ones that are adeed have to do with every fragment hsa to be inside an activity and sometimes fragments wants to know about some stuff about the status of the activity that is inside it 


some methods like onActivityCreated, onPause has to do with on the activity containing you 

it is helpful sometime orride one or two of them in certain cases i have bolded of two that you really need to know 


when you make a new fragment class, you have to have a method called 
onCreateView which is essentially equal to the onCreate method of an activity kinda sets it up or whatever and andorid will make it for you when you say you want a new fragment, you actually do not need to write that one, you need it but you do not have to write it 

there is another method called onActivityCreated method which is like if you would have had some initialization code or set up you should put that code there onActivityCreated, why does not that code go in onCreateView? it is because fragments depend on their enclosing activity to help them initialize or read certain resources so activity needs to be ready to help the fragments do that so if you put code in the activity sometimes is not ready to help you yet and so stuff crashes and it is confusing so 

I will show you a pattern that you can follow for your code to work properly but I am telling you if you look at these different methods it is like I have some startup code when the fragment starts up I want to do something where do I put that code? 

you need to wait until at least onActivityCreated if you do it any earlier than that the activity kinda is not ready and the stuff does not work if you try to load resources if you try to get things id and mess with them. they dont always work. I would put any such code in the onActivityCreated code 

```java
  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_good, container, false);
    }

```


the fragment onCreateView is really frightening, what is all this stuff? the first parameter is inflater, the second parameter is container. the third parameter is bundle. that is it. it returns a view, you do not need to modify this, just leave it 

the method that you are going to want if you need to do any initilization is that other one onCreate 

most code pages will be fine except Intent would not work 
intents refer to activities they won't carry you across for this one 
when you create an Intent, you pass two parameter, the first one is this and the second one is what activity you want to launch. basically you have pass in what activity am i going from and what activity am i going to 
if you say "this" is the activity, this is the wrong data type it does not like that anymore 
whatever actvity that the fragment is in, you want to pass that as a parameter 

so if you are in a fragment 

## fragment versus activity 
- many activity methods are not present in the fragment 
but use acttivity properly to access the activity the frament is in 

```java
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.fragment_bad,container,false);

Button button = view.findViewById<Button>(R.id.myButton);

return view;


                             }
```

sometiems also use view property to refer to the activity's layout 

- event handlers cannot be attached in the xml any more. must be attached in java code instead 

- passing information to a fragment via Intents/Bundles is tricker. the fragmetn must ask its enclosing activity for the information 

- Fragment initlization/lifecycle code is different 
typically move onCreate code to onActivityCreated 

it is techinically a method called get activity that returns the activity but that is it 
openRaw and certain methods they do not work but if you say activity.openRawResources those methods are there now 

if you are brining code over from an activity to a fragment, you sometimes have to patch it and say activity.activity. in order for it to work 



technically your activity can be null, if you are in this activity lifecyle, if you are too easy activity surrounding you has not been created yet it is kinda weired it like builds your ui inside out so I cannot call things out 

if you call a null object on android in java, it will crash, it is the short way of saying that i mean it is a little bit annoying 
the language is trying to protect us here 
the widgets secretly imports those ids into your files somehow so if it does not recognize them you can just double click them and hit alt+enter, it has synethic import 
in general your code will copy paste 

we are still missing the code side by side 

if I save it as a variable, it knows that i did not change my variable 
if it is not positive, it will get mad at me and return a null the next time. we are getting there 

but one of those things which is not right at this point is the event behaviour 


I am pretty sure you cannot use the onClick on the fragment, last time I tried and it did not work. there are thousands ways to break 


```java

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        dictionary = new ArrayList<>();
        view = inflater.inflate(R.layout.fragment_bad,container,false);

        lv = view.findViewById(R.id.dictionary);
        butt = view.findViewById(R.id.butt);
        et = view.findViewById(R.id.et);

        dictionary.add("one");
        dictionary.add("two");
        dictionary.add("three");

        butt.setText("hhelloooo");


       adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,dictionary);



        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dictionary.remove(position);
                adapter.notifyDataSetChanged();
            }
        });


        butt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dictionary.add(et.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });

        return view;
    }

```

can I make it go away? that is back a couple one 




```java

if(resource.configuration.orientation == "Configuration.ORIENTATION_PORTRAIT )
{}
else{}
```

now I do not have to rerun it but I think what would jump to the details 

I want to click here and update this thing over there 

they are the same activity, they are not two different activities anymore 


the way that you make two fragments to talk to each other is 
let's jump ahead back to where I was 


## Fragment communication 
- an activity can contain multiple fragments 
- the fragments can talk to each other 
1. use activity's fragmentManager property 
2. its findFragmetnById method can access any fragment that has an idea 
3. write regular methods to communicate 

```java
Fragment myFrag = getFragmentManager().findFragmentById(R.id.fragment_good);
frag.methodName(parameters);

```



can you have activities call methods of each other and stuff 
no no no, we do not do that 

but with fragments sometimes fragments do want to talk to each other 
there is a variable or global property that you can have access to tahat is called fragmentManager and fragmentManger has a method called findFragmentById

and you pass one id that you gave to the one fragment then you will return that fragment to you as an object you can talk to 

if you want to talk to this thing, we want to refer to it as a details fragment 

that is the general fragment of the superclass

what kind of method i can call? you could call anything a fragment has 
but here is the thing, I really want to emphasize you that is like the normal programming knowledge kicks in, any method that I put in as detail fragment 
I can now call them over in that other code 

they can talk to each other you can call whatever method you want 

```java

//fragment a 
    public void something() {
        Log.v("this","it is great");
    }

// fragment b 


```



how do I make one talk to the other one and tell him to change what is showing 
this is just a normal programming thing like just make a function  and give it parameters 

when you loaded up the activity, that is coming into intent parmaeter 
that is descriptive name and it because possibly work 
do they mate with each other? like hybrid, it is like a shitty knockoff of things 
it is just uniformly worse than it 


what did I do wrong here? let me try again 
I was right, I knew it 

I do not have enough time to fix it 

once your activity is done it should mostly just an empty husk that that contains fragments inside of it but now that I remove the code this thing. let me just confirm to myself it does not work 

basically you cannot find this function 
remember how you know.

#### unfortunately, the ability to set onClick handler in xml only work in the most narrow of circusmstances here. it only works in an activity and it does work in a fragment 

we need to attach the onClick listener to java code 

I want to loop over to all the buttons instad just one button 


I am waving my hands a little bit here the way to loop over is basically to loop over this layout 

so what you do is you have your layout buttons in 

```java
for(Layout layout :layouts.childCount - 1){
    layout = layouts.getChildAt(i);
    for(Button butt : layout_button){

    }
}

```


I tried to loop over all the buttons and attach onClickHandler

hopefully cross fingers this would work 

audible sign of relief comes from the crowd , i would have made you stay after until 6 
if you have done this once or twice, it is not that bad if you felt this was hard to follow today 

























































































































































