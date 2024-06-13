# include <iostream>
# include <stdlib.h>
# include <assert.h>
# include <ctime>
using namespace std;

//pause function
void Press_any_key(void);

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
const int charlieAccuracy = 100;

//Global Variables
bool aaronAlive = true;
bool bobAlive = true;
bool charlieAlive = true;
int aaronWins1 = 0;
int bobWins = 0;
int charlieWins = 0;
int aaronWins2 = 0;

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

    //Run Strategy 1 a total of 10,000 times
    cout << "ready to test strategy 1 (run 10000 times):\n";
    Press_any_key();
    for (int i = 0; i < TOTAL_RUN; i++) {
        charlieAlive = true;
        bobAlive = true;
        aaronAlive = true;
        /*while (at_least_two_alive(aaronAlive, bobAlive, charlieAlive)) {
            if (aaronAlive && at_least_two)
        }*/
    }



    return 0;
}
