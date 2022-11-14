import java.io.*;

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
		int mostFrequent = 0;
        int cnt = 0;
		int mode_max = 0;
		boolean foundFrequent = false;

		for (int i = min + 4000; i <= max + 4000; i++) {
			if (numbers[i] != 0) {
				// 중간값 계산
				if (cnt < (N + 1) / 2) {
					cnt += numbers[i];
					median = i - 4000;
				}
				// 최빈값 계산
				if (mode_max < numbers[i]) {
					foundFrequent = true;
					mode_max = numbers[i];
					mostFrequent = i - 4000;
				} else if (mode_max == numbers[i] && foundFrequent == true) {
					foundFrequent = false;	
					mostFrequent = i - 4000;				
				}
			}
		}
		
		System.out.println((int)Math.round((float)sum / N));
		System.out.println(median);
		System.out.println(mostFrequent);
		System.out.println(max - min);
	}
}
