/* File Name    : project3_McAllister_jbm0118.cpp
 * Author       : JB McAllister
 * User ID      : jbm0118
 * Compilation  : g++ project3_McAllister_jbm0118.cpp -o project3.out
 * The foundation of my code comes from Dr. Li's lecture video "21_22.mp4"
 * and Project3_hints.pdf.
 *
 */

//Import Libraries
#include <fstream>
#include <iostream>
#include <vector>
using namespace std;

//User-Defined functions

/* boolean function that checks if input file is correct and existing.
 *
 * Param: file Name of file (string)
 */
bool check_file(string);

/* vector function that reads the contents of the file
 *
 * Param: file Name of file (string)
 */
vector<int> read_file(string);

/* void function that takes the merged list and write it to file3.
 *
 * Param: file Name of file (string)
 * Param: List of int numbers (vector<int>)
 */
void write_file(string, vector<int>);

/* vector method that merges the lists into one list
 *
 * Param: A list containing the contents of one file (vector<int>)
 * Param: A list containing the contents of the other file (vector<int>)
 */
vector<int> merge(vector<int>, vector<int>);

/*
 * Display the values of a given vector.
 *
 * Param: file Name of file to display. (string)
 * Param: v Vector containing values to display. (vector<int>)
 */
void to_string(string, vector<int>);

/*
 * Merge the numbers in two specified files and wriate all the numbers
 * to a specified third file sorted in ascending order.
 *
 * Return: 1 Program completed successfully. (int)
 */
int main() {
// Variables
 string file1;
 string file2;
 string file3;
 vector<int> numbers1;
 vector<int> numbers2;
 vector<int> numbers3;

 /*
  * Get name of file two from User.
  * Validate the existence of the file one.
  */
 do {

 } while (cin.fail() || !check_file(file1));

 // Get and display numbers from file one.
 numbers1 = read_file(file1);

 /*
  * Get name of file two from User.
  * Validate the existence of the file two.
  */
 do {

 } while (cin.fail() || !check_file(file2));

 // Get and display numbers from file one.
 numbers2 = read_file(file2);

 // Combine list and display the sorted result.
 numbers3 = merge(numbers1, numbers2);


 // Get name of output file.
 do {

 } while (cin.fail());

 // Write combined vector to output file.
 write_file(file3, numbers3);

 return 0;
}

// Implementing the user-defined functions

bool check_file(string file) {
 // Input file stream. (ifstream)
 ifstream stream;

 // Validate whether file exists.
 stream.open(file.c_str());
 if (stream.fail()) {

 }
 stream.close();

 return true;
}

