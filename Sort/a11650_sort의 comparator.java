// ref : https://st-lab.tistory.com/110

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class a11650 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] data = new int[N][2];
        StringTokenizer st;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data, comp);
        // 추가 방법 1. static 형태로 comp를 생성하고 가져오는 대신 comparator 객체를 여기서 바로 생성
        // Arrays.sort(arr, new Comparator<int[]>() {		
        //     @Override
        //     public int compare(int[] e1, int[] e2) {
        //         if(e1[0] == e2[0]) {	
        //             return e1[1] - e2[1];
        //         }
        //         else {
        //             return e1[0] - e2[0];
        //         }
        //     }
        // });

        // 방법 2. Arrays.sort내의 comp를 lambda식으로 만들어 훨씬 간단하게도 구현 가능.
        // Arrays.sort(arr, (e1, e2) -> {
        //     if(e1[0] == e2[0]) {
        //         return e1[1] - e2[1];
        //     }
        //     else {
        //         return e1[0] - e2[0];
        //     }
        // });


        for(int i=0; i<N; i++){
            sb.append(data[i][0]+" "+data[i][1]+"\n");
        }
        System.out.println(sb);
   }

   // Comparator은 입력받은 두 매개변수를 비교 <=> comparable은 자기 자신과 매개변수를 비교하는 함수 (sort시에 쓸 필요 x)
   // Arrays.sort()는 선택적으로 comparator 객체를 넘겨주어 정렬 방법을 정의 가능,
   // static 형태로 '익명 객체'를 선언, 별도의 클래스 선언 없이도 객체를 생성한다.
   // (Class name) (object name) = new (class name)() {(implementation)} 형태로 선언 가능.
   // comp의 비교 방식은 x좌표의 대소를 우선 비교, 같다면 y도 비교하도록 
   public static Comparator<int[]> comp = new Comparator<int[]>() { 
       @Override
       public int compare(int[] a, int[] b){
           if(a[0] == b[0]){
               return a[1] - b[1];
           } else {
               return a[0]-b[0];
           }
       }
   };
}