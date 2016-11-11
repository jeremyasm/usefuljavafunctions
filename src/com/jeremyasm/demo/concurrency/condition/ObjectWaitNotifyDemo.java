package com.jeremyasm.demo.concurrency.condition;

public class ObjectWaitNotifyDemo {
	
    public static Object object = new Object();
    
    
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
         
        thread1.start();
         
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
        thread2.start();
    }
     
    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                try {
                    object.wait();
                } catch (InterruptedException e) {
                }
                	System.out.println(Thread.currentThread().getName()+" gets the lock !");
            }
        }
    }
     
    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object) {
                object.notify();
                System.out.println(Thread.currentThread().getName()+" invokes object.notify()");
            }
            	System.out.println(Thread.currentThread().getName()+" releases the lock !");
        }
    }
}
