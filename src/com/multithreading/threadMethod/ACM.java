package com.multithreading.threadMethod;

//Thread class method
//1. start: used to start new thread
//2. run: Contains the actual code to be executed in the new thread
//3. Thread.sleep: Temporarily pauses the execution of the current thread for a specified time. throws InterruptedException
//4. join: When you want to wait for another thread to finish before continuing further in the current thread. throws InterruptedException.
//5. setPriority: Thread priorities are used by the thread scheduler to decide which thread to execute first when multiple threads are waiting to be executed.
//One thread can start only once, if more than one-> throws IllegalThreadStateException
//6. Interrupt: Just a signal, it doesn’t forcibly stop the thread
//If the thread is in a blocked state (sleep(), wait(), join()) — calling interrupt() will: 1. Wake it up prematurely 2.Throw an InterruptedException
//7. Thread.yield(): To allow other equal-priority threads a chance to run.  It’s a hint to the thread scheduler — not a command.
//8. User Thread VS  Daemon Thread: User Thread-> A chef cooking a dish. Daemon Thread->A helper cleaning the kitchen. Once the chef (user thread) finishes, the restaurant (JVM) closes — the helper (daemon) is forced to stop. Always set .setDaemon(true) before calling .start(). When all user threads finish, daemon threads are automatically stopped, even if they are still running.



public class ACM extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
			Thread.yield();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ACM acm = new ACM();
		// ACM t1=new ACM();
		Thread t = new Thread(acm);
		// t.setPriority(MAX_PRIORITY);
		// t1.start();
		// t.join();
		t.start();
		t.interrupt();
		// t.join();
		for (int i = 0; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName());
			Thread.yield();
		}
	}

}
