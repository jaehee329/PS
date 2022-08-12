import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class a10825 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<Obj> data = new ArrayList<Obj>();
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            data.add(new Obj(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(data, (a, b) ->{
            if (a.kor == b.kor){
                if (a.eng == b.eng){
                    if (a.math == b.math){
                        return a.name.compareTo(b.name);
                    } else {
                        return b.math - a.math;
                    }
                } else {
                    return a.eng - b.eng;
                }
            } else {
                return b.kor - a.kor;
            }
        });

        for(int i=0; i<N; i++){
            sb.append(data.get(i).name+"\n");
        }
        System.out.println(sb);
   }
}
class Obj{
    String name;
    int kor, eng, math;
    public Obj(String name, int kor, int eng, int math){
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }
}