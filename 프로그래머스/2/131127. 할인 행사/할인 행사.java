import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        // 원하는 제품과 수량을 맵에 저장
        Map<String, Integer> wantMap = new HashMap<>();
        for(int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        
        int answer = 0;
        
        // 슬라이딩 윈도우 사용
        for(int i = 0; i <= discount.length - 10; i++) {
            // 현재 윈도우의 제품 수량을 맵에 저장
            Map<String, Integer> windowMap = new HashMap<>();
            for(int j = 0; j < 10; j++) {
                String item = discount[i + j];
                windowMap.put(item, windowMap.getOrDefault(item, 0) + 1);
            }
            
            // 원하는 제품과 수량이 모두 일치하는지 확인
            boolean isValid = true;
            for(String item : wantMap.keySet()) {
                if(windowMap.getOrDefault(item, 0) < wantMap.get(item)) {
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) {
                answer++;
            }
        }
        
        return answer;
    }
}