import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main
{
	// static boolean done = false;

	public static void main(String[] args)
	{
		CircularBuffer buff = new CircularBuffer();

		Producer prod1 = new Producer("producer2", buff);
		Producer prod2 = new Producer("producer2", buff);
		Consumer cons1 = new Consumer("consumer1", buff);
		Consumer cons2 = new Consumer("consumer2", buff);

		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(prod1);
		es.execute(prod2);
		es.execute(cons1);
		es.execute(cons2);
		es.shutdown();

		/*
		 * Thread prodThread1 = new Thread(new Producer("producer1", buf));
		 * prodThread1.start(); Thread prodThread2 = new Thread(new
		 * Producer("producer2", buf)); prodThread2.start(); Thread consThread1
		 * = new Thread(new Consumer("consumer1", buf)); consThread1.start();
		 * Thread consThread2 = new Thread(new Consumer("consumer2", buf));
		 * consThread2.start();
		 * 
		 * /* prodThread1.start(); prodThread2.start(); consThread1.start();
		 * consThread2.start();
		 */
	}

}
