    package backjoon.dfs.Q2667;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.Scanner;

    public class Main {

        static int n, answer = 0;
        static List<Integer> danji = new ArrayList<>();

        static int[][] apt;
        static boolean[][] visited;

        static int [] dx = {-1, 0, 1, 0};
        static int [] dy = {0, 1, 0, -1};
        public void dfs(int x, int y){
            visited[x][y] = true;
            danji.set(answer-1, danji.get(answer-1) + 1);

            for(int cnt = 0; cnt < 4; cnt++){
                int nx = x + dx[cnt];
                int ny = y + dy[cnt];

                if(nx >= 0 && nx < n
                   && ny >= 0 && ny < n
                   && apt[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx, ny);
                }
            }
        }

        public static void main(String[] args) {

            Main M = new Main();
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();

            apt = new int[n][n];
            visited = new boolean[n][n];

            for(int i = 0; i < n; i++){

                char[] cArr = sc.next().toCharArray();
                for(int j = 0; j < n; j++){
                    apt[i][j] = cArr[j] - '0';
                }
            }

           for(int i = 0; i < n; i++){
               for(int j = 0; j < n; j++){
                   if(apt[i][j] == 1 && !visited[i][j]){
                       answer++;
                       danji.add(0);
                       M.dfs(i, j);
                   }
               }
           }

            System.out.println(danji.size());
            Collections.sort(danji);
            danji.forEach(d -> System.out.println(d));

            //스트림으로 하면 좀 더 간결해짐(속도는 더 느린듯?)
            //danji.stream().sorted().forEach(size -> System.out.println(size));
        }

    }
