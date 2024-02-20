import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        // problem 1 ex1
        int[][] matrix1 = {{1,1,0},{0,1,0},{1,1,1}};
        Celebrity p1_1 = new Celebrity(matrix1);
        System.out.println("Input: graph = [[1,1,0],[0,1,0],[1,1,1]]");
        System.out.println("Output: " + p1_1.findCelebrity(3));

        // p1 ex2:
        int[][] matrix2 = {{1,0,1},{1,1,0},{0,1,1}};
        Celebrity p1_2 = new Celebrity(matrix2);
        System.out.println("Input: graph = [[1,0,1],[1,1,0],[0,1,1]]");
        System.out.println("Output: " + p1_2.findCelebrity(3));

        // problem 2
        RemoveNthFromEnd p2 = new RemoveNthFromEnd();

        // p2 ex1:
        int[] p2_arr1 = {1,2,3,4,5};
        int p2_n1 = 2;
        ListNode head1 = makeList(p2_arr1);
        head1 = p2.removeNthFromEnd(head1,p2_n1);
        System.out.println("Input: head = [1,2,3,4,5], n = 2");
        System.out.println("Output: "+p2.listToString(head1));

        // p2 ex2:
        int[] p2_arr2 = {1};
        int p2_n2 = 1;
        ListNode head2 = makeList(p2_arr2);
        head2 = p2.removeNthFromEnd(head2,p2_n2);
        System.out.println("Input: head = [1], n = 1");
        System.out.println("Output: "+p2.listToString(head2));

        // p2 ex3:
        int[] p2_arr3 = {1,2};
        int p2_n3 = 1;
        ListNode head3 = makeList(p2_arr3);
        head3 = p2.removeNthFromEnd(head3,p2_n3);
        System.out.println("Input: head = [1,2], n = 1");
        System.out.println("Output: "+p2.listToString(head3));

        // problem 3
        ReverseWords p3 = new ReverseWords();

        // p3 ex1:
        char[] s1 = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        p3.reverseWords(s1);
        System.out.println("Input: s = [\"t\",\"h\",\"e\",\" \",\"s\",\"k\",\"y\",\" \",\"i\",\"s\",\" \",\"b\",\"l\",\"u\",\"e\"]");
        System.out.println("Output: s = "+ Arrays.toString(s1));

        // p3 ex2:
        char[] s2 = {'a'};
        p3.reverseWords(s2);
        System.out.println("Input s = [\"a\"]");
        System.out.println("Output s = " + Arrays.toString(s2));

        // problem 4 ex:
        String[] p4_arr = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance p4 = new WordDistance(p4_arr);
        System.out.println("Input: s = [\"practice\", \"makes\", \"perfect\", \"coding\", \"makes\"]");
        System.out.println("Word 1: coding; Word 2: practice");
        System.out.println("Output: distance = " + p4.shortest("coding","practice"));
        System.out.println("Word 1: makes; Word 2: coding");
        System.out.println("Output: distance = " + p4.shortest("makes","coding"));
    }

    // building a list for problem 2
    public static ListNode makeList(int[] arr){
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for(int i = 1; i < arr.length; i++){
            ListNode newNode = new ListNode(arr[i]);
            temp.add(newNode);
            temp = temp.next;
        }

        return head;
    }
}
