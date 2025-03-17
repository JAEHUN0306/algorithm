class Solution {
    public int solution(int[] arr) {
        // 배열의 첫 번째 원소로 결과 초기화
        int answer = arr[0];
        
        // 배열의 모든 원소에 대해 순차적으로 최소공배수 계산
        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    // 최대공약수(GCD) 구하는 함수
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    // 최소공배수(LCM) 구하는 함수
    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}