// Online Java Compiler (Editor)
// Write and run Java online using this editor.
import java.util.*;
class Node{
    int val;
    Node left;
    Node right;

    public Node(int key){
        val = key;
        left = right = null;
    }
}

class Pair{
    int num;
    Node node;

    public Pair(Node node,int num){
        this.num = num;
        this.node = node;
    }
}

class AllTraversal {
    Node root;

    public void preInPostTraversal(Node root){
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
 
        if(root == null) return;

        while(!st.isEmpty()){
            Pair it = st.pop();
            
            if(it.num == 1){
                pre.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.left != null){
                    st.push(new Pair(it.node.left,1));
                }
            }else if(it.num == 2){
                in.add(it.node.val);
                it.num++;
                st.push(it);

                if(it.node.right != null){
                    st.push(new Pair(it.node.right,1));
                }
            }else{
                post.add(it.node.val);
                
            }
        }

        System.out.println(pre);
        System.out.println(in);
        System.out.println(post);
    }
    public static void main(String[] args) {
        AllTraversal tree = new AllTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(7);
        tree.root.left.left.right = new Node(8);
        tree.root.left.right.right = new Node(9);

        tree.root.right.right = new Node(6);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.right = new Node(11);

        tree.preInPostTraversal(tree.root);

        
    }
}