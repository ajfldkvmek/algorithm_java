package backjoon.bfs.Q1926;

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

    static int n, m, count = 0, maxSize = 0;

    static int[][] paint;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void bfs(int x, int y){
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        paint[x][y] = 0;
        int size = 1;
        while(!Q.isEmpty()){
           Point p = Q.poll();
           for(int i = 0; i < 4; i++){
               int nx = p.x + dx[i];
               int ny = p.y + dy[i];

               if(nx >= 0 && nx < n
                       && ny >= 0 && ny < m
                       && paint[nx][ny] == 1){
                   paint[nx][ny] = 0;
                   Q.offer(new Point(nx, ny));
                   size++;
               }
           }
            maxSize = Math.max(size, maxSize);
        }
    }

    public static void main(String[] args) {

        Main M = new Main();

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        paint = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                paint[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(paint[i][j] == 1){
                    count++;
                    M.bfs(i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(maxSize);
    }
}
