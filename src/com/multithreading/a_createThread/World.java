package com.multithreading.a_createThread;


//********* Create THREAD   *********
//1. create class, extends thread class, override run method, create object of class , call start method with help of object.
//2.1. create class, Implements runnable interface , override run method, create object of class , create instance of THREAD where enter object in constructor, call start method with help of instance of thread.
//************* Life Cycle ***************
//1. New  2. Runnable    3. Running       4. Blocking/WAIT      5.Terminate
//Runnable is used when class is extends another class already, if you extends thread class then multiple inheritance violation.
//Thread is used when class is not extends another class.



public class World extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(;;) {
		System.out.println(Thread.currentThread().getName());
		}
	}
	
}
