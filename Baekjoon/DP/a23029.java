import java.io.*;

public class a23029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cornerCount = Integer.parseInt(br.readLine());

        if (cornerCount == 0) {
            System.out.println(0);
            return;
        }

        int[] corners = new int[cornerCount];
        for (int i = 0; i < cornerCount; i++) {
            corners[i] = Integer.parseInt(br.readLine());
        }
        
        int[] AnyX = new int[cornerCount];
        int[] XO = new int[cornerCount];
        int[] OO = new int[cornerCount];

        for (int i = 0; i < cornerCount; i++) {
            int foods = corners[i];
            if (i == 0) {
                XO[0] = foods;
                continue;
            } else if (i == 1) {
                AnyX[1] = XO[0];
                XO[1] = foods;
                OO[1] = XO[0] + foods / 2;
                continue;
            }
            AnyX[i] = Math.max(AnyX[i - 1], Math.max(XO[i - 1], OO[i - 1]));
            XO[i] = AnyX[i - 1] + foods;
            OO[i] = XO[i- 1] + foods / 2;
        }
        
        int max = Math.max(AnyX[cornerCount - 1], Math.max(XO[cornerCount - 1], OO[cornerCount - 1]));
        System.out.println(max);
    }
}
