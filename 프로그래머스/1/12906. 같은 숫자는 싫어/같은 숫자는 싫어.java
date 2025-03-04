import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i-1]) Q.offer(arr[i]);
        }
        int size = Q.size();
        int[] result = new int[size];
        
        for(int i = 0; i < size; i++) {
            result[i] = Q.poll();
        }

        return result;
    }
}