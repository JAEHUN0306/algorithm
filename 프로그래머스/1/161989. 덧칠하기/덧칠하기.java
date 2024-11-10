class Solution {
    public int solution(int n, int m, int[] section) {
        int temp = section[0] + m - 1;
        int result = 1;
        for(int i = 0; i < section.length; i++) {
            if(section[i] <= temp) continue;
            else {
                result++;
                temp = section[i] + m - 1;
            }
        }
        return result;
    }
}