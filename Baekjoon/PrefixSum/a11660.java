package Baekjoon.PrefixSum;

import java.io.*;
import java.util.*;

public class a11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] NM = br.readLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);

        int[][] table = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1] + Integer.parseInt(line[j - 1]) - table[i - 1][j - 1];
            }
        }

        StringJoiner answers = new StringJoiner("\n");
        for (int i = 0; i < M; i++) {
            String[] x1y1x2y2 = br.readLine().split(" ");
            int y1 = Integer.parseInt(x1y1x2y2[0]);
            int x1 = Integer.parseInt(x1y1x2y2[1]);
            int y2 = Integer.parseInt(x1y1x2y2[2]);
            int x2 = Integer.parseInt(x1y1x2y2[3]);

            answers.add(Integer.toString(table[y2][x2] + table[y1 - 1][x1 - 1] - table[y2][x1 - 1] - table[y1 - 1][x2]));
        }
        System.out.println(answers.toString());
    }
}
