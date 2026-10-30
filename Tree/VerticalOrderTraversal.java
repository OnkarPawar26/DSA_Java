import java.util.*;

public class VerticalOrderTraversal {
    static class Node {
        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static class Tuple {
        int row;
        int col;
        Node node;

        public Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;

        }
    }

    Node root;

    public List<List<Integer>> verticalTraversal(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple it = q.remove();
            int col = it.col;
            int row = it.row;
            Node node = it.node;

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }

            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>());
            }

            map.get(col).get(row).offer(node.data);

            if (node.left != null) {
                q.offer(new Tuple(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        for (TreeMap<Integer, PriorityQueue<Integer>> inner : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : inner.values()) {
                while (!nodes.isEmpty()) {
                    ans.get(ans.size() - 1).add(nodes.poll());
                }
            }
        }
        return ans;
    }

    public static void main(String[] a) {
        VerticalOrderTraversal tree = new VerticalOrderTraversal();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(10);
        tree.root.right.right = new Node(10);
        tree.root.right.left = new Node(9);

        tree.root.left.left.right = new Node(5);
        tree.root.left.left.right.right = new Node(6);

        System.out.println(tree.verticalTraversal(tree.root));

    }
}
