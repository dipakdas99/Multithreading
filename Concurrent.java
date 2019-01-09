package com.multitheading;
/**
 * 
 * @author dipak.das
 * After finish printing one object of a class then another object start running with out using Runnable
 * With the implement of Runnable both object are running parallelly 
 */
class Runner1 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("Runner1: "+i);
	}
}
class Runner2 implements Runnable{
	@Override
	public void run() {
		for (int i = 0; i < 10; i++)
			System.out.println("Runner2: "+i);
	}
}
public class Concurrent {
	public static void main(String[] args) {
		/*Runner1 t1 = new Runner1();
		Runner2 t2 = new Runner2();
		t1.print();
		t2.print();*/
		Thread t1 = new Thread(new Runner1());
		Thread t2 = new Thread(new Runner2());
		t1.start();
		t2.start();
	}

}
