package Baekjoon.PriorityQueue;

import java.io.*;
import java.util.*;

public class a23656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int gifts = Integer.parseInt(st.nextToken());
        int children = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> giftCountDescendingQueue = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < gifts; i++) {
            int giftCount = Integer.parseInt(st.nextToken());
            giftCountDescendingQueue.add(giftCount);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < children; i++) {
            int childNeed = Integer.parseInt(st.nextToken());

            int maxGift = giftCountDescendingQueue.poll();
            if (maxGift < childNeed) {
                System.out.println("0");
                return;
            }
            giftCountDescendingQueue.add(maxGift - childNeed);
        }
        System.out.println("1");
    }
}
