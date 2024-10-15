class Solution {
    public int solution(int n) {
        StringBuilder sb = new StringBuilder(Integer.toString(n, 3));
        String reverse = sb.reverse().toString();
        return Integer.parseInt(reverse, 3);
    }
}