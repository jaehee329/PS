import java.io.*;
import java.util.*;

public class a4929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String firstLine = br.readLine();
            if (firstLine.equals("0")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(firstLine);
            int firstLength = Integer.parseInt(st.nextToken());
            int[] first = new int[firstLength];
            for (int i = 0; i < firstLength; i++) {
                first[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int secondLength = Integer.parseInt(st.nextToken());
            int[] second = new int[secondLength];
            for (int i = 0; i < secondLength; i++) {
                second[i] = Integer.parseInt(st.nextToken());
            }
            
            int maxSum = 0;
            int firstIdx = 0;
            int secondIdx = 0;
            int firstBuffer = 0;
            int secondBuffer = 0;
            int lastCrossedFirstIdx = 0;
            int lastCrossedSecondIdx = 0;
            while (firstIdx < firstLength && secondIdx < secondLength) {
                if (first[firstIdx] > second[secondIdx]) {
                    secondBuffer += second[secondIdx];
                    secondIdx++;
                } else if (first[firstIdx] < second[secondIdx]) {
                    firstBuffer += first[firstIdx];
                    firstIdx++;
                } else {
                    maxSum += Math.max(firstBuffer, secondBuffer);
                    maxSum += first[firstIdx];
                    firstBuffer = 0;
                    secondBuffer = 0;
                    firstIdx++;
                    secondIdx++;
                    lastCrossedFirstIdx = firstIdx;
                    lastCrossedSecondIdx = secondIdx;
                }
            }

            int firstRemainder = 0;
            while (lastCrossedFirstIdx < firstLength) {
                firstRemainder += first[lastCrossedFirstIdx];
                lastCrossedFirstIdx++;
            }

            int secondRemainder = 0;
            while (lastCrossedSecondIdx < secondLength) {
                secondRemainder += second[lastCrossedSecondIdx];
                lastCrossedSecondIdx++;
            }
            maxSum += Math.max(firstRemainder, secondRemainder);
            bw.write(maxSum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}