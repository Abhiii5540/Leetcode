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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        
        //count the nodes
        int c=1;
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
            c++;
        }
        
        //point last node to fast node, i.e.head
        cur.next=head;
        
        //Now , iterate k times , that will bring to node from where we need to rotate
        k=k%c;
        k=c-k;
        for(int i=0;i<k;i++){
            cur=cur.next;
        }
        head=cur.next;
        cur.next=null;
        
        return head;
    }
}