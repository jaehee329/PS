class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            Node newNode = new Node(temperatures[i], i);
            while (!stack.isEmpty() && stack.peek().val < temperatures[i]) {
                Node colder = stack.pop();
                ans[colder.idx] = i - colder.idx;
            }
            stack.push(newNode);
        }
        return ans;
    }

    private class Node {
        private int val;
        private int idx;

        public Node(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}