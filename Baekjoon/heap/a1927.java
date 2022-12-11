// min heap
import java.io.*;

public class a1927 {
    private static class Heap {
        public int size = 0;
        public int[] data;

        public Heap(int N) {
            data = new int[N+1];
        }
        
        public void add(int val) {
            siftUp(++size, val);
        }

        private void siftUp(int idx, int val) {
            while (idx > 1) {
                int parentIdx = getParent(idx);
                int parentVal = data[parentIdx];
                if (parentVal < val) {
                    break;
                }
                data[idx] = parentVal;
                idx = parentIdx;
            }
            data[idx] = val;
        }

        public int remove() {
            if (size == 0) {
                return 0;
            }
            int result = data[1];
            int val = data[size];
            data[size] = 0;
            size--;
            siftDown(1, val);
            return result;
        }

        private void siftDown(int idx, int val) {
            int parentIdx = idx;
            int child;
            while ((child = getLeftChild(parentIdx)) <= size) {
                int right = getRightChild(parentIdx);
                int leftChildVal = data[child];
                if(right <= size && leftChildVal > data[right]) {
                    child = right;
                    leftChildVal = data[child];
                }
                if(val < leftChildVal){
                    break;
                }
                data[parentIdx] = leftChildVal;
                parentIdx = child;
            }
            data[parentIdx] = val;
        }


        private int getParent(int index) {
            return index / 2;
        }

        private int getLeftChild(int index) {
            return index * 2;
        }

        private int getRightChild(int index) {
            return index * 2 + 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Heap h = new Heap(N);
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            int t = Integer.parseInt(br.readLine());
            if (t == 0) {
                sb.append(h.remove() + "\n");
                continue;
            }
            h.add(t);
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }
}
