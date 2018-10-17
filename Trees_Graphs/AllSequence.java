import java.util.*;
public class AllSequence {
    static ArrayList<LinkedList<Integer>> allSequence(Node node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList();
        if (node == null) {
            result.add(new LinkedList());
            return result;
        }
        LinkedList<Integer> prefix = new LinkedList();
        prefix.add(node.data);
        ArrayList<LinkedList<Integer>> leftSeq = allSequence(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequence(node.right);

        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second, 
        ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
            if (first.size() == 0 || second.size() == 0) {
                LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
                result.addAll(first);
                result.addAll(second);
                results.add(result);
                return;
            }

            System.out.println(first.toString());
            System.out.println(second.toString());
            int headFirst = first.removeFirst();
            prefix.addLast(headFirst);
            weaveLists(first, second, results, prefix);
            prefix.removeLast();
            first.addFirst(headFirst);

            int headSecond = second.removeFirst();
            prefix.addLast(headSecond);
            weaveLists(first, second, results, prefix);
            prefix.removeLast();
            second.addFirst(headSecond);

    }

    public static void main(String[] args) {
        Node head = new Node(5);
        Node nine = new Node(9);
        Node ten = new Node(10);
        Node fifteen = new Node(15);
        Node two = new Node(2);
        Node one = new Node(1);
        Node three = new Node(3);
        two.left = one;
        two.right = three;
        nine.left = ten;
        nine.right = fifteen;
        head.left = nine;
        head.right = two;
        for (LinkedList<Integer> list : allSequence(head)) {
            System.out.println(list.toString());
            
        }
    }
}

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}