package backjoon.bfs.Q7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
    int x, y, z;
    Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int m, n, h, answer = 0;
    static int[][][] tomato;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<Point> Q = new LinkedList<>();

    public void bfs() {
        while (!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                int nz = p.z + dz[i];

                if (nx >= 0 && nx < m
                && ny >= 0 && ny < n
                && nz >= 0 && nz < h
                && tomato[ny][nx][nz] == 0) {
                    tomato[ny][nx][nz] = tomato[p.y][p.x][p.z] + 1;
                    Q.add(new Point(nx, ny, nz));
                }
            }
        }
    }

    public void solve() {
        for (int a = 0; a < h; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < m; c++) {
                    if (tomato[b][c][a] == 1) {
                        Q.add(new Point(c, b, a));
                    }
                }
            }
        }

        bfs();

        for (int a = 0; a < h; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < m; c++) {
                    if (tomato[b][c][a] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, tomato[b][c][a]);
                }
            }
        }
        System.out.println(answer - 1);
    }

    public static void main(String[] args) {

        Main M = new Main();
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        h = sc.nextInt();

        tomato = new int[n][m][h];

        for (int a = 0; a < h; a++) {
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < m; c++) {
                    tomato[b][c][a] = sc.nextInt();
                }
            }
        }

        M.solve();
    }
}