package backjoon.bfs.Q5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int F, G, S, U, D;

    static int[] visited;

    public String bfs(int floor){

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(floor);
        visited[floor] = 1;
        //G: 목표위치, S: 시작위치, U: 업, D: 다운

        while(!Q.isEmpty()){

            int current = Q.poll();

            if(current == G) {
                return (visited[current]-1) + "";
            }

            int upStair = current + U;
            int downStair = current - D;
            if(upStair <= F && visited[upStair] == 0) {
                visited[upStair] = visited[current] + 1;
                Q.offer(upStair);
            }

            if(downStair >= 1 && visited[downStair] == 0){
                visited[downStair] = visited[current] + 1;
                Q.offer(downStair);
            }
        }
        return "use the stairs";
    }
    public static void main(String[] args) {

        Main M = new Main();
        Scanner sc = new Scanner(System.in);
        String answer = "";

        // 1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000
        F = sc.nextInt(); //전체 층
        S = sc.nextInt(); //현재 위치
        G = sc.nextInt(); //도착 위치
        U = sc.nextInt(); //위로 이동
        D = sc.nextInt(); //아래로 이동

        if (S == G) {
            System.out.println(0);
        } else {
            visited = new int[F + 1];

            System.out.println(M.bfs(S));

//            if(visited[G] == 0) System.out.println("use the stairs");
//            else System.out.println(visited[G]);
        }
    }
}
