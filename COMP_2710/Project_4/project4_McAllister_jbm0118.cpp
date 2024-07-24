/* File Name    : project4_McAllister_jbm0118.cpp
 * Author       : JB McAllister
 * User ID      : jbm0118
 * Compilation  : g++ project4_McAllister_jbm0118.cpp -o project4.out
 * Most information about data structures came from COMP 2210 taught by Dean Heandrix.
 * Syntax on Data Structures came from GeeksforGeeks
 */

#include <iostream>
using namespace std;

//Step 1
class TriviaNode {
// Used GeeksForGeeks
public:
    string question;
    string answer;
    int points;
    TriviaNode* next;

    // Constructor
    TriviaNode(string q, string a, int p) {
        question = q;
        answer = a;
        points = p;
        next = NULL;
    }
};

class TriviaList {
private:
    TriviaNode* head;

public:
    TriviaList() {
        head = NULL;
    }

    void addQuestionToList(string q, string a, int p) {
        TriviaNode* newNode = new TriviaNode(q, a, p);
        newNode->next = head;
        head = newNode;
    }

    void initializeTriviaList() {
        addQuestionToList("What is the best-selling video game of all time? (Hint: Call of Duty or Wii Sports)?", "Wii Sports", 20);
        addQuestionToList("What was Bank of America's original name? (Hint: Bank of Italy or Bank of Germany)", "Bank of Italy", 50);
        addQuestionToList("How long was the shortest war on record? (Hint: how many minutes)", "38", 100);
    }

    void displayTrivia() {
        TriviaNode* current = head;
        while (current != NULL) {
            cout << "Question: " << current->question << endl;
            cout << "Answer: " << current->answer << endl;
            cout << "Points: " << current->points << endl;
            cout << "------------------------" << endl;
            current = current->next;
        }
    }
};

int main() {
    // Create a TriviaList object
    TriviaList triviaList;

    // Initialize the list with hard-coded trivia questions
    triviaList.initializeTriviaList();

    // Display the list to verify the initialization
    triviaList.displayTrivia();

    return 0;
}
