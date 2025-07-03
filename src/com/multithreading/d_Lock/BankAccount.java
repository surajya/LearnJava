package com.multithreading.d_Lock;

//Two type of locks 1. Intrinsic lock  2.explicit lock
//1.Intrinsic lock: It is buit in lock into every object, when we use 'Synchronized" then it is used.
//2. Explicit Lock: This is more advance lock you can control using lock class.
//we can say 'Synchronized' is automatic locks where 'Locks' interface is manual locks.
//Locks: when thread-1 take too much time and thread-2 are waiting. This is the disadvantage of synchronized keyword. So, locks interface comes into picture.
//locks method: 
//1. trylock()-> this is check lock is free or not, if lock is not free then this method throw false immediate
//2. TryLock(time, unit)-> by this thread wait till time for free the lock.
//3. Unlock() -> this is used for free the lock.

public class BankAccount {
	private int balance=100;
	
	public int getBalance() {
		return balance;
	}
	public synchronized void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName()+" attempting to withdraw: "+ amount);
		
		if(amount<=balance) {
			try {
				Thread.sleep(10000);
			}catch(Exception e) {
				System.out.println(e);
			}
			
			balance -=amount;
			
			System.out.println(Thread.currentThread().getName()+" withdraw successfull. remaining balance:  "+ amount);
		}else {
			System.out.println(Thread.currentThread().getName()+" unsuccessful transaction: balance is low: "+ amount);
		}
	}
}
