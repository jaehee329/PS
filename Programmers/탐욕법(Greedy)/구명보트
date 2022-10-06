class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int[] weights = new int[241];
        int len = people.length;
        for(int i=0; i<len; i++){
            weights[people[i]]++;
        }
        for(int i=40; i<=240; i++){
            while(weights[i]>0){
                weights[i]--;
                answer++;
                for(int j=limit-i; j>=40; j--){
                    if(weights[j]>0){
                        weights[j]--;
                        break;
                    }
                }
            }
        }
        return answer;
    }
}
