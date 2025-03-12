class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int time = 0; // 가격이 떨어지지 않은 시간
            
            for (int j = i + 1; j < n; j++) {
                time++; // 시간 증가
                
                if (prices[i] > prices[j]) {
                    // 가격이 떨어진 경우
                    break;
                }
            }
            
            answer[i] = time;
        }
        
        return answer;
    }
}