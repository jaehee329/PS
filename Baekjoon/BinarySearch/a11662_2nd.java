import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a11662_2nd {
    static double[] coord;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        coord = new double[8];
        for(int i=0; i<8; i++){
            coord[i] = Integer.parseInt(st.nextToken());
        }
        double min = 0;
        double max = 1;
        double mid1 = 0;
        double mid2 = 1;
        while(Math.abs(mid1-mid2)>0.0000000001){
            mid1 = (2*min+max)/3;
            mid2 = (min+2*max)/3;
            double mid1Dist = inter(mid1);
            double mid2Dist = inter(mid2);
            if(mid1Dist<mid2Dist){
                max = mid2;
            } else {
                min = mid1;
            }
        }
        System.out.println(String.format("%.10f",inter((mid1+mid2)/2)));
    }
    private static double inter(double mid){
        double[] m = new double[2];
        m[0] = mid*coord[2] + (1-mid)*coord[0];
        m[1] = mid*coord[3] + (1-mid)*coord[1];

        double[] g = new double[2];
        g[0] = mid*coord[6] + (1-mid)*coord[4];
        g[1] = mid*coord[7] + (1-mid)*coord[5];
        return dist(m, g);
    }
    private static double dist(double[] m, double[] g){
        double mx = m[0]; double my = m[1];
        double gx = g[0]; double gy = g[1];
        return(Math.sqrt((mx-gx)*(mx-gx) + (my-gy)*(my-gy)));
    }
}
