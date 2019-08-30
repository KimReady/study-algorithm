#include <stdio.h>

#define MAXN 20		// maximum for bits

/**
 *	A function to print out the gray-bits
 */
void print_code(int code[], int len) {
	for(int i = 0; i < len; i++) {
		printf("%d", code[i]);
	}
	printf("\n");
}

/**
 * A function that print out gray codes using recursive calls
 * @param code gray code data
 * @param n size of code
 * @param index current index
 * @param reverse reverse or not
 */
void print_gray(int code[], int n, int index, int reverse) {
	if(index == n) {
		print_code(code, n);
		return;
	}

	code[index] = reverse;
	print_gray(code, n, index + 1, 0);
	code[index] = 1 - reverse;
	print_gray(code, n, index + 1, 1);
}

int main(int argc, char** argv) {
	int code[MAXN], n;

	scanf("%d", &n);
	print_gray(code, n, 0, 0);
	return 0;
}
