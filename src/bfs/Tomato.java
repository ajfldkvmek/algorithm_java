package bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Tomato {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] box, dis;
    static int n, m;
    static Queue<Point> queue = new LinkedList<>();
    public void bfs() {

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx >= 0 && nx < n
                        && ny >= 0 && ny < m
                        && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Tomato T = new Tomato();
        Scanner sc = new Scanner(System.in);
        int answer = 0;

        System.out.print("가로 세로 입력: ");
        m = sc.nextInt();
        n = sc.nextInt();

        box = new int[n][m];
        dis = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                box[i][j] = sc.nextInt();
                if(box[i][j] == 1) queue.offer(new Point(i, j));
            }
        }
        T.bfs();
        boolean flag = false;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(box[i][j] == 0) {
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
