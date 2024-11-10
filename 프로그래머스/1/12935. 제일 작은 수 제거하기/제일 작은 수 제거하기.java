import java.util.*;
class Solution {
    public int[] solution(int[] arr) {
        if(arr.length <= 1) return new int[]{-1};
        
        ArrayList<Integer> nums = new ArrayList<>();
        int min = arr[0];
        
        for(int i = 0; i < arr.length; i++) {
            if(min > arr[i]) {
                min = arr[i];
            }
        }
        
        for(int i = 0; i < arr.length; i++) {
            if(min != arr[i]) {
                nums.add(arr[i]);
            }
        }
        
        return nums.stream().mapToInt(i -> i).toArray();
    }
}