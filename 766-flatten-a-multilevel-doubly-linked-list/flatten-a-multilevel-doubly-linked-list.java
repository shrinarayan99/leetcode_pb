/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node pointer=head;
        while(pointer!=null){
            if(pointer.child!=null){
                Node temp=flatten(pointer.child);
                Node t=pointer.next;

                pointer.next=temp;
                temp.prev=pointer;
                //make child null
                pointer.child=null;

                // temp pointer do not modift original pointer
                // Node tempPointer=temp;
                // while(tempPointer.next!=null){
                //     tempPointer=tempPointer.next;
                // }
                // tempPointer.next=t;
                // if(t!=null){
                //     t.prev=tempPointer;
                // }
                
                while(pointer.next!=null){
                    pointer=pointer.next;
                }
                pointer.next=t;
                if(t!=null){
                    t.prev=pointer;
                }
                pointer=pointer.next;;

            }
            else{
                pointer=pointer.next;
            }
        }
        return head;
    }
}