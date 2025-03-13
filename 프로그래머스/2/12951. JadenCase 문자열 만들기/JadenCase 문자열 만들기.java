import java.util.*;
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isNewWord = true;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ') {
                isNewWord = true;
                sb.append(c);
            } else if(isNewWord) {
                sb.append(Character.toUpperCase(c));
                isNewWord=false;
            } else {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }
}