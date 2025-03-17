import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0}; // 번호, 차례
        ArrayList<String> already = new ArrayList<>(); // 이미 나온 단어들
        
        // 첫 단어 처리
        already.add(words[0]);
        char last = words[0].charAt(words[0].length() - 1);
        
        for(int i = 1; i < words.length; i++) {
            // 현재 플레이어와 차례 계산
            int player = (i % n) + 1;
            int order = (i / n) + 1;
            
            // 끝말잇기 규칙 검사
            if(last != words[i].charAt(0) || already.contains(words[i])) {
                answer[0] = player;
                answer[1] = order;
                return answer;
            } else {
                last = words[i].charAt(words[i].length() - 1);
                already.add(words[i]);
            }
        }
        
        return answer; // 탈락자가 없으면 [0, 0] 반환
    }
}