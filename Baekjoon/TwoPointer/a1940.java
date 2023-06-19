package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;

public class a1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        List<Integer> numbers = new ArrayList<>(N);
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);

        int headIdx = N - 1;
        int tailIdx = 0;
        int answer = 0;
        while (headIdx > tailIdx) {
            int head = numbers.get(headIdx);
            int tail = numbers.get(tailIdx);
            if (head + tail < M) {
                tailIdx++;
            } else {
                if (head + tail == M) {
                    answer++;
                }
                headIdx--;
            }
        }
        System.out.println(answer);
    }
}
