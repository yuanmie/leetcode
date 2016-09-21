/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        //swap listnode value;
        int temp;
        ListNode root = head;
        while(head != null  && head.next != null){
            temp = head.val;
            head.val = head.next.val;
            head.next.val = temp;

            head = head.next.next;
        }

        return root;
    }
}