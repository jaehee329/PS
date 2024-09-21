import java.io.*;
import java.util.*;

public class a1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tcCount = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < tcCount; i++) {
            st = new StringTokenizer(br.readLine());
            int firstX = Integer.parseInt(st.nextToken());
            int firstY = Integer.parseInt(st.nextToken());
            int firstR = Integer.parseInt(st.nextToken());
            int secondX = Integer.parseInt(st.nextToken());
            int secondY = Integer.parseInt(st.nextToken());
            int secondR = Integer.parseInt(st.nextToken());

            if (firstX == secondX && firstY == secondY && firstR == secondR) {
                bw.append("-1\n");
                continue;
            }

            int rSumSquare = firstR * firstR + secondR * secondR + 2 * firstR * secondR;
            int rDiffSqure = firstR * firstR + secondR * secondR - 2 * firstR * secondR;
            int distSquare = (firstX - secondX) * (firstX - secondX) + (firstY - secondY) * (firstY - secondY);
            if (distSquare == rSumSquare || distSquare == rDiffSqure) {
                bw.append("1\n");
            } else if (distSquare > rSumSquare || distSquare < rDiffSqure) {
                bw.append("0\n");
            } else {
                bw.append("2\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
