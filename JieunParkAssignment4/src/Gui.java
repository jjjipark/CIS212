import javax.swing.JFrame;

public class Gui
{

	public static void main(String[] args)
	{

		ButtonFrame bf = new ButtonFrame();

		bf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		bf.setSize(400, 200);
		bf.setVisible(true);
	}

}