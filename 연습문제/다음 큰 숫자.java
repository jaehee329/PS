class Solution {
    public int solution(int n) {
        int tgt = Integer.bitCount(n);
        while(tgt != Integer.bitCount(++n)){}
        return n;
    }
}


// 처음에는 아래와 같이 'toBinaryString()'을 사용, 'bitCount()'가 더 효율적이어서 바꿈
// class Solution {
//     public int solution(int n) {
//         String tgt = Integer.toBinaryString(n).replace("0", "");
//         while(!tgt.equals(Integer.toBinaryString(++n).replace("0", ""))){}
//         return n;
//     }
// }
