package primenumber;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeNumber02 {

    /*
        입력받은 숫자를 뒤집어서 소수인지 확인하기
     */


    public boolean isPrime(int num){

        if(num <= 1) return false;

        int sqrt = (int) Math.sqrt(num);

        for(int i = 2; i <= sqrt; i++){
            if(num % i == 0) return false;
        }

        return true;
    }

    public ArrayList<Integer> solution(int n, int[] arr){

         ArrayList<Integer> answer = new ArrayList<>();

         for(int i = 0; i < n; i++){
             int tmp = arr[i];
             int res = 0;

             while(tmp > 0){
                 int t = tmp % 10;
                 res = res*10 + t;
                 tmp = tmp/10;
             }

             if(isPrime(res)) answer.add(res);

         }

         return answer;
    }

    public static void main(String[] args) {

        PrimeNumber02 T = new PrimeNumber02();

        Scanner sc = new Scanner(System.in);

        //입력할 수의 갯수
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            //각각의 입력할 숫자
            arr[i] = sc.nextInt();
        }

        //foreach 문으로 solution메소드가 리턴한 리스트를 순회하며 숫자 출력
        for(int x : T.solution(n, arr)){
            System.out.print(x + " ");
        }
    }

}
