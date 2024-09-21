class Solution {
    public int solution(int[] numbers) {
        int result = 45;// 0~ 9까지의 합 = 45
        for(int i = 0; i < numbers.length; i++) {
            result -= numbers[i];
        }
        
        return result;
    }
}