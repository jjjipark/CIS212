import java.util.LinkedList;

public class CircularBuffer
{

	// private boolean empty = true;
	private String contents;
	int occupiedcells = 0;
	private LinkedList<String> buffer = new LinkedList<String>();

	public synchronized void put(String n) throws InterruptedException
	{

		while (occupiedcells == 100)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				throw e;
			}
		}

		// contents = n;
		// notify();
		buffer.addLast(n);

		// empty = false;
		++occupiedcells;
		notifyAll();

	}

	public synchronized String get() throws InterruptedException
	{
		String val;

		while (occupiedcells == 0)
		{
			try
			{
				wait();
			} catch (InterruptedException e)
			{
				throw e;
			}
		}
		// empty = true;
		// notify();
		--occupiedcells;
		val = buffer.removeFirst();
		notifyAll();

		return val;

	}
}
