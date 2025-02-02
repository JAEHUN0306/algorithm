import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < charArray.length ; i++) {
            if(charArray[i] == '(') {
                stack.push(charArray[i]);
            } else {
                if(stack.isEmpty()) {
                    answer = false;
                } else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {
            answer = false;
        }
    
        return answer;
    }
}