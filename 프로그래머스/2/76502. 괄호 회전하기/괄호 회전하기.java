import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        String newS = s + s;
        for(int i = 0; i < s.length(); i++) {
            String S1 = newS.substring(i, s.length() + i);
            if(isGood(S1)) answer++;
        }
        return answer;
    }
    
    public static boolean isGood(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '{' || chars[i] == '(' || chars[i] == '[') {
                stack.push(chars[i]);    
            } else if(chars[i] == '}') {
                if(stack.isEmpty() || stack.peek() != '{') return false;
                stack.pop();
            } else if(chars[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '(') return false;
                stack.pop();
            } else if(chars[i] == ']') {
                if(stack.isEmpty() || stack.peek() != '[') return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}