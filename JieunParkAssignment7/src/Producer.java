
public class Producer implements Runnable
{
	private CircularBuffer buf;
	private String n;
	int producer_count = 0;
	private static boolean done = false;

	public Producer(String name, CircularBuffer _buf)
	{
		n = name;
		buf = _buf;
	}

	@Override
	public void run()
	{
		for (int i = 1; i <= 1000; i++)
		{
			/*
			 * try { Thread.sleep(10); } catch (InterruptedException e) {
			 * return; }
			 */
			if (i % 100 == 0)
			{
				System.out.printf(n + " produced " + i + " events\n");
			}

			String randomStr = Double.toString(Math.random());
			try
			{
				buf.put(randomStr);
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			producer_count++;

			try
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				return;
			}
		}
		done = true;
		System.out.println("Summary");
		System.out.println(n + " : " + producer_count + " events consumed");
	}

	public static boolean complete()
	{
		return done;
	}

}
