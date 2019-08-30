#include <stdio.h>

int c[100];

void calculate_max_consecutive_sum(int s[], int n) {
	int i;

	c[0] = s[0];
	for(i = 1; i < n; i++)
		c[i] = (s[i] > s[i] + c[i-1]) ? s[i] : s[i] + c[i-1];
}

int find_max_consecutive_sum(int n) {
	int max_sum = 0, i;

	for(i = 0; i < n; i++) {
		if(c[i] > max_sum)
			max_sum = c[i];
	}
	return max_sum;
}

int main(int argc, char** argv) {
	int arr[] = {33, 36, -73, 15, 43, -17, 36, -28, -1, 21};

	calculate_max_consecutive_sum(arr, 10);

	printf("%d\n", find_max_consecutive_sum(10));

	return 0;
}

