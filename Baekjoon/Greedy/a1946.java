import java.io.*;
import java.util.*;

public class a1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            int cnt = Integer.parseInt(br.readLine());
            Score[] scores = new Score[cnt];
            for (int j = 0; j < cnt; j++) {
                st = new StringTokenizer(br.readLine());
                int paper = Integer.parseInt(st.nextToken());
                int interview = Integer.parseInt(st.nextToken());
                scores[j] = (new Score(paper, interview));
            }
            Arrays.sort(scores);
            int passed = 1;
            int bestInterview = scores[0].interview;
            for (int j = 1; j < cnt; j++) {
                int targetInterview = scores[j].interview;
                if (targetInterview < bestInterview) {
                    bestInterview = targetInterview;
                    passed++;
                }
            }
            System.out.println(passed);
        }
    }

    private static class Score implements Comparable<Score> {
        public int paper;
        public int interview;
        public Score(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
        @Override
        public int compareTo(Score score) {
            if (this.paper == score.paper) {
                return this.interview - score.interview;
            } else {
                return this.paper - score.paper;
            }
        }
    }
}
