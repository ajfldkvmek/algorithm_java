package backjoon.bfs.Q7576;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    public int x, y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

}

public class Main {

    static int n, m;
    static int[][] tomato, dis;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> Q = new LinkedList<>();
    public void bfs(){

        while(!Q.isEmpty()){

            Point p = Q.poll();

            for(int i = 0; i < 4; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n
                        && ny >= 0 && ny < m
                        && tomato[nx][ny] == 0) {
                    tomato[nx][ny] = 1;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main M = new Main();
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        //n: col, m: col
        m = sc.nextInt();
        n = sc.nextInt();

        tomato = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                tomato[i][j] = sc.nextInt();
                if(tomato[i][j] == 1)Q.offer(new Point(i, j));
            }
        }

        M.bfs();
        boolean flag = false;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(tomato[i][j] == 0){
                    flag = true;
                    answer = -1;
                    break;
                }
            answer = Math.max(answer, dis[i][j]);
            }
            if(flag) break;
        }
        System.out.println(answer);
    }
}
