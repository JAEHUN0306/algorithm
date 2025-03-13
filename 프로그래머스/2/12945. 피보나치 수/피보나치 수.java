class Solution {
    public int solution(int n) {
        int[] fibo = new int[100001];
        fibo[1] = 1;
        fibo[2] = 1;
        for(int i = 3; i < 100001; i++) {
            fibo[i] = (fibo[i - 2] + fibo[i - 1]) % 1234567;
        }
        return fibo[n];
    }
}