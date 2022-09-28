import java.io.*;
import java.util.*;

public class a1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i=0; i<N; i++){
            int t = Integer.parseInt(br.readLine());
            if(minHeap.size() == maxHeap.size()){
                maxHeap.offer(t);
            } else {
                minHeap.offer(t);
            }
            if(!minHeap.isEmpty() && !maxHeap.isEmpty())
                if(minHeap.peek() < maxHeap.peek()){
                    int temp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(temp);
                }
            sb.append(maxHeap.peek() + "\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
