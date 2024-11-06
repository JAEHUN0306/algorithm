import java.util.*;
class Solution {
    public int solution(int[] nums) {
        int result = 0;
        
        // 3개의 숫자를 골라 더한 후 바로 소수인지 판별
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime(sum)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }
        return true;
    }
}