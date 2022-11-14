import java.io.*;
import java.util.*;

public class s1244 {
	public static int numArr[];
	public static int result;
	public static int count;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int TC = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			numArr = new int[str.length()];
			result = 0;
			for (int i = 0; i < str.length(); i++) {
				numArr[i] = str.charAt(i) - '0';
            }
			count = Integer.parseInt(st.nextToken());
			count = count > str.length() ? str.length() - 1 : count;
			selectionSort(0, 0);
			
            System.out.println("#" + tc + " " + result);
		}
	}

	public static void selectionSort(int s, int e) {
		if (e == count) {
			result = Math.max(result, Integer.parseInt(Arrays.toString(numArr).replaceAll("[^0-9]", "")));
			return;
		}
		for (int i = s; i < numArr.length - 1; i++) {
			for (int j = i + 1; j < numArr.length; j++) {
				int t;
				t = numArr[i];
				numArr[i] = numArr[j];
				numArr[j] = t;
				
				selectionSort(i, e + 1);
				
				t = numArr[i];
				numArr[i] = numArr[j];
				numArr[j] = t;
			}
		}
	}
}