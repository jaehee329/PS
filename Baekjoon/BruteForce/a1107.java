// 예외처리가 까다로움. 숫자 자릿수 계산에서 log10 사용 시 log10(0)인 경우에 문제 발생, 0보다 작아지는 경우나 고장난게 없는 등의 예외처리 모두 해줘야
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a1107 {
    static boolean[] broke = new boolean[10];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int broken = Integer.parseInt(br.readLine());
        int max = Math.abs(N-100);
        int lenN = 1;
        if(N != 0){
            lenN = (int)Math.log10(N)+1;
        }
        if(broken == 0){
            System.out.println((int)Math.min(max, lenN));
            return;
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<broken; i++){
            broke[Integer.parseInt(st.nextToken())] = true;
        }

        int nearest = 100;
        for(int diff = 0; diff<max; diff++){
            if(N-diff>=0 && available(N-diff)){
                nearest = N-diff;
                break;
            }
            if(available(N+diff)){
                nearest = N+diff;
                break;
            }
        }
        int len = 1;
        if(nearest != 0){
            len = (int)Math.log10(nearest)+1;
        }
        System.out.println((int)Math.min(max, Math.abs(N-nearest)+len));
    }
    private static boolean available(int num){
        int len = 1;
        if(num != 0){
            len = (int)Math.log10(num)+1;
        }
        for(int i=0; i<len; i++){
            int t = num%10;
            if(broke[t]){
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
