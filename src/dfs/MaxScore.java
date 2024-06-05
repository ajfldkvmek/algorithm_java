package dfs;

import java.util.Scanner;

public class MaxScore {

    static int[] ps , pt;
    static int answer = Integer.MIN_VALUE, n, m;
    boolean flag = false;
    static Scanner sc = new Scanner(System.in);
    public void dfs(int L, int sum, int time){
        if(time > m) return;
        if(L == n){
            //n이면 끝까지 탐색한 것
            answer = Math.max(answer, sum);
        } else {
            dfs(L+1, sum+ps[L], time+pt[L]);
            dfs(L+1, sum, time);
        }
    }

    public static void main(String[] args) {
        MaxScore ms = new MaxScore();
        //n은 총 문제수
        //m은 최대 시간
        n = sc.nextInt();
        m = sc.nextInt();

       ps  = new int[n];
       pt  = new int[n];

        for(int i = 0; i < n; i++){
            //a배열에는 문제의 점수
            //b배열에는 문제의 걸리는 시간
            ps[i] = sc.nextInt();
            pt[i] = sc.nextInt();
        }
        ms.dfs(0,0,0);
        System.out.println(answer);
    }
}
