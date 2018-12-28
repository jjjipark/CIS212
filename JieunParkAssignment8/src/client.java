import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class client
{

	private static final int PORT = 2200;
	private static ArrayList<Integer> user_input = new ArrayList<Integer>();
	private static Socket socket;
	private static ObjectOutputStream output;
	private static ObjectInputStream input;
	private static final String a = "!";

	public static void main(String[] args) throws IOException
	{

		try
		{
			InetAddress address = InetAddress.getLoopbackAddress();
			socket = new Socket(address, PORT);

			output = new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			input = new ObjectInputStream(socket.getInputStream());
			Scanner in = new Scanner(System.in);

			while (true)
			{
				System.out.print("Enter an Integer ('!' to send): ");
				String msg = in.nextLine();
				if (msg.matches(a))
				{
					sendMessage(user_input);
					break;

				} else
				{
					user_input.add(Integer.parseInt(msg));

				}
			}
			in.close();
			String message = input.readUTF();
			messageReceived(message);

		} catch (IOException ex)
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

	private static void sendMessage(ArrayList<Integer> message)
	{
		try
		{
			output.writeObject(message);
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
}
