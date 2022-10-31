// 뒤에서부터 확인하면 O(n)으로 해결 가능, 결과가 Long일 수 있음에 유의
import java.io.*;
import java.util.*;

public class s1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 1; i <= tc; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int last = arr[N-1];
            Long profit = 0L;
            for (int j = N-2; j >= 0; j--) {
                if (arr[j] <= last) {
                    profit += last - arr[j];
                } else {
                    last = arr[j];
                }
            }
            System.out.println("#" + i + " " + profit);
        }
    }
}
