/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
       if (head == null || head.next == null) {
        return null;   // no circle
    }
    ListNode slow = head, fast = head ,temp=head;
    while (fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if (fast == slow) {  // circle detected
            while (temp != slow) {//loop created to find the element creating loop
                slow = slow.next;
                temp = temp.next;
            }
            return temp;
        }
    }
    return null; // no circle
    }
}