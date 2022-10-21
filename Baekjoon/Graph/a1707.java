import java.io.*;
import java.util.*;

public class a1707 {
    private static int numOfVertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        for (int i=0; i<K; i++) {
            printBipartity(br);
        }
    }
    
    private static void printBipartity(BufferedReader br) throws IOException {
        ArrayList<ArrayList<Integer>> graph = getGraph(br);
        boolean biparitite = checkBiparity(graph);
        if (biparitite) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static ArrayList<ArrayList<Integer>> getGraph(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        numOfVertex = Integer.parseInt(st.nextToken());
        int numOfEdge = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i=0; i<numOfVertex+1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i=0; i<numOfEdge; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        return graph;
    }

    private static boolean checkBiparity(ArrayList<ArrayList<Integer>> graph) {
        int[] visit = new int[numOfVertex+1];
        int group = 1;
        for (int i=1; i<=numOfVertex; i++) {
            if (visit[i]==0) {
                Queue<Integer> q = new LinkedList<>();
                visit[i] = group;
                q.add(i);
                while (!q.isEmpty()) {
                    int src = q.poll();
                    int srcGroup = visit[src];
                    for (int j=0; j<graph.get(src).size(); j++) {
                        int dst = graph.get(src).get(j);
                        if (visit[dst]==0) {
                            visit[dst] = -1*srcGroup;
                            q.add(dst);
                        } else if (visit[dst] != -1*srcGroup) {
                             return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}