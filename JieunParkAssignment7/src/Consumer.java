
public class Consumer implements Runnable
{

	private CircularBuffer buf;
	String n;
	int consumer_count = 0;

	public Consumer(String name, CircularBuffer _buf)
	{
		n = name;
		buf = _buf;
	}

	@Override
	public void run()
	{
		String value;

		while (!Producer.complete())
		{
			try
			{
				value = buf.get();
				if (value != null)
				{
					consumer_count++;
					if (consumer_count % 100 == 0)
					{
						System.out.println(n + " : " + consumer_count + " events consumed");
					}
				}
			} catch (InterruptedException e1)
			{
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try
			{
				Thread.sleep(10);
			} catch (InterruptedException e)
			{
				return;
			}
		}
		System.out.println(n + " consumed " + consumer_count + " events");
	}
}
