import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int count = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        Map<String, Integer> windowMap = new HashMap<>();
        for(int i = 0; i < 10; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
        }
        if(isValid(wantMap, windowMap)) count++;
        
        for(int i = 10; i < discount.length; i++) {
            windowMap.put(discount[i], windowMap.getOrDefault(discount[i], 0) + 1);
            windowMap.put(discount[i - 10], windowMap.getOrDefault(discount[i - 10], 0) - 1);
            if(isValid(wantMap, windowMap)) count++;
        }
        return count;
    }
    
    public boolean isValid(Map<String, Integer> map1, Map<String, Integer> map2) {
        for(String s : map1.keySet()) {
            if(map2.getOrDefault(s, 0) < map1.get(s)) {
                return false;
            }
        }
        return true;
    }
}