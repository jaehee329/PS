class MyCircularQueue {

    private static final int INVALID = -1;

    private Node front;
    private Node rear;

    public MyCircularQueue(int k) {
        Node first = new Node(null);
        Node last = first;
        for (int i = 1; i < k; i++) {
            Node node = new Node(last);
            last = node;
        }
        first.next = last;
        this.front = last;
        this.rear = last;
    }
    
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        if (front.val != INVALID) {
            rear = rear.next;
        }
        rear.val = value;
        return true;
    }
    
    public boolean deQueue() {
        if (front.val == INVALID) {
            return false;
        }
        front.val = INVALID;
        if (front == rear) {
            rear = rear.next;
        }
        front = front.next;
        return true;
    }
    
    public int Front() {
        return front.val;
    }
    
    public int Rear() {
        return rear.val;
    }
    
    public boolean isEmpty() {
        return front.val == INVALID;
    }
    
    public boolean isFull() {
        return rear.val != INVALID && rear.next == front;
    }

    private class Node {
        int val;
        Node next;
        
        public Node(Node next) {
            this.val = INVALID;
            this.next = next;
        }
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */