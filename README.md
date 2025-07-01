# Comparing Knapsacks Experiment
**Purpose**: To practice and demonstrate proficiency in creating brute force, greedy, and dynamic programming algorithms for the fractional knapsack problem and the 01 Knapsack problem using Java.

To run the program, after cloning, run src/Knapsack01/Main.java for the Knapsack 01 Problem and src/FractionalKnapsack/Main.java for the Fractional Knapsack problem. Charts will be displayed in addition to output in the terminal. To see just the charts, run src/Charts/Main.java.

Do note that to run the charts, you need the library xchart. Download the jar file from https://knowm.org/open-source/XChart/.
Then, in IntelliJ, go to Project Structure > Libraries
Click the + icon and search for knowm.xchart, select the most recent version of xchart.
You should now be able to run the charts.

## Summary
For this project, in a team of four, we implemented brute force, greedy, and dynamic programming solutions for the 01 Knapsack Problem and the Fractional Knapsack Problem. We then compared their execution times using chart visualizations with the library xchart to demonstrate the benefit of greedy and dynamic programming solutions compared to the slower brute force solutions. 

My primary role was to work on file processing. This involved creating multiple CSV / text files containing random numbers of different lengths using Java's file processing capabilities, creating a class containing static methods to read those files, as well as a Knapsack and Item class. These files are contained in the KnapsackItems package.
I also implemented the brute force solution for the fractional knapsack problem using a slower recursive solution to demonstrate the cost of the brute force solution compared to more efficient solutions.
Finally, I completed documentation, including JavaDocs, this README, collaborating on the UML design, and writing portions of the analysis for the final paper.

**Brute Force**: A trial and error method used to find solutions through exhaustive effort. In other words, running through all possible choices to find the most optimal solution. 

**Greedy**: We can find a globally optimal solution by choosing the locally optimal solution, called the greedy choice. In other words, choosing the option that looks best in the current position, without consideration to the results from subproblems.

**Dynamic Programming**: Like divide-and-conquer, dynamic programming solves problems by combining the solutions to sub-problems. This is especially useful when sub-problems share sub-problems.

In addition to the coding, we developed a final report that details the design and results.

## Designing the Experiment
We created a UML document to organize the software.
![image](https://github.com/user-attachments/assets/0692cfda-cdc0-412e-971d-c7c7ccf6c754)

We used an existing CSV file for data input. We also created 3 additional input files, filling them with random values of sizes 20, 25, and 30, using Java file processing. These files were ingested once for each iteration being tested.

Execution time was measured in microseconds (nanoseconds / 1000 or one millionth of a second).

Output includes printing to the terminal when the main program is run, including:
* Knapsack Number
* Knapsack Capacity
* Printout of Values
* Printout of Weights
* Best value for Brute Force
* Best value for Dynamic Programming
* Best value for Greedy Algorithm

## Illustrating and Analyzing Results
When the main program is run, in addition to printing to the terminal, charts will be displayed, visualizing the results. These can be seen in the final report as well. The final report also includes information on the empirical and theoretical results.

JavaDoc was used to document the classes, methods, and interfaces.

For further information on the project, please feel free to view the final report [here](https://docs.google.com/document/d/1GFoTamd9mQrrIp_Rdjvust02MfC1O2qJq6QPe1RsoIU/edit?usp=sharing) or download the Word document from the repo.
