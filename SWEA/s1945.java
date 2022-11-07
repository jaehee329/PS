import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class s1945 {
    private final static int[] FACTORS = new int[] {2, 3, 5, 7, 11};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int i = 1; i <= TC; i++) {
            int target = Integer.parseInt(br.readLine());
            List<Integer> factors = factorize(target);
            System.out.print("#" + i);
            IntStream factorStream = factors.stream().mapToInt(Integer::intValue);
            factorStream.forEach(a -> System.out.print(" " + a));
            System.out.println();
        }
    }

    private static List<Integer> factorize(int target) {
        List<Integer> factors = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0));
        for (int i = 0; i < FACTORS.length; i++) {
            int factor = FACTORS[i];
            while (target % factor == 0) {
                factors.set(i, factors.get(i) + 1);
                target /= factor;
            }
        }
        return factors;
    }
}
