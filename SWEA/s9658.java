// 입력받는 정수 String이 매우 길어 앞 부분만 떼서 사용해야 함
// Math.round() 사용 시 틀린 tc가 있어 직접 구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class s9658 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=1; i<=N; i++) {
            changeAndPut2Sb(i, br.readLine());
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static void changeAndPut2Sb(int idx, String numberString) {
        sb.append("#" + idx + " ");
        int n = numberString.length() - 1;

        if (numberString.substring(0, 2).equals("99") && numberString.charAt(2)-'0' >= 5) {
            sb.append("1.0");
            n++;
        } else {
            int t = numberString.charAt(2) - '0';
            if (t >= 5) {
                int a = Integer.parseInt(numberString.substring(0, 2)) + 1;
                sb.append(a/10 + "." + a%10);
            } else {
                sb.append(numberString.charAt(0) + "." + numberString.charAt(1));
            }
        }
        sb.append("*10^" + n +"\n");
    }
}