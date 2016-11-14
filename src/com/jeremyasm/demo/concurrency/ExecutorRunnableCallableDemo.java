package com.jeremyasm.demo.concurrency;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorRunnableCallableDemo {
	
	
	
	
	class Printer implements Runnable{

		@Override
		public void run() {

			for(int i=0;i<10;i++){
				System.out.println("Runnable Printing Line - " + i);
			}
			
		}
		
	}
	
	
	class CallablePrinter implements Callable{
		
		private int num;
		
		CallablePrinter(int i){
			
			num = i;
		}

		@Override
		public Object call() throws Exception {
			
			return "Callable Printing Line - " + num;
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws InterruptedException, ExecutionException{
		
		ExecutorRunnableCallableDemo et = new ExecutorRunnableCallableDemo();
		ExecutorService exeService = Executors.newCachedThreadPool();
		
		//Runnable
		exeService.execute(et.new Printer());
		
		//Callable
		ArrayList<Future<String>> resList = new ArrayList<Future<String>>();
		for(int n=0; n<6; n++)
		resList.add(exeService.submit(et.new CallablePrinter(n)));
	
		for(Future<String> fs:resList){
			System.out.println(fs.get());
		}
		
		exeService.shutdown();
	}

}
