/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode root = null;
        ListNode result = null;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                if(root == null){
                    root = new ListNode(l1.val);
                    result = root;   
                }else{
                    result.next = new ListNode(l1.val);
                    result = result.next;
                }
             l1 = l1.next;
            }else{
              if(root == null){
                    root = new ListNode(l2.val);
                    result = root;
                }else{
                    result.next = new ListNode(l2.val);
                    result = result.next;
                }
                l2 = l2.next;  
            }
        }

        if(l1 == null){
            while(l2 != null){result.next = new ListNode(l2.val);l2 = l2.next; result = result.next;}
        }

        if(l2 == null){
             while(l1 != null){result.next = new ListNode(l1.val);l1 = l1.next; result = result.next;}
        }

        return root;
    }
}