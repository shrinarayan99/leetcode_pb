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
        if (head == null || head.next == null || k == 0) return head;
        int loop=count(head);
        k=k%loop;
        while(k!=0){
            
            ListNode pointer=head;
            ListNode dummy=new ListNode(0);
            ListNode pDummy=dummy;
            int n=0;
            while(n<loop-1){
                pDummy.next=new ListNode(pointer.val);
                pDummy=pDummy.next;
                pointer=pointer.next;
                n++;
            }
            ListNode pDummy2=dummy.next;
            head=pointer;
            ListNode pointer2=head;
            while(pDummy2!=null){
                pointer2.next=pDummy2;
                pointer2=pointer2.next;
                pDummy2=pDummy2.next;
            }
            k--;
        }
        return head;
    }
    public int count(ListNode head){
        ListNode pointer=head;
        int count=0;
        while(pointer!=null){
            count++;
            pointer=pointer.next;
        }
        return count;
    }
}

/*WILL FACE TLE FOR LARGER K(input)

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        while(k!=0){
            int loop=count(head);
            ListNode pointer=head;
            ListNode dummy=new ListNode(0);
            ListNode pDummy=dummy;
            int n=0;
            while(n<loop-1){
                pDummy.next=new ListNode(pointer.val);
                pDummy=pDummy.next;
                pointer=pointer.next;
                n++;
            }
            ListNode pDummy2=dummy.next;
            head=pointer;
            ListNode pointer2=head;
            while(pDummy2!=null){
                pointer2.next=pDummy2;
                pointer2=pointer2.next;
                pDummy2=pDummy2.next;
            }
            k--;
        }
        return head;
    }
    public int count(ListNode head){
        ListNode pointer=head;
        int count=0;
        while(pointer!=null){
            count++;
            pointer=pointer.next;
        }
        return count;
    }
}

*/