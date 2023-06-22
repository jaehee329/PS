package Baekjoon.SlidingWindow;

import java.io.*;
import java.util.*;

public class a11003 {
    private static class Node {
        public int index;
        public int value;
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int maxLength = Integer.parseInt(st.nextToken());
        
        Deque<Node> deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int newest = Integer.parseInt(st.nextToken());
            while (!deque.isEmpty() && deque.getLast().value > newest) {
                deque.removeLast();
            }
            deque.addLast(new Node(i, newest));
            if (deque.getFirst().index < i - maxLength + 1) {
                deque.pollFirst();
            }
            bw.write(deque.getFirst().value + " ");
        }
        bw.flush();
        bw.close();
    }
}
