package com.jeremyasm.demo.concurrency.lockbank;

/**
 * This program shows data corruption when multiple threads access a data structure
 * @version 1.30 2004-08-01
 * @author Cay Horstmann
 *
 */
public class LockBankTest {
	
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	
	public static void main(String[] args){
		
		LockBank bank = new LockBank(NACCOUNTS, INITIAL_BALANCE);
		for(int i = 0; i < NACCOUNTS; i++ ){
			TransferRunnable transferRunnable = new TransferRunnable(bank, i, INITIAL_BALANCE);
			Thread t = new Thread(transferRunnable);
			t.start();
		}
	}

}

