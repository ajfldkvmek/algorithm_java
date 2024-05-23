package slidingwindow;

import java.util.*;

public class Main {

    public int solution(int n, int k, int[] arr){
        int answer = 0, sum = 0;

        //첫날 ~ k-1 번쨰 날 까지 의 합(k일 의 합 구하기)
        for(int i = 0; i < k; i++)
            sum+=arr[i];
        answer = sum;

        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i-k]);
            answer = Math.max(answer, sum); // 둘 중 큰 값을 선택
        }
        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();

        Scanner sc = new Scanner(System.in);

        //총 n개의 날짜에 대한 데이터가 주어지고
        int n = sc.nextInt();

        //그 중 연속된 k일의 값들의 합을 구하고자 한다.
        int k = sc.nextInt();

        int [] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(T.solution(n, k , arr));

    }
}