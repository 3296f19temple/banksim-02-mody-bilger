# BankSim

## Task 1 Race Condition
![Task 1 Diagram](Task_1.png)
<br />
The race condition may occur when multiple threads "override" each other when setting the deposit amount or the withdrawal amount. This can happen when, for instance, thread A withdraws $100 dollars and deposits it into thread B but at the same time thread C withdraws $100 dollars and deposits it into thread B as well. If they both are in the function to do the depositing (account.deposit()) into account C, and both obtain the current balance of $10,000, then they will each add $100 dollars to the current balance ($10,000) and will each individually set the output balance to $10,100. The actual account balance of account C should be $10,200 after these two deposits.

## Task 3 Race Condition
![Task 3 Diagram](Task_3.png)
<br />
The race condition that exists is due to the testing attempting to access the current balance of each individual account while the other threads are still transferring funds between accounts. This means that while one account balance is being read, another account can be transferring into it, therefore making the testing thread summation invalid. We removed this race condition by moving the testing to it's own thread (TestingThread.java) and forcing each other account to finish transferring before the testing will take place. This removed the race condition while allowing the testing thread to make sure that the bank was in balance.

## Requirements
The requirements for this lab project were to identify any and all existing race conditions in the given program, and then find ways of removing them, all while maintain parallelism throughout the program. We implemented everything that was asked in the project requirements. This includes but is not limited to; identifying the race condition existing in the deposit()/withdraw()/transfer() functions, identifying the race condition existing in the testing of the bank every N itterations of transfers, removing the two previous race conditions, maintaining a high level of parallelism, and using the GitHub repository as well as Trello project boards for communication throughout.

## Teamwork
The collaboration for this lab project consisted mainly of face-to-face and text messages. We used a Trello project board for keeping track of current branches and project progress. Below is a description of what each team member contributed towards the final lab project. It seems that both team members contributed equally to the end result of the project, and that no one person was more rapid than another when it came to the coding portions of the lab. The writing and tests were done mainly by Chris; however, both team members had input into what in being written. The work was revised by Tanmay to ensure that the code and written is as intended.

**Chris**: I completed the Tasks 1,3,5 of the lab project and wrote the unit tests for the project. The tasks were all completed in order and we switched every other task as per the lab assignment requirements.

**Tanmay**: I completed the Tasks 2 and 4 of the lab project. I also worked on parts of readme.md. We worked on alternate tasks. Since Chris started from task 1, I completed task 2 and task 4.

## Testing
The testing for this lab project consists of unit tests for the individual components; IE, the bank, the accounts, etc. All of the tests that were implemented in this lab project are automated and can be run using the NetBeans built in "Run Tests" functionality. We didn't discover bugs while doing the unit tests; however, the unit tests proved very helpful for building the program as we invisioned it in our heads. The tests were written by Chris, but, both all team members had input into them. All tests were commited after the code, but the code was removed prior to writting the tests to ensure test integrity.
