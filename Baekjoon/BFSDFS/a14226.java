import java.io.*;
import java.util.*;

public class a14226 {

    public static class Node {

        public int clipSize;
        public int total;
        public int move;
        
        public Node(int clipSize, int total, int move) {
            this.clipSize = clipSize;
            this.total = total;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 1, 0));

        boolean[][] visit = new boolean[1001][1001];
        visit[0][1] = true; 
        
        while(!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.total == s) {
                System.out.println(cur.move);
                return;
            }
            
            q.add(new Node(cur.total, cur.total, cur.move + 1)); 

            if (cur.clipSize != 0 && cur.total + cur.clipSize <= s && !visit[cur.clipSize][cur.total + cur.clipSize]) {
                visit[cur.clipSize][cur.total + cur.clipSize] = true;
                q.add(new Node(cur.clipSize, cur.total + cur.clipSize, cur.move + 1));
            }

            if (cur.total >= 1 && !visit[cur.clipSize][cur.total - 1]) {
                visit[cur.clipSize][cur.total - 1] = true;
                q.add(new Node(cur.clipSize, cur.total - 1, cur.move + 1));
            }
        }
    }
}
