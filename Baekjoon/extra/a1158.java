import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class a1158{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i=1; i<=N; i++){
            q.offer(i);
        }
        Queue<Integer> t = new LinkedList<Integer>();
        StringJoiner sj = new StringJoiner(", ", "<", ">");
        int i=1; 
        while(!q.isEmpty()){
            while(!q.isEmpty()){
                if(i%K==0){
                    sj.add(Integer.toString(q.poll()));
                }else{
                    t.offer(q.poll());   
                }
                i++;
            }
            q.clear();
            while(!t.isEmpty()){
                q.offer(t.poll());
            }
            t.clear();
        }
        System.out.println(sj);
    }
}
// was bad since just poll and adding integer to the last of the single queue is much faster.