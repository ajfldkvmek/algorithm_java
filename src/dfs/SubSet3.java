package dfs;

import java.util.Scanner;

public class SubSet3 {

    static int answer = 0, c,n;
    static Scanner sc = new Scanner(System.in);
    public void dfs(int L, int sum, int[] arr) {
        if (sum > c) return;
        if (L == n) {
            answer = Math.max(answer, sum);
        } else {
            dfs(L + 1, sum + arr[L], arr);
            dfs(L + 1, sum, arr);
        }
    }

    public static void main(String[] args) {
        SubSet3 sb3 = new SubSet3();
        c = sc.nextInt();
        n = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        sb3.dfs(0, 0, arr);
        System.out.println(answer);
    }
}
