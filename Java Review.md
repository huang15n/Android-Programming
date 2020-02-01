


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


















