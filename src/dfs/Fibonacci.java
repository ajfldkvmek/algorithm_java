package dfs;

import java.util.Scanner;

public class Fibonacci {
    static int[] fArr;
    public int fibo(int n){
        if(fArr[n] > 0) return fArr[n];
        if(n <= 2) return fArr[n] = 1;
        return fArr[n] = fibo(n-2) + fibo(n-1);
    }

    public static void main(String[] args) {

        Fibonacci f = new Fibonacci();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("숫자를 입력하시오(종료: 0): ");
            int num = sc.nextInt();
            fArr = new int[num+1];
            if(num == 0) break;
            if(num < 1){
                System.out.println("1보다 큰 자연수를 입력하시오");
                continue;
            }
            f.fibo(num);
            System.out.printf(">>> %d\n", fArr[num]);
        }
    }
}
