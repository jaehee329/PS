import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class a1406{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        Stack<Character> l = new Stack<Character>();
        Stack<Character> r = new Stack<Character>();
        char[] temp = str.toCharArray();
        for(char c : temp){
            l.push(c);
        }
        for(int i=0; i<n; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");
            String in = st.nextToken();
            switch(in) {
                case "L":
                    if(!l.isEmpty()){
                        r.push(l.pop());
                    }
                    break;
                case "D":
                    if(!r.isEmpty()){
                        l.push(r.pop());
                    }
                    break;
                case "B":
                    if(!l.isEmpty()){
                        l.pop();
                    }
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);
                    l.push(c);
                    break;
            }
        }
        StringBuilder left = new StringBuilder();       
        while(!l.isEmpty()){
            left.append(l.pop());
        }
        StringBuilder right = new StringBuilder();       
        while(!r.isEmpty()){
            right.append(r.pop());
        }
		System.out.print(left.reverse()); System.out.println(right);
    }
}