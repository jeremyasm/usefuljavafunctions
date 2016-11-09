package com.jeremyasm.demo.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
	
	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args){
		
		final TryLockDemo tryLockDemo = new TryLockDemo();
		
		new Thread(){
			public void run(){
				tryLockDemo.insertThread(Thread.currentThread());
			}
		}.start();
		
		new Thread(){
			public void run(){
				tryLockDemo.insertThread(Thread.currentThread());
			}
		}.start();
		
	}
	
	public void insertThread(Thread thread){
		
		if(lock.tryLock()){
			try{
				System.out.println(Thread.currentThread().getName() + " gets the lock !" );
				for(int i = 0 ; i < 100 ; i++){
					System.out.println(Thread.currentThread().getName() + " - " + i);
				}
			}finally{
				System.out.println(Thread.currentThread().getName() + " releases the lock !" );
				lock.unlock();
			}
		}else{
			System.out.println(Thread.currentThread().getName() + " fails to get the lock !");
		}
	}

}
