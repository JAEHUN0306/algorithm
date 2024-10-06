class Solution {
    public String solution(String s) {
        if(s.length() % 2 == 1) { // 홀수
            return s.charAt(s.length()/2) + "";
        } else { // 짝수
            return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        }
    }
}