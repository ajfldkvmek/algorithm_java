package hash;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Anagram01 {

    public boolean solution(String a, String b){

       boolean result = false;

        Map<Character, Integer> map = new HashMap<>();

        for(char x : a.toCharArray()){
            //key x를 통해 value를 가져오되, 값이 없으면 0을 가져옴
            map.put(x, map.getOrDefault(x, 0)+1);
        }

         for(char x : b.toCharArray()){
             if(!map.containsKey(x) || map.get(x) == 0) {
                return result;
             }
             map.put(x, map.get(x) - 1);
         }

         return !result;
    }

    public static void main(String[] args) {

        Anagram01 T = new Anagram01();

        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        if(T.solution(a, b)) System.out.println("YES");
        else System.out.println("NO");
    }
}
