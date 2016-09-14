/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode point = head;
        ListNode current = null;

        while((n--) > 0) point = point.next;
        while(point != null){
            if(current == null) current = head;else  current = current.next;  
            point = point.next;
           
        }

        if(current == null){
            head = head.next;
            return head;
        }
        current.next = current.next.next;
        return head;
    }

    public static void main(String args[]){

    }
}
//[1.2] 1
/*
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.*/