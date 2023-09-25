import java.io.*;
import java.util.*;

public class a1011 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i = 0; i < tc; i++) {
			st = new StringTokenizer(br.readLine());
			int distance = -1 * (Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
			
			int max = (int)Math.sqrt(distance);
			if (max == Math.sqrt(distance)) {
				sb.append(max * 2 - 1).append('\n');
			} else if(distance <= max * max + max) {
				sb.append(max * 2).append('\n');
			} else {
				sb.append(max * 2 + 1).append('\n');
			}
		}
		System.out.println(sb);
	}
}
