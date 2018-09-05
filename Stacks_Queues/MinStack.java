public class MinStack {
    public class Node {
        int val;
        Node next;
        Node nextMin;
        
        public Node(int val) {
            this.val = val;
        }
    }
    Node top;
    Node min;
    /** initialize your data structure here. */
    public MinStack() {
        top = null;
        min = null;
    }
    
    public void push(int x) {
        Node temp = top;
        top = new Node(x);
        top.next = temp;
        if (min == null) min = top;
        else if (min.val > top.val) {
            Node min2 = min;
            min = top;
            min.nextMin = min2;
        }
    }
    
    public void pop() {
        if (top == min) {
            min = min.nextMin;
        }
        top = top.next;
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return min.val;
    }
}
