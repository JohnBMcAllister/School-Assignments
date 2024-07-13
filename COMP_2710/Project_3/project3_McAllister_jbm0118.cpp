/* File Name    : project3_McAllister_jbm0118.cpp
 * Author       : JB McAllister
 * User ID      : jbm0118
 * Compilation  : g++ project3_McAllister_jbm0118.cpp -o project3.out
 * The foundation of my code comes from Dr. Li's lecture video "21_22.mp4"
 * and Project3_hints.pdf.
 * I used resources like ChatGPT to help with debugging issues
 * I used the site GeeksforGeeks to learn gnomesort sorting algorithm.
 * I used the site bgsu.edu to see examples of fstream
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
void write_file(const string&, const vector<int>&);

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
 * Sorts the 3rd vector after merging by using Gnome Sort
 * Used gnome sort because it is simple and a cool concept.
 *
 * Time Complexity: O(N^2) (Not the fastest)
 * Parem: Third vector containing values of the two merged vectors.
 */
void gnomeSort(vector<int>&);

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

  if(!check_file(file1)) {
   cout << "Error: File does not exist." << endl;
   cin.clear();
  }
 } while (cin.fail() || !check_file(file1));

 // Get and display numbers from file one.
 numbers1 = read_file(file1);

 to_string(file1, numbers1);

 /*
  * Get name of file two from User.
  * Validate the existence of the file two.
  */
 do {
  cout << "\nEnter the second input file name: ";
  cin >> file2;

  if(!check_file(file2)) {
   cout << "Error: File does not exist." << endl;
   cin.clear();
  }
 } while (cin.fail() || !check_file(file2));

 // Get and display numbers from file one.
 numbers2 = read_file(file2);

 to_string(file2, numbers2);

 // Combine list and display the sorted result.
 numbers3 = merge(numbers1, numbers2);
 cout << "\nThe sorted list of " << numbers3.size() << " numbers is: ";
 for(int i = 0; i < numbers3.size(); i++) {
  cout << numbers3[i] << " ";
 }

 // Get name of output file.
 do {
  cout << "\nEnter the output file name: ";
  cin >> file3;

 } while (cin.fail());

 // Write combined vector to output file.
 write_file(file3, numbers3);

 cout << "*** Please check the new file - " << file3 << " ***\n"
  << "*** Goodbye. ***";

 return 0;
}

// Implementing the user-defined functions

//Used Sample Code 2 to learn how to open a file.
bool check_file(string file) {
 // Input file stream. (ifstream)
 ifstream stream;

 // Validate whether file exists.
 stream.open(file.c_str());
 if (stream.fail()) {
  stream.close();
  return false;

 }
 stream.close();

 return true;
}

//Used a combination of Sample Code 2 from Project3.pdf and ChatGPT to debug
vector<int> read_file(string file) {
 // Input file stream. (ifstream)
 ifstream stream;

 // Vector containing numbers from file. (vector<int>)
 vector<int> v;

 // Integer read from file. (int)
 int i;

 // Add each number in the file to a vector.
 stream.open(file.c_str());
 /* Originally used while(stream.good()), but encounter a bug
  * where it would push back the last int of the array twice
  * ChatGPT suggested using (stream >> i) because it checks the stream
  * state immediately after attempting to read a number. */
 while (stream >> i) {
  v.push_back(i);
 }

 return v;
}
//Used Dr. Li's video and a site "Writing Data to Files Using C++" on bgsu.edu
void write_file(const string& file, const vector<int>& v) {
 // Output file stream. (ofstream)
 ofstream OutFile(file.c_str());

 for (size_t i = 0; i < v.size(); ++i) {
  OutFile << v[i] << endl;
 }

 OutFile.close();
}


vector<int> merge(vector<int> v1, vector<int> v2) {
vector<int> v3;

 //Loop pushes the first vector into the third vector
 for(int i = 0; i < v1.size(); ++i) {
  v3.push_back(v1[i]);
 }

 //Loop pushes the second vector into the third vector
 for(int i = 0; i < v2.size(); ++i) {
  v3.push_back(v2[i]);
 }

 //Sorts the unsorted vector using gnome sort
 gnomeSort(v3);

 return v3;
}

void to_string(string file, vector<int> v) {

 // Vector interator number. (unsigned short)
 unsigned short i;

 cout << "The list of " << v.size() << " numbers in file " << file << " is:" << endl;

 // Display the numbers contained in a vector
 for (i; i < v.size(); i++) {
  cout << v[i] << endl;
 }
}

void gnomeSort(vector<int>& v3) {
 int index = 0;

 /* Gnome Sort Concept:
  * the index starts at first element checks if there is a previous element.
  * If there is no previous element, increment the index. If there is previous element then compare the elements
  * If the previous element is larger than present element, swap the elements and decrement the index.
  * If the previous element is smaller than present element, increment the index.
  */
 while (index < v3.size()) {
  if (index == 0) {
   index++;
  }
  if (v3[index] >= v3[index - 1]) {
   index++;
  } else {
   swap(v3[index], v3[index - 1]);
   index--;
  }
 }
 }


