class Solution {
    public long solution(int n) {
        long a = 1;
        long b = 2;
        if(n==1){
            return 1;
        }
        for(int i=3; i<=n; i++){
            long c = (a+b)%1234567;
            a = b;
            b = c;
        }
        return b;
    }
}
