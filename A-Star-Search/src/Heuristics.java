public class Heuristics {
//on this class we calculate the heuristics for the game  
    public static int calculate(String state) {
        int count = 0;
        for (int i = 0; i < state.length(); i++) {
            if (state.charAt(i) == 'W' && state.substring(0, i).contains("B")) {
                count++;  
            }
        }
        return count;
    }

}
