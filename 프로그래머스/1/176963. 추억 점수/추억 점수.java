import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> yearnMap = new HashMap<>();
        int[] result = new int[photo.length];
        for(int i = 0; i < name.length; i++) {
            yearnMap.put(name[i], yearning[i]);
        }
        
        for(int i = 0; i < photo.length; i++) {
            int score = 0;
            for(int j = 0; j < photo[i].length; j++) {
                score += yearnMap.getOrDefault(photo[i][j], 0);
            }
            result[i] = score;
        }
        return result;
    }
}