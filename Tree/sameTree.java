public class sameTree{
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        preorder( p ,list1);
        preorder(q, list2);

        return list1.equals(list2);
    }

    public void preorder(TreeNode root ,List<String> list){

        if(root == null){
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));
        preorder(root.left,list);
        preorder(root.right,list);

    }
}