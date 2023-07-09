import java.io.*;
import java.util.*;

public class a10709 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            int prevCloudIdx = -1;
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);
                if (c == 'c') {
                    bw.write("0 ");
                    prevCloudIdx = j;
                } else {
                    if (prevCloudIdx < 0) {
                        bw.write("-1 ");
                    } else {
                        bw.write(Integer.toString(j - prevCloudIdx) + " ");
                    }
                }
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
