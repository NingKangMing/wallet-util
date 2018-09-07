package com.wallet.km.thread;

import java.util.concurrent.Callable;

public class TaskBoolean implements Callable<Boolean>{

	@Override
	public Boolean call() throws Exception {
		System.out.println("TaskBoolean call------");
		return true;
	}

}
