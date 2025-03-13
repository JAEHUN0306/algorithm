import java.util.*;
class Solution {
    public int[] solution(String s) {
        int zero = 0; // 삭제한 0
        int count = 0; // 실행 횟수
        while(!s.equals("1")) {
            zero += s.length() - s.replace("0", "").length(); // 0 갯수 +
            s = s.replace("0", ""); // 0 없애기
            s = Integer.toBinaryString(s.length()); // 이진 변환
            count++;
        }
        int[] result = new int[2];
        result[0] = count;
        result[1] = zero;
        return result;
    }
}