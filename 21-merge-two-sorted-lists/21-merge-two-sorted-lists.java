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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        ListNode temp=new ListNode(-1);//-1 means null node
        ListNode curr=temp;
        while(l1!=null && l2!=null){//till both ll is empty
            if(l1.val<l2.val){// if element in 1st ll is smaller
                curr.next=l1;//add that element to new ll
                curr=curr.next;//shift curr pointer
                l1=l1.next;//shift l1 pointer
            }
            else{// if element in 2nd ll is smaller
                curr.next=l2;
                curr=curr.next;
                l2=l2.next;
            }
        }
        //if either of them is unfinished
        if(l1!=null){
            curr.next=l1;
        }
        
        if(l2!=null){
            curr.next=l2;
        }
        return temp.next;
        
        */
        
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val>l2.val){//swap l1 and l2
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
        ListNode res=l1;
        while(l1!=null && l2!=null){
            ListNode dummy=null;
            while(l1!=null && l1.val<=l2.val){
                dummy=l1;
                l1=l1.next;
            }
            dummy.next=l2;
            
            ListNode temp=l1;
            l1=l2;
            l2=temp;
        }
    return res;
    }
}
