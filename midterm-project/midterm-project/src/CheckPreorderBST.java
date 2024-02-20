import java.util.Stack;

public class CheckPreorderBST {

    /*
     * @brief: since the given array is the preorder traversal of tree,
     * using stack to hold all left children of the tree and check if any other
     * node (which is right child of the current root node) is less than the current root node
     * if yes, this is not a valid preorder; otherwise, it is valid
     */
    public boolean checkPreorder(int[] preorder){
        if(preorder.length == 0) return false;

        if(preorder.length > 104) throw new IllegalArgumentException("1 <= preorder.length < 104");

        Stack<Integer> stk = new Stack<>();

        int root = Integer.MIN_VALUE;

        for(int val: preorder){
            if(val < 1 || val > 104) throw new IllegalArgumentException("1 <= preorder[i] <= 104");

            if(val < root) return false;

            // pop the front node as the new root node if the current element
            // is larger than the vale of the front node in the queue
            while(!stk.isEmpty() && stk.peek() < val){
                root = stk.pop();
            }

            //
            stk.push(val);
        }

        return true;
    }
}
