// JAVA 8 Stream에 확실히 익숙해져야 할 듯.. 없이 하니 불필요한 HashMap과 HashSet이 많이 만들어지게 됨.
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        HashMap<String, HashSet<String>> result = new HashMap<>();
        for(String rpt : report){
            StringTokenizer st = new StringTokenizer(rpt);
            String reporter = st.nextToken();
            String reporting = st.nextToken();
            if(result.containsKey(reporting)){
                result.get(reporting).add(reporter);
            } else {
                HashSet<String> rpter = new HashSet<>();
                rpter.add(reporter);
                result.put(reporting, rpter);
            }
        }

        HashMap<String, Integer> output = new HashMap<>();
        for(String id : id_list){
            output.put(id, 0);
        }
        for(String id : id_list){
            if(result.containsKey(id) && result.get(id).size()>=k){
                for(String tgt : result.get(id)){
                    output.put(tgt, output.get(tgt)+1);
                }
            }
        }
        answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            answer[i] = output.get(id_list[i]);
        }
        return answer;
    }
}