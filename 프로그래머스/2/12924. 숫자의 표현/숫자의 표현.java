class Solution {
    public int solution(int n) {
        int sum = 0;
        int start = 1;
        int answer = 0;
        
        for(int end = 1; end <= n; end++) {
            sum += end;
            while(sum > n) {
                sum -= start;
                start++;
            }
            
            if(sum == n) {
                answer++;
            }
        }
        return answer;
    }
}