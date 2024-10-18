package it.unibs.pajc;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class ThreadExampleMain {

	public static void main(String[] args) throws Exception {
		/*for(int i = 0;i < 100 ;i++) {
			System.out.println("Numero: " + i + (NumeriPrimi.isPrimo(i) ? " SI" : " NO"));
		}*/
		
		long nMax = 10_000_000;
		int nTask = 10;
		Chrono c = new Chrono();

		ExecutorService executor = Executors.newFixedThreadPool(4);
		long valoriPerTaks = nMax / nTask;
		ArrayList<Future<Long>> futures = new ArrayList<Future<Long>>();

		for (int i = 0;i < nTask;i++) {
			NumeriPrimi task = new NumeriPrimi(i * valoriPerTaks + 1, Math.min((i + 1) * valoriPerTaks, nMax));
			futures.add(executor.submit(task));
		}

		long count = 0;
		for (Future<Long> f : futures) {
			count += f.get();
		}

		executor.shutdown();
		System.out.println(count + " -> " + c);
	}
}
