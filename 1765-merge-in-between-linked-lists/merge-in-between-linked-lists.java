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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int count_a=0;
        int count_b=0;
        ListNode newList=new ListNode(-1);
        newList.next=list1;
        ListNode pnt_a=newList;
        ListNode pnt_b=list1;
        while(count_b<b+1){
            if(count_a<a){
                pnt_a=pnt_a.next;
                count_a++;
            }
            pnt_b=pnt_b.next;
            count_b++;
        }
        pnt_a.next=list2;
        while(pnt_a.next!=null){
            pnt_a=pnt_a.next;
        }
        pnt_a.next=pnt_b;

        return newList.next;
    }
}