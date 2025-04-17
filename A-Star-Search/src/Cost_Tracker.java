import java.util.*;

//in this class we keep tabs on the cost of actions , the states and the path of the solution 
public class Cost_Tracker {
    private Map<String, String> cameFrom; // Map to store parent state for each state
    private Map<String, Integer> costSoFar; // Map to store the cost for each state

    public Cost_Tracker(String initialState) {
        this.cameFrom = new HashMap<>();
        this.costSoFar = new HashMap<>();
        costSoFar.put(initialState, 0); // Initialize the cost for the initial state
    }

    // Calculate the cost of the action taken
    public static int actionCost(String currentState, String neighbor) {
        int zeroIdxCurr = currentState.indexOf('0');
        int zeroIdxNeigh = neighbor.indexOf('0');
        if( Math.abs(zeroIdxCurr - zeroIdxNeigh) <= 2)
        	return 1;
        else
        	return 2;
    }

    // Update the cost and path for a neighboring state
    public void updateCostAndPath(String currentState, String neighbor, PriorityQueue<StateNode> queue) {
        int newCost = costSoFar.get(currentState) + actionCost(currentState, neighbor); // Calculate new cost for the neighboring state
        if (!costSoFar.containsKey(neighbor)) {   // If the neighbor state has not been visited 
            queue.offer(new StateNode(neighbor, Heuristics.calculate(neighbor) + newCost, newCost)); // Add neighbor state to the queue
            cameFrom.put(neighbor, currentState); // Update the parent state for the neighbor
            costSoFar.put(neighbor, newCost); // Update the cost for the neighbor state
        }
    }

    // Reconstruct the path from the initial state to the final state for printing reasons 
    public List<String> reconstructPath(String finalState) {
        List<String> path = new ArrayList<>();
        String currentState = finalState;
        while (currentState != null) {
            path.add(0, currentState);
            currentState = cameFrom.get(currentState);
        }
        return path;
    }

}
