import java.util.*; 
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean toUpper = true;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append(c);
                toUpper = true;
            } else {
                sb.append(toUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
                toUpper = !toUpper;
            }
        }
        
        return sb.toString();
    }
}