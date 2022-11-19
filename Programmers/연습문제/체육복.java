class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        boolean[] remain = new boolean[n+1];
        boolean[] needs = new boolean[n+1];
        
        for(int i: lost) {
            needs[i] = true;
        }
        for(int i: reserve) {
            if(!needs[i]){
                remain[i] = true;
            } else {
                needs[i] = false;
                answer++;
            }
        }
        for(int i=1; i<n+1; i++) {
            if(needs[i]){
                for(int j=i-1; j<=i+1; j++) {
                    try {
                        if(remain[j]==true){
                            remain[j]=false;
                            answer++;
                            break;
                        }
                    } catch(Exception e) {}
                }
            }
        }
        return answer;
    }
}
