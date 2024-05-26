package stack;

import java.util.Scanner;
import java.util.Stack;

public class Toycrane {

    public int solution(int[][] arr, int[] moves){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int pos : moves){
            for(int i = 0; i < arr.length; i++){
                if(arr[i][pos-1] != 0){
                    int tmp = arr[i][pos-1];
                    arr[i][pos-1]=0;

                    if(!stack.isEmpty() && tmp == stack.peek()){
                        answer += 2;
                        stack.pop();
                    }
                    else {
                        stack.push(tmp);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Toycrane T = new Toycrane();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; i < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

    }

}
