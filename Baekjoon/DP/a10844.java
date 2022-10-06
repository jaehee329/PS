// wrong, couldn't solve

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a10844 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] initial = {0,1,1,1,1,1,1,1,1,1};

        if(N!=1){
            for(int i=1; i<N; i++){
                long[] temp = new long[10];
                for(int j=0; j<10;j++){
                    switch(j){
                        case 0: temp[0]=initial[1]; break;
                        case 9: temp[9]=initial[8]; break;
                        default: temp[j]=(initial[j-1]+initial[j+1])%1_000_000_000L; break;
                    }
                }
                initial=temp;
            }
            long sum=0;
            for(int i=0; i<10; i++){
                System.out.printf("%d\t",initial[i]);
                sum+=initial[i];
            }
            System.out.println(sum%1_000_000_000L);
        } else {
            System.out.println(9);
        }

    }
}