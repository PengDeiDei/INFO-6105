/*
 * Author: Haonan Peng
 * Email: peng.haon@northeastern.edu
 *
 * Description:
 * Solution of problem 2 -- Given the head of a linked list, remove
 * the nth node from the end of the list and return its head.
 */


import java.util.ArrayList;

public class RemoveNthFromEnd {
    // using two pointer to delete n-th node from the end of the single link list
    public ListNode removeNthFromEnd(ListNode head, int n){
        // assigning a fast pointer and a slow pointer pointing to the head node
        ListNode fast = head;
        ListNode slow = head;

        // using for loop to move fast pointer to n-th node from the end of list
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }

        // delete the head node if the length of list is n
        if(fast == null) return head.next;

        // moving fast pointer to reach the end of list while moving the slow pointer
        // to the (n-1)-th node
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }

        // deleting the n-th node
        slow.next = slow.next.next;

        // return head node
        return head;
    }

    public String listToString(ListNode head){
        ListNode temp = head;
        ArrayList<Integer> al = new ArrayList<>();

        while(temp != null){
            al.add(temp.val);
            temp = temp.next;
        }

        return al.toString();
    }
}
