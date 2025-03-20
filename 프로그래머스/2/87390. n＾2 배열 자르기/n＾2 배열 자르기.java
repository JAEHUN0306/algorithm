import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        // 결과 배열의 크기 계산
        int size = (int)(right - left + 1);
        int[] result = new int[size];
        
        // left부터 right까지의 인덱스에 해당하는 값을 직접 계산
        for (int i = 0; i < size; i++) {
            long index = left + i;
            int row = (int)(index / n); // 행 번호 (0부터 시작)
            int col = (int)(index % n); // 열 번호 (0부터 시작)
            
            // (row, col) 위치의 값은 max(row, col) + 1
            // row와 col 중 더 큰 값 + 1이 해당 위치의 값
            result[i] = Math.max(row, col) + 1;
        }
        
        return result;
    }
}