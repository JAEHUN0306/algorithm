import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        
        // 다리를 0으로 초기화 (다리 길이만큼)
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int time = 0;
        int currentWeight = 0;
        int truckIndex = 0;
        
        // 모든 트럭이 다리를 건널 때까지 반복
        while (truckIndex < truck_weights.length || currentWeight > 0) {
            // 시간 증가
            time++;
            
            // 다리 맨 앞의 트럭이 빠져나감
            int frontTruck = bridge.poll();
            currentWeight -= frontTruck;
            
            // 아직 처리할 트럭이 남아있으면
            if (truckIndex < truck_weights.length) {
                // 다음 트럭이 다리에 올라갈 수 있는지 확인
                if (currentWeight + truck_weights[truckIndex] <= weight) {
                    // 트럭을 다리에 올림
                    bridge.add(truck_weights[truckIndex]);
                    currentWeight += truck_weights[truckIndex];
                    truckIndex++;
                } else {
                    // 못 올리면 0을 넣어서 다리 길이 유지
                    bridge.add(0);
                }
            } else {
                // 더 이상 트럭이 없지만 다리 길이 유지를 위해 0 추가
                bridge.add(0);
            }
        }
        
        return time;
    }
}