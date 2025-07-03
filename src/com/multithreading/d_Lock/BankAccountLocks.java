package com.multithreading.d_Lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Two type of locks 1. Intrinsic lock  2.explicit lock
//1.Intrinsic lock: It is buit in lock into every object, when we use 'Synchronized" then it is used.
//2. Explicit Lock: This is more advance lock you can control using lock class.
//we can say 'Synchronized' is automatic locks where 'Locks' interface is manual locks.
//Locks: when thread-1 take too much time and thread-2 are waiting. This is the disadvantage of synchronized keyword. So, locks interface comes into picture.
//locks method: 
//1. trylock()-> this is check lock is free or not, if lock is not free then this method throw false immediate
//2. TryLock(time, unit)-> by this thread wait till time for free the lock.
//3. Unlock() -> this is used for free the lock.
//4. lock() -> thread will wait for infinite time untill lock not find.
//5. Thread.currentThread().interrupt()

//ReentrantLock: it is used give the permission to one thread can aquire lock multiple time and need to unlock same number as aquire lock.
//Reentrantlock: when we use the fair as true then order of locking and unlocking is reserve. means in same order they are locking and unlocking for specific thread.

public class BankAccountLocks {
	private int balance=100;
	
	public int getBalance() {
		return balance;
	}
	
	private final Lock lock=new ReentrantLock();
	public void withdraw(int amount) {
		
		System.out.println(Thread.currentThread().getName()+" attempting to withdraw: "+ amount);
		
		try {
			if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
				System.out.println(Thread.currentThread().getName()+" has taken lock");
				if(amount<=balance) {
					try {
						Thread.sleep(3000);
						balance -=amount;
						System.out.println(Thread.currentThread().getName()+" withdraw successfull. remaining balance:  "+ amount);
					}catch(InterruptedException e) {
						Thread.currentThread().interrupt();
					}finally {
						lock.unlock();
					}
				}else {
					System.out.println(Thread.currentThread().getName()+" unsuccessful transaction: balance is low: "+ amount);
				}
			}else {
				System.out.println(Thread.currentThread().getName()+" lock is not free "+ amount);

			}
		} catch (InterruptedException e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();
		}
		
		if(Thread.currentThread().isInterrupted()) {
			System.out.println("Current thread is interrupted...............");
		}
	}
}
