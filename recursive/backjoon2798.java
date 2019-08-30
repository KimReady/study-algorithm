import java.util.Scanner;

public class Test {
	private static int[] cards;
	private static int N;
	private static int M;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		N = scan.nextInt();
		M = scan.nextInt();
		cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = scan.nextInt();
		}
		
		System.out.println(recursive(0, 0, 0));
	}

	private static int recursive(int sum, int idx, int cnt) {
		if(cnt == 3) {
			return sum > M ? 0 : sum;
		}
		if(idx >= N) {
			return 0;
		}
		int max = 0;
		for(int i = idx; i < N; i++) {
			max = Math.max(max, recursive(sum+cards[i], i+1, cnt+1));
		}
		return max;
	}
}
