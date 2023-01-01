import java.io.*;
import java.util.*;

public class a2042 {
	private static long[] elements;
    private static long[] segmentTree;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		elements = new long[N + 1];
		for (int i = 1; i <= N; i++) {
			elements[i] = Long.parseLong(br.readLine());
		}

		int k = (int) Math.ceil(Math.log(N) / Math.log(2)) + 1;
		int size = (int) Math.pow(2, k);
		
		segmentTree = new long[size];

		init(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());

			if (a == 1) {
				long diff = c - elements[b];
				elements[b] = c;
				update(1, N, 1, b, diff);
			} else {
				sb.append(partialSum(1, N, 1, b, (int) c) + "\n");
			}
		}

        sb.setLength(sb.length()-1);
        System.out.println(sb);
	}

	public static long init(int start, int end, int node) {
		if (start == end) {
			return segmentTree[node] = elements[start];
		}
		int mid = (start + end) / 2;
		return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}

	public static long partialSum(int start, int end, int node, int left, int right) {
		if (left > end || right < start) {
			return 0;
		}
		if (left <= start && end <= right) {
			return segmentTree[node];
		}
		int mid = (start + end) / 2;
		return partialSum(start, mid, node * 2, left, right) + partialSum(mid + 1, end, node * 2 + 1, left, right);
	}

    public static void update(int start, int end, int node, int idx, long dif) {
		if (idx < start || idx > end) {
			return;
		}
		segmentTree[node] += dif;
		if (start == end) {
			return;
		}

		int mid = (start + end) / 2;
		update(start, mid, node * 2, idx, dif);
		update(mid + 1, end, node * 2 + 1, idx, dif);
	}
}
