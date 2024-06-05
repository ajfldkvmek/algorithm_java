package dfs;

import java.util.Scanner;

public class Permutation2 {

    static int[] pm, ch, arr;
    static int n, m;

    public void dfs(int L){

        if(L == m){
            for(int i : pm) System.out.print(i + " ");
            System.out.println();
            return;
        } else {
            for(int i = 0; i < n; i++){
                if(ch[i] == 0){
                    //해당 인덱스를 입력했는지 체크하고 해제
                    ch[i] = 1;
                    pm[L] = arr[i];
                    dfs(L+1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Permutation2 p2 = new Permutation2();

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n];
        ch = new int[n];
        pm = new int[m];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        p2.dfs(0);

    }
}
