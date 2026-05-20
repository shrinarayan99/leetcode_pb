/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        // will mark that clone node is created
        Map<Node,Node> map=new HashMap<>();
        //for traversal on graph
        Queue<Node> q=new LinkedList<>();
        // make clone of current node
        Node clone=new Node(node.val);
        // mark that clone is created
        map.put(node,clone);
        // add current node in queue to access further neighbors
        q.add(node);
        while(!q.isEmpty()){

            Node curr=q.poll();
            // get all neighbors of current node
            for(Node n:curr.neighbors){
                //if neighbour already created than just link the(add in neighbors)
                if(map.containsKey(n)){
                    map.get(curr).neighbors.add(map.get(n));
                    continue;
                }
                // else create clone of node and link it to the neighbour of current node
                Node newClone=new Node(n.val);
                map.get(curr).neighbors.add(newClone);
                //mark that clone is created
                map.put(n,newClone);
                // add in queue for accessing further neighbors
                q.add(n);
            }

        }
        return clone;
    }
}