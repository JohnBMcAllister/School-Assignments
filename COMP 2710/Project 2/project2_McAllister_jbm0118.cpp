# include <iostream>
# include <stdlib.h>
# include <assert.h>
# include <ctime>
using namespace std;

//pause function
void Press_any_key(void) {
    std::cout << "Press Enter to continue...";
    std::cin.ignore().get(); // Pause Terminal
}

//spins wheel for shot
bool result_target_shot(int probability);

//Test Prototypes
void test_at_least_two_alive(void);
void test_Aaron_shoots1(void);
void test_Bob_shoots(void);
void test_Charlie_shoots(void);
void test_Aaron_shoots2(void);

// Constant Variables
const int TOTAL_RUN = 10000;
const int aaronAccuracy = 33;
const int bobAccuracy = 50;

//Global Variables
bool aaronAlive = true;
bool bobAlive = true;
bool charlieAlive = true;
int aaronWins1 = 0;
int bobWins = 0;
int charlieWins = 0;
int aaronWins2 = 0;

bool at_least_two_alive(bool A_alive, bool B_alive, bool C_alive) {
    return ((A_alive && B_alive) || (B_alive && C_alive) || (A_alive && C_alive));
}
/* Input: A_alive indicates whether Aaron is alive */
/* B_alive indicates whether Bob is alive */
/* C_alive indicates whether Charlie is alive */
/* Return: true if at least two are alive */
/* otherwise return false */

void Aaron_shoots1(bool& B_alive, bool& C_alive) {
    assert(aaronAlive == true);
    bool shot = result_target_shot(aaronAccuracy);
    if (shot && C_alive) {
        C_alive = false;
        return;
    }
    if (shot && B_alive) {
        B_alive = false;
        return;
    }
}
/* Strategy 1: Use call by reference
* Input: B_alive indicates whether Bob alive or dead
* C_alive indicates whether Charlie is alive or dead
* Return: Change B_alive into false if Bob is killed.
* Change C_alive into false if Charlie is killed.
*/

void Bob_shoots(bool& A_alive, bool& C_alive) {
    assert(bobAlive == true);
    bool shot = result_target_shot(bobAccuracy);
    if (shot && C_alive) {
        C_alive = false;
        return;
    }
    if (shot && A_alive) {
        A_alive = false;
        return;
    }
}
    /* Call by reference
    * Input: A_alive indicates if Aaron is alive or dead
    * C_alive indicates whether Charlie is alive or dead
    * Return: Change A_alive into false if Aaron is killed.
    * Change C_alive into false if Charlie is killed.
    */

void Charlie_shoots(bool& A_alive, bool& B_alive) {
    assert(charlieAlive == true);
    if (B_alive) {
        B_alive = false;
        return;
    }
    if (A_alive) {
        A_alive = false;
        return;
    }
}
/* Call by reference
* Input: A_alive indicates if Aaron is alive or dead
* B_alive indicates whether Bob is alive or dead
* Return: Change A_alive into false if Aaron is killed.
* Change B_alive into false if Bob is killed.
*/

void Aaron_shoots2(bool& B_alive, bool& C_alive) {
    assert(aaronAlive == true);
    bool shot;

    if(C_alive && B_alive) {
        shot = false;
    } else {
        shot = result_target_shot(aaronAccuracy);
    }

    if (shot && C_alive) {
        C_alive = false;
        return;
    }
    if (shot && B_alive) {
        B_alive = false;
    }
}
/* Strategy 2: Use call by reference
* Input: B_alive indicates whether Bob alive or dead
* C_alive indicates whether Charlie is alive or dead
* Return: Change B_alive into false if Bob is killed.
* Change C_alive into false if Charlie is killed.
*/

bool result_target_shot(int probability) {
    int result = rand()%100;
    return result <= probability;
}

