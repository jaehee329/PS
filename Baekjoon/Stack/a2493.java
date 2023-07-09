import java.io.*;
import java.util.*;

public class a2493 {

    private static class NumberWithIdx {
        public int number;
        public int idx;
        public NumberWithIdx(int number, int idx) {
            this.number = number;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayDeque<NumberWithIdx> stack = new ArrayDeque<>();

        int[] reception = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int number = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty() && stack.peekLast().number < number) {
                NumberWithIdx numberWithIdx = stack.pollLast();
                if (stack.isEmpty()) {
                    reception[numberWithIdx.idx] = 0;
                } else {
                    reception[numberWithIdx.idx] = stack.peekLast().idx;
                }
            }
            stack.add(new NumberWithIdx(number, i));
        }

        while (!stack.isEmpty()) {
            NumberWithIdx previous = stack.pollLast();
            if (stack.isEmpty()) {
                reception[previous.idx] = 0;
            } else {
                reception[previous.idx] = stack.peekLast().idx;
            }
        }

        for (int i = 1; i <= N; i++) {
            bw.write(reception[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}
