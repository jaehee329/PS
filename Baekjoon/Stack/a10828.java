import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a10828 {
    private static int[] stack = new int[10_000];
    private static int size=0;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s){
                case "push":
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "top":
                    top();
                    break;
            }
        }
        System.out.println(sb);
    }
    private static void push(int num){
        stack[size] = num;
        size++;
    }
    private static void pop(){
        if(size==0){
            sb.append("-1\n");
            return;
        }
        sb.append(String.valueOf(stack[size-1])+"\n");
        size--;
    }
    private static void size(){
        sb.append(String.valueOf(size)+"\n");
    }
    private static void empty(){
        if(size==0){
            sb.append("1\n");
        } else {
            sb.append("0\n");
        }
    }
    private static void top(){
        if(size==0){
            sb.append("-1\n");
        } else {
            sb.append(String.valueOf(stack[size-1])+"\n");
        }
    }
}