//Test Functions
void test_at_least_two_alive(void) {
    // First Case
	cout << "\tCase 1: Aaron alive, Bob alive, Charlie alive\n";
	assert(true == at_least_two_alive(true, true, true));
	cout << "\tCase passed ...\n";
	// Second Case
	cout << "\tCase 2: Aaron dead, Bob alive, Charlie alive\n";
	assert(true == at_least_two_alive(false, true, true));
	cout << "\tCase passed ...\n";
	// Third Case
	cout << "\tCase 3: Aaron alive, Bob dead, Charlie alive\n";
	assert(true == at_least_two_alive(true, false, true));
	cout << "\tCase passed ...\n";
	// Fourth Case
	cout << "\tCase 4: Aaron alive, Bob alive, Charlie dead\n";
	assert(true == at_least_two_alive(true, true, false));
	cout << "\tCase passed ...\n";
	// Fifth Case
	cout << "\tCase 5: Aaron dead, Bob dead, Charlie alive\n";
	assert(false == at_least_two_alive(false, false, true));
	cout << "\tCase passed ...\n";
	// Sixth Case
	cout << "\tCase 6: Aaron dead, Bob alive, Charlie dead\n";
	assert(false == at_least_two_alive(false, true, false));
	cout << "\tCase passed ...\n";
	// Seventh Case
	cout << "\tCase 7: Aaron alive, Bob dead, Charlie dead\n";
	assert(false == at_least_two_alive(true, false, false));
	cout << "\tCase passed ...\n";
	// Eighth Case: All dead
	cout << "\tCase 8: Aaron dead, Bob dead, Charlie dead\n";
	assert(false == at_least_two_alive(false, false, false));
	cout << "\tCase passed ...\n";
}

void test_Aaron_shoots1(void) {
    cout << "Unit Testing 2: Function Aaron_shoots1(Bob_alive, Charlie_alive)\n";

    //First Case: Bob alive, Charlie alive
    cout << "\tCase 1: Bob alive, Charlie alive\n"
         << "\t\tAaron is shooting at Charlie\n";

    Aaron_shoots1(bobAlive, charlieAlive);
	assert(true == bobAlive);

    // Second Case: Bob dead, Charlie alive
	bobAlive = false, charlieAlive = true;
	cout << "\tCase 2: Bob dead, Charlie alive\n"
		 << "\t\tAaron is shooting at Charlie\n";
	Aaron_shoots1(bobAlive, charlieAlive);

	// Third Case: Bob alive, Charlie dead
	bobAlive = true, charlieAlive = false;
	cout << "\tCase 3: Bob alive, Charlie dead\n"
		 << "\t\tAaron is shooting at Bob\n";
	Aaron_shoots1(bobAlive, charlieAlive);
}

void test_Bob_shoots() {
    cout << "Unit Testing 3: Function Bob_shoots(Aaron_alive, Charlie_alive)\n";

    // First Case: Aaron alive, Charlie alive
    aaronAlive = true;
    charlieAlive = true;
    cout << "\tCase 1: Aaron alive, Charlie alive\n"
         << "\t\tBob is shooting at Charlie\n";
    Bob_shoots(aaronAlive, charlieAlive);

    // Second Case: Aaron dead, Charlie alive
    aaronAlive = false;
    charlieAlive = true;
    cout << "\tCase 2: Aaron dead, Charlie alive\n"
         << "\t\tBob is shooting at Charlie\n";
    Bob_shoots(aaronAlive, charlieAlive);

    // Third Case: Aaron alive, Charlie dead
    aaronAlive = true;
    charlieAlive = false;
    cout << "\tCase 3: Aaron alive, Charlie dead\n"
         << "\t\tBob is shooting at Aaron\n";
    Bob_shoots(aaronAlive, charlieAlive);
}

void test_Charlie_shoots(){
    cout << "Unit Testing 4: Function Charlie_shoots(Aaron_alive, Bob_alive)\n";


    bool aaron_a = true, bob_a = true;
    cout << "\tCase 1: Aaron alive, Bob alive\n"
         << "\t\tCharlie is shooting at Bob\n";
    Charlie_shoots(aaron_a, bob_a);
    assert(false == bob_a && true == aaron_a);


    aaron_a = false, bob_a = true;
    cout << "\tCase 1: Aaron dead, Bob alive\n"
         << "\t\tCharlie is shooting at Bob\n";
    Charlie_shoots(aaron_a, bob_a);
    assert(false == bob_a && false == aaron_a);


    aaron_a = true, bob_a = false;
    cout << "\tCase 3: Aaron alive, Bob dead\n"
         << "\t\tCharlie is shooting at Aaron\n";
    Charlie_shoots(aaron_a, bob_a);
    assert(false == aaron_a && false == bob_a);
}

