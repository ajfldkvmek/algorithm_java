package twopointer;

import java.util.Scanner;

public class ContinuousNumber {

    public int soluton(int num){
        int answer = 0, lt = 0, sum = 0;
        int max = num/2 + 1;
        int[] arr = new int[max];
        for(int a = 0; a < max; a++) arr[a] = a+1;

        for(int rt = 0; rt < max; rt++){
            sum += arr[rt];
            if(sum == num) answer++;

            while(sum >= num) {
                sum -= arr[lt++];
                if(sum == num) answer++;
            }
        }



        return answer;
    }

    public static void main(String[] args) {

        ContinuousNumber T = new ContinuousNumber();
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(T.soluton(num));
    }
}
