// bottom-up approach : timeout -> changed to top-down
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.HashSet;
public class a11726 {
    static Integer[] ans;
    public static void main(String[] args) throws IOException{
        HashMap<String, HashMap<String, Integer>> result = new HashMap<>();
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        
        for(String rpt : report){
            StringTokenizer st = new StringTokenizer(rpt);
            String reporter = st.nextToken();
            String reporting = st.nextToken();
            HashMap<String, Integer> rpter = new HashMap<>();
            rpter.put(reporter, 1);
            result.put(reporting, rpter);
            System.out.println(rpter.size());
        }
        System.out.println(result);
        System.out.println(result.size());
        System.out.println(result.get("frodo").size());
    }
}
