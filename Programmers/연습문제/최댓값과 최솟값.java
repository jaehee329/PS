import java.util.StringTokenizer;
class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s);
        int length = st.countTokens();
        int max = Integer.parseInt(st.nextToken());
        int min = max;
        for(int i=1; i<length; i++){
            int t = Integer.parseInt(st.nextToken());
            max = t > max ? t : max;
            min = t < min ? t : min;
        }
        return Integer.toString(min) + " " + Integer.toString(max);
    }
}