import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class extraClient
{
	private static final int PORT = 1211;
	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static Socket socket;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private static int num = 0;

	public static class UserInput extends Thread
	{
		public void run()
		{
			try
			{
				InetAddress address = InetAddress.getLoopbackAddress();
				socket = new Socket(address, PORT);
				output = new ObjectOutputStream(socket.getOutputStream());
				output.flush();
				input = new ObjectInputStream(socket.getInputStream());
				System.out.println("Enter '!' to start and stop, '#' to quit");

				while (true)
				{
					Scanner s = new Scanner(System.in);
					String user_input = s.next();

					if (user_input.equals("!") && num % 2 == 0)
					{
						generation g = new generation();
						Thread t = new Thread(g);
						t.start();
						num++;
					}

					else if (user_input.equals("!") && num % 2 == 1)
					{
						generation.Running = false;
						Thread.sleep(1000);
						num++;
						System.out.println("Enter '!' to start and stop, '#' to quit");
					}

					else if (user_input.equals("#"))
					{
						// System.out.println("DONE");
						System.exit(0);
					}
				}
			} catch (IOException | InterruptedException ex)
			{
				ex.printStackTrace();
			} finally
			{

				try
				{
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
				} catch (IOException ex)
				{
					ex.printStackTrace();
				}
			}
		}
	}

	public static class generation extends Thread
	{
		static boolean Running = true;

		public void run()
		{
			while (true)
			{
				if (Running)
				{
					try
					{
						sendMessage(randomNum(2, 100));
					} catch (InterruptedException e1)
					{
						e1.printStackTrace();
					}
					String message;
					try
					{
						message = input.readUTF();
						messageReceived(message);
					} catch (IOException e)
					{
						e.printStackTrace();
					}
				} else
				{
					Running = true;
					return;
				}

			}
		}
	}

	private static void sendMessage(ArrayList<Integer> message) throws InterruptedException
	{
		try
		{
			output.writeObject(message);
			Thread.sleep(1000);
			System.out.println("Send: " + message);
			output.flush();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

	private static void messageReceived(String message)
	{
		System.out.println(message);
	}

	private static ArrayList<Integer> randomNum(int min, int max)
	{
		Random rn = new Random();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int num = 0;
		for (int i = 1; i <= 5; i++)
		{
			num = rn.nextInt((max - min) + 1) + min;
			list.add(num);
		}

		return list;
	}

	public static void main(String[] args)
	{

		UserInput user = new UserInput();
		Thread t = new Thread(user);
		t.start();

	}
}