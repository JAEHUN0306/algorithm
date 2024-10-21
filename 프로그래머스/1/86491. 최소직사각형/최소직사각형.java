import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        // (큰 거, 작은 거로 변경), 두 부분 중 가장 큰 값 두개를 선택해서 곱해준다.
        for(int i = 0; i < sizes.length; i++) {
                if (sizes[i][0] < sizes[i][1]) {
                    int temp = sizes[i][1];
                    sizes[i][1] = sizes[i][0];
                    sizes[i][0] = temp;
            }
            maxWidth = Math.max(maxWidth, sizes[i][0]);
            maxHeight = Math.max(maxHeight, sizes[i][1]);
        }
        
        
        return maxWidth*maxHeight;
    }
}