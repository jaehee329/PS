public class Solution5 {
    public int solution(int n, int[] tops) {
        int length = tops.length;
        int[][] dp = new int[length][4];
        int top0 = tops[0];
        // 단위: 3개(사다리꼴) 혹은 4개(큰 정삼각형)의 정삼각형의 묶음
        // 단위의 중심이 정삼각형인 경우
        dp[0][0] = 1;
        // 단위의 중심과 좌하단의 정삼각형이 합쳐진 경우
        dp[0][1] = 1;
        // 단위의 중심과 상단의 정삼각형이 합쳐진 경우
        if (top0 == 1) {
            dp[0][2] = 1;
        }
        // 단위의 중심과 우하단의 정삼각형이 합쳐진 경우
        dp[0][3] = 1;

        for (int i = 1; i < length; i++) {
            int top = tops[i];
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 10007;
            if (top == 1) {
                dp[i][2] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007;
            }
            dp[i][3] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3]) % 10007;
        }
        return (dp[length - 1][0] + dp[length - 1][1] + dp[length - 1][2] + dp[length - 1][3]) % 10007;
    }
}
