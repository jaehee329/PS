package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a24049 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[height + 1][width + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= height; i++) {
            int value = Integer.parseInt(st.nextToken());
            map[i][0] = value == 1 ? true : false;
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= width; i++) {
            int value = Integer.parseInt(st.nextToken());
            map[0][i] = value == 1 ? true : false;
        }

        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                map[i][j] = map[i - 1][j] ^ map[i][j - 1];
            }
        }

        System.out.println(map[height][width] == true ? "1" : "0");
    }
}
