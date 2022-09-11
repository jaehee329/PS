class Solution {
    public int solution(String word) {
        int answer = 0;
        int[] gap = {781, 156, 31, 6, 1};
        for(int i=0; i<word.length(); i++) {
            answer++;
            int t = change(word.charAt(i));
            answer += gap[i]*t;
        }
        return answer;
    }
    private int change(char c){
        switch(c) {
            case 'A':
                return 0;
            case 'E':
                return 1;
            case 'I':
                return 2;
            case 'O':
                return 3;
            case 'U':
                return 4;
        }
        return 0;
    }
}