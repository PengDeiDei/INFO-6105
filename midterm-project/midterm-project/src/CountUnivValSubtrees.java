import java.util.LinkedList;
import java.util.Queue;

public class CountUnivValSubtrees {

    public int countUnivValSubtree(TreeNode root){
        int count = countBFS(root,0);

        return count;
    }

    private int countBFS(TreeNode root, int count){
        if(root == null) return 0;

        Queue<TreeNode> treeQue = new LinkedList<>();
        treeQue.add(root);

        while(!treeQue.isEmpty()){
            TreeNode node = treeQue.poll();

            if(isUnivVal(node)) count++;

            if(node.left != null) treeQue.add(node.left);

            if(node.right != null) treeQue.add(node.right);
        }

        return count;
    }

    private boolean isUnivVal(TreeNode node){
        if(node.val < -1000 || node.val > 1000) throw new IllegalArgumentException("-1000 <= Node.val <= 1000");

        if(node.left != null && node.val != node.left.val){
            return false;
        }

        if(node.right != null && node.val != node.right.val){
            return false;
        }

        return true;
    }
}
