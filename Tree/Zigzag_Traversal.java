/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        if(root == null){
            return list;
        }
        queue.offer(root);
        int flag = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> sublist = new ArrayList<>();
            for(int i = 0;i < size;i++){
                
                TreeNode curr = queue.poll();
                sublist.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
        
                }
                if(curr.right != null){
                    queue.offer(curr.right);
        
                }
            }
            if(flag == 1){
                Collections.reverse(sublist);
                list.add(sublist);
                flag = 0;   
            }else{
                list.add(sublist);
                flag = 1;
            }
            
        }
        return list;

    }
}