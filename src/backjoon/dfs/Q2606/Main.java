package backjoon.dfs.Q2606;

import java.util.Scanner;

public class Main {

    static int n, m, answer = 0;
    static int[][] graph;
    static boolean[] visited;

    public void dfs(int idx){

        visited[idx] = true;

        for(int i = 1; i <=n; i++){
            if(graph[idx][i] == 1 && !visited[i]){
                answer++;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) {

        Main M = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];

        m = sc.nextInt();

        for(int i = 0; i < m; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            graph[row][col] = 1;
            graph[col][row] = 1;
        }

        M.dfs(1);

        System.out.println(answer);
    }
}
