package Baekjoon.PrefixSum;

import java.io.*;

public class a10986 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        String[] numbers = br.readLine().split(" ");
        int sum = 0;
        int[] remainderCount = new int[M];
        for (int i = 0; i < N; i++) {
            sum = (sum + Integer.parseInt(numbers[i])) % M;
            remainderCount[sum]++;
        }
        long ans = remainderCount[0];
        for (int i = 0; i < M; i++) {
            ans += (long) remainderCount[i] * (remainderCount[i] - 1) / 2;
        }
        System.out.println(ans);
    }
}
