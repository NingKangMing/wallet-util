package com.wallet.km.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExecutorTest {
	
	public static void main(String[] args) {
		ThreadPoolExecutor executor =(ThreadPoolExecutor)Executors.newFixedThreadPool(2);
		Future<String> future = executor.submit(new TaskStr());
		Future<Integer> fu2 = executor.submit(new TaskInteger());
		try {
			String str = future.get();
			System.out.println(str);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		try {
			Integer in = fu2.get();
			System.out.println(in);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		Future<Boolean> fu3 = executor.submit(new TaskBoolean());
		try {
			Boolean b = fu3.get();
			System.out.println(b);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		executor.shutdownNow();
	}

}
