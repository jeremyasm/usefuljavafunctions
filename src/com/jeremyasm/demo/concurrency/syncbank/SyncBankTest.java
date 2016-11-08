package com.jeremyasm.demo.concurrency.syncbank;

public class SyncBankTest {

	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;
	
	public static void main(String[] args){
		
		SyncBank bank = new SyncBank(NACCOUNTS, INITIAL_BALANCE);
		for(int i = 0; i < NACCOUNTS; i++ ){
			TransferRunnable transferRunnable = new TransferRunnable(bank, i, INITIAL_BALANCE);
			Thread t = new Thread(transferRunnable);
			t.start();
		}
	}
}
