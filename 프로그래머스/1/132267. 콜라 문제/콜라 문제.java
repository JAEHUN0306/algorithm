class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        //a개 -> b개
        while(n >= a){
            answer += (n / a) * b;
            n = n % a + (n / a) * b;
        }
        
        return answer;
    }
}