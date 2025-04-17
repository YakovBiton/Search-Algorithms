// we represent every state in the game as a node 
public class StateNode  {
    public String state;
    public int priority;
    public int cost;

    public StateNode(String state, int priority, int cost) {
        this.state = state;
        this.priority = priority;
        this.cost = cost;
    }

	public String getState() {
		return state;
	}

	public int getPriority() {
		return priority;
	}
	

	public int getCost() {
		return cost;
	}

    
}
