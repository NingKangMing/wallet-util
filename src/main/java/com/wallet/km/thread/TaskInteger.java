package com.wallet.km.thread;

import java.util.concurrent.Callable;

public class TaskInteger implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("TaskInteger call -------");
		return 1;
	}

}
