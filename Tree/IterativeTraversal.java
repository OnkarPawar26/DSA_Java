// Online Java Compiler (Editor)
// Write and run Java online using this editor.

class Node{
    int data;
    Node left;
    Node right;

    public Node(int key){
        data = key;
        left = right = null;
    }
}


class IterativeTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();

        TreeNode node = root;

        while(true){
            if(node != null){
                st.push(node)
                node = node.left
            }else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                list.add(node.val);
                node = node.right;
            }

        }
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println("Creating tree");
        IterativeTraversal tree = new IterativeTraversal();
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
        
    }
}