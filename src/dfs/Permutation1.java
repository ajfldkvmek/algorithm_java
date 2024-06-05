package dfs;

import java.util.Scanner;

public class Permutation1 {

    static int[] pm;
    static int n, m;
    public void dfs(int L){
        if(L == m) {
            for(int x : pm) System.out.print(x + " ");
            System.out.println();
            return;
        } else {
            for(int i = 1; i <= n; i++){
                pm[L] = i;
                dfs(L+1);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Permutation1 P = new Permutation1();
        //n: 숫자의 범위(1 ~ n)
        //m: 뽑을 숫자(m 개)
        n = sc.nextInt();
        m = sc.nextInt();
        pm = new int[m];

        P.dfs(0);
    }
}
