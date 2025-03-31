class Solution {
    public boolean isValid(String s) {
        Stack stack = new Stack(null);
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return false;
                    }
                    stack.pop();
                }
                case '{' -> stack.push(c);
                case '}' -> {
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return false;
                    }
                    stack.pop();
                }
                case '[' -> stack.push(c);
                case ']' -> {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return false;
                    }
                    stack.pop();
                }
                default -> throw new RuntimeException();
            }
        }
        if (stack.isEmpty()) {
            System.out.println(4);
            return true;
        }
        return false;
    }

    private static class Node {
        char val;
        Node next;
        public Node(char val, Node next) {
            this.val = val;
            this.next = next;
        }

        public Node(char val) {
            this.val = val;
            this.next = null;
        }
    }

    private static class Stack {
        Node last;
        public Stack(Node last) {
            this.last = last;
        }

        public void push(char val) {
            Node newNode = new Node(val, this.last);
            this.last = newNode;
        }

        public char pop() {
            char val = last.val;
            last = last.next;
            return val;
        }

        public char peek() {
            return last.val;
        }

        public boolean isEmpty() {
            return last == null;
        }
    }
}