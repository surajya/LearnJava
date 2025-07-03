package com.multithreading.c_syncronization;

public class Testsync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter counter=new Counter();
		MyThreadsync t1=new MyThreadsync(counter);
		MyThreadsync t2=new MyThreadsync(counter);
		t1.start();
		t2.start();
		try {
			t1.join(); t2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(counter.getCount());
	}

}
