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
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> list=new ArrayList<>();
        for(ListNode node:lists){
            ListNode pointer=node;
            while(pointer!=null){
                list.add(pointer.val);
                pointer=pointer.next;
            }

        }
        Collections.sort(list);
        ListNode newNode=new ListNode(-1);
        ListNode pointer=newNode;

        for(int val:list){
            pointer.next=new ListNode(val);
            pointer=pointer.next;
        }
        pointer.next=null;
        return newNode.next;
    }
}