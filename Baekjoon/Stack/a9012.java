import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a9012 {
    private static int size;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            String s = br.readLine();
            size = 0;
            int ret = 0;
            for(int j=0; j<s.length();j++){
                switch (s.charAt(j)){
                    case '(':
                        push();
                        break;
                    case ')':
                        if(pop()==-1) ret = -1;
                        break;
                    }
            }
            if(ret==0 && empty()==0){
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
    private static void push(){
        size++;
    }
    private static int pop(){
        if(size==0){
            return -1;
        }
        size--;
        return 0;
    }
    private static int empty(){
        if(size==0){
            return 0;
        } else {
            return -1;
        }
    }
}