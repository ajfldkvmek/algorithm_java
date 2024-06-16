package backjoon.bfs.Q1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, K;
    static int[] visited = new int[100001];

    public void bfs(int idx){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(idx);
        visited[idx] = 0;

        while(!Q.isEmpty()){

            int current = Q.poll();

            if(current-1 >= 0 && visited[current-1] == 0){
                visited[current-1] = visited[current]+1;
                Q.offer(current-1);
            }

            if(current + 1 <= 100000 && visited[current+1] == 0){
                visited[current+1] = visited[current]+1;
                Q.offer(current+1);
            }

            if(current * 2 <= 100000 && visited[current*2] == 0){
                visited[current*2] = visited[current]+1;
                Q.offer(current*2);
            }

            if(visited[K] != 0) break;
        }
    }

    public static void main(String[] args) {

        Main M = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //수빈\
        K = sc.nextInt(); //동생

        if(N == K){
            System.out.println(0);
        } else {
            M.bfs(N);
            System.out.println(visited[K]);
        }
    }
}
