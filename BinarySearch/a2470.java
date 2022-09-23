import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class a2470 {
    private static int[] liquid;
    private static int N;
    private static int a;
    private static int b;
    public static void main(String[] args) throws Exception {
        staticAscendingLiquidIntArrSetter();
        binarysearchSetAB();
        System.out.println(a + " " + b);
    }
    private static void staticAscendingLiquidIntArrSetter() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        liquid = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            liquid[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(liquid);
    }
    private static void binarysearchSetAB() {
        int lo = 0;
        int hi = N-1;
        int min = Integer.MAX_VALUE;
        while(lo<hi) {
            int sum = liquid[lo]+liquid[hi];
            int abs = Math.abs(sum);
            if(abs < min) {
                min = abs;
                a = liquid[lo];
                b = liquid[hi];
            }
            if(sum>0){
                hi--;
            } else {
                lo++;
            }
        }
    }
}
