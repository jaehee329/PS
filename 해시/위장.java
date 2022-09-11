import java.util.HashMap;
import java.util.Set;
class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> c = new HashMap<>();
        int len = clothes.length;
        for(int i=0; i<len; i++){
            String category = clothes[i][1];
            if(!c.containsKey(category)){
                c.put(category,1);
            } else {
                c.put(category, c.get(category)+1);
            }
        }
        int answer = 1;
        Set<String> keys = c.keySet();
        for(String key : keys){
            answer *= c.get(key)+1;
        }
        return answer-1;
    }
}