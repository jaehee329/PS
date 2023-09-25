import java.io.*;

public class a16171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();
        char[] filtered = new char[inputs.length];
        int cnt = 0;
        for (int i = 0; i < inputs.length; i++) {
            if (Character.isAlphabetic(inputs[i])) {
                filtered[cnt] = inputs[i];
                cnt++;
            }
        }
        char[] trimmed = new char[cnt];
        System.arraycopy(filtered, 0, trimmed, 0, cnt);

        String string = new String(trimmed);
        String target = br.readLine();
        if (string.contains(target)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
