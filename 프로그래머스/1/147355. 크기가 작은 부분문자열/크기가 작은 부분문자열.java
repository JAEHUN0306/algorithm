import java.util.*; 

class Solution {
    public int solution(String t, String p) {
        int result = 0;
        int a = p.length();
        long b = Long.parseLong(p);
        
        for(int i = 0; i <= t.length() - a; i++) {
            if (Long.parseLong(t.substring(i, i + a)) <= b) {
                result++;
            }
        }
        
        return result;
    }
}