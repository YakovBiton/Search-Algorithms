import java.util.*;

public class Game_Solver {
    //game solver class for solving the game with the A* algorithm 
    public Solution solve(String initialState) {
        Set<String> visited = new HashSet<>(); // Set Map for visited states
        PriorityQueue<StateNode> steps = new PriorityQueue<>(Comparator.comparingInt(s -> s.getCost() + Heuristics.calculate(s.getState()))); // make Priority queue with comparator that order the priority by cost + heuristic
        steps.offer(new StateNode(initialState, Heuristics.calculate(initialState), 0)); // Add the initial state at the start
        Cost_Tracker costTracker = new Cost_Tracker(initialState); // Initialize cost tracker

        // Iterate through the PriorityQueue
        while (!steps.isEmpty()) {
            StateNode currentNode = steps.poll(); // Get the state with the lowest cost
            String currentState = currentNode.getState();

            // If the heuristic equal 0 solution is found
            if (Heuristics.calculate(currentState) == 0) {
                return new Solution(costTracker.reconstructPath(currentState), currentNode.getCost());
            }

            // If the state hasn't been visited yet
            if (!visited.contains(currentState)) {
                visited.add(currentState);
                for (String neighbor : Board.neighbors(currentState)) { // Loop through the neighboring states
                    costTracker.updateCostAndPath(currentState, neighbor, steps);
                }
            }
        }
        return null; // return null if no solution found
    }
}
