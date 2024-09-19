class Solution {
    boolean solution(String s) {
        int temp = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
                temp += 1;
            } else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
                temp -= 1;
            }
        }
        boolean result = temp == 0 ? true : false;
        return result;
    }
}