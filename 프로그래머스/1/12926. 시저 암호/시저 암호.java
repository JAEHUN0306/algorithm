class Solution {
    public String solution(String s, int n) {
        
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base + n) % 26 + base);
            }
            sb.append(c);
        }
        return sb.toString();
    }
}