
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Conference[] confs = new Conference[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            confs[i] = new Conference(start, end);
        }
        Arrays.parallelSort(confs);
        int lastTime = -1;
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            if(lastTime <= confs[i].start) {
                lastTime = confs[i].end;
                cnt++;
            }
        }
        
        bw.write(String.valueOf(cnt));
        br.close();
        bw.close();
    }
    
    private static class Conference implements Comparable<Conference> {
        int start;
        int end;
        
        Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Conference o) {
            int comp = Integer.compare(end, o.end);
            return comp != 0 ? comp : Integer.compare(start, o.start);
        }
    }
}
