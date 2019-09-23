import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minQue = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++) {
            String[] op = operations[i].split(" ");
            switch(op[0]) {
                case "I":
                    int num = Integer.parseInt(op[1]);
                    maxQue.offer(num);
                    minQue.offer(num);
                    break;
                case "D":
                    if(maxQue.isEmpty()) {
                        break;
                    }
                    if(op[1].equals("1")) {
                        int max = maxQue.poll();
                        minQue.remove(max);
                    } else {
                        int min = minQue.poll();
                        maxQue.remove(min);
                    }
                    break;
                default:
                    break;
            }
        }
        if(!maxQue.isEmpty()) {
            answer[0] = maxQue.poll();
            answer[1] = minQue.poll();
            return answer;
        }
        return new int[] {0, 0};
    }
}