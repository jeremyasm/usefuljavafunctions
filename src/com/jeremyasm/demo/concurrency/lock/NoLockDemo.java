package com.jeremyasm.demo.concurrency.lock;

public class NoLockDemo {
		
	public static void main(String[] args){
		
		final NoLockDemo noLockDemo = new NoLockDemo();
		
		new Thread(){
			public void run(){
				noLockDemo.insertThread(Thread.currentThread());
			}
		}.start();
		
		new Thread(){
			public void run(){
				noLockDemo.insertThread(Thread.currentThread());
			}
		}.start();
		
	}
	
	public void insertThread(Thread thread){

		for(int i = 0 ; i < 100 ; i++){
				System.out.println(Thread.currentThread().getName() + " - " + i);
		}
	}
	
	
	
	

}

