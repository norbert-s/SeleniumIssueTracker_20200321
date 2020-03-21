# SeleniumIssueTracker_20200321

Fully working one

One of the projects one need to finish in order to get the back end certificate on freecodecamp.org is to develop an issue tracker.
the online version is here : https://issue-tracker-ns.herokuapp.com/

the github version can be found here : https://github.com/norbert-s/issuetracker

Part of the projects is to unit, functional, integration test the project which happens from the back end.
But as part of a personal project I documented the testing of the UI of the issue tracker (with testrail) and 
tested the UI fully (focusing on testing the functionality and not being concerned with what the font size was or how the tracker looked  like on a Samsung Galaxy S10,or the like). 
This project was to test the UI with selenium using Utility class, Page Object Model, Page Factory, properties -Data-driven, Key driven testing and Model based testing overall in Java. 

The first phase of the testing process was to lay out what was needed to be tested, which happened using testrail.
Then I moved on to write the tests exactly as I layed it out in the test plan.
Then tested the UI features of the issue tracker notably : 1. creation of new issues 2. update of issues 3. deletion of issues 4. querying the database.
This is the first phase.
In the second phase I am going to add:
1. a TestNG runner, or several testNG runners still.
2. in depth reporting and screenshots of failures, probably also screenshots of successfull tests in order to be able to take those screenshots and attach them as proof to testrail test cases and runs.
3. Jenkins
