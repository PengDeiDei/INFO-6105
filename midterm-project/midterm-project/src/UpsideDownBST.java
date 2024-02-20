import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UpsideDownBST {

    public TreeNode upsideDownBST(TreeNode root){
        // return null if the root is null
        if(root == null) return null;

        TreeNode curr = root;
        TreeNode next;
        TreeNode temp = null;
        TreeNode prev = null;

        /* recursive method
        // return root if both the left and right children are null
        if(root.left == null && root.right == null) return root;

        // recursively call the function until the tree reaches its left-most child
        TreeNode newRoot = upsideDownBST(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
        */

        while(curr != null){
            next = curr.left;

            curr.left = temp;

            temp = curr.right;

            curr.right = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    /*
     * @brief: method to print out the level order of the tree
     */
    public void printBST(TreeNode root){
        // return and print nothing if the root is empty
        if(root == null){
            System.out.println("Output: []");
            return;
        }

        ArrayList<String> levelOrder = new ArrayList<>();
        Queue<TreeNode> treeQue = new LinkedList<>();
        treeQue.add(root);

        // using a queue to go through the tree by level
        while(!treeQue.isEmpty()){
            TreeNode node = treeQue.remove();

            levelOrder.add(String.valueOf(node.val));

            if(node.left != null) treeQue.add(node.left);
            if(node.right != null) treeQue.add(node.right);
        }

        System.out.println("Output: " + levelOrder);
    }
}
