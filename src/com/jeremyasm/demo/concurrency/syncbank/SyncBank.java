package com.jeremyasm.demo.concurrency.syncbank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SyncBank {

	
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
	
	/**
	 * Constructor of Bank
	 * @param n the number of accounts
	 * @param initialBalance the initial balance for each account
	 */
	public SyncBank(int n, double initialBalance){
		accounts = new double[n];
		for(int i=0; i < accounts.length; i++)
			accounts[i] = initialBalance;
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}
	
	/**
	 * Gets the number of accounts in the bank
	 * @return the number of accounts
	 */
	public int size(){
		return accounts.length;
	}
	
	/**
	 * Gets the sum of all account balances
	 * @return the total balance
	 */
	public synchronized double getTotalBalance(){
//		bankLock.lock();
//		try{
			double sum = 0;
			for(double a : accounts)
				sum += a;
			return sum;
//		}finally{
//			bankLock.unlock();
//		}
	}
	
	/**
	 * Transfer money from one account to another.
	 * @param from  the account to transfer from
	 * @param to    the account to transfer to
	 * @param amount the amount to transfer
	 * @throws InterruptedException
	 */
	public synchronized void transfer(int from, int to, double amount) throws InterruptedException{
//		bankLock.lock();
//		try{
			while(accounts[from] < amount)
//				sufficientFunds.await();
				wait();
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.println("Transfer " + amount + " from " + from + " to " + to + ".");
			accounts[to] += amount;
			System.out.println("Total Balance: " + getTotalBalance());
//			sufficientFunds.signalAll();
			notifyAll();
//		}finally{
//			bankLock.unlock();
//		}
			
	}
	


}
