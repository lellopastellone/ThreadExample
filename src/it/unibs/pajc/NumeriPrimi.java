package it.unibs.pajc;

import java.util.concurrent.Callable;

public class NumeriPrimi implements Callable<Long>{
	private long start;
	private long end;
	private long count;
	
	public NumeriPrimi(long start, long end) {
		this.start = start;
		this.end = end;
		count = 0;
	}
	
	public Long call() {
		count = contaPrimi(start, end);
		System.out.println(count);
		return count;
	}
	
	public static boolean isPrimo(long k) {
		if (k == 2) return true;
		if (k <= 1 || k % 2 == 0) return false;
		
		long kMax = (long) Math.sqrt(k);
		
		for (int i = 3;i <= kMax;i += 2) {
			if (k % i == 0) return false;
		}
		return true;
	}
	
	public static long contaPrimi(long start, long end) {
		
		long count = 0;
		
		for (long i = start; i <= end; i++) {
			if(isPrimo(i)) count++;
		}
		return count;
	}
}
