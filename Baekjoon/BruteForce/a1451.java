// 진짜 노가다중 노가다 문제.. 풀지 말자 이런거 경우 나눠서 메소드도 못 빼고 다 따져서 해야 함
// 그나마 유의할 건 사각형 정수 합을 long으로 저장해야 한다는 것.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a1451 {
    static int N;
    static int M;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            String str = br.readLine();
            for(int j=1; j<=M; j++){
                map[i][j] = str.charAt(j-1)-'0';
            }
        }
        long max = 0;
        if(N>=3){
            for(int lenA=1; lenA<=N-2; lenA++) {
                for(int lenB=1; lenB<=N-lenA-1; lenB++) {
                    int lenC = N-lenA-lenB;
                    long sumA = squareSum(1, lenA, 1, M);
                    long sumB = squareSum(1+lenA, lenB, 1, M);
                    long sumC = squareSum(1+lenA+lenB, lenC, 1, M);
                    if(sumA*sumB*sumC>max){
                        max = sumA*sumB*sumC;
                    }                 
                }
            }
        }
        if(M>=3){
            for(int lenA=1; lenA<=M-2; lenA++) {
                for(int lenB=1; lenB<=M-lenA-1; lenB++) {
                    int lenC = M-lenA-lenB;
                    long sumA = squareSum(1, N, 1, lenA);
                    long sumB = squareSum(1, N, 1+lenA, lenB);
                    long sumC = squareSum(1, N, 1+lenA+lenB, lenC);
                    if(sumA*sumB*sumC>max){
                        max = sumA*sumB*sumC;
                    }                 
                }
            }
        }
        if(N>=2 && M>=2){
            for(int lenA = 1; lenA<=N-1; lenA++) {
                for(int lenB = 1; lenB<=M-1; lenB++) {
                    int lenC = M-lenB;
                    long sumA = squareSum(1, lenA, 1, M);
                    long sumB = squareSum(lenA+1, N-lenA, 1, lenB);
                    long sumC = squareSum(lenA+1, N-lenA, 1+lenB, lenC);
                    if(sumA*sumB*sumC>max){
                        max = sumA*sumB*sumC;
                    }

                    sumA = squareSum(N-lenA+1, lenA, 1, M);
                    sumB = squareSum(1, N-lenA, 1, lenB);
                    sumC = squareSum(1, N-lenA, 1+lenB, lenC);
                    if(sumA*sumB*sumC>max){
                        max = sumA*sumB*sumC;
                    }
                }
            }
            for(int lenA = 1; lenA<=M-1; lenA++) {
                for(int lenB = 1; lenB<=N-1; lenB++) {
                    int lenC = N-lenB;
                    long sumA = squareSum(1, N, 1, lenA);
                    long sumB = squareSum(1, lenB, 1+lenA, M-lenA);
                    long sumC = squareSum(1+lenB, lenC, 1+lenA, M-lenA);
                    if(sumA*sumB*sumC>max){
                        max = sumA*sumB*sumC;
                    }
                    sumA = squareSum(1, N, M-lenA+1, lenA);
                    sumB = squareSum(1, lenB, 1, M-lenA);
                    sumC = squareSum(1+lenB, lenC, 1, M-lenA);
                    if(sumA*sumB*sumC>max){
                        max = sumA*sumB*sumC;
                    }
                }
            }
        }
        System.out.println(max);
    }

    private static int squareSum(int Y, int ylen, int X, int xlen) {
        int sum = 0;
        for(int i=Y; i<Y+ylen; i++){
            for(int j=X; j<X+xlen; j++){
                sum += map[i][j];
            }
        }
        return sum;
    }
}
