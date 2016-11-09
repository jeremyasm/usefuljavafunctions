package com.jeremyasm.demo.concurrency.lock;

public class NoReadWriteLockDemo {
	
	public static void main(String[] args){
		
		final NoReadWriteLockDemo noRWLockDemo = new NoReadWriteLockDemo();
		
		new Thread(){
			public void run(){
				noRWLockDemo.get(Thread.currentThread());
			}
		}.start();
		
		new Thread(){
			public void run(){
				noRWLockDemo.get(Thread.currentThread());
			}
		}.start();
		
	}
	
	public synchronized void get(Thread thread){

			for(int i = 0 ; i < 1000 ; i++){
				System.out.println(Thread.currentThread().getName() + " - " + i + " - " + "do Get");
			}
	}
}
