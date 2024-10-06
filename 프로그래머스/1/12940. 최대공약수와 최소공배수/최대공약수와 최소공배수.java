class Solution {
    public int[] solution(int n, int m) {
        
        int cross = n * m;
        while(m != 0) {
            int temp = m;
            m = n % m;
            n = temp;
        }
        int[] answer = {n, cross / n};
        
        return answer;
            
    }
}