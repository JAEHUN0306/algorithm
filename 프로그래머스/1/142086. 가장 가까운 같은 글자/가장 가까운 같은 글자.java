import java.util.*;
class Solution {
    public int[] solution(String s) {
// for문을 돌면서 charAt으로 한글자씩 때서 맵에 추가할건데, 결과와, 현재 위치를 맵에 (키,값)으로 추가할거임.
// 추가 할때마다 맵 키에 이미 키로 있으면 -> 현재 위치 - 그 키의 값을 배열에 저장하고, 키의 값을 현재 위치로 저장할거임.
// 없으면 -1을 배열에 저장하고 키의 값을 현재 위치로 저장할거임.
        HashMap<Character, Integer> map = new HashMap<>();
        int[] result = new int[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                result[i] = i - map.get(c);
            } else {
                result[i] = -1;
            }
            
            map.put(c, i);
        }
        return result;
    }
}