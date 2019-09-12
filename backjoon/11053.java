package backjoon;

import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] nums = new int[n+1];
        int[] dp = new int[n+1];
        int max = 0;
        
        tokenizer = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(tokenizer.nextToken());
            int maxLen = 0;
            for(int j = 1; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(maxLen < dp[j]) {
                        maxLen = dp[j];
                    }
                }
            }
            dp[i] = maxLen + 1;
            max = Math.max(max, dp[i]);
        }
        
        bw.write(String.valueOf(max));
        br.close();
        bw.close();
    }
}
