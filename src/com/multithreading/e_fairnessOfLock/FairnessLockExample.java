package com.multithreading.e_fairnessOfLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Reentrant has availability of fairness.
//when we are autometically locking and unlocking then thread will waiting int read and write both case.
// But in case of manually we can overcome this.
//By readWriteLock rwl=new ReentrantReadWriteLock();
// Readlock before locking check that writelock is acquire lock or not. if writelock acquire lock then readlock is wait



public class FairnessLockExample {
	
	public final Lock unfairLock= new ReentrantLock(true);
	
	public void accessResource() {
		unfairLock.lock();
		
		try {
			System.out.println(Thread.currentThread().getName()+" acquiring the lock");
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO: handle exception
			Thread.currentThread().interrupt();
		} finally {
			unfairLock.unlock();
			System.out.println(Thread.currentThread().getName()+" releasing the lock");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		FairnessLockExample fairnessLock=new FairnessLockExample();
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				fairnessLock.accessResource();
			}
		};
		
		Thread t1=new Thread(task, "Task -1");
		Thread t2=new Thread(task, "Task -2");
		Thread t3=new Thread(task, "Task -3");
		
		t1.start(); 
		Thread.sleep(500); 
		t2.start();
		Thread.sleep(500); 
		t3.start();
		
	}
}
