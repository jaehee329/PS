import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class a5639 {
    private static class node {
        node parent;
        int value;
        node leftChild;
        node rightChild;
    }
    private static class tree {
        StringBuilder sb = new StringBuilder();
        node root;
        public tree(int val) {
            node root = new node();
            root.value = val;
            this.root = root;
        }
        public void add(int val) {
            node parent = root;
            node target = root;
            while (!(leftPuttable(val, target) || rightPuttable(val, target))) {
                parent = target;
                if (val < target.value) {
                    target = parent.leftChild;
                } else {
                    target = parent.rightChild;
                }
            }
            node newNode = new node();
            newNode.value = val;
            newNode.parent = parent;
            if (leftPuttable(val, target)) {
                target.leftChild = newNode;
            } else {
                target.rightChild = newNode;
            }
        }
        public boolean leftPuttable(int val, node target) {
            if (val < target.value && target.leftChild == null) {
                return true;
            }
            return false;
        }
        public boolean rightPuttable(int val, node target) {
            if (val > target.value && target.rightChild == null) {
                return true;
            }
            return false;
        }
        public void printPostOrder() {
            postOrder(root);
            sb.setLength(sb.length()-1);
            System.out.println(sb);
        }
        public void postOrder(node target) {
            if (target.leftChild != null) {
                postOrder(target.leftChild);
            }
            if (target.rightChild != null) {
                postOrder(target.rightChild);
            }
            sb.append(target.value + "\n");
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tree tree = new tree(Integer.parseInt(br.readLine()));
        String s = "";
        while ((s = br.readLine()) != null) {
            tree.add(Integer.parseInt(s));
        }
        tree.printPostOrder();
    }
}
