import java.util.*;

class FibonacciSolution {
	public int slowFibonacci(int n) {
		// this will be too slow: around 2^n
		// 3. define the end / exit
		if (n <= 1) {
			return n;
		}
		// 1. define your recursion: what parameter, what return value, what's the meaning
		// 2. divide and conquer recursion tasks
		return fibonacci(n - 1) + fibonacci(n - 2);
	}
	
	public int fibonacci(int n) {
		if (n <= 1) {
			return n;
		}
		HashMap<Integer, Integer> hashmap = new HashMap<>();
		hashmap.put(0, 0);
		hashmap.put(1, 1);
		int i = 2;
		while (i <= n) {
			hashmap.put(i, hashmap.get(i - 1) + hashmap.get(i - 2));
		}
		return hashmap.get(n);
	}
}

class FibonacciSolution2 {
	int[] memo;
	public FibonacciSolution2() {
		memo = new int[1000];
		Arrays.fill(memo,  -1);
		memo[0] = 0;
		memo[1] = 1;
	}
	// 备忘模型：未知->已知 easier to construct
	public int F1(int n) {
		if (memo[n] == -1) {
			memo[n] = F1(n - 1) + F1(n - 2);
		}
		return memo[n];
	}
	// 演绎模型：已知->未知
	public int F2(int n) {
		for (int i = 2; i <= n; i++) {
			memo[n] = memo[i - 1] + memo[i - 2];
		}
		return memo[n];
	}
	
}
/*
 * Modification
 * 1. F(n) = F(n - 1) + 2F(n - 2)
 * 		needs to change one row of code only
 * 2. 100 students, ranked by height, next height the sum of first 2 heights * 3/4, what's the sum of all heights
 * 		F(n) = 3/4 * (F(n - 1) + F(n - 2))
 * 
 */
public class Fibonacci {
	public static void main(String[] args) {
		FibonacciSolution s = new FibonacciSolution();
		System.out.println(s.fibonacci(6));
	}
}
