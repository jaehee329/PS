import java.io.*;

public class a1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();

        int length = s.length();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = s.charAt(i) - '0';
        }

        for (int i = 0; i < length; i++) {
            int max = 0;
            int maxIdx = i;
            for (int j = i; j < length; j++) {
                if (numbers[j] > max) {
                    max = numbers[j];
                    maxIdx = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[maxIdx];
            numbers[maxIdx] = temp;
        }

        for (int i = 0; i < length; i++) {
            bw.write(String.valueOf(numbers[i]));
        }
        bw.flush();
        bw.close();
    }
}
