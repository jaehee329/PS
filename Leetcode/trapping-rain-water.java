class Solution {
    public int trap(int[] height) {
        // 왼쪽부터 시작, 지금까지의 가장 큰 길이와 위치를 저장
        // 마지막 최대 길이를 만날때까지 순회
        // 현재 길이가 최대 길이보다 작다면, (현 길이 - 최대 길이)를 적립
        // 현재 길이가 최대 길이와 같거나 더 크다면, 적립된 길이를 저장하고 현재 길이를 최대 길이로 갱신
        // 마지막 최대 길이부턴... 같은 동작을 맨 뒤에서부터 마지막 최대 길이까지 수행
        int lastMaxHeightIdx = findLastMaxHeightIdx(height);
        int currentMaxHeight = 0;
        int trappedWater = 0;
        int tempTrappedWater = 0;
        // left -> right
        for (int i = 0; i <= lastMaxHeightIdx; i++) {
            int currentHeight = height[i];
            if (currentHeight < currentMaxHeight) {
                tempTrappedWater += currentMaxHeight - currentHeight;
            } else {
                trappedWater += tempTrappedWater;
                tempTrappedWater = 0;
                currentMaxHeight = currentHeight;
            }
        }

        currentMaxHeight = 0;
        tempTrappedWater = 0;
        // right -> left
        for (int i = height.length - 1; i >= lastMaxHeightIdx; i--) {
            int currentHeight = height[i];
            if (currentHeight < currentMaxHeight) {
                tempTrappedWater += currentMaxHeight - currentHeight;
            } else {
                trappedWater += tempTrappedWater;
                tempTrappedWater = 0;
                currentMaxHeight = currentHeight;
            }
        }
        return trappedWater;
    }

    private int findLastMaxHeightIdx(int[] height) {
        int maxHeight = 0;
        int maxHeightIdx = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] >= maxHeight) {
                maxHeight = height[i];
                maxHeightIdx = i;
            }
        }
        return maxHeightIdx;
    }
}