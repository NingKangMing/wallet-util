package com.wallet.km.thread;

import java.util.concurrent.Callable;

public class TaskStr implements Callable<String>{

	@Override
	public String call() throws Exception {
		
		System.out.println("TaskStr call----------");
		return "mytask";
	}

}
