import java.util.HashSet;
class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        HashSet<String> w = new HashSet<>();
        int cnt = 0;
        String prev = Character.toString(words[0].charAt(0));
        for(String word : words) {
            cnt++;
            if(prev.charAt(prev.length()-1) != word.charAt(0) || w.contains(word)){
                answer[0] = (cnt-1)%n+1;
                answer[1] = (cnt-1)/n+1;
                break;
            }
            w.add(word);
            prev = word;
        }
        System.out.println(cnt);
        return answer;
    }
}