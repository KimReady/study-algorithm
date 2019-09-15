
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   
        int n = Integer.parseInt(br.readLine());
        int[] people = new int[n];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            queue.offer(Integer.valueOf(tokenizer.nextToken()));
        }
        
        int sum = 0;
        for(int i = n; i > 0; i--) {
            sum += queue.poll() * i;
        }
        
        bw.write(String.valueOf(sum));

        br.close();
        bw.close();
    }
}
