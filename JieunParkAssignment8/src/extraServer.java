import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class extraServer
{
	private static final int PORT = 1211;
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static ArrayList<Integer> primeList = new ArrayList<Integer>();

	public static void main(String[] args) throws ClassNotFoundException, InterruptedException
	{
		ServerSocket serversocket = null;
		Socket socket = null;
		ObjectOutputStream output = null;
		ObjectInputStream input = null;
		try
		{
			serversocket = new ServerSocket(PORT);
			while (true)
			{
				socket = serversocket.accept();

				output = new ObjectOutputStream(socket.getOutputStream());
				output.flush();

				input = new ObjectInputStream(socket.getInputStream());

				while (true)
				{
					try
					{
						Object message = input.readObject();
						list = (ArrayList<Integer>) message;
						for (int i = 0; i < list.size(); i++)
						{
							boolean Prime = PrimeCheck(list.get(i));
							if (Prime)
							{
								primeList.add(list.get(i));
							}
						}
						output.writeUTF("Receive: " + primeList);
						output.flush();
						Thread.sleep(1000);
						primeList = new ArrayList<Integer>();

					} catch (EOFException ex)
					{
						break;
					}
				}
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (serversocket != null)
				{
					serversocket.close();
				}
				if (socket != null)
				{
					socket.close();
				}
				if (output != null)
				{
					output.close();
				}
				if (input != null)
				{
					input.close();
				}
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

	public static boolean PrimeCheck(int n)
	{
		if (n == 2 || n == 3)
		{
			return true;
		} else if (n % 2 == 0)
		{
			return false;
		} else if (n == 1)
		{
			return false;
		}
		int sqrt = (int) Math.sqrt(n) + 1;
		for (int i = 3; i < sqrt; i += 2)
		{
			if (n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}
