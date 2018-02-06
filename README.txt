1. What does the line super(5); do when placed in a class’s constructor?

A: It call the constructors in the parent class, and constructs a parent class object with parameter int 5.

2. Assume you have a base class Superclass, and class Subclass that extends Superclass. If you have the following code:
Superclass c = new Subclass(); will this cause an error? (Assume Subclass has a default constructor). Why or why not?

A: It will not cause any errors because subclass is a superclass and it is ok to treat the instance of subclass as superclass.

3. For the classes Superclass and Subclass as described above, which is true:

a. A Superclass “is a” Subclass

b. A Subclass “is a” Superclass

c. Both of these

d. Neither of these.

A: b

4. Now assume you have classes Person and Student as defined in class. Assume that you have a Person type variable that references
 a Student type object. I.e. Person p = new Student(“Sally”, 18); If the method sayHi() is defined in the Person class and overridden
 in the student class, which version of the method will be called when I write p.sayHi(), the Person’s version or the Student’s version?

 A: It will return the person version. p is created as a person (superclass) object, so it can only access to the public methods in
 Person class not in the Student class

5. Which methods from Critter will you override in the Bear class?

A: eat fight getColor getMove toString

6.Will the following cause an error: Bear b = new Critter(); Why or why not?

A: There will be error because a superclass is not a subclass, therefore a superclass cannot be treated as a subclass.
c 
7. True or false: you will need to add a line of code that calls the method “eat” critters to eat food during the simulation.

A: False

8. True or false: The member variables in the Dragon class can be different and have no relation to the member variables in the Tiger class.

A: True

9. Explain how you could use a static member variable in the Bear class to keep track of the total number of Bears that had ever been created.
(Note: There’s no need to actually do this in the code).

A: A static variable is only initialized once and shared by all instances, therefore an int variable count can be initialized as 0 at the
beginning of the code, and get increment every time the constructor is called.
