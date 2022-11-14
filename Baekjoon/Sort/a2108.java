import java.io.*;
import java.util.*;

public class a2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[8001];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            numbers[num + 4000]++;
            min = (min > num) ? num : min;
            max = (max < num) ? num : max;
            sum += num;
        }
        int median = 0;
		int mode = 0;
        int count = 0;
		int mode_max = 0;
		
		boolean flag = false;	 
		
		for (int i = min + 4000; i <= max + 4000; i++) {
			if (numbers[i] > 0) {
				if (count < (N + 1) / 2) {
					count += numbers[i];
					median = i - 4000;
				}
				if (mode_max < numbers[i]) {
					mode_max = numbers[i];
					mode = i - 4000;
					flag = true;
				} else if (mode_max == numbers[i] && flag == true) {
					mode = i - 4000;
					flag = false;					
				}
			}
		}
		
		System.out.println((int)Math.round((double)sum / N));
		System.out.println(median);
		System.out.println(mode);
		System.out.println(max - min);
	}
}
