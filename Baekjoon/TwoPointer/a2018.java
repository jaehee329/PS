package Baekjoon.TwoPointer;

import java.io.*;

public class a2018 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int head = 1;
        int tail = 1;
        int sum = 1;
        while (head <= N) {
            if (sum < N) {
                head++;
                sum += head;
            } else {
                if (sum == N) {
                    answer++;
                }
                sum -= tail;
                tail++;
            }
        }
        System.out.println(answer);
    }
}
