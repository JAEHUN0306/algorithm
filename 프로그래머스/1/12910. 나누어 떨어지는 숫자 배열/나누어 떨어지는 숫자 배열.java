import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] % divisor == 0) {
                nums.add(arr[i]);
            }
        }
        Collections.sort(nums);
        if(nums.size() == 0) {
            return new int[]{-1};
        } else {
            return nums.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}