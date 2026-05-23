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
    int count;
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode newHead=new ListNode();
        ListNode p=newHead;
        ListNode Pointer=head;
        while(Pointer!=null){
            p.next=new ListNode(Pointer.val);
            p=p.next;
            Pointer=Pointer.next;
        }
        
        count=0;
        ListNode prev=reverse(newHead.next);




        ListNode newNode=new ListNode(0);
        ListNode newPointer=newNode;
        ListNode pointer1=head;
        ListNode pointer2=prev;
        int c=0;
        while(c<count/2){
            newPointer.next=new ListNode(pointer1.val);
            newPointer.next.next=new ListNode(pointer2.val);
            newPointer=newPointer.next.next;
            pointer1=pointer1.next;
            pointer2=pointer2.next;
            c++;
        }
        if(count%2!=0){
            newPointer.next=new ListNode(pointer1.val);
            newPointer=newPointer.next;
        }
        newPointer.next=null;
        ListNode temp = head;
        ListNode ans = newNode.next;

        while(temp != null && ans != null){
            temp.val = ans.val;
            temp = temp.next;
            ans = ans.next;
        }
    }
    public ListNode reverse(ListNode root){
       
        ListNode curr=root;
        ListNode prev=null;
        
        while(curr!=null){
            count++;
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        return prev;
    }
}