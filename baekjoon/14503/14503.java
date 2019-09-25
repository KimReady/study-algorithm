import java.io.*;
import java.util.*;

class Main {
    private static int[][] map;
    private static boolean[][] clean;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        clean = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        int dirCount = 0;
        while(true) {
            if(!clean[r][c]) {
                clean[r][c] = true;
                count++;
            }
            dir = (dir > 0) ? dir - 1 : 3;
            dirCount++;
            int preR = r + dy[dir];
            int preC = c + dx[dir];
            if(!canMove(preR, preC)) {
                if(dirCount == 4) {
                    dirCount = 0;
                    int back = (dir+2) % 4;
                    int backR = r + dy[back];
                    int backC = c + dx[back];
                    if(backR >= 0 && backR < n && backC >= 0 && backC < m && map[backR][backC] == 0) {
                        r = backR;
                        c = backC;
                    } else {
                        break;
                    }
                }
                continue;
            }

            dirCount = 0;
            r = preR;
            c = preC;
        }
        System.out.println(count);
    }

    private static boolean canMove(int preR, int preC) {
        return !(preR < 0 || preR == map.length || preC < 0 || preC == map[0].length
                || map[preR][preC] == 1 || clean[preR][preC]);
    }
}
