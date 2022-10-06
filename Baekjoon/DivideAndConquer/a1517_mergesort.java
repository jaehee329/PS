import java.util.*;
import java.io.*;

public class a1517_mergesort {
    static long cnt = 0;
	static int[] sorted;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        sorted = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        mergeSort(a, 0 ,N-1);
        System.out.println(cnt);
    }
    static void mergeSort(int[] a, int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(a, low, mid);
            mergeSort(a, mid+1, high);
            merge(a, low, mid, high);
        }
    }
 
    static void merge(int[] a, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int index = low;
 
        while(i <= mid && j <= high) {
            if(a[i] <= a[j])
                sorted[index++] = a[i++];
            else {
                sorted[index++] = a[j++];
                cnt += (mid + 1 - i);
            }
        }
 
        while(i <= mid) 
            sorted[index++] = a[i++];
        
        while(j <= high)
            sorted[index++] = a[j++];
 
        for(int k=low; k<=high; k++)
            a[k] = sorted[k];
    }
}