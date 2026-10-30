import java.util.*;

public class LevelOrder {
    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    Node root;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) { 
            int size = q.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
                subList.add(node.data);
            }
            ans.add(subList);

        }

        return ans;
    }

    public static void main(String[] a) {
        LevelOrder tree = new LevelOrder();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(10);
        tree.root.right.right = new Node(10);
        tree.root.right.left = new Node(9);

        tree.root.left.left.right = new Node(5);
        tree.root.left.left.right.right = new Node(6);

        System.out.println(tree.levelOrder(tree.root));

    }

}
