import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        String[] character = {"RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA"};
        HashMap<String, Integer> c = new HashMap<>();
        for(String ch : character) {
            c.put(ch, 0);
        }
        for(int i=0; i<survey.length; i++){
            String t = survey[i];
            if(choices[i] != 4){
                c.put(t, c.get(t)-choices[i]+4);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        if(c.get("RT")>=c.get("TR")){
            sb.append('R');
        } else {
            sb.append('T');
        }
        if(c.get("CF")>=c.get("FC")){
            sb.append('C');
        } else {
            sb.append('F');
        }
        if(c.get("JM")>=c.get("MJ")){
            sb.append('J');
        } else {
            sb.append('M');
        }
        if(c.get("AN")>=c.get("NA")){
            sb.append('A');
        } else {
            sb.append('N');
        }
        answer = sb.toString();
        return answer;
    }
}