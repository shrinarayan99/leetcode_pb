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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null) return null;
        int count=0;
        ListNode pointer=head;
        while(pointer!=null){
            count++;
            pointer=pointer.next;
        }
        if(count==1) return null;
        pointer=head;
        int i=0;
        while(i<(count/2)-1){
            pointer=pointer.next;
            i++;
        }
        pointer.next=pointer.next.next;
        return head;
    }
}