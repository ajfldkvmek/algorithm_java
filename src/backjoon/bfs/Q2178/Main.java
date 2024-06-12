package backjoon.bfs.Q2178;

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

    //최단거리 알고리즘은 bfs가 좋다

    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] maze, dis;


    public void bfs(int x, int y){

        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x,y));
        dis[1][1] = 1;

        while(!Q.isEmpty()){
            Point p = Q.poll();
            for(int i = 0; i < 4; i++){
                //각 방향별로 이동
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx >= 1 && nx <= n
                        && ny >= 1 && ny <= m
                        && maze[nx][ny] == 1){
                    maze[nx][ny] = 0;
                    Q.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }

    }

    public static void main(String[] args) {
        //1은 이동가능, 0은 불가
        Main M = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //row
        m = sc.nextInt(); //col
        char[] cArr = new char[m];

        maze = new int[n+1][m+1];
        dis = new int[n+1][m+1];

        for(int i = 1; i <= n; i++){
            String s = sc.next();
            cArr = s.toCharArray();
            //char to int -> char - '0';
            int idx = 1;
            for(char c : cArr){
                maze[i][idx] = c - '0';
                idx++;
            }
        }

        sc.close();

        M.bfs(1, 1);

        System.out.println(dis[n][m]);
    }
}
