import java.util.*;
class Solution {
    private static HashMap<String, ArrayList<Integer>> recordHashMap = new HashMap<>();
    private static HashMap<String, Integer> totalParkTimeOfEachCar = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        setRecordHashMapFromRecords(records);
        setTotalParkTimeOfEachCar();
        return getFeeOfEachCarByFees(fees);
    }
    private static void setRecordHashMapFromRecords(String[] records) {
        int recordLen = records.length;
        for(int i=0; i<recordLen; i++){
            StringTokenizer st = new StringTokenizer(records[i]);
            int time = timeToMin(st.nextToken());
            String carNum = st.nextToken();
            if(!recordHashMap.containsKey(carNum)) {
                recordHashMap.put(carNum, new ArrayList<>());
            }
            recordHashMap.get(carNum).add(time);
        }
    }
    private static int timeToMin(String time) {
        int hour = Integer.parseInt(time.substring(0,2));
        int min = Integer.parseInt(time.substring(3,5));
        return hour*60 + min;
    }
    private static void setTotalParkTimeOfEachCar() {
        for(String carNum : recordHashMap.keySet()){
            ArrayList<Integer> list = recordHashMap.get(carNum);
            int minuteForSingleCar = 0;
            for(int i=0; i<list.size(); i++) {
                if(i%2==0){
                    minuteForSingleCar -= list.get(i);
                } else {
                    minuteForSingleCar += list.get(i);
                }
            }
            if(list.size()%2==1) {
                minuteForSingleCar += timeToMin("23:59");
            }
            totalParkTimeOfEachCar.put(carNum, minuteForSingleCar);
        }
    }
    private static int[] getFeeOfEachCarByFees(int[] fees) {
        int baseMin = fees[0];
        int baseFee = fees[1];
        int unitMin = fees[2];
        int unitFee = fees[3];
        int size = totalParkTimeOfEachCar.size();
        int[] FeeOfEachCarByFees = new int[size];
        ArrayList<String> carNums = new ArrayList<>(totalParkTimeOfEachCar.keySet());
        Collections.sort(carNums);
        for(int i=0; i<size; i++) {
            String targetCar = carNums.get(i);
            int targetMin = totalParkTimeOfEachCar.get(targetCar);
            int over = targetMin > baseMin ? targetMin-baseMin : 0;
            int fee = baseFee + (int)Math.ceil((double)over/unitMin)*unitFee;
            FeeOfEachCarByFees[i] = fee;
        }
        return FeeOfEachCarByFees;
    }
}
