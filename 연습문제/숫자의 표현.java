class Solution {
    public int solution(int n) {
        int answer = 1;
        double mid = 0;
        int elems=2;
        while((mid=(double)n/elems)>1){
            int start = (int)Math.ceil(mid-elems/2); //2.5-2
            if(start<1){
                break;
            }
            if((2*start+elems-1)*elems==n*2){
                answer++;
            }
            elems++;
        }
        return answer;
    }
}
