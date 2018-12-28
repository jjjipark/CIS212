import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class Assignment7
{
	private static boolean done = false;
	// private static Random r = new Random();

	public static void main(String[] args)
	{
		LinkedBlockingQueue<String> queue = new LinkedBlockingQueue<String>(100);

		Producer producer1 = new Producer(queue);
		Consumer consumer1 = new Consumer(queue, "consumer1");
		Consumer consumer2 = new Consumer(queue, "consumer2");
		Consumer consumer3 = new Consumer(queue, "consumer3");
		// Consumer consumer4 = new Consumer(queue, "consumer4");

		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(producer1);
		es.execute(consumer1);
		es.execute(consumer2);
		es.execute(consumer3);
		// es.execute(consumer4);
		es.shutdown();
	}

	public static class Producer implements Runnable
	{
		private LinkedBlockingQueue<String> queue;
		int produce_count;

		public Producer(LinkedBlockingQueue<String> queue)
		{
			this.queue = queue;
		}

		@Override
		public void run()
		{
			for (int i = 1; i <= 1000; i++)
			{
				if (i % 100 == 0)
				{
					System.out.printf("Producer 1 : %d events produced\n", i);
				}
				try
				{
					String randomStr = Double.toString(Math.random());
					queue.put(randomStr);
					produce_count++;
					// long sleep_delay = (long) (10 * Math.random());
					// Thread.sleep(sleep_delay);

				} catch (InterruptedException e)
				{
					System.out.println("InterruptedException");
				}
			}
			done = true;
			System.out.println("Summary: ");
			System.out.println("Producer 1 produces " + produce_count + " events");

		}

		public static boolean complete()
		{
			return done;
		}
	}

	public static class Consumer implements Runnable
	{
		LinkedBlockingQueue<String> queue;
		String name;
		int consumer_count = 0;

		public Consumer(LinkedBlockingQueue<String> queue, String name)
		{
			this.queue = queue;
			this.name = name;
		}

		@Override
		public void run()
		{

			while (!Producer.complete())
			{
				long sleep_delay = (long) (10 * Math.random());
				try
				{
					Thread.sleep(sleep_delay);
				} catch (InterruptedException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				try
				{
					String n = queue.poll(100, TimeUnit.MILLISECONDS);
					if (n != null)
					{
						consumer_count++;
						if (consumer_count % 100 == 0)
						{
							System.out.println(name + " : " + consumer_count + " events consumed");
						}

					}
				} catch (InterruptedException e)
				{
					System.out.println("Consumer Interrupted");
				}
			}
			System.out.println(name + " consumes " + consumer_count + " events");
			// System.out.println(consumer_count);
		}
	}
}
