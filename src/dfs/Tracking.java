package dfs;

import java.util.Scanner;

public class Tracking {

    static int n, m, answer = 0;
    static int[][] graph;
    static int[] ch;
    public void dfs(int v){
        if(v == n){
            //n번 node 이면 ++
            answer++;
        } else {
            for(int i = 1; i < n; i++){
                //간선이 있고, 방문한 적이 없으면
                if(graph[v][i] == 1 && ch[i] == 0){
                    //방문 체크후 호출
                    ch[i] = 1;
                    dfs(i);
                    //탐색후 초기화
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Tracking T = new Tracking();
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n+1][n+1];
        ch = new int[n+1];
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] =1;
        }
        ch[1] = 1;
        T.dfs(1);
        System.out.println(answer);
    }
}
