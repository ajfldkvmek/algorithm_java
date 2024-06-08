package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Island_bfs {

    static int answer = 0, n;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    Queue<Point> queue = new LinkedList<>();

    public void bfs(int x,int y, int[][] board){
        queue.add(new Point(x, y));
        while(!queue.isEmpty()){
            Point p = queue.poll();
            for(int i = 0; i < 8; i++){
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n
                && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    queue.add(new Point(nx, ny));
                }
            }
        }
    }

    public void solution(int[][] map){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == 1){
                    map[i][j] = 0;
                    bfs(i, j, map);
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Island_bfs ib = new Island_bfs();
        Scanner sc = new Scanner(System.in);

        System.out.print("지도의 크기: ");
        n = sc.nextInt();

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        ib.solution(arr);
        System.out.println(answer);
    }
}
