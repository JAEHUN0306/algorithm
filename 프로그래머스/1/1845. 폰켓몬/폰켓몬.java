import java.util.*;
class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> types = new HashSet<>();
        
        for(int num: nums) {
            types.add(num);
        }
        
        return Math.min(types.size(), nums.length/2);
    }
}