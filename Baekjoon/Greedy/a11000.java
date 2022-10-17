// Greedy + Priority Queue
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class a11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 수업의 끝나는 시간을 오름차순으로 정렬하는 우선순위 큐 생성 (단순 배열을 사용하면 추후 정렬 한 번 필요)
        PriorityQueue<Integer[]> classHoursEndAscendingQ = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        StringTokenizer st;
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            Integer start = Integer.parseInt(st.nextToken());
            Integer end = Integer.parseInt(st.nextToken());
            classHoursEndAscendingQ.add(new Integer[]{start, end});
        }     
        
        // 현재 필요한 강의실들을 끝나는 시간을 기준으로 저장하는 우선순위 큐
        PriorityQueue<Integer> classroomEndHoursQ = new PriorityQueue<>();
        classroomEndHoursQ.add(0);
        while(!classHoursEndAscendingQ.isEmpty()) {
            Integer[] classStartAndEnd = classHoursEndAscendingQ.poll();
            int start = classStartAndEnd[0];
            int end = classStartAndEnd[1];
            int minClassroomEndHour = classroomEndHoursQ.peek();
            if(minClassroomEndHour <= start) {
                classroomEndHoursQ.poll();
            }
            classroomEndHoursQ.add(end);
        }
        System.out.println(classroomEndHoursQ.size());


        // 아래는 강의실 저장 배열 + 끝나는 시간 ArrayList로 저장하는 버전

        // int[][] classHours = new int[N][2];
        // StringTokenizer st;
        // for(int i=0; i<N; i++) {
        //     st = new StringTokenizer(br.readLine());
        //     classHours[i][0] = Integer.parseInt(st.nextToken());
        //     classHours[i][1] = Integer.parseInt(st.nextToken());
        // }

        // Arrays.sort(classHours, (o1, o2) -> o1[0]-o2[0]);
        // ArrayList<Integer> classroomEndHourArr = new ArrayList<>();
        // classroomEndHourArr.add(0);
        // for(int i=0; i<N; i++) {
        //     int curClassStartHour = classHours[i][0];
        //     int curClassEndHour = classHours[i][1];
        //     for(int j=0; j<classroomEndHourArr.size(); j++) {
        //         int curClassroomEndHour = classroomEndHourArr.get(j);
        //         if(curClassroomEndHour <= curClassStartHour) {
        //             classroomEndHourArr.set(j, curClassEndHour);
        //             break;
        //         } 
        //         if(j == classroomEndHourArr.size()-1) {
        //             classroomEndHourArr.add(curClassEndHour);
        //             break;
        //         }
        //     }
        // }
        // System.out.println(classroomEndHourArr.size());
    }    
}
