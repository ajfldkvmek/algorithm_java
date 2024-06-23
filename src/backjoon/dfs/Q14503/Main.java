package backjoon.dfs.Q14503;

import java.util.Scanner;

//문제 틀린 이유 -> 0과 1의 값을 반대로 이해
//이 문제의 경우 1이면 벽 0이면 빈칸
//문제 잘 읽자

public class Main {

    static int N, M, ix, iy, d, answer = 1;
    static int[][] room;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void dfs(int x, int y, int dir){

        room[x][y] = -1; //청소 칸 값 변경

        for(int i = 0 ; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if(nx >= 0 && nx < N
            && ny >= 0 && ny < M
            && room[nx][ny] == 0) {
                answer++;
                dfs(nx, ny, dir);
                return;
            }
        }

        //후진
        int rd = (dir + 2) % 4;
        int rx = x + dx[rd];
        int ry = y + dy[rd];
        if(rx >= 0 && rx < N
                && ry >= 0 && ry < M
                && room[rx][ry] != 1) {
            dfs(rx, ry, dir);
        }
    }
    public static void main(String[] args) {

        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        //크기 N: row, M:col
        N = sc.nextInt();
        M = sc.nextInt();
        //시작위치, 진행방향
        ix = sc.nextInt();
        iy = sc.nextInt();

        //0: 북, 1: 동, 2: 남, 3: 서
        //방향으로 90도 회전

        d = sc.nextInt();

        room = new int[N][M];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                room[i][j] = sc.nextInt();
            }
        }
        sc.close();
        m.dfs(ix, iy, d);

        System.out.println(answer);
    }

}
