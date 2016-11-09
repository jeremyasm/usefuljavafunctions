package com.jeremyasm.demo.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class InterruptLockDemo {

	private Lock lock = new ReentrantLock();
	
	public static void main(String[] args){
		
		final InterruptLockDemo interruptLockDemo = new InterruptLockDemo();
		InterruptLockDemo.ThreadTest tt1 = interruptLockDemo.new ThreadTest();
		InterruptLockDemo.ThreadTest tt2 = interruptLockDemo.new ThreadTest();
		
		tt1.start();
		tt2.start();
		
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tt2.interrupt();
		
		
	}
	
	//an inner class
	class ThreadTest extends Thread{
		@Override
		public void run(){
			try {
				insertThread(Thread.currentThread());
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + " is interrupted !");
			}
		}
	}
	
	public void insertThread(Thread thread) throws InterruptedException{
		
        lock.lockInterruptibly();   
        try {  
            System.out.println(Thread.currentThread().getName() + " gets the lock !");
            long startTime = System.currentTimeMillis();
            for(    ;     ;) {
                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
                    break;
            }
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" executes finally !");
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " releases the lock !");
        }  
	}
}
