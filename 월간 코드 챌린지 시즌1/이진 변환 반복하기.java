class Solution {
    public int[] solution(String s) {
        int cnt = 0;
        int loop = 0;
        while(!s.equals("1")){
            loop++;
            cnt += s.length();
            s = s.replace("0","");
            cnt -= s.length();
            s = Integer.toBinaryString(s.length());
        }
        return new int[]{loop, cnt};
    }
}