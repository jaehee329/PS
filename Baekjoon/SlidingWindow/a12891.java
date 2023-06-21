package Baekjoon.SlidingWindow;

import java.io.*;
import java.util.*;

public class a12891 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int totalLength = Integer.parseInt(st.nextToken());
        int partialLegnth = Integer.parseInt(st.nextToken());

        String dna = br.readLine();
        st = new StringTokenizer(br.readLine());
        int[] minACGT = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        int headIdx = 0;
        int tailIdx = 0 + partialLegnth;
        int passwordCount = 0;
        String target = dna.substring(headIdx, tailIdx);
        int[] ACGT = getACGTCounter(target);
        if (ACGT[0] >= minACGT[0] && ACGT[1] >= minACGT[1] && ACGT[2] >= minACGT[2] && ACGT[3] >= minACGT[3]) {
            passwordCount++;
        }

        while (tailIdx < totalLength) {
            char oldest = dna.charAt(headIdx);
            char next = dna.charAt(tailIdx);
            ACGT = addToCounter(next, ACGT);
            ACGT = deleteFromCounter(oldest, ACGT);
            if (ACGT[0] >= minACGT[0] && ACGT[1] >= minACGT[1] && ACGT[2] >= minACGT[2] && ACGT[3] >= minACGT[3]) {
                passwordCount++;
            }
            headIdx++;
            tailIdx++;
        }
        System.out.println(passwordCount);
    }

    private static int[] getACGTCounter(String target) {
        int[] ACGT = new int[4];
        for (int i = 0; i < target.length(); i++) {
            char character = target.charAt(i);
            ACGT = addToCounter(character, ACGT);
        }
        return ACGT;
    }

    private static int[] addToCounter(char character, int[] ACGT) {
        if (character == 'A') {
            ACGT[0]++;
        } else if (character == 'C') {
            ACGT[1]++;
        } else if (character == 'G') {
            ACGT[2]++;
        } else if (character == 'T') {
            ACGT[3]++;
        }
        return ACGT;
    }

    private static int[] deleteFromCounter(char character, int[] ACGT) {
        if (character == 'A') {
            ACGT[0]--;
        } else if (character == 'C') {
            ACGT[1]--;
        } else if (character == 'G') {
            ACGT[2]--;
        } else if (character == 'T') {
            ACGT[3]--;
        }
        return ACGT;
    }
}
