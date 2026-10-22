// boundary traversal

import java.util.*;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
      this.data = data;
      left = right = null;
    }
    
  }

public class Main {

  static Node root;

  public static boolean isLeaf(Node root){
    if(root.left == null && root.right == null){
      return true;
    }
    return false;
  }

  public static void leftSide(Node root, ArrayList<Integer> res){
    if(root == null){
      return;
    }

    if(!isLeaf(root)){
      res.add(root.data);
    }

    Node curr = root.left;
    while(true){
      if(isLeaf(curr)){
        return;
      }
      else if(curr.left == null){
        curr = curr.right;
        res.add(curr.data);
      }
      else{
        res.add(curr.data);
        curr = curr.left;
      }
    }
  }

  public static void leaves(Node root,ArrayList<Integer> res ){
    if (root == null) {
        return;
    }
    if(isLeaf(root)){
      res.add(root.data);
      return;
    }

    leaves(root.left,res);
    leaves(root.right,res);

  }

 public static void rightSide(Node root, ArrayList<Integer> temp) {
    if (root == null) {
        return;
    }

    Node curr = root.right;

    while (curr != null) {
        if (isLeaf(curr)) {
            return;
        }

        temp.add(curr.data);

        if (curr.right != null) {
            curr = curr.right;
        } else {
            curr = curr.left;
        }
    }
}

    public static void main(String[] args) {
      root = new Node(1);

root.left = new Node(2);
root.right = new Node(3);

root.left.left = new Node(4);
root.left.right = new Node(5);
root.right.left = new Node(6);
root.right.right = new Node(7);

root.left.left.left = new Node(8);
root.left.left.right = new Node(9);
root.left.right.left = new Node(10);
root.left.right.right = new Node(11);

root.right.left.left = new Node(12);
root.right.left.right = new Node(13);
root.right.right.left = new Node(14);
root.right.right.right = new Node(15);

root.left.left.left.left = new Node(16);
root.left.left.left.right = new Node(17);
root.left.right.right.left = new Node(18);
root.right.left.right.left = new Node(19);
root.right.right.right.right = new Node(20);
root.right.right.right.right.right = new Node(21);

    ArrayList<Integer> res = new ArrayList<>();

      leftSide(root,res);
      leaves(root,res);
      ArrayList<Integer> temp = new ArrayList<>();

      rightSide(root,temp);

      for(int i = temp.size()-1; i >= 0;i--){
        res.add(temp.get(i));
      }


      for(int i : res){
        System.out.print(i + " ");
      }






    }
}