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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode pointer=head;
        ListNode counter=head;
        int count=1;

        ListNode newNode=new ListNode(-1);
        ListNode p=newNode;
        while(counter!=null){
            counter=counter.next;
            if(counter!=null){
                count++;
            }
            pointer=counter;
            
            
            if(count==k){
                if(counter!=null){
                    pointer=counter.next;
                    counter.next=null;
                }
                p.next=reverse(head);
                
                head=pointer;
                counter=head;
                count=1;
            }
            while(p.next!=null) {
                p=p.next;
            }
            
        }
        
        p.next=head;
        return newNode.next;
        

        
    }
    public ListNode reverse(ListNode head){
        ListNode current=head;
        ListNode prev=null;
        while(current!=null){
            ListNode temp=current.next;
            current.next=prev;
            prev=current;
            current=temp;
        }
        return prev;
    }
}