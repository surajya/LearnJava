package com.multithreading.createThread;


//********* Create THREAD   *********
//1. create class, extends thread class, override run method, create object of class , call start method with help of object.
//2.1. create class, Implements runnable interface , override run method, create object of class , create instance of THREAD where enter object in constructor, call start method with help of instance of thread.



public class RunnableThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
		System.out.println(Thread.currentThread().getName());
		}
	}
	
}
