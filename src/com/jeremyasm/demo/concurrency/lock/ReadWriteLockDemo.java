package com.jeremyasm.demo.concurrency.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
	
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public static void main(String[] args){
		
		final ReadWriteLockDemo rwLockDemo = new ReadWriteLockDemo();
		
		new Thread(){
			public void run(){
				rwLockDemo.get(Thread.currentThread());
			}
		}.start();
		
		new Thread(){
			public void run(){
				rwLockDemo.get(Thread.currentThread());
			}
		}.start();
		
	}
	
	public void get(Thread thread){
	
		lock.readLock().lock();
		try{
			for(int i = 0 ; i < 1000 ; i++){
				System.out.println(Thread.currentThread().getName() + " - " + i + " - " + "do Get");
			}
		}finally{
			lock.readLock().unlock();
		}
        lock.readLock().lock();
	}

}
