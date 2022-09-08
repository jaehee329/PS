class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0; i<s.length(); i++){
            if(i==0 || (s.charAt(i-1)==' ' && Character.isAlphabetic(s.charAt(i)))){
                sb.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        return sb.toString();
    }
}