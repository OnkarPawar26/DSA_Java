// package DSA_Java.Tree;
import java.util.*;

public class TopViewOfBT {

    static class Node{
        int data;
        Node right;
        Node left;

        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }

    static class Pair{
        int line;
        Node node;

        public Pair(int line , Node node ){
            this.line = line;
            this.node = node;
        }
    }
    Node root;

    public static ArrayList<Integer> topView(Node root){
        ArrayList<Integer> ans = new ArrayList<>();

        if(root == null) return ans;
        Queue<Pair> q = new LinkedList<>();
        Map<Integer,Integer> map = new TreeMap<>();
        q.offer(new Pair(0, root));
        while(!q.isEmpty()){
            Pair it = q.remove();

            int line = it.line;
            Node temp = it.node;

            if(map.get(line) == null) map.put(line,temp.data);

            if(temp.left != null){
                q.offer(new Pair(line -1, temp.left));
            }

            if(temp.right != null){
                q.offer(new Pair(line+1, temp.right));
            }
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }

        return ans;
    }

    public static void main(String[] a){
        TopViewOfBT tree = new TopViewOfBT();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(7);

        tree.root.left.right.left = new Node(6);

        System.out.println(topView(tree.root));;
    }
}
