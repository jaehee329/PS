import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class a14888 {
 
	public static int Max = -1_000_000_000;
	public static int Min = 1_000_000_000;
	public static int[] operator = new int[4]; 
	public static int[] number;
	public static int N;
 
	public static void main(String[] args) throws IOException {
		setStaticVar();
		bruteForce(number[0], 1);
 
		System.out.println(Max);
		System.out.println(Min);
 
	}

	private static void setStaticVar() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
    
		number = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
 
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
	}
 
	public static void bruteForce(int num, int idx) {
		if (idx == N) {
			Max = (Max < num) ? num : Max;
			Min = (Min > num) ? num : Min;
			return;
		}
 
		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				switch (i) {
				    case 0:
						bruteForce(num+number[idx], idx+1);
						break;
				    case 1:
						bruteForce(num-number[idx], idx+1);
						break;
				    case 2:	
						bruteForce(num*number[idx], idx+1);	
						break;
				    case 3:	
						bruteForce(num/number[idx], idx+1);	
						break;
				}
				operator[i]++;
			}
		}
	}
}