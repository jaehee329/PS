import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class a1406_timeout{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int pos = str.length();
        LinkedList<Character> ans = new LinkedList<Character>();
        char[] temp = str.toCharArray();
        for(char c : temp){
            ans.add(c);
        }
        for(int i=0; i<n; i++){
            str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");
            String in = st.nextToken();
            switch(in) {
                case "L":
                    if(pos>0){
                        pos--;
                    }
                    break;
                case "D":
                    if(pos<ans.size()){
                        pos++;
                    }
                    break;
                case "B":
                    if(pos>0){
                        ans.remove(pos-1);
                        pos--;
                    }
                    break;
                case "P":
                    char c = st.nextToken().charAt(0);
                    ans.add(pos, c);
                    pos++;
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c:ans){
            sb.append(c);
        }
		System.out.println(sb);
    }
}