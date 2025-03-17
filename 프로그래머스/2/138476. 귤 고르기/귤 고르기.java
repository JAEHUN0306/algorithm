import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        ArrayList<Integer> frequencies = new ArrayList<>(map.values());
        Collections.sort(frequencies, Collections.reverseOrder());
        
        int count = 1;
        for(Integer i : frequencies) {
            if(k - i > 0) {
                k -= i;
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}