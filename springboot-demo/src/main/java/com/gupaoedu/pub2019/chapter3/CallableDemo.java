package com.gupaoedu.pub2019.chapter3;

import java.util.concurrent.*;

public class CallableDemo implements Callable<String> {
	public static void main(String[] args) throws ExecutionException,InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();
		CallableDemo callableDemo = new CallableDemo();
		Future<String> future = executorService.submit(callableDemo);
		System.out.println(future.get());//阻塞
	}
	@Override
	public String call() throws Exception {
		return "String"+1;
	}
}
