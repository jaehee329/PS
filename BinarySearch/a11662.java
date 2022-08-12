import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class a11662 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        double ax1 = Double.parseDouble(st.nextToken());
        double ay1 = Double.parseDouble(st.nextToken());
        double ax2 = Double.parseDouble(st.nextToken());
        double ay2 = Double.parseDouble(st.nextToken());
        double cx1 = Double.parseDouble(st.nextToken());
        double cy1 = Double.parseDouble(st.nextToken());
        double cx2 = Double.parseDouble(st.nextToken());
        double cy2 = Double.parseDouble(st.nextToken());
        
        int del = 1000000;
        
        double adx = (ax2-ax1) / del;
        double ady = (ay2-ay1) / del;
        double cdx = (cx2-cx1) / del;
        double cdy = (cy2-cy1) / del;
        
        double i = -1*((ax1-cx1) * (adx-cdx) + (ay1-cy1) * (ady-cdy)) / (Math.pow(adx-cdx, 2) + Math.pow(ady-cdy, 2));
        
        if(i < del && i > 0 && !Double.isNaN(i)) {
            double min = dist(ax1+adx*i, ay1+ady*i, cx1+cdx*i, cy1+cdy*i);
            System.out.println(String.format("%.10f",min));
        } else {
            double min1 = dist(ax1, ay1, cx1, cy1);
            double min2 = dist(ax2, ay2, cx2, cy2);
            System.out.println(String.format("%.10f",Math.min(min1, min2)));
        }
    }
    private static double dist(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2-x1, 2) + Math.pow(y2-y1, 2));
    }
}
