import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner input = new Scanner(System.in);// creates scanner to read user input
        
        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------
        System.out.println("=== DAILY BUDGET TRACKER ===");// prints program title
        System.out.println("This program tracks your daily spending for 7 days and provides weekly analysis.");
        System.out.println("It will help you understand your spending habits and stay within your budget.");
        System.out.println();// prints blank line for separation
        
        // Ask user for their daily budget goal
        System.out.print("What is your daily budget goal? $");// asks user for budget
        double dailyBudgetGoal = input.nextDouble();// stores user's budget goal
        System.out.println();
        
        // Display the goal back to the user
        System.out.println("Great! You've set a daily budget goal of $" + dailyBudgetGoal);
        System.out.println("Let's track your spending for this week!");
        System.out.println();


        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------
        double[] weekData = new double[7];// creates array to hold 7 days of spending


        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------
        for (int i = 0; i < 7; i++) { // loops through 7 days
            System.out.print("Enter spending for day " + (i + 1) + ": $");// asks for day's spending
            double spending = input.nextDouble();// stores user's input
            
            // Input validation: prevent negative values
            while (spending < 0) { // checks for invalid negative values
                System.out.println("Invalid amount! Spending cannot be negative.");
                System.out.print("Enter spending for day " + (i + 1) + ": $");
                spending = input.nextDouble();
            }
            
            weekData[i] = spending;// adds spending to array at current day
        }
        System.out.println();


        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------
        WeeklyData weeklyData = new WeeklyData(weekData);// creates WeeklyData object with our array


        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------
        System.out.println("=== WEEKLY SPENDING ANALYSIS ===");// prints section title
        System.out.println();
        
        System.out.println("Total spending for the week: $" + weeklyData.getTotal());// shows total
        System.out.println("Average daily spending: $" + String.format("%.2f", weeklyData.getAverage()));// shows average
        System.out.println("Minimum daily spending: $" + weeklyData.getMin());// shows minimum
        System.out.println("Maximum daily spending: $" + weeklyData.getMax());// shows maximum
        System.out.println();
        
        // Compare average to budget goal
        double averageSpending = weeklyData.getAverage();// stores average for later use
        System.out.println("=== BUDGET COMPARISON ===");
        if (averageSpending > dailyBudgetGoal) { // checks if over budget
            System.out.println("You exceeded your daily budget goal by $" + String.format("%.2f", averageSpending - dailyBudgetGoal) + " on average.");
        } else if (averageSpending < dailyBudgetGoal) { // checks if under budget
            System.out.println("You stayed under your daily budget goal by $" + String.format("%.2f", dailyBudgetGoal - averageSpending) + " on average.");
        } else {
            System.out.println("You exactly met your daily budget goal!");
        }
        System.out.println();


        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("=== DAILY BREAKDOWN ===");
        System.out.print(weeklyData.toString());// displays all 7 days of data
        System.out.println();


        // -------------------------------------------------------------
        // DAILY BUDGET STATUS
        // -------------------------------------------------------------
        System.out.println("=== DAILY BUDGET STATUS ===");
        System.out.println("Budget Goal: $" + dailyBudgetGoal);
        System.out.println();
        System.out.print(weeklyData.getDailyBudgetStatus(dailyBudgetGoal));// shows daily budget comparison


        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        // -------------------------------------------------------------
        System.out.println("=== WEEKLY INSIGHTS ===");
        
        if (averageSpending > dailyBudgetGoal) {
            System.out.println("You need to cut back on spending next week!");
            System.out.println("Tip: Review your largest expenses and look for areas to reduce.");
        } else if (averageSpending <= dailyBudgetGoal * 0.8) {
            System.out.println("Excellent job! You were very thrifty this week!");
            System.out.println("Tip: Consider putting some savings aside for future goals.");
        } else {
            System.out.println("You did well managing your budget this week!");
            System.out.println("Tip: Keep tracking your spending to maintain good habits.");
        }
        
        // Additional insight based on spending variation
        double spendingRange = weeklyData.getMax() - weeklyData.getMin();// calculates difference between max and min
        if (spendingRange > dailyBudgetGoal * 2) { // checks if spending varied a lot
            System.out.println("Notice: Your spending varied greatly between days. Try to be more consistent.");
        }
        
        System.out.println("=== DAILY BUDGET STATUS ===");
        System.out.println("Budget Goal: $" + dailyBudgetGoal);
        System.out.println();
        System.out.print(weeklyData.getDailyBudgetStatus(dailyBudgetGoal));
        
        input.close();// closes scanner to prevent memory leaks
    }
}

