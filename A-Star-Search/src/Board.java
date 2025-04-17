import java.util.*;
//on this class we define the set of moves and create the board of the game with the changes
public class Board {
    // Get neighborings states of the current state
    public static List<String> neighbors(String state) {
        List<String> neighborsStates = new ArrayList<>();
        int zeroIdx = state.indexOf('0'); // Find the index of the empty slot (0)
        int[] possibleMoves = {1,2,3};

        // Generate neighboring states by swapping the empty slot with adjacent slots
        for (int move : possibleMoves) {
            if (zeroIdx - move >= 0) {
                neighborsStates.add(swap(state, zeroIdx, zeroIdx - move));
            }
            if (zeroIdx + move < state.length()) {
                neighborsStates.add(swap(state, zeroIdx, zeroIdx + move));
            }
        }

        return neighborsStates;
    }

    // Swap two characters in the board 
    private static String swap(String state, int i, int j) {
        char[] chars = state.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }
}
