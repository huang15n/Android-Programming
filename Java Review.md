


# variable: a piece of the computer's memory that given a name and type, and can store a value 
#### syntax: type name = value 
##### a variable can be declared / initialized in one statement 

# java's primitive types: 8 simple types for numbers, text, etc. java also has object types 

# type char: a primitive type representing single characters 
#### each character inside a String is stored as a char value 
#### literal char values are surrounded with apostrophe single-quote marks. 
#### it is legal to have variables, parameters, returns of type char 
#### char values can be concatenated with strings 

# Strings : an object storing a sequence of text characters. characters of a string are numbered with 0 based indexes
#### the first character's index is always 0 
#### the last character's index is 1 less than the string's length 
#### the individual characters are values of type char 

#### string methods: 
##### indexOf(str)
#####  length() 
##### substring(index1,index2); substring(index1)
#####  toLowerCase() 
#####  toUpperCase() 
#####  equals(str). equalsIgnoreCase(str)
#####  startsWith(str) 
#####  endsWith(str)
#####  contains(str)
#### these methods are called using the dot notation 


# char versus String 
### "" is a String '' is a char, the two behave differently 
### String is an object; it contains methods 
### char is primitive; you cannot call methods on it 


# type boolean : a logical type whose values are true and false. a test in an if, for , or while is a boolean expression
### you can create boolean variables, pass boolean paramters, return boolean values from ethods 



# relational expression" a test in an if is the same as in a for loop . tests use relational operators: == , != , <=, >= , < > 
### syntax : for(int index; i <= value; i++) {
###	statements; 
### }
### there are boolean expressions 

# logical operators : &&, ||, ! . conditions can be combined using logical operators 
### truth table for each, used with logical values p and q 



# type cast: a conversion from one type to another. 
#### syntax: type name = value 
##### to promote an int into a double to get exact divison from / 
##### to truncate double from a real number to an integer 


# shortcuts to increase or decrease a variable's value by 1 
#### syntax: variable ++; variable--;

# precedence : order in which operators are evaluated 
##### generally operators evaluate left-to-right 
##### but */ % have a higher level of precednce than +-,  paretheses can force a certain order of evaluation 

##### space does not affect order of evaluation 

##### string concatenation: using + between a string and another value to make a longer strng 
##### use + to print a string and an expression's value together 



# variable scope: the prt of a program where a variable exists. 
##### from its declaration to the end of the {} braces 
a variable declared for a for loop exists only in that loop 
a variable declared in a method exsts only in that method 



# class constants: a value visible to the whole program.
#### syntax: public static final type name = value;
##### value can only be set at declaration
##### values cannot be changed while the program is running 


# passing parameters
### syntax : declaration :  public void name (type name, type name....) {
###	statements; 
###  }

### call: methodName(value,value, ..., value);

# Return 
### return: to send out a value as the result of a method 
### the opposite of a parameter 
### parameters send nfo in from the caller to the method 
### return values send information out from a method to its caller 

# Return a value
### syntax : declaration :  public type name (type name, type name....) {
###	statements; 
###	return expressions; 
###  }


# the equals method: ojects are compared using a method named equals. 
### technically this is a method that returns a value of type boolean, the type used in logical tests 






# if/else : execute block if a test is true, another if false 
### syntax1 : if(test) {
###	statements; 
### }
### else {
###	statements; 
###  }

### syntax2 : if(test) {
###	statements; 
### }
### else if {
###	statements; 
###  }

### syntax3 : if(test) {
###	statements; 
### }
### if {
###	statements; 
###  }

### syntax4 : if(test) {
###	statements; 
### }
### else if {
###	statements; 
###  }
### else {
###	statements; 
###  }



# while loop: repeatedly executes its body as long as a logical test is true 
### syntax1 : while(test) {
###	statements; 
### }




# do/ while loop: executes statements repeatedly while a condition is true, testing it at the end of each repetition 
### syntax1 : do  {
###	statements; 
### } while(test);

# break statement: immediately exists a loop 
### can be used to write a loop whose test is in the middle 
### such loops are often called forever loops because their header's boolean test is often changed to a trivial true 
### some programmers consider break to be bad style 

# the Random class: a Random object generates pseudo-random numbers. class Random is found in the java.util package. import java.util.\*; 
### nextInt(); returns a random int 
### nextInt(max); returns a random integer in the range [0, max) 
### nextDouble(); returns a random real number in the range[0.0, 1.0];


