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
        
        int[] tiles = new int[n+1];
        tiles[1] = 1;
        tiles[2] = 2;
        for(int i = 3; i <= n; i++) {
            tiles[i] = (tiles[i-1] + tiles[i-2]) % 15746;
        }
        
        bw.write(String.valueOf(tiles[n]));
        
        br.close();
        bw.close();
    }
}
