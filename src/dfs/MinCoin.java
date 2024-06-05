package dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MinCoin {

    static int n, m, answer = Integer.MAX_VALUE;
    public void dfs(int L, int sum, Integer[] arr){
        if(sum>m) return;
        if(L>=answer) return;
        if(sum == m){
            //값 만족하면 기존의 answer과 비교하여 더 작은 수의 동전 입력
             answer = Math.min(answer, L);
        }
        else {
            for(int i = 0; i < n; i++){
                dfs(L+1, sum+arr[i], arr);
            }
        }
    }

    public static void main(String[] args) {
        MinCoin mc = new MinCoin();
        //동전 종류의 수
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        //Integer로 사용하는 이유는 Colletions으로 정렬하려고
        Integer[] arr = new Integer[n];
        //각 동전들의 값 입력
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        //거슬러줄 금액
        //내림차순 정렬하기
        //더 큰 숫자로 조합해야 더 적게 나올 가능성이 높아...
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();

        mc.dfs(0,0,arr);
        System.out.println(answer);
        sc.close();
    }
}
