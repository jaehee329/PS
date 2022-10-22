import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s14413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            char first ='?';
            boolean firstAssigned = false;
            int fn = 0;
            int fm = 0;
            boolean possible = true;
            for (int n=0; n<N; n++) {
                String s = br.readLine();
                for (int m=0; m<M && possible; m++) {
                    char t = s.charAt(m);
                    if (t != '?') {
                        if(!firstAssigned) {
                            fn = n;
                            fm = m;
                            firstAssigned = true;
                            first = t;
                        } else {
                            if (((n+m-fn-fm)%2==0 && t!=first) || ((n+m-fn-fm)%2==1 && t==first)) {
                                possible = false;
                                break;
                            }
                        }
                    }
                }
            }
            String s = possible ? "possible" : "impossible";
            sb.append("#" + i + " " + s + "\n");
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
