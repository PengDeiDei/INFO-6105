/*
 * Author: Haonan Peng
 * Email: peng.haon@northeastern.edu
 *
 * Description:
 * Single-linked list for problem 2
 */


public class ListNode {
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val){ this.val = val; }
    ListNode(int val, ListNode next){ this.val = val; this.next = next; }

    public void add(ListNode next){
        this.next = next;
    }
 }