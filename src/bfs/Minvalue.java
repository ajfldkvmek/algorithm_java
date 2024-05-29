package bfs;

import node.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Minvalue {
    Node root;
    public int bfs(Node root){
        Queue<Node> queue = new LinkedList<>();

        queue.offer(root);
        int L = 0; //레벨 탐색

         while(!queue.isEmpty()){
             int len = queue.size();
             for(int i = 0; i < len; i++){
                 Node curr = queue.poll();
                 //말단 노드인지 안닌지 판단하는 것
                 if(curr.lt == null && curr.rt == null) return L;
                 //자식 노드가 있으면 그 값을 queue에 삽입
                 if(curr.lt != null) queue.offer(curr.lt);
                 if(curr.rt != null) queue.offer(curr.rt);
             }
             L++;
         }
         return 0;
    }
    //트리구현부
    public static void main(String[] args) {
        Minvalue tree = new Minvalue();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.bfs(tree.root));
    }
}