# Arrays: object that stores many values of the same type :
## element: one value in an array 
## index: a 0-based integer to access an element from an array 
## array declaration type [] name = new type[length];
## quick array initialization: type [] name = {value, value, ... value}
### useful when you know what the array's elements will be 
##### the compiler figures out the size by counting the values 
## the length field: an array's length field stores its number of element. name.length. it does not use parentheses like a String's .length() 
## accessing elements; name[index];  name[index] = value;
#### out of bounds : legal indexes: between 0 and the array's length -1 
#### reading or writing any index outside this range will throw ArrayIndexOutOfBoundsException.




# the Arrays Class in package java.util has useful methods for manipulating arrays 
###### binarySearch(array, value)
###### equals(array1, array2)
###### fill(array, value)
###### sort(array)
###### toString(array)

## Arrays as parameters:
#### declaration: public type methodName(type [] name) {
#### } 
#### call: methodName(arrayName);


## Arrays as return: 
#### declaration: public type[] methodName(parameters) {
#### } 
#### calling type [] name = methodName(parameters);


# value semantics/ primitives: bahavior where values are copied when assigne to each other or passed as parameters.
## when one primitive variable is assigned to another, its value is copied 
## modifying the value of one variable does not affect others 
# reference semantics/ objects : behaviour where variables actuall store the address of an object in memory 
## when one reference variable is assigned to another, the object is not copied; botht variables refer to the same object 
## modifying the value of one variable will afect others 
int [] a1 = new int[3];
int [] a2 = a1;
a2[0] = 7;

# null: a reference that does not refer to any object 
## fields of an object that refer to objects are initalized to null 
## the elements of an array of objects are intialzied to null 

# NullPointerException: dereference: to access data or methods of an object with the dot notation,. 
## it is illegal to dereference null causes an exception 
## null is not any object, so it has no methods or data 




# classes and objects:  
# class, a program entity that represents either 1 a program / module, or 2 a template for a new type of obejct 
# object: an entity that combines state and behaviour. Object oriented porgramming: programs that perform their behaviour as interactions between objects 

# fields: a variable inside an object that is part of its state
## each object has its own copy of each field 
## encapsulation: declaring fields private to hide their data 
## declaration syntax: private type name; 

# instance methods: one that exists inside each object of a class and deines behaviour of that object 
## public type name(parameters){
## statements;	
## }


# the implicit parameter: the object on which an instance method is called . the instance method can refer to that object's field 


# kinds of methods. instance methods take advantage of an object's state. some methods allow clients to access / modify its state 
## accessor: a method that lets clients examine object state 
## mutator: a method that modifies an object's state 


# constructors: initializes the state of new objects 
## public type(parameters){
## statements 	
## }
## runs when the client uses the new keywords 
## does not specify a return type, implicity returns a new object 
## if a class has no constructor, java gives it a default contructor with no parametrs tha sets all fields to 0 

# toString method : tells java how to convert an object into a String. 
## called when an object is printed/ concatenated to a String 
## every class has a toString, even if it is not in your code 


# this keyword : a reference to the implict parameter 
## syntax for using this:  
##  1 to refer to a field : this.field 
## 2 to call a method : this.method(parameter);
## 3 to call a constructor from another constructor: this(parameters);


# static method : part of a class , not part of an object 
## shared by all obejcts of that class 
## good for code related to a class but not to each object's state 
## does not understand the implicit parameter, this; therefore, cannot access an object's fields directly 
## if public, can be caleld from inside or outside the class 
## declaration syntax : public static type name(parameters){
## statements;	
## }




# inheritance: a way to form new classes based on existing classes, taking on their attribtues / behaviour
## a way to group related class 
## a way to share code between two or more class 
### one calss can extend another, absorbing its data/behaviour 
#### superclass : the parent class that is being extended 
#### subclass: the child class that extends the superclass and inherits its behaviour 
#### subclass gets a copy of every field and method from superclass 
## inheritance syntax: public name extends superclass{
## }


# overriding methods : override to write a new version of a method in a subclass that replaces the superclass's version -- no special syntax required to override a superclass method. just write a new version of it in the subclass 

# super keyword. subclasses can call overriden methods with super . super.method(parameters)
## super.method(parameters);
## super(paramters);

