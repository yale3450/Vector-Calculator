# Linear Algebra Calculator

## Introduction

*What will the application do? Who will use it? Why is this project of interest to you?*

For my application I will be making a linear algebra calculator that will be able to perform basic operations on 
vectors such as addition, subtraction, dot product, cross product and modulus. It will also calculate the distance
 between lines, planes and points, as well as find the angles between lines and planes. 
 
 My target audience for this project are other students who are studying linear 
 algebra. Doing such calculations are mundane, time-consuming and often serve as sources of error, so I wanted to 
 make a tool that makes doing assignments faster and easier. Higher level users will probably be familiar with matlab
 and would not require tools such as the one I am making.
  
 This project is interesting to me because linear algebra is a weaker subject for m. I hope I can gain a deeper 
 understanding of the subject through this project and improve on this deficiency. I also wanted to make a tool that
 was somewhat technical and relevant to my subject of study so I can use it for my resume. Finally, there is an 
 element of practicality to this project, so I hope in the future some students may find it useful for when they are
 studying linear algebra. 
 
 ## User Stories
*The following are user stories which describe the specific actions of my application:*

- As a user I want to be able to add values to a vector
- As a user I want to be able to add coordinates to a point
- As a user I want to define a plane or a vector with points and vectors
- As a user I want to be able to add vectors and operations to an expression
- As a user I want to be able to compute an expression 
- As a user I want to be able to access my past operations history
-As a user i want to import my operation history from a file into my user interface
- as a user I want to export my operation history into a file. 
 ## Phase 4: Task 2
Phase 4: My project has already implemented extra type hierarchies. My findDistance class interface is implemented by 
line, point and operation, they have three functions which are overridden in each class.
My VorP class also has vector and point as subclasses. 

## Phase 4: task 3
If I were to refactor my code I'd add a global enumeration for operation so I don't have to redeclare them in every 
class. I would also make it so that operation takes the actual classes of plane point vector etc. objects instead of
string representations of them so it will be easier to expand functionality in the future. I would also like to refactor
my gui into seperate classes instead of one giant class with a bunch of different methods. 