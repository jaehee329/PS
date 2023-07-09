package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

public class a21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int totalDays = Integer.parseInt(st.nextToken());
        int period = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] visitors = new int[totalDays];
        visitors[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < totalDays; i++) {
            visitors[i] = visitors[i - 1] + Integer.parseInt(st.nextToken());
        }

        int[] partialSum = new int[totalDays];
        int max = 0;
        int maxCount = 0;
        for (int i = 0; i < totalDays; i++) {
            int front = 0;
            if (i >= period) {
                front = visitors[i - period];
            }

            int IthPartialSum = visitors[i] - front;
            if (IthPartialSum == max) {
                maxCount++;
            } else if (IthPartialSum > max) {
                maxCount = 1;
                max = IthPartialSum;
            }
            partialSum[i] = IthPartialSum;
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(maxCount);
        }
    }
}
