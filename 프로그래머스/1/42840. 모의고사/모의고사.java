import java.util.*;
class Solution {
   public int[] solution(int[] answers) {
       int[] first = {1,2,3,4,5};
       int[] second = {2,1,2,3,2,4,2,5};
       int[] third = {3,3,1,1,2,2,4,4,5,5};
       
       int[] count = new int[3];
       
       // 각 수포자별 정답 체크
       for(int i = 0; i < answers.length; i++) {
           if(answers[i] == first[i % first.length]) count[0]++;
           if(answers[i] == second[i % second.length]) count[1]++;
           if(answers[i] == third[i % third.length]) count[2]++;
       }
       
       // 최대 점수 찾기
       int max = Math.max(count[0], Math.max(count[1], count[2]));
       
       // 최대 점수를 받은 사람 수 계산
       int maxCount = 0;
       for(int i = 0; i < 3; i++) {
           if(count[i] == max) maxCount++;
       }
       
       // 결과 배열 생성
       int[] answer = new int[maxCount];
       int idx = 0;
       for(int i = 0; i < 3; i++) {
           if(count[i] == max) {
               answer[idx++] = i + 1;  // 수포자 번호는 1부터 시작
           }
       }
       
       return answer;
   }
}