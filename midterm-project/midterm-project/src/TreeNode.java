public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        if(val < 1 || val > 10) throw new IllegalArgumentException("1 <= Node.val <= 10");
        this.val = val;
    }
}
