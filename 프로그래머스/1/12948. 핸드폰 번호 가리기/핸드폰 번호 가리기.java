class Solution {
    public String solution(String phone_number) {
        StringBuilder sb = new StringBuilder();
        
        char[] nums = phone_number.toCharArray();
        for(int i = 0; i < nums.length - 4 ; i++) {
            sb.append("*");
        }
        
        for(int i = nums.length -4 ; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        
        return sb.toString();
        
    }
}