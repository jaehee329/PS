import java.io.*;
import java.util.*;

public class a5545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int toppingCount = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int doughPrice = Integer.parseInt(st.nextToken());
        int toppingPrice = Integer.parseInt(st.nextToken());

        int doughCalory = Integer.parseInt(br.readLine());

        long totalPrice = doughPrice;
        long totalCalory = doughCalory;

        List<Integer> toppingCalories = new ArrayList<>(toppingCount);
        for (int i = 0; i < toppingCount; i++) {
            toppingCalories.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(toppingCalories, Comparator.reverseOrder());

        for (int i = 0; i < toppingCount; i++) {
            int toppingCalory = toppingCalories.get(i);
            if (totalCalory * (totalPrice + toppingPrice) <= (totalCalory + toppingCalory) * totalPrice) {
                totalPrice += toppingPrice;
                totalCalory += toppingCalory;
            } else {
                break;
            }
        }

        System.out.println((int) (totalCalory / totalPrice));
    }
}
