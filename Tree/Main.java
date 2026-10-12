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

class Main {
    Node root;

    void preOrder(Node node){

        if(node == null){
            return ;
        }

        System.out.print(node.data+" ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void inOrder(Node node){
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }

    void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+" ");
    }
    
    public static void main(String[] args) {
        System.out.println("Creating tree");
        Main tree = new Main();
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
        

        System.out.println("Printing preorder traversal : ");
        tree.preOrder(tree.root);
        System.out.println();

        System.out.println("Printing inorder traversal : ");
        tree.inOrder(tree.root);
        System.out.println();

        System.out.println("Printing postorder traversal : ");
        tree.postOrder(tree.root);
    }
}