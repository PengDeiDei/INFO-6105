import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        problem1();

        problem2();

        problem3();

        problem4();
    }

    public static void problem1(){
        System.out.println("Problem 1.");

        // Example 1
        UpsideDownBST updown = new UpsideDownBST();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Example 1:");
        System.out.println("Input: ["+root.val+"]");

        TreeNode newRoot = updown.upsideDownBST(root);
        updown.printBST(newRoot);


        // Example 2
        System.out.println("Example 2:");
        System.out.println("Input: []");

        TreeNode newRoot2 = updown.upsideDownBST(null);
        updown.printBST(newRoot2);

        // Example 3
        TreeNode root3 = new TreeNode(1);
        System.out.println("Example 3:");
        System.out.println("Input: ["+root3.val+"]");
        TreeNode newRoot3 = updown.upsideDownBST(root3);
        updown.printBST(newRoot3);
    }

    public static void problem2(){
        CountUnivValSubtrees countSubtree = new CountUnivValSubtrees();
        System.out.println("Problem 2.");

        // Example 1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);

        int count = countSubtree.countUnivValSubtree(root);
        System.out.println("Example 1:");
        System.out.println("Input: root = [5, 1, 5, 5, 5, null, 5]");
        System.out.println("Output: "+count);

        // Example 2
        int count2 = countSubtree.countUnivValSubtree(null);
        System.out.println("Example 2:");
        System.out.println("Input: root = []");
        System.out.println("Output: "+count2);

        // Example 3
        TreeNode root3 = new TreeNode(5);
        root3.left = new TreeNode(5);
        root3.right = new TreeNode(5);
        root3.left.left = new TreeNode(5);
        root3.left.right = new TreeNode(5);
        root3.right.right = new TreeNode(5);

        int count3 = countSubtree.countUnivValSubtree(root3);
        System.out.println("Example 3:");
        System.out.println("Input: root = [5, 5, 5, 5, 5, null, 5]");
        System.out.println("Output: "+count3);
    }

    public static void problem3(){
        CheckPreorderBST cp = new CheckPreorderBST();

        // Example 1
        int[] preorder = {5, 2, 1, 3, 6};
        System.out.println("Example 1:");
        System.out.println("Input: preorder = [5, 2, 1, 3, 6]");
        System.out.println("Output: "+cp.checkPreorder(preorder));

        // Example 2
        int[] preorder2 = {5,2,6,1,3};
        System.out.println("Example 2:");
        System.out.println("Input: preorder = [5,2,6,1,3]");
        System.out.println("Output: "+cp.checkPreorder(preorder2));

        int[] preorder3 = {40, 30, 35, 20, 80, 100};
        System.out.println("Example 3:");
        System.out.println("Input: preorder = [40, 30, 35, 20, 80, 100]");
        System.out.println("Output: "+cp.checkPreorder(preorder3));
    }

    public static void problem4(){
        // Example 1
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = {0,4};
        int[] destination = {4,4};

        MazeSolver ms = new MazeSolver(maze,start,destination);
        int dist = ms.shortestDistance();

        System.out.println("Example 1:");
        System.out.println("Input: maze = "+Arrays.deepToString(maze));
        System.out.println("start = "+Arrays.toString(start));
        System.out.println("destination: "+Arrays.toString(destination));
        System.out.println("Output: distance = "+dist);

        // Example 2
        int[][] maze2 = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start2 = {0,4};
        int[] destination2 = {3,2};

        ms = new MazeSolver(maze2,start2,destination2);
        int dist2 = ms.shortestDistance();

        System.out.println("Example 2:");
        System.out.println("Input: maze = "+Arrays.deepToString(maze2));
        System.out.println("start = "+Arrays.toString(start2));
        System.out.println("destination: "+Arrays.toString(destination2));
        System.out.println("Output: distance = "+dist2);

        //Example 3
        int[][] maze3 = {{0,0,0,0,0},{1,1,0,0,1},{0,0,0,0,0},{0,1,0,0,1},{0,1,0,0,0}};
        int[] start3 = {4,3};
        int[] destination3 = {0,1};

        ms = new MazeSolver(maze3,start3,destination3);
        int dist3 = ms.shortestDistance();

        System.out.println("Example 3:");
        System.out.println("Input: maze = "+Arrays.deepToString(maze3));
        System.out.println("start = "+Arrays.toString(start3));
        System.out.println("destination: "+Arrays.toString(destination3));
        System.out.println("Output: distance = "+dist3);
    }
}