# the Class Object
## the class Object forms the root of the overall inheritance tree of all ajva calsses. every class is implicitly a subclass of Object 
## the Object class defines several methods that become part of every class you write 
##### public String to String() returns a text representation of the object, usually so that it can be printed 
### protected Object clone() creates a copy of the object
### public boolean equals(Object o) returns whether two objects have the same state
### protected void finalize(). ???????????
### public Class<?> getClass(). info about the object's type
###  public int hashCode() a code suitable for putting this object into a hash collection
### public String toString(). text representation of object
### public void notify() public void notifyAll() public void wait() public void wait(...). methods related to concurrency and locking (seen later)

#Using the object class 
## you can store any object in a variable of type Object 
Object o1 = new Something();
object o2 = "String";
## you can write methos that accept an Object parameter;
public void checkNotNull(Object o){
	
}
## you can make arrays or collections of Objects 
List<Object> list = new ArrayList<Object>();
# comparing object : The == operator does not work well with objects.
## 1 It compares references, not objects' state.
## 2 It produces true only when you compare an object to itself.
# Default equals method: The Object class's equals implementation is very simple:
## public class Object {
##    ...
##    public boolean equals(Object o) {
##        return this == o;
## } 
## }
### The Java API documentation for equals is elaborate. Why?????? 


# Implementing equals
## public boolean equals(Object name) 
## { 
##     statement(s) that return a boolean value ;
## }
## The parameter to equals must be of type Object.
## Having an Object parameter means any object can be passed.
#### If we don't know what type it is, how can we compare it?


### what does this list of methods tell you about java design?????? 

# Polymorphism: ability for the same code to be used ith ifferent types of objects and behave diffrently with each 
# a variable type T can hold an object of any subcalss of T 
## you can call any methods from super class on the object 
## you cannot call any methods specific to the subclasses 
## when the method is called, it behaves as a subclass 


# Casting references: Casting references is different than casting primitives.
Object o1 = new Point(5, -3);
### Really casting an Object reference into a subclass reference
### Doesn't actually change the object that is referred to.
### Tells the compiler to assume that o1 refers to an object.


# The instanceof keyword
### if (variable instanceof type) 
### { 
### 	statement(s);
### }
### Asks if a variable refers to an object of a given type. – Used as a boolean test.


# Equality is expected to be reflexive, symmetric, and transitive:
a.equals(a) is true for every object a
a.equals(b) ↔ b.equals(a)
(a.equals(b) && b.equals(c)) ↔ a.equals(c)
# No non-null object is equal to null: a.equals(null) is false for every object a
# wo sets are equal if they contain the same elements


# The hashCode method: public int hashCode()
1 Returns an integer hash code for this object, indicating its preferred to place it in a hash table / hash set.
2 Allows us to store non-int values in a hash set/map:

How is hashCode implemented?
1 Depends on the type of object and its state.
2 You can write your own hashCode methods in classes you write.



# Collections and lists , collection an object that stores data import java.util.* 
# list: a collection of elements with 0 based indexes
## elements can be added to the front, back, or elsewhere 
## a lsit has size -- number of elements that have been added 
## in java, a list can be represented as an ArrayList object 




# the for each loop
## for (type name : collection){
## statements;	
## }

## provide a clean synatx for looping over the elements of a Set or List, array, or other colelction 



# idea of a List : an ArrayList is like an array that resizes to fit its conents 
## when a list is created, it is initially empty [] 
## you can add items to the list, by default, adds at end of list 
#### the list object keeps track of the element values that have been added to it , their order, indexes, and its total size 
#### you can add, remove , get, set , ... any index at any time 



# Type parameters/ generics 
## ArrayList<Type> name = new ArrayList<Type> ();
## when constructing an ArrayList, you must specify the type of its elements in <> 
### this is called a type parameter; ArrayList is a generic class 
### allows the ArrayList class to store lists of different types 


# ArrayList methods: 
### add(value) 
### add(index, value)
### clear() 
### indexOf(value)
### get(index)
### remove(index)
### set(index, value)
### size() 
### toString()

# ArrayList as param/return 
### public void name(ArrayList<Type> name){}
### public ArrayList<Type> name(params) 


