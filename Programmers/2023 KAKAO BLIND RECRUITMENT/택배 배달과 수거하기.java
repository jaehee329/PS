class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long length = 0;
        int farthestDelivery = shrink(deliveries, n - 1);
        int farthestPickup = shrink(pickups, n - 1);
        while (farthestDelivery > -1 || farthestPickup > -1) {
            // 가장 멀리 떨어진 것부터 cap개 줄여 deliveries, pickups를 갱신, farthestXXX를 수정한다.
            int farthest = Math.max(farthestDelivery, farthestPickup);
            farthestDelivery = decreaseFarthest(deliveries, farthestDelivery, cap);
            farthestPickup = decreaseFarthest(pickups, farthestPickup, cap);
            length += (farthest + 1) * 2;
        }
        return length;
    }
    
    private int decreaseFarthest(int[] remainders, int farthestIndex, int amount) {
        int index = farthestIndex;
        while (amount > 0 && index > -1) {
            if (remainders[index] == 0) {
                index--;
            } else {
                int decrease = Math.min(amount, remainders[index]);
                amount -= decrease;
                remainders[index] -= decrease;
            }
        }
        return shrink(remainders, index);
    }
    
    private int shrink(int[] arr, int index) {
        while (index > -1) {
            if (arr[index] == 0) {
                index--;
                continue;
            }
            break;
        }
        return index;
    }
}