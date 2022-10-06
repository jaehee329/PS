import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class a10866 {
    private static int[] stack = new int[20_000];
    private static int size=0, front=10_000;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            switch (s){
                case "push_front":
                    push_front(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    push_back(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    pop_front();
                    break;
                case "pop_back":
                    pop_back();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }
        System.out.println(sb);
    }
    private static void push_front(int num){
        stack[--front] = num;
        size++;
    }
    private static void push_back(int num){
        stack[front+size] = num;
        size++;
    }
    private static void pop_front(){
        if(size==0){
            sb.append("-1\n");
            return;
        }
        sb.append(String.valueOf(stack[front])+"\n");
        front++;
        size--;
    }
    private static void pop_back(){
        if(size==0){
            sb.append("-1\n");
            return;
        }
        sb.append(String.valueOf(stack[front+size-1])+"\n");
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
    private static void front(){
        if(size==0){
            sb.append("-1\n");
        } else {
            sb.append(String.valueOf(stack[front])+"\n");
        }
    }
    private static void back(){
        if(size==0){
            sb.append("-1\n");
        } else {
            sb.append(String.valueOf(stack[front+size-1])+"\n");
        }
    }
}