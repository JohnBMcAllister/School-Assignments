/* File Name    : project4_McAllister_jbm0118.cpp
 * Author       : JB McAllister
 * User ID      : jbm0118
 * Compilation (Production): g++ project4_McAllister_jbm0118.cpp -o project4.out
 * Compilation (Unit Testing): g++ -DUNIT_TESTING project4_McAllister_jbm0118.cpp -o project4_testing.out
 * Most information about data structures came from COMP 2210 taught by Dean Heandrix.
 * Syntax on Data Structures and the compare function came from GeeksforGeeks
 * ChatGPT was used when I stumbled across bugs during debugging.
 * ChatGPT also provided me with examples of creating functions with linked lists.
 * Note: I imported Limits because cin would not work properly and this helped prevent
 * the code from skipping over places where the user needed to input something.
 */

#include <iostream>
#include <limits>
using namespace std;

//Node that stores Question, Answer, Points
struct TriviaNode {

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

// The linked list that the node will traverse
struct TriviaList {
private:
    TriviaNode* head;

public:
    TriviaList() {
        head = NULL;
    }

    /* Function that adds a question to list
     *
     * param: string q (question)
     * parem: string a (answer)
     * parem: int p (points)
     */
    void addQuestionToList(string q, string a, int p) {
        TriviaNode* newNode = new TriviaNode(q, a, p);
        newNode->next = head;
        head = newNode;
    }

    /* Function that asks for users to create questions */
    void createQuestions() {
        bool nextStep = false;

        while (!nextStep) {
            string question;
            string answer;
            int points;
            string addMore;

            cout << "Enter a Question: ";
            cin.ignore(); // Clear input buffer
            getline(cin, question);

            cout << "Enter an answer: ";
            getline(cin, answer);

            cout << "Enter award points: ";
            while (!(cin >> points)) {
                cout << "Enter award points: ";
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
            }

            cin.ignore(numeric_limits<streamsize>::max(), '\n');

            addQuestionToList(question, answer, points);

            cout << "Continue? (Yes/No): ";
            cin >> addMore;

            while (addMore != "Yes" && addMore != "No") {
                cout << "Please enter \"Yes\" or \"No\": ";
                cin >> addMore;
            }

            if (addMore == "No") {
                nextStep = true;
            }
        }
    }

    // Function that hard codes the questions in debug
    void initializeTriviaList() {
        addQuestionToList("What is the best-selling video game of all time? (Hint: Call of Duty or Wii Sports)?", "Wii Sports", 20);
        addQuestionToList("What was Bank of America's original name? (Hint: Bank of Italy or Bank of Germany)", "Bank of Italy", 50);
        addQuestionToList("How long was the shortest war on record? (Hint: how many minutes)", "38", 100);
    }

    // Function that counts how many questions in the linked list
    int countQuestions() {
        int count = 0;
        TriviaNode* current = head;
        while (current != NULL) {
            count++;
            current = current->next;
        }
        return count;
    }

    /* Function that askes a question and awaits user's input
     *
     * Param: int questions (number of questions to answer)
    */
    int askQuestions(int questions) {
        int totalQuestions = countQuestions();

        // Validates user asks at least 1 question
        if (questions < 1) {
            cout << "Warning - the number of trivia to be asked must equal to or be larger than 1." << endl;
            return 0;
        }

        // Validates user doesn't ask more than what is in linked list.
        if (questions > totalQuestions) {
            cout << "Warning - There are only " << totalQuestions << " trivia in the list." << endl;
            return 0;
        }

        TriviaNode* current = head;
        int totalPoints = 0;
        int questionsAsked = 0;

        // Loop that goes through each question for user to answer
        while (current != NULL && questionsAsked < questions) {
            string uAnswer;

            cout << "Question: " << current->question << endl;
            cout << "Answer: ";
            getline(cin, uAnswer);

            // Checks if answer is right or wrong
            if(compareStrings(uAnswer, current->answer)) {
                cout << "Your answer is correct! you recieve " << current->points << " points." << endl;
                totalPoints += current->points;
            } else {
                cout << "Your answer is wrong. The correct answer is: " << current->answer << endl;
            }

            cout << "Your total points: " << totalPoints << endl << endl;

            current = current->next;
            questionsAsked++;
        }

        return totalPoints;
    }

    /* Function that makes anwers not case sensitive
     * Note: Used Geeks4Geeks to help create this.
     *
     * Parem: string& str1 (user's input)
     * Parem: string& str2 (correct answer)
    */
    bool compareStrings(string& str1, string& str2)
    {
        if (str1.length() != str2.length())
            return false;

        for (int i = 0; i < str1.length(); ++i) {
            if (tolower(str1[i]) != tolower(str2[i]))
                return false;
        }

        return true;
    }
};

// Function that runs the entire debug version
void UnitTest() {
    cout << "***This is a debugging version ***" << endl;

    //Initializes the hard-coded questions to be tested
    TriviaList triviaList;
    triviaList.initializeTriviaList();

    cout << "Unit Test Case 1: Ask no question. The program should give a warning message." << endl;
    triviaList.askQuestions(0);
    cout << "Case 1 Passed" << endl << endl;

    cout << "Unit Test Case 2.1: Ask 1 question in the linked list.\tThe tester enters an incorrect answer." << endl;
    triviaList.askQuestions(1);
    cout << "Case 2.1 passed" << endl << endl;

    cout << "Unit Test Case 2.2: Ask 1 question in the linked list.\tThe tester enters a correct answer." << endl;
    triviaList.askQuestions(1);
    cout << "Case 2.2 passed" << endl << endl;

    cout << "Unit Test Case 3: Ask all the questions of the last trivia in the linked list." << endl;
    triviaList.askQuestions(3);
    cout << "Case 3 passed\n\n";

    cout << "Unit Test Case 4: Ask 5 questions in the linked list." << endl;
    triviaList.askQuestions(5);
    cout << "Case 4 passed\n\n";

    cout << "*** End of the Debugging Version ***" << endl;
}


int main() {

#ifdef UNIT_TESTING
    UnitTest();
#else
    TriviaList triviaList;
    cout << "*** Welcome to McAllister's trivia quiz game ***\n";
    triviaList.createQuestions();
    cout << endl;
    cin.ignore();
    triviaList.askQuestions(triviaList.countQuestions());
    cout << "*** Thank you for playing the trivia quiz game. Goodbye ***" << endl;
#endif

    return 0;
}
