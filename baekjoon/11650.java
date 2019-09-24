package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        
        int n = Integer.parseInt(br.readLine());
        Location[] locations = new Location[n];
        for(int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            locations[i] = new Location(x, y);
        }
        
        Arrays.sort(locations);
        for(Location location : locations) {
            System.out.println(location.x + " " + location.y);
        }
    }
    
    private static class Location implements Comparable<Location> {
        int x;
        int y;
        
        private Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public int compareTo(Location o) {
            if(x < o.x) {
                return -1;
            } else if(x > o.x) {
                return 1;
            } else if(x == o.x) {
                if(y < o.y) {
                    return -1;
                } else if(y > o.y) {
                    return 1;
                } else {
                    return 0;
                }
            }
            return 0;
        }
        
    }
}
