package com.jeremyasm.demo.concurrency.simplebank;

/**
 * A runnable that transfers money from an account to other accounts in a bank
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 */
public class TransferRunnable implements Runnable{
	
	private SimpleBank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;
	
	public TransferRunnable(SimpleBank bank2, int from, double max){
		bank = bank2;
		fromAccount = from;
		maxAmount = max;
	}
	
	public void run(){
		try{
			while(true){
				int toAccount = (int) (bank.size() * Math.random()); //bank.size() how many accounts in the bank
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep ((int) (DELAY * Math.random()));//necessary ???
			}
		}catch(InterruptedException e){
			
		}
	}

}
