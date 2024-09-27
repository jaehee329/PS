import java.io.*;
import java.util.*;

public class a16401 {
    public static void main(String[] args) throws IOException {
        // best 길이를 x라 했을 때 x로 나눠줄 수 있는 인원수가 사람수보다 크거나 같은 최소의 x를 찾아가는 binarySearch
        // x로 나눈 몫들의 합과 나눠줘야 하는 인원수들의 비교로 binarySearch한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int manCount = Integer.parseInt(st.nextToken());
        int cookieCount = Integer.parseInt(st.nextToken());

        int[] cookieLengths = new int[cookieCount];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cookieCount; i++) {
            cookieLengths[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cookieLengths);

        System.out.println(binarySearch(cookieLengths, 1, cookieLengths[cookieCount - 1], manCount));
    }

    public static int binarySearch(int[] arr, int low, int high, int targetShare) {
        int maxLength = 0;
        while (low <= high) {
            int mid =  low + (high - low) / 2;
            int share = 0;
            for (int i = 0; i < arr.length; i++) {
                share += arr[i] / mid;
            }
            // 목표 인원을 충족하면 일단 기록을 저장하고 그보다 작게도 되나 찾아본다.
            // 충족하는 인원이 변동되지 않는 한도에서 linear하게 길이를 1씩 키우는 식으로 maxLength를 찾으려 하면 반례에 걸림.
            if (share >= targetShare) {
                maxLength = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return maxLength;
    }
}
