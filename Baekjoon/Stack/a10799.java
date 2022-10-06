import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class a10799 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean cut = false;
        int p=0, size=0;
        for(int i=0; i<s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    cut=true;
                    size++;
                    break;
                case ')':
                    if(cut){
                        cut=false;
                        size--;
                        p+=size;
                    } else {
                        cut=false;
                        if(size>0){
                            size--;
                            p++;
                        }
                    }
                    break;
                }
        }
        System.out.println(p);
    }
}