import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int result = 0;
        Integer[] nums = Arrays.stream(score).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, Collections.reverseOrder());
      
        for (int i = 0; i <= nums.length - m; i += m) {
            // m개씩 묶은 후 가장 작은 값(nums[i + m - 1])을 기준으로 계산
            result += Math.min(k, nums[i + m - 1]) * m;
        }
        return result;
    }
}