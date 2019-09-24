package backjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] ans = new int[n+1][10];
        
        for(int i = 0; i < 10; i++) {
            ans[1][i] = 1;
        }
        
        for(int i = 2; i <= n; i++) {
            for(int j = 0; j < 10; j++) {
                if(j > 0) {
                    ans[i][j] += ans[i-1][j-1];
                }
                if(j < 9) {
                    ans[i][j] += ans[i-1][j+1];
                }
                ans[i][j] %= 1000000000;
            }
        }
        int sum = 0;
        for(int i = 1; i <= 9; i++) {
            sum = (sum + ans[n][i]) % 1000000000;
        }
        bw.write(String.valueOf(sum));
        br.close();
        bw.close();
    }
}
