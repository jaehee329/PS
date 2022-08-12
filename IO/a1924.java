import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class a1924 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int[] date = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] weeks = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i=0; i<month-1; i++){
            sum +=date[i];
        }
        sum = (sum+day-1)%7;
        System.out.println(weeks[sum]);
    }   
}
