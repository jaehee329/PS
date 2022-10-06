import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class a10814 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Obj> data = new ArrayList<Obj>();
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            data.add(new Obj(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(data, (a, b) ->{
            return a.age - b.age;
        });

        for(int i=0; i<N; i++){
            sb.append(data.get(i).age +" "+ data.get(i).name+"\n");
        }
        System.out.println(sb);
   }
}
class Obj{
    int age;
    String name;
    public Obj(int age, String name){
        this.name = name;
        this.age = age;
    }
}