# Sets : set is a collection of unique values (no duplicates allowed) that can perform the following operations efficiently. -- add, remove, search(contains)
#### we do not think of a set as having indexes; we just add things to the set in general and do not worry about order 
## set implementation. in java, sets are represented by Set type in java.util 
## set is implemented by HashSet and TreeSet classes 
## HashSet: implemented using a hashtable array. very fast O(1) for all operations . elements are stored in unpredictable order 
## TreeSet: implemented using a binary search tree. pretty fast : O(logN) for all operations elements are stored in sorted order 
## LinkedHashSet: O(1) but stores in order of insertin, slightly slower than HashSet because of extra info stored 

# Set methods 
### Set <Integer> set = new TreeSet<Integer>();
### Set <Integer> set = new HashSet<String>(list);
##### can construct an empty set or one based on a given collection 
###### add(value)
###### contains(value)
###### remove(value)
###### clear()
###### size() 
###### isEmpty() 
###### toString() 


# Maps: map holds a set of unique keys and a collection of values, , where each key is associated with one value 
### basic map operation 
###### put(key,value)
###### get(key)
######  remove(key)
### Map implementation: in java, maps are represented by Map type in java.util 
### HashMap is implemented using an array called a hashtable extremely fast ; keys are stored in unpredictable order 
### TreeMap: implemented as a linked binary tree structure; very fast : O(log N); keys are stored in sorted order 
### LinkedHashMap: O(1); keys are stored in order of insertion 
### A map requires 2 type params: one for keys, one for values 
### Map methods:
###### put(key,value)
###### get(key)
###### remove(key)
###### containsKey(key)
###### clear()
###### size() 
###### isEmpty() 
###### toString() 
###### keySet() 
###### values() 
###### putAll(map). add all key/value pairs from the given map to this map 
###### equals(map) returns true if given map has the same mappings as this one 

# Using maps, a map allows you to get from one half of a pair to the other. remembers one piece of information about every key(index). later, we can supply only the key and get back the realted value 

# keySet and values method returns a Set of all keys in the map. can loop over the keys in a foreach loop. can get each key's associated value by calling get on the map 
# values method returns a collection of all values in the map . can loop over the values in a foreach loop. no easy way to get from a value to its associated keys 

# the compareTo method. the standard way for a java class to define a comparison function for its object is to define a compareTo method. 
### public int compareTo(String other)
### a call of A.compareTo(B) will return 
### a value < 0 if A comes before B in the ordering 
### a value > 0 if A comes after B in the ordering 
### or 0 if A and B are considered equal in the ordering 
## using compareTo can be used as a test in an if statement 
if (a.compareTo(b) < 0) { ...
if (a.compareTo(b) <= 0) { ...
if (a.compareTo(b) == 0) { ...
if (a.compareTo(b) != 0) { ...
if (a.compareTo(b) >= 0) { ...
if (a.compareTo(b) > 0) { ...

# comparreTo and collections: you can use an array or list of strings with java's included binary search method because it calls compareTo internally 
##### java's TreeSet /map use compareTo internally for ordering 
Set<String> set = new TreeSet<String>();
	for (String s : a){
	set.add(s);
}

# ordering our own types. we cannot binary search or make a TreeSet/Map of arbitrary types, because java does not know how to order the elements. the program compiles but crashes when we run it 


# Comparable.
### public interface Comparable<E> 
###	{ 
###	public int compareTo(E other);
### }
## a class can implement the Comparable interface to define a natural ordering function for its objects 
## a call to your compareTo method should return 
## a value < 0 if this object comes before the other object 
## a value > 0. if this object comes after the other object 


# Collections class
#### binarySearch(list, value)
#### copy(listTo, listFrom)
#### emptyList(), emptyMap(), emptySet()
#### fill(list, value)
#### max(collection), min(collection)
#### replaceAll(list, old, new)
#### reverse(list)
#### shuffle(list)
#### sort(list)

# Sorting methods in Java
## The Arrays and Collections classes in java.util have a static method sort that sorts the elements of an array/list
Arrays.sort(words);




# Throwing exceptions 
## throw new ExceptionType();
## throw new ExceptionType("message");
## generates an exception that will crash the program, unless it has code to handle ("catch") the exception 
## common exception types: 
ArithmeticException, ArrayIndexOutOfBoundsException, FileNotFoundException, IllegalArgumentException, IllegalStateException, IOException, NoSuchElementException, NullPointerException, RuntimeException, UnsupportedOperationException
### why would anyone ever want a program to crash?????? 

















