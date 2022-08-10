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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // prepare the results for each of the buckets upto k size
		ListNode[] result = new ListNode[k];
        
		// if root is null then return the empty array
        if (head == null)
            return result;
        
        // find the total length of the list
        int length = 0;
        ListNode curr = head;
        while (curr != null){
            length++;
            curr = curr.next;
        }
        
        //find the length of each bucket in k buckets 
		int eachLength = length / k;
        //not every time we get equal size for all the buckets so sometimes some of the bucket will have extra elements in it
		//so we have to find the length of extra buckets by mod operation
       	int extraLength = length % k;
        
		int index = 0;
        
        curr = head;
        ListNode prev=null;
        
        //loop for all the elements in the list
        while (curr != null && index<k){
            //for every bucket we start with the current element
			result[index]=curr;
            
            //each part difference is either 0 or 1, we use the reminder to identify the difference
            int difference = extraLength > 0 ? 1 : 0;
            
            //move the pointer to the size of eachlength
            for(int i=0;i< eachLength + difference ;i++){
                prev=curr;
                curr = curr.next;
            }
            
            prev.next=null;
            index++;
            //decrement the extra length
            extraLength--;
        }       
        return result;
    }
}