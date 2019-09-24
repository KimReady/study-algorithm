
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }

        System.out.println(max * min);
        br.close();
    }   
}
