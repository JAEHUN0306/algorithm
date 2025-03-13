class Solution {
    public int solution(int n) {
        int answer = n + 1;
        while(one(n) != one(answer)){
            answer++;
        } 
        return answer;
    }
    
    public int one(int n) {
        String s = Integer.toBinaryString(n);
        return s.replace("0", "").length();
    }
    
}