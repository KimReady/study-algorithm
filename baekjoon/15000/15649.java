import java.io.*;
import java.util.*;

class Main {
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit;
    static int N;
    static int M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[N+1];
        perm(0);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void perm(int cnt) {
        if(cnt == M) {
            printStack();
            return;
        }
        for(int i = 1; i <= N; i++) {
            if(visit[i]) {
                continue;
            }

            stack.push(i);
            visit[i] = true;
            perm(cnt+1);
            stack.pop();
            visit[i] = false;
        }
    }

    private static void printStack() {
        for(int i = 0; i < M; i++) {
            sb.append(stack.get(i) + " ");
        }
        sb.append("\n");
    }
}
