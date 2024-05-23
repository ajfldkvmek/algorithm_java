package primenumber;

import java.util.*;
/*
    1부터 n까지 수에서
    소수의 갯수를 구하는 가장 빠른 방법은

    "에라토스테네스의 체" 를 기용하는 것

    2부터 시작하여 자기 자신을 제외한 자신의 배수는 모두 삭제하는 방법으로 진행

    예를 들어 n이 120이라 가정하면

    처음 시작할 때 방을 하나 만들고 2부터 n까지의 모든 수를 입력

    2부터 시작하여 자기 자신을 제외한 자신의 배수를 모두 삭제

    다음 수로 이동하여 위 과정을 반복

 */
public class PrimeNumber01 {

    public static void main(String[] args) {

        PrimeNumber01 T = new PrimeNumber01();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(T.solution(n));
    }

    public int solution(int n){
        int answer = 0;
        int[] ch = new int[n+1];

        for(int i = 2; i <= n; i++){
            if(ch[i] == 0) {
                answer++;
                for(int j = i; j <= n; j = j+i) ch[j] = 1;
            }
        }
        return answer;
    }

}