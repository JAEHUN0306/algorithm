import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> answer = new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 작은 값 저장
        // 작은 값중 가장 큰 값이 중앙값임.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 큰 값 저장

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size()) {
                if(!minHeap.isEmpty() && minHeap.peek() < num) {
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                } else {
                    maxHeap.add(num);
                }
            } else {
                if(maxHeap.peek() > num) {
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            }

            answer.add(maxHeap.peek());
        }

        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
