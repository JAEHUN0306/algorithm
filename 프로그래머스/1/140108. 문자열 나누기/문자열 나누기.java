import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        
        for(int i = 0; i < s.length(); i++) {
            if(stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if(stack.peek().equals(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    stack.pop();
                    if(stack.isEmpty()) {
                        count++;
                    }
                }
            }
        }
        
        if(!stack.isEmpty()) {
            count++;
        }
        
        return count;
    }
}