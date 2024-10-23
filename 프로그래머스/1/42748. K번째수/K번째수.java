import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++) {
            int[] cut = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cut);
            result[i] = cut[commands[i][2]-1];
        }
        return result;
    }
}