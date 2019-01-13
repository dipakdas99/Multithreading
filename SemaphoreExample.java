package com.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum Downloader{
	INSTANCE;
	private Semaphore semaphore = new Semaphore(3, true);

	public void DownloadData(){
		try {
			semaphore.acquire();
			Download();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
	}

	private void Download() {
		System.out.println("Downloading data.....");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
public class SemaphoreExample {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for (int i = 0; i < 12; i++){
			executor.execute(new Runnable(){
				public void run() {
					Downloader.INSTANCE.DownloadData();
				}

			});
		}
	}

}
