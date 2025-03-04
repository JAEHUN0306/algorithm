import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> Q = new LinkedList<>();
        int size = progresses.length;
        for(int i = 0 ; i < size ; i++) {
            if((100 - progresses[i]) % speeds[i] == 0) {
                Q.add((100 - progresses[i]) / speeds[i]);
            } else {
                Q.add((100 - progresses[i]) / speeds[i] + 1);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(!Q.isEmpty()) {
            Integer x = Q.poll();
            int count = 1;
            while(!Q.isEmpty() && Q.peek() <= x) {
                Q.poll();
                count++;
            }
            list.add(count);
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}