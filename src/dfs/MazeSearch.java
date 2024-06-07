package dfs;

import java.util.Scanner;

public class MazeSearch {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;
    static int[][] maze;
    static int answer = 0;

    public void dfs(int x, int y){
        if(x == n && y == n) answer++;
        else {
            for(int i = 0; i < 4; i++){
                //방향 제어
                int nx = x + dx[i];
                int ny = y + dy[i];

                //index가 범위내, 방문하지 않았을 때
                if(nx >= 1 && nx <= n
                        && ny >= 1 && ny <= n
                        && maze[nx][ny] == 0){
                    maze[nx][ny] = 1;
                    dfs(nx, ny);
                    maze[nx][ny] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        MazeSearch ms = new MazeSearch();
        Scanner sc = new Scanner(System.in);

        System.out.print("미로의 크기를 설정: ");
        n = sc.nextInt();
        maze = new int[n+1][n+1];

        System.out.println("미로 입력> ");
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        //시작점
        maze[1][1] = 1;
        ms.dfs(1, 1);

        System.out.println("탈출가능한 총 경로의 수: " + answer);
    }

}
