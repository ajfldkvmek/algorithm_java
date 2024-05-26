package stack;

import java.util.Scanner;
import java.util.Stack;

public class RightBracket {

    public boolean solution(String str){

        boolean answer = false;

        Stack<Character> stack = new Stack<>();

        for(char c : str.toCharArray()){
            if(c == '(') stack.push(c);
            else {
                if(stack.empty()) return answer;
                stack.pop();
            }
        }

        if(stack.size() != 0) return answer;

        return !answer;

    }

    public static void main(String[] args) {

        RightBracket rb = new RightBracket();
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        if(rb.solution(str)) System.out.println("YES");
        else System.out.println("NO");

    }
}
