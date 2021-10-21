package br.com.codenation;

import java.util.Arrays;

public class StatisticUtil {

	public static int average(int[] elements) {
		int totalSum = Arrays.stream(elements).sum();
		return totalSum / elements.length;
	}

	public static int mode(int[] elements) {
		int theMoreRepeats = 0;
		int repeats = 0;
		int moda = 0;
		for (int n: elements) {
			for (int num: elements) {
				if (n == num) {
					repeats++;
				}
			}
			if (repeats > theMoreRepeats) {
				theMoreRepeats = repeats;
				moda = n;
			}
			repeats = 0;
			}
		return moda;
	}

	public static int median(int[] elements) {
		Arrays.sort(elements);
		int lngt = elements.length;
		int myMedian = 0;
		if (lngt % 2 != 0) {
			int indexOfMedian = (lngt/2);
			myMedian = elements[indexOfMedian];
		}else{
			int indexA = lngt/2;
			int indexB = (lngt/2 - 1);
			myMedian = ((elements[indexA] + elements[indexB]) / 2);
		}

		return myMedian;
	}
}