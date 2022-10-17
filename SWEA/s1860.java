import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class s1860 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = getTc(br);
        
        for(int i=1; i<=tc; i++) {
            boolean possible = getPossibility(br);
            addAns2Sb(sb, i, possible);
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    private static int getTc(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static boolean getPossibility(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfClients = Integer.parseInt(st.nextToken());
        int period = Integer.parseInt(st.nextToken());
        int outputPerPeriod = Integer.parseInt(st.nextToken());

        int[] clientsArrival = new int[numOfClients];
        int maxArrival = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<numOfClients; i++) {
            int t = Integer.parseInt(st.nextToken());
            clientsArrival[i] = t;
            maxArrival = (t>maxArrival) ? t : maxArrival;
        }

        Arrays.sort(clientsArrival);
        if(clientsArrival[0]==0) {
            return false;
        }

        int remainder = 0;
        int clientsIdx = 0;
        for(int i=1; i<=maxArrival; i++) {
            if(i % period == 0) {
                remainder += outputPerPeriod;
            }
            while(clientsIdx<numOfClients && clientsArrival[clientsIdx] == i) {
                if(remainder == 0 ) {
                    return false;
                }
                clientsIdx++;
                remainder--;
            }
        }
        return true;
    }

    private static void addAns2Sb(StringBuilder sb, int idx, boolean possible) {
        String possibility = "";
        if(possible) {
            possibility = "Possible";
        } else {
            possibility = "Impossible";
        }
        sb.append("#" + idx + " " + possibility + "\n");
    }
}
