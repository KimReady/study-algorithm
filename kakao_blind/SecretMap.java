public class Main {
    public static void main(String[] args) {
        int n = 5;
	    int[] arr1 = {9, 20, 28, 18, 11};
	    int[] arr2 = {30, 1, 21, 17, 28};
	    
	    String[] ans = solution(n, arr1, arr2);
	    for(String str : ans) {
	        System.out.println(str);
	    }
	}
    
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] ans = new int[n];
        
        for(int i = 0; i < n; i++) {
            ans[i] = arr1[i] | arr2[i];
        }
        
        for(int i = 0; i < n; i++) {
            StringBuilder strBuilder = new StringBuilder();
            for(int j = 0; j < n; j++) {
                strBuilder.append((ans[i] & 1) == 1 ? "#" : " ");
                ans[i] = ans[i] >> 1;
            }
            answer[i] = strBuilder.reverse().toString();
        }
        return answer;
    }
}
