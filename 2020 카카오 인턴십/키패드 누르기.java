class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int[] lPos = new int[]{3, 0};
        int[] rPos = new int[]{3, 2};
        for(int i=0; i<numbers.length; i++) {
            int target = numbers[i];
            if(target==1 || target==4 || target==7) {
                sb.append('L');
                lPos = toCoord(target);
            } else if(target==3 || target==6 || target==9){
                sb.append('R');
                rPos = toCoord(target);
            } else {
                int[] t = toCoord(target);
                int lDist = dist(lPos, t);
                int rDist = dist(rPos, t);
                if(lDist > rDist || (lDist==rDist && hand.equals("right"))) {
                    sb.append('R');
                    rPos=t;
                } else {
                    sb.append('L');
                    lPos=t;
                }
            }
        }
        System.out.println(toCoord(6)[0] +" "+ toCoord(6)[1]);
        return sb.toString();
    }
    private int[] toCoord(int target) {
        if(target==0) {
            return new int[]{3,1};
        } else {
            return new int[]{(target-1)/3, (target-1)%3};
        }
    }
    private int dist(int[] handPos, int[] t) {
        return Math.abs(handPos[0]-t[0])+Math.abs(handPos[1]-t[1]);
    }
}