void test_Aaron_shoots2(){
    cout << "Unit Testing 5: Function Aaron_shoots2(Bob_alive, Charlie_alive)\n";

    // First Case: Bob alive, Charlie alive
    bool bobAlive = true, charlieAlive = true;
    cout << "\tCase 1: Bob alive, Charlie alive\n"
         << "\t\tAaron intentionally misses his first shot\n"
         << "\t\tBoth Bob and Charlie are alive.\n";
    Aaron_shoots2(bobAlive, charlieAlive);
    assert(bobAlive == true && charlieAlive == true);

    // Second Case: Bob dead, Charlie alive
    bobAlive = false, charlieAlive = true;
    cout << "\tCase 2: Bob dead, Charlie alive\n"
         << "\t\tAaron is shooting at Charlie\n";
    Aaron_shoots2(bobAlive, charlieAlive);

    // Third Case: Bob alive, Charlie dead
    bobAlive = true, charlieAlive = false;
    cout << "\tCase 3: Bob alive, Charlie dead\n"
         << "\t\tAaron is shooting at Bob\n";
    Aaron_shoots2(bobAlive, charlieAlive);
}

int main() {
    //Start the duel
    cout << "*** Welcome to McAllister's Duel Simulator ***\n";

    //Initialize Random number generator seed
    srand(time(0));

    //Initialize the test functions
    test_at_least_two_alive();
    Press_any_key();
    test_Aaron_shoots1();
    Press_any_key();
    test_Bob_shoots();
    Press_any_key();
    test_Charlie_shoots();
    Press_any_key();
    test_Aaron_shoots2();
    Press_any_key();

    //Run Strategy 1 a total of 10,000 times
    cout << "ready to test strategy 1 (run 10000 times):\n";
    Press_any_key();
    for (int i = 0; i < TOTAL_RUN; i++) {
        charlieAlive = true;
        bobAlive = true;
        aaronAlive = true;
        while (at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
            if (aaronAlive && at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
                Aaron_shoots1(bobAlive, charlieAlive);
            }
            if (bobAlive && at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
                Bob_shoots(aaronAlive, charlieAlive);
            }
            if (charlieAlive && at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
                Charlie_shoots(aaronAlive, bobAlive);
            }
        }
        if (aaronAlive) {
            aaronWins1++;
        }
        if (bobAlive) {
            bobWins++;
        }
        if (charlieAlive) {
            charlieWins++;
        }
    }

    cout << "Aaron won " << aaronWins1 << "/10000 duels or " << static_cast<double>(aaronWins1) / TOTAL_RUN * 100 << "%\n"
         << "Bob won " << bobWins << "/10000 duels or " << static_cast<double>(bobWins) / TOTAL_RUN * 100 << "%\n"
         << "Charlie won " << charlieWins << "/10000 duels or " << static_cast<double>(charlieWins) / TOTAL_RUN * 100 << "%\n"
         << endl;

    //Restart Simulation for Strategy 2
    aaronWins2 = 0;
    bobWins = 0;
    charlieWins = 0;
    srand(time(0));
    cout << "Ready to test strategy 2 (run 10000 times);\n";
    Press_any_key();
    for (int i = 0; i < TOTAL_RUN; i++) {
        charlieAlive = true;
        bobWins = true;
        aaronAlive = true;
        while (at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
            if (aaronAlive && at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
                Aaron_shoots2(bobAlive, charlieAlive);
            }
            if (bobAlive && at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
                Bob_shoots(aaronAlive, charlieAlive);
            }
            if (charlieAlive && at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
                Charlie_shoots(aaronAlive, bobAlive);
            }
        }
        if (aaronAlive) {
            aaronWins2++;
        }
        if (bobAlive) {
            bobWins++;
        }
        if (charlieAlive) {
            charlieWins++;
        }
    }

    cout << "Aaron won " << aaronWins2 << "/10000 duels or " << static_cast<double>(aaronWins2) / TOTAL_RUN * 100 << "%\n"
         << "Bob won " << bobWins << "/10000 duels or " << static_cast<double>(bobWins) / TOTAL_RUN * 100 << "%\n"
         << "Charlie won " << charlieWins << "/10000 duels or " << static_cast<double>(charlieWins) / TOTAL_RUN * 100 << "%\n"
         << endl;

    if (aaronWins1 > aaronWins2) {
        cout << "Strategy 1 is better than strategy 2.\n";
    } else {
        cout << "Strategy 2 is better than strategy 1.\n";
    }
    return 0;
}
