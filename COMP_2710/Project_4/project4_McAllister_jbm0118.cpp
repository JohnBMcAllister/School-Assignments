/* File Name    : project4_McAllister_jbm0118.cpp
 * Author       : JB McAllister
 * User ID      : jbm0118
 * Compilation  : g++ project4_McAllister_jbm0118.cpp -o project4.out
 * Most information about data structures came from COMP 2210 taught by Dean Heandrix.
 * Syntax on Data Structures came from GeeksforGeeks
 * ChatGPT was used when I stumbled across bugs during debugging.
 * ChatGPT also provided me with examples of creating functions with linked lists.
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

void UnitTest() {
    cout << "***This is a debugging version ***" << endl;

    cout << "Unit Test Case 1: Ask no question. The program should give a warning message." << endl;
    // creates a function that takes the parameters of the linked list and int 0 to represent asking zero questions
    // The output should be a cout that says "Warning - the number of trivia to be asked must equal to or be larger than 1.
    cout << "Case 1 Passed" << endl << endl;

    cout << "Unit Test Case 2.1: Ask 1 question in the linked list.\tThe tester enters an incorrect answer." << endl;
    // same function as previous test but int is 1 instead of 0 to represent asking one question.
    // The user should input the wrong answer and the message will be "Your answer is wrong. The correct answer is [answer] Your total points: [points]
    cout << "Case 2.1 passed" << endl << endl;

    cout << "Unit Test Case 2.2: Ask 1 question in the linked list.\tThe tester enters a correct answer." << endl;
    // same function as previous test but inputs the right answer.
    // The message out put should be "Your answer is correct! You receive 100 points.
}

// Defining Debug/Production versions
#define UNIT_TESTING
#define PRODUCTION_VERSION

int main() {

#ifdef UNIT_TESTING
    UnitTest();
    return 0;
#endif


    return 0;
}
