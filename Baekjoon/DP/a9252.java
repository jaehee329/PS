import java.io.*;
import java.util.*;

public class a9252 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		int len1 = s1.length;
		int len2 = s2.length;
		int[][] dp = new int[len2+1][len1+1];
		
		for(int i=1; i<len2+1; i++) {
			for(int j=1; j<len1+1; j++) {
				if(s2[i-1] != s1[j-1]) {
					dp[i][j] = dp[i-1][j] > dp[i][j-1] ? dp[i-1][j] : dp[i][j-1];
                }
				else {
					dp[i][j] = dp[i-1][j-1] + 1;
                }
			}
		}

		int ans = dp[len2][len1];
		System.out.println(ans);
        if (ans == 0) {
            return;
        }
		int i = len2;
		int j = len1;
		Stack<Character> stack = new Stack<>();
		while(i >=1 && j >= 1) {
			if(dp[i][j] == dp[i-1][j]) {
				i--;
            }
			else if(dp[i][j] == dp[i][j-1]) {
				j--;
            }
			else {
				stack.push(s2[i-1]);
				i--;
                j--;
			}		
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
        }
	}
}