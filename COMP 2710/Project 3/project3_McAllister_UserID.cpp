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
#include <string.h>
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

 cout << "*** Welcome to McAllister's sorting program ***" << endl;

 /*
  * Get name of file two from User.
  * Validate the existence of the file one.
  */
 do {
  cout << "Enter the first input file name: ";
  cin >> file1;

  check_file(file1);
 } while (cin.fail() || !check_file(file1));

 // Get and display numbers from file one.
 numbers1 = read_file(file1);

 cout << "The list of " << numbers1.size() << "\n";
 for()

 /*
  * Get name of file two from User.
  * Validate the existence of the file two.
  */
 do {
  cout << "Enter the second input file name: ";
  cin >> file2;

  check_file(file2);

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
 //Used Geeksforgeeks to learn cerr https://www.geeksforgeeks.org/get-error-message-when-ifstream-open-fails-in-cpp/#
 if (stream.fail()) {
  cerr << "Error Details: " << strerror(errno);
  stream.close();
  return false;

 }
 stream.close();

 return true;
}

vector<int> read_file(string file) {
 // Input file stream. (ifstream)
 ifstream stream;

 // Vector containing numbers from file. (vector<int>)
 vector<int> v;

 // Integer read from file. (int)
 int i;

 // Add each number in the file to a vector.
 stream.open(file.c_str());
 while (stream.good()) {
  stream >> i;
  v.push_back(i);
 }

 return v;
}

void write_file(string file, vector<int> v) {
 // Output file stream. (ofstream)

}

vector<int> merge(vector<int> v1, vector<int> v2) {

}

void to_string(string file, vector<int> v) {

 // Vector interator number. (unsigned short)
 unsigned short i;

 // Display the numbers contained in a vector
}




