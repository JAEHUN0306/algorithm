import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        // nums 에는 문자열로 된 숫자들이 들어가있음.
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2+o1).compareTo(o1+o2);
            }
        });
        // 0만 있는 경우
        if (nums[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for (String s : nums) {
            sb.append(s);
        }
        return sb.toString();
    }
}