package node;

public class Node {
    public int data;
    public Node lt, rt;
    public Node(int val){
        data = val;
        lt = rt = null;
    }
}