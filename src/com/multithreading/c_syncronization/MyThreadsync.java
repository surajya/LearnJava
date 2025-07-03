package com.multithreading.c_syncronization;

public class MyThreadsync extends Thread{
	private Counter counter;
	
	public MyThreadsync(Counter counter) {
		// TODO Auto-generated constructor stub
		this.counter=counter;
	}

	@Override
	public void run() {
		for(int i=0; i<1000; i++) {
			counter.increment();
		}
	}
	
	
}
