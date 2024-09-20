import java.util.*;

class Solution {
    public long solution(long n) {
        char[] a = String.valueOf(n).toCharArray();
        Arrays.sort(a);
        StringBuilder sb = new StringBuilder(new String(a));
        return Long.parseLong(sb.reverse().toString());
    }
}