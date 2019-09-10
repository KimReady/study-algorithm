package backjoon;

import java.util.Scanner;

public class Main {
    private static char[][] BOARD;
    private static char[][] WB;
    
    public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int m = scan.nextInt();
		scan.nextLine();
		WB = new char[2][8];
		WB[0] = "WBWBWBWB".toCharArray();
		WB[1] = "BWBWBWBW".toCharArray();
		
		BOARD = new char[n][m];
		for(int i = 0; i < n; i++) {
		    BOARD[i] = scan.nextLine().toCharArray();
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n - 7; i++) {
		    for(int j = 0; j < m - 7; j++) {
		        min = Math.min(min, draw(i, j));
		    }
		}
		System.out.println(min);
    }
    
    private static int draw(int y, int x) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < WB.length; i++) {
            int cnt = 0;
            for(int j = 0; j < WB[0].length; j++) {
                for(int k = 0; k < WB[0].length; k++) {
                    if(BOARD[y+j][x+k] != WB[(i+j)%2][k]) {
                        cnt++;
                    }
                }
            }
            min = Math.min(min, cnt);
        }
        return min;
    }
}
