package bfs;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import node.Node;
public class TreeSearch {

    Node root;
    public void bfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while(!queue.isEmpty()){
            int len = queue.size();
            System.out.print(L + " : ");
            for(int i = 0; i < len; i++){
                Node node = queue.poll();
                System.out.print(node.data + " ");
                if(node.lt != null) queue.offer(node.lt);
                if(node.rt != null) queue.offer(node.rt);
            }
            L++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        TreeSearch tree = new TreeSearch();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.bfs(tree.root);
    }

}
