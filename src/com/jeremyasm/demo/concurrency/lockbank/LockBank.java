package com.jeremyasm.demo.concurrency.lockbank;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A bank with a number of bank accounts that uses locks for serializing access.
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class LockBank {
	
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;
	
	/**
	 * Constructor of Bank
	 * @param n the number of accounts
	 * @param initialBalance the initial balance for each account
	 */
	public LockBank(int n, double initialBalance){
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
	public double getTotalBalance(){
		bankLock.lock();
		try{
			double sum = 0;
			for(double a : accounts)
				sum += a;
			return sum;
		}finally{
			bankLock.unlock();
		}
	}
	
	/**
	 * Transfer money from one account to another.
	 * @param from  the account to transfer from
	 * @param to    the account to transfer to
	 * @param amount the amount to transfer
	 * @throws InterruptedException
	 */
	public void transfer(int from, int to, double amount) throws InterruptedException{
		bankLock.lock();
		try{
			while(accounts[from] < amount)
				sufficientFunds.await();
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.println("Transfer " + amount + " from " + from + " to " + to + ".");
			accounts[to] += amount;
			System.out.println("Total Balance: " + getTotalBalance());
			sufficientFunds.signalAll();
		}finally{
			bankLock.unlock();
		}
	}
	

}
