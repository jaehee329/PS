import java.io.*;

public class a2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int[][] population = new int[15][15];
        for (int i = 1; i <= 14; i++) {
            population[0][i] = i;
        }
        for (int i = 1; i <= 14; i++) {
            for (int j = 1; j <= 14; j++) {
                population[i][j] = population[i][j - 1] + population[i - 1][j]; 
            }
        }
        
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(population[k][n] + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
