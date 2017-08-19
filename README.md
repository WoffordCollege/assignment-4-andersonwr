# COSC410 Assignment 4

## Tic Tac Toe
This project provides a terminal-based Tic Tac Toe game. The files here
are simply placeholders with ideas of where you might start. In the
end, your program must pass the Robot Framework acceptance tests in 
TicTacToeTests.robot.


## Building the Project
After you have cloned the repository, you should be able to navigate
to the directory containing the `gradle.build` file. There, you can
build the project by running the command

`gradlew build`

You can run the acceptance tests separately, if you like. 

`gradlew runrobot`

Finally, you can run the unit test coverage report.

`gradlew jacocoTestReport`

You can even do all of those things in one statement:

`gradlew build runrobot jacocoTestReport`

When you want to get rid of all of the temporary files (like compiled class files and such), you can say

`gradlew clean`

If you want to do a full build and reporting from a clean project, you can just string it all together:

`gradlew clean build runrobot jacocoTestReport`

And if you want to run the application you have created, you can say

`gradlew run`


## Structure
The directory structure that is assumed by Gradle (though it can be changed if you want) is as follows:

    project root     (root directory of project)
               |
                - build.gradle    (contains the instructions for the build tasks)
               |
                - src             (root directory of the source code; main and tests)
                    |
                     - main       (root directory of normal source code)
                    |     |
                    |      - java (all packages go here)
                    |           |
                    |            - edu    
                    |           |    |
                    |           |     - wofford (source code goes here)
                    |           |
                    |            - keywords (Robot Framework keyword code goes here)
                    |
                     - test       (root directory of test code, both unit and acceptance)
                          |
                           - acceptancetest    (all Robot Framework test files go here)
                          |
                           - java (all packages go here)
                                |
                                 - edu    
                                     |
                                      - wofford (unit test code goes here)

After you run `gradlew build`, a new `build` directory will automatically be created. This will contain all of the generated files (compiled class files, JAR files, reports, etc.). The most important things here are as follows:

`build/reports/tests/index.html`
: This file holds the results of all of the unit tests.

`build/reports/jacoco/test/html/index.html`
: This file holds the unit test code coverage results from Jacoco.

`build/robot-results/report.html`
: This file holds the Robot Framework test results.

`build/robot-results/debug.log`
: This file holds all of the debug information from the Robot Framework tests.

`build/libs/<name>.jar`
: This file (where *name* is specified in the jar settings of `gradle.build`) is the fully bundled code for the project. You can run this by saying
  `java -jar build/libs/<name>.jar`
  from the project root. This is what your end user would do to run your code (once you give them the JAR file). Remember that they will not have gradle installed, so `gradle run` is not an option.
