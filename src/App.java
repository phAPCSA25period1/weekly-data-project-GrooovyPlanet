import java.util.Scanner;

/**
 * Budget Planner App
 * Tracks weekly spending and provides analysis.
 */
public class App {

    public static void main(String[] args) {

        // Create Scanner
        Scanner input = new Scanner(System.in);

        // Program introduction
        System.out.println("=====================================");
        System.out.println("        Weekly Budget Planner        ");
        System.out.println("=====================================");
        System.out.print("Enter your weekly budget goal: $");

        double budgetGoal = input.nextDouble();

        // Validate budget goal
        while (budgetGoal < 0) {
            System.out.print("Budget cannot be negative. Enter again: $");
            budgetGoal = input.nextDouble();
        }

        // Create array for 7 days
        double[] weekData = new double[7];

        // Collect spending for each day
        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter spending for day " + (i + 1) + ": $");
            double dailyAmount = input.nextDouble();

            while (dailyAmount < 0) {
                System.out.print("Spending cannot be negative. Enter again: $");
                dailyAmount = input.nextDouble();
            }

            weekData[i] = dailyAmount;
        }

        // Create WeeklyData object
        WeeklyData budgetWeek = new WeeklyData(weekData);

        // Display analysis
        System.out.println("\n========== Weekly Summary ==========");
        System.out.println("Total Spending: $" + budgetWeek.getTotal());
        System.out.println("Average Daily Spending: $" + budgetWeek.getAverage());
        System.out.println("Minimum Spending: $" + budgetWeek.getMin());
        System.out.println("Maximum Spending: $" + budgetWeek.getMax());

        // Display full week data
        System.out.println("\nDaily Breakdown:");
        System.out.println(budgetWeek.toString());

        // Budget insight
        System.out.println("\n========== Budget Insight ==========");

        double total = budgetWeek.getTotal();

        if (total > budgetGoal) {
            System.out.println("You went over your weekly budget.");
            System.out.println("Try reducing daily spending next week.");
        } 
        else if (total < budgetGoal * 0.75) {
            System.out.println("Great job! You stayed well under budget.");
        } 
        else {
            System.out.println("Nice work! You stayed within your budget.");
        }
    }
}
