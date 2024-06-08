package dfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {

    static int n, m, len, answer = Integer.MAX_VALUE;
    static int[] combi;
    static ArrayList<Point> pz, hs;

    public void dfs(int L, int s){
        if(L == m){
            int sum = 0;
            for(Point phs : hs){
                int dis = Integer.MAX_VALUE;
                for(int i : combi){
                    dis =
                     Math.min(dis, Math.abs(phs.x - pz.get(i).x) +  Math.abs(phs.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);

        } else {
            for(int i = s; i < len; i++){
                combi[L] = i;
                dfs(L+1, i+1);
            }
        }
    }
    public static void main(String[] args) {
        Pizza P = new Pizza();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        pz = new ArrayList<>();
        hs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int temp = sc.nextInt();
                if(temp == 1) hs.add(new Point(i, j));
                if(temp == 2) pz.add(new Point(i, j));
            }
        }
        len = pz.size();
        combi = new int[m];
        P.dfs(0,0);
        System.out.println(answer);
    }
}
