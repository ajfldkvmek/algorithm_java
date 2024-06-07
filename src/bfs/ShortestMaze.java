package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShortestMaze {

    static int n;
    static int[][] maze, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void bfs(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        maze[x][y] = 1;

        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i = 0; i < 4; i++){
                //각 방향별로 이동
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 1 && nx <= n
                        && ny >= 1 && ny <= n
                        && maze[nx][ny] == 0){
                    maze[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }
    public static void main(String[] args) {

        ShortestMaze sm = new ShortestMaze();
        Scanner sc = new Scanner(System.in);

        System.out.print("미로의 크기: ");
        n = sc.nextInt();

        maze = new int[n+1][n+1];
        dis = new int[n+1][n+1];

        System.out.println("미로 입력> ");
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= n; j++){
                maze[i][j] = sc.nextInt();
            }
        }
        sc.close();

        sm.bfs(1, 1);

        System.out.println(dis[n][n] == 0 ? -1 : dis[n][n]);
    }

}
