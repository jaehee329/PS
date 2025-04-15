class MyCircularDeque {
    private static final int INVALID = -1;
    private Node front;
    private Node last;

    public MyCircularDeque(int k) {
        Node first = new Node(INVALID);
        Node current = first;
        for (int i = 1; i < k; i++) {
            Node newNode = new Node(INVALID);
            current.after = newNode;
            newNode.before = current;
            current = newNode;
        }
        current.after = first;
        first.before = current;
        front = first;
        last = first;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            front = front.before;
        }
        front.val = value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (!isEmpty()) {
            last = last.after;
        }
        last.val = value;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front.val = INVALID;
        if (front != last) {
            front = front.after;
        }
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        last.val = INVALID;
        if (front != last) {
            last = last.before;
        }
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front.val;
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return last.val;
    }
    
    public boolean isEmpty() {
        return front.val == INVALID;
    }
    
    public boolean isFull() {
        return last.val != INVALID && last.after == front;
    }

    private class Node {
        Node before;
        Node after;
        int val;
        public Node(int val) {
            this.before = null;
            this.after = null;
            this.val = val;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */