package Baekjoon.TwoPointer;

import java.io.*;
import java.util.*;

public class a1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        int good = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;
            while (true) {
                if (left == i) {
                    left++;
                } else if (right == i) {
                    right--;
                }
                if (left >= right) {
                    break;
                }
                if (numbers[left] + numbers[right] > numbers[i]) {
                    right--;
                } else if (numbers[left] + numbers[right] < numbers[i]) {
                    left++;
                } else{
                    good++;
                    break;
                }
            }
        }
        System.out.println(good);
    }
}
