package com.multithreading.d_Lock;

public class TestLock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//BankAccount sbi=new BankAccount();
		BankAccountLocks sbi=new BankAccountLocks();
		Runnable run=new Runnable() {
			@Override
			public void run() {
				sbi.withdraw(50);
			}
		};
		
		Thread t1=new Thread(run,"Thread-1");
		Thread t2=new Thread(run, "Thread-2");
		t1.start();
		t2.start();
	}

}
