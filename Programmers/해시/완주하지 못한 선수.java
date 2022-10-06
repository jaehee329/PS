import java.util.HashMap;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> m = new HashMap<>();
        String answer = "";
        for(int i=0; i<completion.length; i++) {
            if(m.containsKey(completion[i])){
                m.put(completion[i], m.get(completion[i])+1);
            } else {
                m.put(completion[i], 1);
            }
        }
        System.out.println(m.size());
        for(int i=0; i<participant.length; i++){
            if(!m.containsKey(participant[i]) || m.get(participant[i])==0) {
                answer = participant[i];
            } else {
                m.put(participant[i], m.get(participant[i])-1);
            }
        }
        return answer;
    }
}