package backjoon.bfs.Q2644;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {

    static int n, row, col, cnt;
    static int[][] graph;
    static boolean[] visited;

    public void bfs(int strt){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(strt);
        visited[strt] = true;

        while(!Q.isEmpty()){
            int current = Q.poll();

            for(int i = 1; i <= n; i++){
                if(graph[current][i] == 1 && !visited[i]){
                    visited[i] = true;
                    Q.offer(i);
                    graph[strt][i] = graph[strt][current] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Main M = new Main();
        Scanner sc = new Scanner(System.in);
        //전체 사람 수
        n = sc.nextInt();
        graph = new int[n+1][n+1];
        visited = new boolean[n+1];
        //row 와 col의 촌수 구하기
        row = sc.nextInt();
        col = sc.nextInt();

        //반복횟수
        cnt = sc.nextInt();
        for(int a = 0; a < cnt; a++){
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x][y] = 1;
            graph[y][x] = 1;
        }

        M.bfs(row);

        System.out.println(graph[row][col] == 0 ? -1 : graph[row][col]);
    }
}
