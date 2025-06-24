package com.multithreading.createThread;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		World world=new World();
//		world.start();
		
		RunnableThread rt=new RunnableThread();
		Thread thread=new Thread(rt);
		thread.start();
		
		for(;;) {
			System.out.println(Thread.currentThread().getName());
			
			
		}
	}

}
