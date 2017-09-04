import java.util.ArrayList;
import java.util.Scanner;

class DepthSearch {
	/*
	 * 
	 */

	public static void dfs(int step, int n, int[] book, int[] A, DepthSearch ds) {

		if (step == n + 1) {
			for (int i = 1; i <= n; i++) {
				System.out.print(A[i]);
			}
			System.out.println();
			return;
		} else {
			for (int i = 1; i <= n; i++) {
				if (book[i] == 0) {
					A[step] = i;
					book[i] = 1;

					dfs(step + 1, n, book, A, ds);
					book[i] = 0;
				}
			}
			return;
		}
	}

	public static void main(String[] args) {
		int n = 0;
		DepthSearch ds = new DepthSearch();
		System.out.println("Input the range");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] book = new int[n + 1];
		int[] A = new int[book.length];
		sc.close();
		dfs(1, n, book, A, ds);
	}
}
