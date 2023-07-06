import java.io.*;
import java.util.*;

public class a14646 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int menuCount = Integer.parseInt(br.readLine());
        int recordCount = menuCount * 2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxStickerCount = 0;
        int currentStickerCount = 0;
        boolean[] hasSticker = new boolean[recordCount + 1];
        for (int i = 0; i < recordCount; i++) {
            int record = Integer.parseInt(st.nextToken());
            if (!hasSticker[record]) {
                currentStickerCount++;
                hasSticker[record] = true;
                maxStickerCount = Math.max(maxStickerCount, currentStickerCount);
            } else {
                currentStickerCount--;
                hasSticker[record] = false;
            }
        }
        System.out.println(maxStickerCount);
    }
}
