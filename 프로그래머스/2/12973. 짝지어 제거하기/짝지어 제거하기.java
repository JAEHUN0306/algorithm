import java.util.*;
class Solution
{
    public int solution(String s){
        int answer = 0; // 성공하면 1, 아니면 0
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        stack.push(chars[0]); // 처음엔 그냥 넣음
        for(int i = 1; i < s.length(); i++) {
            if(!stack.isEmpty() && chars[i] == stack.peek()) stack.pop();
            else stack.push(chars[i]);
        }
        if(stack.isEmpty()) answer = 1;
        else answer = 0;
        return answer;
    }
}