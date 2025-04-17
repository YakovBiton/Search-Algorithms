import java.util.List;
//this class purpose is to create the solution element print it properly 
public class Solution {
    public List<String> path; 
    public int cost;

    public Solution(List<String> path, int cost) {
        this.path = path;
        this.cost = cost;
    }

 

    // Method to print the solution, including the path and cost
    public void printSolution() {
        int totalCost = 0;
        for (int i = 0; i < path.size(); i++) {
            String state = path.get(i);
            if (i > 0) {
                int zeroIdx = state.indexOf('0');
                int prevZeroIdx = path.get(i - 1).indexOf('0');
                String action = "Switching '" + path.get(i - 1).charAt(zeroIdx) + "' in index " + zeroIdx + " and blank in index " + prevZeroIdx;
                System.out.println(action);
                System.out.println(i + ". " + state);
                int cost = Cost_Tracker.actionCost(state, path.get(i - 1));
                totalCost += cost;
                System.out.println("cost of this action is: " + cost);
                System.out.println("Total cost so far is: " + totalCost);
                System.out.println();
            } else {
                System.out.println(i + ". initial state :   " + state);
                System.out.println();
            }
        }
        System.out.println("\nSolution found, lowest possible cost is: " + cost);
    }
}
