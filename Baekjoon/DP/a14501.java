import java.io.*;
import java.util.*;

public class a14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int days = Integer.parseInt(br.readLine());
        CostAndPay[] costAndPays = new CostAndPay[days + 1];
        StringTokenizer st;
        for (int i = 0; i < days; i++) {
            st = new StringTokenizer(br.readLine());
            costAndPays[i] = new CostAndPay(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        // dp[i] 는 i일 혹은 이전에 일이 끝나는 경우 중 가장 많은 소득을 올리는 경우
        int[] dp = new int[days + 1];
        for (int i = 0; i < days; i++) {
            CostAndPay costAndPay = costAndPays[i];
            dp[i + 1] = Math.max(dp[i], dp[i + 1]); // 내일의 최대 소득은 오늘의 최대 소득 이상
            if (i + costAndPay.timeCost <= days) { // 오늘 일이 최대 날짜 이전에 끝나는 경우, 오늘 일이 끝나는 날짜의 최대 소득 = Math.max(해당 날짜의 기존 소득, 오늘 일을 무조건 경우의 소득)
                dp[i + costAndPay.timeCost] = Math.max(dp[i + costAndPay.timeCost], dp[i] + costAndPay.pay);
            }
        }
        System.out.println(dp[days]);
    }

    private static class CostAndPay {
        int timeCost;
        int pay;
        public CostAndPay(int timeCost, int pay) {
            this.timeCost = timeCost;
            this.pay = pay;
        }
    }
}
