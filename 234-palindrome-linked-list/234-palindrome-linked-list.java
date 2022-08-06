/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    ListNode middle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
       
        // Even List fast!=null
        // Odd List
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    
    public ListNode reverseList(ListNode head) {
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
         if (head == null) {
            return true;
        }
         if(head.next==null){
        return true;
    }
        ListNode mid=middle(head);
        ListNode last=reverseList(mid.next);
        ListNode cur=head;
        while(last!=null){
            if(last.val!=cur.val){
                return false;
            }
            last=last.next;
            cur=cur.next;
        }
        return true;
    }
}