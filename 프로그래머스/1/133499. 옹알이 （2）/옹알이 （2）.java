class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String str : babbling) {
            if(str.contains("ayaaya") || str.contains("yeye") || 
               str.contains("woowoo") || str.contains("mama")) {
                continue;
            }

            if(str.matches("^(aya|ye|woo|ma)+$")) {
                answer++;
            }
        }
        return answer;
    }
}