package dfs;

import java.util.Scanner;

public class PascalTriangle {

     static int[] b, p, ch;
     static int n, f;
     static int [][] arr;
     boolean flag = false;

     public int combi(int n, int r){

         if(arr[n][r] > 0) return arr[n][r];
         if(n == r || r == 0) return 1;
         return arr[n][r] = combi(n-1, r-1)+combi(n-1, r);
     }

     public void dfs(int L, int sum){
         if(flag) return;
         if(L == n){
            if(sum == f) {
                for(int x : p) System.out.print(x + " ");
                flag = !flag;
            }
        }
        else {
            for(int i = 1; i <= n; i++){
                if(ch[i] == 0){
                    ch[i] = 1;
                    p[L] = i;
                    dfs(L+1, sum+(p[L] * b[L]));
                    ch[i] = 0;
                }
            }
        }
     }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        f = sc.nextInt();

        arr = new int[n+1][n+1];
        b = new int[n];
        p = new int[n];
        ch = new int[n+1];

        for(int i = 0; i < n; i++){
            b[i] = pt.combi(n-1, i);
        }

        pt.dfs(0,0);
    }

}
