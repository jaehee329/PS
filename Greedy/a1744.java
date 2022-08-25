// 구현이 지저분한 문제. 양수/음수를 별도로 관리하며 양수의 경우 1은 묶지 않는게 이득, 음수는 두 개씩 묶는게 무조건 이득.
// 0이 있다면 추가적으로 음수가 홀수 개일 때 가장 작은 음수 하나를 마지막에 더해주지 않는 처리까지 해야 함.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class a1744 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        Integer[] negatives = new Integer[50];
        int np = 0;
        Integer[] positives = new Integer[50];
        int nn = 0;
        boolean zero = false;
        for(int i=0; i<N; i++){
            int t = Integer.parseInt(br.readLine());
            if(t>0){
                positives[np] = t;
                np++;
            } else if(t<0) {
                negatives[nn] = t;
                nn++;
            } else {
                zero = true;
            }
        }

        if(nn>=1){
            negatives = Arrays.copyOfRange(negatives, 0, nn);
            Arrays.sort(negatives);
            for(int i=0; i<nn/2; i++){
                sum += negatives[2*i]*negatives[2*i+1];
            }
            if(nn/2==(nn-1)/2 && !zero){
                sum += negatives[negatives.length-1];
            }
        }
        if(np>=1){
            positives = Arrays.copyOfRange(positives, 0, np);
            Arrays.sort(positives, Collections.reverseOrder());
            for(int i=0; i<np/2; i++){
                if(positives[2*i]==1 || positives[2*i+1]==1){
                    sum = sum + positives[2*i] + positives[2*i+1];
                } else {
                    sum += positives[2*i]*positives[2*i+1];
                }
            }
            if(np/2==(np-1)/2){
                sum += positives[positives.length-1];
            }
        }
        System.out.println(sum);
    }
}
