package dfs;

import java.util.Scanner;

public class Combination2 {

    static int n, m;
    static int[] combi;

    public void dfs(int L, int s){
        if(L == m){
            for(int i : combi) System.out.print(i + " ");
            System.out.println();
            return;
        }
        for(int i = s; i <= n; i++){
            combi[L] = i;
            dfs(L+1, i+1);
        }
    }

    public static void main(String[] args) {

        Combination2 c2 = new Combination2();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];

        c2.dfs(0,1);
    }
}
