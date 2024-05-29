package dfs;
import node.Node;
import java.util.*;


public class Binarytree01 {
    Node root;
    public void dfs(Node root){
        if(root == null) return;

        dfs(root.lt);
        //System.out.println(root.data); //증위순회
        dfs(root.rt);
    }

    public static void main(String[] args){
        Binarytree01 tree = new Binarytree01();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);

        tree.dfs(tree.root);
    }

}
