public class AStarMain {
	//the main function for activation
	 public static void main(String[] args) {
	        String initialState = "BBB0WWW";
	        Game_Solver game = new Game_Solver();
	        Solution game_solution = game.solve(initialState);

	        if (game_solution != null) {
	        	game_solution.printSolution();
	        } else {
	            System.out.println("No solution found.");
	        }
	    }
}
