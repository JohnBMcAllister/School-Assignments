/* FILE NAME: project1_McAllister_jbm0118.cpp
 * AUTHOR: John McAllister
 * DESCRIPTION: COMP 2710 Project 1
 * COMPILE: g++ project1_McAllister_jbm0118.cpp -o project1.out
 */

#include <iostream>
using namespace std;

int main() {
  // VARIABLE INITIALIZATION
  double loan = 0.0;
  double interestRate = 0.0;
  double interestRateC = 0.0;
  double monthlyPaid = 0.0;
  int currentMonth = 0;
  double interestTotal = 0.0;
  double monthlyInterest = 0.0;

  // Currency Format
  cout.setf(ios::fixed);
  cout.setf(ios::showpoint);
  cout.precision(2);

  // USER INPUT
  // NOTE: For valid input, the loan, interest, and monthly payment must
  // be positive. The monthly payment must also be large enough to
  // terminate the loan.

  // a loop that will not break until loan is valid
  while (loan <= 0) {
    cout << "\nLoan Amount: ";
    cin >> loan;
  }

  // A loop that will not break until interest is valid
  while (interestRate <= 0) {
    cout << "Interest Rate (% per year): ";
    cin >> interestRate;
  }

  // GET PROPER INTEREST RATES FOR CALCULATIONS
  interestRate /= 12;
  interestRateC = interestRate / 100;

  // A loop that will not break untill monthly payment is valid
  while (monthlyPaid < (interestRateC * loan)){
  cout << "Monthly Payments: ";
  cin >> monthlyPaid;
  }

  cout << endl;

  // AMORTIZATION TABLE
  cout << "*****************************************************************\n"
       << "\tAmortization Table\n"
       << "*****************************************************************\n"
       << "Month\tBalance\t\tPayment\tRate\tInterest\tPrincipal\n";

    // LOOP TO FILL TABLE
    while (loan > 0) {
      if (currentMonth == 0) {
        cout << currentMonth++ << "\t$" << loan;
        if (loan < 1000) cout << "\t";
      cout << "\t" << "N/A\tN/A\tN/A\t\tN/A\n";
              }
      else {

        // Calculate the monthly interest and adds to toal interest
        monthlyInterest = loan * interestRateC;
        interestTotal += monthlyInterest;

        // Calculate Loan after payment
        loan = (loan * (1 + interestRateC)) - monthlyPaid;
        // Validates if loan is paid off
        if (loan < 0) {
          monthlyPaid += loan;
          loan = 0;
        }

        // Print row of table
        cout << currentMonth++ << "\t$" << loan << "\t";
        if (loan < 1000) cout << "\t";
        cout << "$" << monthlyPaid << "\t" << interestRate 
          << "\t$" << monthlyInterest << "\t\t$" << monthlyPaid - monthlyInterest << endl;
      }
    }

  cout << "****************************************************************\n";
  cout << "\nIt takes " << --currentMonth << " months to pay off the loan.\n"
     << "Total interest paid is: $" << interestTotal;
  cout << endl << endl;

  // Returns 0 to confirm program ran successfully
  return 0;
}

