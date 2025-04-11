class MyStack {
    // 큐: 먼저 넣은 게 먼저 빠짐
    // 스택: 먼저 넣은 게 나중에 빠짐
    // 큐 두 개? stack pop 시에는 마지막 남은 것까지 queue에서 pop하여 다음 queue에 넣고, 마지막을 반환한다.
    // 1 2 3 4 5
    // 2 3 4 5 -> 1
    // 3 4 5 -> 1 2
    // 4 5 -> 1 2 3
    // 5 -> 1 2 3 4
    // push? 그냥 넣으면 됨
    // 1 2 3 4 5 6
    // top? pop과 동일한 방식.
    private Queue<Integer> mainQueue;

    public MyStack() {
        this.mainQueue = new LinkedList<>();
    }
    
    public void push(int x) {
        mainQueue.add(x);
    }
    
    public int pop() {
        if (empty()) {
            return 0;
        }
        Queue<Integer> subQueue = new LinkedList<>();
        int lastVal = 0;
        while (!mainQueue.isEmpty()) {
            lastVal = mainQueue.poll();
            if (!mainQueue.isEmpty()) {
                subQueue.add(lastVal);
            }
        }
        mainQueue = subQueue;
        return lastVal;
    }
    
    public int top() {
        if (empty()) {
            return 0;
        }
        Queue<Integer> subQueue = new LinkedList<>();
        int lastVal = 0;
        while (!mainQueue.isEmpty()) {
            lastVal = mainQueue.poll();
            subQueue.add(lastVal);
        }
        mainQueue = subQueue;
        return lastVal;
    }
    
    public boolean empty() {
        return mainQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */