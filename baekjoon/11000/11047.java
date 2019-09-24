
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());
        int[] coins = new int[n];
        
        for(int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int count = 0;
        for(int i = n-1; i >= 0; i--) {
            if(k >= coins[i]) {
                count += k / coins[i];
                k %= coins[i];
            }
        }
        
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
