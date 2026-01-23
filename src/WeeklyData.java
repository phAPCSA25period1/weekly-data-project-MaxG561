/**
 * The WeeklyData class stores and analyzes a week's worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * or any other measurable daily value.
 */
public class WeeklyData {

    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    // TODO: Declare a private array to store the week's data
    //       Choose an appropriate type (double[] or int[])
    //       Create other instance variables as necessary
    
    private double[] data;  // array to store the 7 days of data
    


    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     */
    public WeeklyData(double[] input) {
        // TODO: (Optional) Check if input is null and handle appropriately
        // TODO: Create a new array with the same length as input
        // TODO: Copy each value from input into the internal data array
        // NOTE: Do NOT do this.data = input; (that would create aliasing)
        
        // Create a new array with the same length as input
        data = new double[input.length];
        
        // Copy each value from input into the internal data array (deep copy)
        for (int i = 0; i < input.length; i++) {
            data[i] = input[i];
        }
    }


    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        // TODO: Create a variable to store the running total
        // TODO: Use a loop to add each value in the array to the total
        // TODO: Return the total
        
        double total = 0.0;  // start with 0
        
        // Loop through each element and add to total
        for (int i = 0; i < data.length; i++) {
            total = total + data[i];
        }
        
        return total;
    }


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        // TODO: If the array length is 0, return 0.0
        // TODO: Otherwise, divide the total by the number of elements
        // Hint: You may call getTotal()
        
        // If array is empty, return 0.0
        if (data.length == 0) {
            return 0.0;
        }
        
        // Calculate average: total divided by number of days
        double average = getTotal() / data.length;
        
        return average;
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        // TODO: Assume the first value is the current maximum
        // TODO: Loop through the rest of the array and update max as needed
        // TODO: Return the maximum value found
        
        // Assume the first value is the current maximum
        double max = data[0];
        
        // Loop through the rest of the array
        for (int i = 1; i < data.length; i++) {
            // If we find a bigger value, update max
            if (data[i] > max) {
                max = data[i];
            }
        }
        
        return max;
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        // TODO: Assume the first value is the current minimum
        // TODO: Loop through the rest of the array and update min as needed
        // TODO: Return the minimum value found
        
        // Assume the first value is the current minimum
        double min = data[0];
        
        // Loop through the rest of the array
        for (int i = 1; i < data.length; i++) {
            // If we find a smaller value, update min
            if (data[i] < min) {
                min = data[i];
            }
        }
        
        return min;
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day's data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week's data
     */
    @Override
    public String toString() {
        // TODO: Create a StringBuilder
        // TODO: Loop through the data array
        // TODO: Append each value with a day label (Day 1, Day 2, etc.)
        // TODO: Return the completed String
        
        StringBuilder sb = new StringBuilder();
        
        // Loop through each value and add to the StringBuilder
        for (int i = 0; i < data.length; i++) {
            sb.append("Day " + (i + 1) + ": " + data[i] + "\n");
        }
        
        return sb.toString();
    }


    // -------------------------------------------------------------
    // getDailyBudgetStatus
    // -------------------------------------------------------------
    /**
     * Compares each day's data against a budget threshold and returns
     * a formatted string showing whether each day was under or over budget.
     *
     * @param budget the daily budget threshold to compare against
     * @return a formatted String showing budget status for each day
     */
    public String getDailyBudgetStatus(double budget) {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < data.length; i++) {
            sb.append("Day " + (i + 1) + ": $" + data[i]);
            
            if (data[i] > budget) {
                double overAmount = data[i] - budget;
                sb.append(" (OVER BUDGET by $" + String.format("%.2f", overAmount) + ")");
            } else if (data[i] < budget) {
                double underAmount = budget - data[i];
                sb.append(" (UNDER BUDGET by $" + String.format("%.2f", underAmount) + ")");
            } else {
                sb.append(" (ON BUDGET)");
            }
            
            sb.append("\n");
        }
        
        return sb.toString();
    }
}

