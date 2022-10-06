class Solution {
    public String solution(int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        int x = 1;
        while(true){
            int lower = 3*((int)Math.pow(3, x-1)-1)/2 + 1;
            int upper = 3*((int)Math.pow(3, x)-1)/2;
            if(n>=lower && n<=upper){
                break;
            }
            x++;
        }
        int nth = n-3*((int)Math.pow(3, x-1)-1)/2;
        int xp = x;
        for(int i=0; i<xp; i++){
            x--;
            int t = (nth-1)/(int)Math.pow(3, x);
            if(t==0){
                sb.append('1');
            } else if(t==1){
                sb.append('2');
            } else {
                sb.append('4');
            }
            nth = (nth-1)%(int)Math.pow(3, x)+1;
        }
        System.out.println(sb);
        return sb.toString();
    }
}