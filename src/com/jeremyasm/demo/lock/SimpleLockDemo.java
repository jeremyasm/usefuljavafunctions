package com.jeremyasm.demo.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SimpleLockDemo {
	
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args){
		
		final SimpleLockDemo simpleLockDemo = new SimpleLockDemo();
		
		new Thread(){
			public void run(){
				simpleLockDemo.insertThread(Thread.currentThread());
			}
		}.start();
		
		new Thread(){
			public void run(){
				simpleLockDemo.insertThread(Thread.currentThread());
			}
		}.start();
		
	}
	
	public void insertThread(Thread thread){
		lock.lock();
		try{
			System.out.println(Thread.currentThread().getName() + " gets the lock !" );
			for(int i = 0 ; i < 100 ; i++){
				System.out.println(Thread.currentThread().getName() + " - " + i);
			}
		}finally{
			System.out.println(Thread.currentThread().getName() + " releases the lock !" );
			lock.unlock();
		}
	}
	
	
	
	

}
