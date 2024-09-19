class Solution {
    public long[] solution(int x, int n) {
        long[] nums = new long[n];
        for(int i = 0; i < n; i++) {
            nums[i] = (long) x * (i + 1);
        }
        
        return nums;
    }
}