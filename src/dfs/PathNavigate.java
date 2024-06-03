package dfs;

import java.util.*;
public class PathNavigate {

    static int n, m, answer = 0;

    static ArrayList<ArrayList<Integer>> graph;

    static int[] ch;

    public void dfs(int v){
        if(v == n) answer++;
        else {
            for(int nv : graph.get(v)){
                if(ch[nv] == 0){
                    ch[nv] = 1;
                    dfs(nv);
                    ch[nv] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        PathNavigate pn = new PathNavigate();
        Scanner sc = new Scanner(System.in);

        // n은 정점의 수, m은 간선의 수
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new ArrayList<ArrayList<Integer>>();
        //그래프 객체 생성
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }
        ch = new int[n+1];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
        }
        ch[1] = 1;
        pn.dfs(1);
        System.out.println(answer);
    }
}
