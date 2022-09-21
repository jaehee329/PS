import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Iterator;

public class a2806 {
    static ArrayList[] compConnection;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfComps = Integer.parseInt(br.readLine());
        int numOfNetworkedComps = Integer.parseInt(br.readLine());

        compConnection = new ArrayList[numOfComps+1];
        for(int i=0; i<numOfComps+1; i++){
            compConnection[i] = new ArrayList<Integer>();
        }

        visited = new boolean[numOfComps+1];

        for (int i=0; i<numOfNetworkedComps; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int compA = Integer.parseInt(st.nextToken());
            int compB = Integer.parseInt(st.nextToken());
            compConnection[compA].add(compB);
            compConnection[compB].add(compA);
        }

        int numOfCorrupted = 0;
        visited[1] = true;
        Queue<Integer> corruptedQ = new LinkedList<>();
        corruptedQ.add(1);
        while (!corruptedQ.isEmpty()) {
            int originComp = corruptedQ.poll();
            Iterator<Integer> iter = compConnection[originComp].iterator();
            while (iter.hasNext()) {
                int connectedComp = iter.next();
                if(!visited[connectedComp]) {
                    visited[connectedComp] = true;
                    corruptedQ.add(connectedComp);
                    numOfCorrupted++;
                }
            }
        }
        System.out.println(numOfCorrupted);
    }    
}
