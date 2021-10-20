package br.com.codenation.desafioexe;

import java.util.List;
import java.util.ArrayList;

public class DesafioApplication {
	public static List<Integer> fibonacci() {
		int positionA = 0;
		int positionB = 1;
		ArrayList<Integer> fibonacciList = new ArrayList<>();
		fibonacciList.add(positionA);
		while (positionA <= 350) {
			fibonacciList.add(positionB);
			int secondLastIndex = fibonacciList.size() - 2;
			positionA = positionB;
			positionB = fibonacciList.get(secondLastIndex) + positionB;
		}
		return fibonacciList;
	}

	public static Boolean isFibonacci(Integer a) {
		List<Integer> fibonacciList = fibonacci();
		return fibonacciList.contains(a);
	}
}