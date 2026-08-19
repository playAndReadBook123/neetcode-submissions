/*
Definition for a Node.
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

    Map<Node, Node> clone = new HashMap<>();

    public Node cloneGraph(Node node) {

        if(node == null){
            return null;
        }

        if(clone.containsKey(node)){
            return clone.get(node);
        }

        Node cloneNode = new Node();
        cloneNode.val = node.val;
        clone.put(node, cloneNode);

        for(Node next : node.neighbors){
            cloneNode.neighbors.add(cloneGraph(next));
        }

        return cloneNode;
    }
}