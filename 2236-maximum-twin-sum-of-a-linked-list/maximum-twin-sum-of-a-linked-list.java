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
    public int pairSum(ListNode head) {
        if(head==null) return 0;
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!= null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode half=reverse(slow.next);
        slow.next=null;

        ListNode pointer1=head;
        ListNode pointer2=half;

        int ans=Integer.MIN_VALUE;

        while(pointer1!=null && pointer2!=null){
            ans=Math.max(ans,pointer1.val+pointer2.val);
            pointer1=pointer1.next;
            pointer2=pointer2.next;
        }
        return ans;

    }
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null;
        while(curr!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}