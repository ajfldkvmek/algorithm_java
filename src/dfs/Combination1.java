package dfs;

import java.util.Scanner;

public class Combination1 {
    static int [][] arr;
    public int dfs(int n, int r){
        if(arr[n][r] > 0) return arr[n][r];
        if(n == r || r == 0) {
            return 1;
        }
        else {
            return arr[n][r] = dfs(n - 1, r - 1) + dfs(n - 1, r);
        }
    }

    public static void main(String[] args) {
        Combination1 c1 = new Combination1();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        arr = new int[n+1][n+1];
        System.out.println(c1.dfs(n, m));
    }
}
