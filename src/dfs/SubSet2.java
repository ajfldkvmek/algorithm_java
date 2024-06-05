package dfs;

import java.util.Scanner;

public class SubSet2 {

    static String answer = "NO";
    static Scanner sc = new Scanner(System.in);
    boolean flag = false;
    static int n, total = 0;

    public void dfs(int L, int sum, int[] arr){
        if(flag) return;
        if(sum > total/2) return;
        if(L == n){
            if((total-sum) == sum){
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(L+1, sum+arr[L], arr);
            dfs(L+1, sum, arr);
        }
    }

    public static void main(String[] args) {
        SubSet2 sb2 = new SubSet2();
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        sb2.dfs(0,0,arr);
        System.out.println(answer);
    }
}
