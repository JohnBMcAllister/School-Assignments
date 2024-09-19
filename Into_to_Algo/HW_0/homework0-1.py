'''
COMP 3270 Intro to Algorithms Homework 0: Introduction to Python
install python (google it) and make sure you have python version 3.6+ 
'''
from math import factorial
# this is a single line comment just so you know

'''
This is a multi
line comment just fyi
'''

#<editor-fold desc="Questions 1">
#Problem 1: print the string hello world to standard out
# your code here
print("Hello World", "\n");
#</editor-fold>

#<editor-fold desc="Question 2">
'''
Problem 2: declare variables with the types int, float, boolean, Nonetype and print their values and types
then perform operations additions, subtraction, multiplication, division, and power on the float and integer division and modulo on the int
'''
#your code here
integer = int(2);
decimal = float(0.1);
TruthValue = bool(True);
Nothing = None;

print(integer, type(integer));
print(decimal, type(decimal));
print(TruthValue, type(TruthValue));
print(Nothing, type(Nothing));
print("0.1 + 0.3 =", decimal + 0.3);
print("0.1 - 0.1 =", decimal - decimal);
print("0.1 * 0.1 =", decimal * decimal);
print("0.1 / 0.1 =", decimal / decimal);
print("0.1^3 =", pow(decimal, 3));
print("2 // 1 =", integer // 1);
print("2 % 2 =", integer % integer, "\n");
#</editor-fold>

#<editor-fold desc="Question 3">
'''
Problem 3: declare two strings and concatenate them
then print out the 2nd character to the last character without knowing the length of the string. 
'''
# your code here
word1 = str("after")
word2 = str("noon")
compoundWord = word1 + word2;
print(compoundWord[1:], "\n");
#</editor-fold>

#<editor-fold desc="Question 4">
#Problem 4: Write a function that takes in a string name and prints out Hello, <name>!
#your code here
def HelloName():
    name = input("Enter you name: ");
    print("Hello, " + name + "!\n");
HelloName();
#</editor-fold>

#<editor-fold desc="Question 5">
'''
Problem 5: Write a function that takes in a number x and you compute and print out x! 
'''
#your code here
def ComputeFactorial():
    x = input("Enter a number: ");
    computeX = factorial(int(x));
    print(f"{x}! = {computeX}\n");

ComputeFactorial();
#</editor-fold>

#<editor-fold desc="Question 6">
'''
Problem 6: Write if statements to check if a number is postive, negative, or 0 and print a statement to that effect
'''
#your code here
number1 = int(input("Enter a number: "));
if number1 < 0:
    print("The number is negative\n");
elif number1 > 0:
    print("The number is positive\n");
else:
    print("The number is zero\n");
#</editor-fold>

#<editor-fold desc="Question 7">
'''
Problem 7: Write a function that takes in a number x and prints out x^2
'''
#your code here
x = int(input("Enter a number: "));
def ComputePower(x):
    power = pow(x, 2);
    print(f"{x}^2 = {power}\n");
ComputePower(x);
#</editor-fold>

#<editor-fold desc="Question 8">
'''
Problem 8: Make a list of the squares of the numbers 0 to 9
add 100 to the end of that list
create another list with the square of the values 11 to 15 and concatenate those lists (show me 2 ways to do this)
check if the number 25 is in that list and print if it is
do the same with a list-comprehension to generate the list
create a dictionary where the keys are the numbers 0 to 9 and the values are the square of those numbers
create a set of the unique characters in a string
'''
#your code here
#List 1
List1 = [];
i = 0;
while i <= 9:
    List1.append(pow(i, 2));
    i += 1
List1.append(100);
print("List 1:", List1);

#List 2
List2 = [];
j = 11;
while j <= 15:
    List2.append(pow(j, 2));
    j += 1;
print("List 2:", List2);

#concatenate the lists (method 1)
List3 = List1 + List2;
print("Method 1 list:", List3);

#concatenate the lists (method 2)
for x in List2:
    List1.append(x);
print("Method 2 List:",List1);

#checks if 25 is in the list
if 25 in List3:
    print("List contains 25");
else:
    print("List does not contain 25");

#check if 25 is in the list using list-comprehension
testContain = [x for x in List3 if x == 25];
if testContain:
    print("List contains 25");
else:
    print("List does not contain 25");

#creating a dictionary
Dict1 = {0: pow(0,2), 1: pow(1,2), 2: pow(2,3), 3: pow(3,4), 4: pow(4,5),
         5: pow(5,6), 6: pow(6,7), 7: pow(7,8), 8: pow(8,9), 9: pow(9,10)};
print("Dictionary 1:", Dict1, "\n");

#creating a set
uniqueString = str(input("Enter a string: "));
stringSet = {i for i in uniqueString};
print("String set:", stringSet, "\n");
#</editor-fold>

#<editor-fold desc="Question 9">
'''
Problem 9: FizzBuzz
Write a function that takes in a list of numbers, loops over it and prints out Fizz if the number is a multiple
of 3, Buzz if it is multiple of 5, and FizzBuzz if it is a multiple of 3 and 5, otherwise print out the number
'''
#your code here
FizzList = [45, 98, 30, 10, 20, 11, 75, 22, 36, 50, 63, 1, 90, 28, 15, 72, 42]
def FizzBuzz(list):
    for int in list:
        if int % 3 == 0 and int % 5 == 0:
            print("FizzBuzz");
        elif int % 5 == 0:
            print("Buzz");
        elif int % 3 == 0:
            print("Fizz");
        else:
            print(int);
FizzBuzz(FizzList);

#</editor-fold>

#<editor-fold desc="Question 10">
'''
Problem 10: Make a class called Person with attributes age and name
Make a method for that class called introduce which prints out an introduction with its name and age
Make an instance of that class and call its introduce method
'''
#your code here
class Person:
    def __init__(self, name, age):
        self.name = name;
        self.age = age;

    def introduce(self):
        print(f"\nHello my name is {self.name} and my age is {self.age}\n");

john = Person("John", 21);
john.introduce();

#</editor-fold>

#<editor-fold desc="Question 11">
'''
Problem 11: install numpy, import it here and get the mean of a list of numbers and print it out
'''
import numpy

numpyLIst = [1, 3, 4, 4, 5, 6, 6, 4, 3, 2, 1, 4, 5, 4, 3,];
numpyMean = numpy.mean(numpyLIst);
print("The mean of the list is: ", numpyMean);
#</editor-fold>