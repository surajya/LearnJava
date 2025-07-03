package com.multithreading.f_ReadWriteCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Read-Write lock provide the acceptability to multiple read-thread can read concurrently as long as no thread is writing to it.

public class ReadWriteCounter {
	
	private int counter=0;
	private final ReadWriteLock lock=new ReentrantReadWriteLock();
	private final Lock readLock=lock.readLock();
	private final Lock writeLock=lock.writeLock();
	
	public void increment() throws InterruptedException {
		writeLock.lock();
		try {
			counter++;
			Thread.sleep(8);
		} finally {
			writeLock.unlock();
		}
	}
	
	public int getCount() {
		readLock.lock();
		try {
			return counter;
		} finally {
			readLock.unlock();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReadWriteCounter counter=new ReadWriteCounter();
		Runnable readTask=new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					System.out.println(Thread.currentThread().getName()+" Read "+counter.getCount());
				}
				
			}
		};
		
		Runnable writeTask=new Runnable() {
			
			@Override
			public void run() {
				for(int i=0; i<10; i++) {
					try {
						counter.increment();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println(Thread.currentThread().getName()+" Increment ");
				}
				
			}
		};
		
		Thread writeThread=new Thread(writeTask);
		Thread ReaderThread1=new Thread(readTask);
		Thread ReaderThread2=new Thread(readTask);
		
		writeThread.start();
		ReaderThread1.start();
		ReaderThread2.start();
		
		writeThread.join();
		ReaderThread1.join();
		ReaderThread2.join();
		
		System.out.println("Value of final counter: "+counter.getCount());
		
	}

}
