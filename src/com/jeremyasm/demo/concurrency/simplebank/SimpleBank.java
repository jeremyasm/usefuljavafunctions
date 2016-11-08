package com.jeremyasm.demo.concurrency.simplebank;

/**
 * A bank with a number of bank accounts
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 *
 */
public class SimpleBank {

	private final double[] accounts;
	
	public SimpleBank(int n, double initialBalance){
		accounts = new double[n];
		for(int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
	}
	
	/**
	 * Transfer money from one account to another.
	 * @param from  the account to transfer from
	 * @param to    the account to transfer to
	 * @param amount the amount to transfer
	 */
	public void transfer(int from, int to, double amount){
		if(accounts[from] < amount) return;
		System.out.println(Thread.currentThread());
		accounts[from] -= amount;
		System.out.println("Transfer " + amount + " from " + from + " to " + to + ".");
		accounts[to] += amount;
		System.out.println("Total Balance: " + getTotalBalance());
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

		double sum = 0;
		for(double a : accounts)
				sum += a;
			return sum;
	}
		
}
