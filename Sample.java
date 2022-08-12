import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sample{
    public static void main(String[] args) throws IOException{
        LinkedList<Character> ans = new LinkedList<Character>();
        String str = "0";
        for(int i=0; i<100_000;i++){
            str+="0";
        }

        long beforeTime = System.nanoTime(); 
        for(char c : str.toCharArray()){
            ans.add(c);
        }
        long afterTime = System.nanoTime();
        long secDiffTime = (afterTime - beforeTime)/1000;
        System.out.println("diff(m) : "+secDiffTime);

        long beforeTime2 = System.nanoTime(); 
        LinkedList<Character> ans2 = new LinkedList<Character>();
        char[] newstr = str.toCharArray();
        for(char c : newstr){
            ans2.add(c);
        }
        long afterTime2 = System.nanoTime();
        long secDiffTime2 = (afterTime2 - beforeTime2)/1000; 
        System.out.println("diff(m) : "+secDiffTime2);
    }
}