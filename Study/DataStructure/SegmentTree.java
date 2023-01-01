/*
 * Segment Tree, 세그먼트 트리
 * 자료구조 특징: 특정 구간의 합을 구하거나 값을 수정할 때 O(logN)이 소요된다.
 * 트리의 크기는 N보다 큰 2의 거듭제곱 중 두 번째로 작은 것을 선택한다. (N이 12라면 트리의 크기는 32)
 * 혹은 귀찮다면 N*4로 지정하면 메모리는 더 소요되나 편하게 지정 가능하다.
 * 트리 배열의 인덱스를 0이 아닌 1부터 시작해 (인덱스 * 2)가 왼쪽 자식 노드의 인덱스를 가리키도록 한다.
 */

public class SegmentTree {

    private static final int[] elements = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
    private static final int SIZE = 12;
    private static final int START_IDX = 3;
    private static final int END_IDX = 7;
    private static final int UPDATE_IDX = 5;
    private static final int UPDATE_INTO = 1;
    private static int[] segmentTree;

    public static void main(String[] args) {
        init();
        System.out.println("Partial sum of start idx = " + START_IDX + " end idx = " + END_IDX + " is = " + partialSum(START_IDX, END_IDX));

        update(UPDATE_IDX, UPDATE_INTO);
        System.out.println("\nPartial sum after update = " + partialSum(START_IDX, END_IDX));
    }

    public static void init() {
        segmentTree = new int[getSize(SIZE)];
        add(0, SIZE - 1, 1);
    }

    private static int getSize(int size) {
        int h = (int)Math.ceil(Math.log(size) / Math.log(2));
        return 1 << h+1;
    }

    private static int add(int start, int end, int root) {
        if (start == end) {
            return segmentTree[root] = elements[start];
        }
        int mid = (start + end) / 2;
        return segmentTree[root] = add(start, mid, root * 2) + add(mid + 1, end, root * 2 + 1);
    }

    public static int partialSum(int startInclusive, int endNotInclusive) {
        return sum(0, SIZE - 1, 1, startInclusive, endNotInclusive);
    }

    private static int sum(int start, int end, int root, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return segmentTree[root];
        }
        int mid = (start + end) / 2;
        return sum(start, mid, root * 2, left, right) + sum(mid + 1, end, root * 2 + 1, left, right);
    }

    public static void update(int idx, int changeInto) {
        int diff = changeInto - elements[idx];
        change(0, SIZE - 1, 1, idx, diff);
    }

    private static void change(int start, int end, int root, int idx, int diff) {
        if (idx < start || idx > end) {
            return;
        }
        segmentTree[root] += diff;
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        change(start, mid, root * 2, idx, diff);
        change(mid + 1, end, root * 2 + 1, idx, diff);
    }
}
