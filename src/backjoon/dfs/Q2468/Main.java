package backjoon.dfs.Q2468;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, result, max = 0;
    static int [][] area;
    static boolean [][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public void dfs(int x, int y, int h){

       visited[x][y] = true;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N
            && ny >= 0 && ny < N
            && !visited[nx][ny]
            && area[nx][ny] > h){
                dfs(nx, ny , h);
            }

        }
    }

    public void solve() {

        for(int h = 0; h < max; h++) {
            visited = new boolean[N][N];
            int cnt = 0;

            for(int a = 0; a < N; a++){
                for(int b = 0; b < N; b++){
                    if(visited[a][b] || area[a][b] <= h) continue;
                    dfs(a, b ,h);
                    cnt += 1;
                }
            }
            result = Math.max(result, cnt);
        }
    }

    public static void main(String[] args) {

        Main M = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        area = new int[N][N];

        for(int a = 0; a < N; a++){
            for(int b = 0; b < N; b++){
                area[a][b] = sc.nextInt();
                max = Math.max(area[a][b], max);
            }
        }

        M.solve();

        System.out.println(result);
    }

}
