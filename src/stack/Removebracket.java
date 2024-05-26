package stack;

import java.util.Scanner;
import java.util.Stack;

public class Removebracket {

    public String solution(String str){

        String answer= "";

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){

            if(c == ')') {
                while(stack.pop() != '(');
            }
            else {
                stack.push(c);
            }
        }
        for(int i = 0; i < stack.size(); i++)
            answer += stack.get(i);
        return answer;
    }

    public static void main(String[] args) {

        Removebracket rb = new Removebracket();

        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.println(rb.solution(str));

    }

}
