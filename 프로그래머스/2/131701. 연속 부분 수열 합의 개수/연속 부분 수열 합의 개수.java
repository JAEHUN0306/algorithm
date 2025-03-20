import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> uniqueSums = new HashSet<>();
        
        // 원형 수열의 모든 부분 수열 합 구하기
        for (int start = 0; start < n; start++) {
            int sum = 0;
            for (int length = 1; length <= n; length++) {
                // 원형 수열이므로 인덱스가 배열 범위를 넘어갈 경우 모듈로 연산으로 처리
                int idx = (start + length - 1) % n;
                sum += elements[idx];
                uniqueSums.add(sum);
            }
        }
        
        return uniqueSums.size();
    }
}