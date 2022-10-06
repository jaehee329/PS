import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class a10610 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[10];
        int total = 0;
        boolean flag = true;
        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i)-'0';
            arr[temp] += 1;
            if(temp == 0){
                flag = false;
            }
            total += temp;
        }
        if (flag || total % 3 != 0){
            System.out.println(-1);
            return;
        }
        for (int i = 9; i >= 0; i--) {
            while (arr[i] > 0) {
                System.out.print(i);
                arr[i]--;
            }
        }
    }
}