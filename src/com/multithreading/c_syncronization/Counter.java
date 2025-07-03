package com.multithreading.c_syncronization;

//🔐 What is Synchronization: Synchronization means controlling access to shared resources (like variables or objects) so that only one thread can use it at a time.
//👉 Think of it like a bathroom with a lock: Only one person (thread) can use it at a time. Others must wait until it's free.
// we can make any block or whole method as synchronized.

public class Counter {
	private int count;
	
	public void increment() {
		synchronized(this){
		count++;}
	}
	
//	public synchronized void increment() {
//		count++;
//	}
	
	public int getCount() {return count;}
}
