package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

public class a11659 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NAndProblems = br.readLine().split(" ");
        int N = Integer.parseInt(NAndProblems[0]);
        
        String[] numbers = br.readLine().split(" ");
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(numbers[i - 1]);
        }


        int problems = Integer.parseInt(NAndProblems[1]);
        StringJoiner sj = new StringJoiner("\n");
        for (int k = 0; k < problems; k++) {
            String[] ij = br.readLine().split(" ");
            int i = Integer.parseInt(ij[0]);
            int j = Integer.parseInt(ij[1]);

            sj.add(Integer.toString(prefixSum[j] - prefixSum[i - 1]));
        }
        System.out.println(sj.toString());
    }
}
