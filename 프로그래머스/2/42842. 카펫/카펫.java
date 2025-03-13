class Solution {
    public int[] solution(int brown, int yellow) {
        int width = 0; // 가로
        int height = 0; // 세로
        
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                height = i;
                width = yellow / i;
                
                // 갈색 테두리의 개수 계산 - 올바른 계산식
                if ((width * 2) + (height * 2) + 4 == brown) {
                    return new int[]{width + 2, height + 2};
                }
            }
        }
        
        return new int[]{width + 2, height + 2};
    }
}