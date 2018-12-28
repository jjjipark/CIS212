import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonFrame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private paintPanel _paintPanel;

	// Color Buttons
	private final JButton blackbutton;
	private final JButton greenbutton;
	private final JButton yellowbutton;
	private final JButton graybutton;

	// size buttons
	private final JButton smallbutton;
	private final JButton mediumbutton;
	private final JButton largebutton;
	private final JButton clearbutton;

	public ButtonFrame()
	{
		super("GUI");
		setLayout(new BorderLayout());

		_paintPanel = new paintPanel();
		add(_paintPanel, BorderLayout.CENTER);

		// COLOR
		JPanel button1 = new JPanel();
		button1.setLayout(new GridLayout(4, 1));

		blackbutton = new JButton("Black");
		blackbutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.setnewcolor(Templates.black);
			}
		});
		button1.add(blackbutton); // attach button to panel

		yellowbutton = new JButton("Yellow");
		yellowbutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.setnewcolor(Templates.yellow);
			}
		});
		button1.add(yellowbutton);
		greenbutton = new JButton("Green");
		greenbutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.setnewcolor(Templates.green);
			}
		});
		button1.add(greenbutton);
		graybutton = new JButton("Gray");
		graybutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.setnewcolor(Templates.gray);
			}
		});
		button1.add(graybutton);

		add(button1, BorderLayout.WEST);

		// SIZE
		JPanel button2 = new JPanel();
		button2.setLayout(new GridLayout(4, 1));

		smallbutton = new JButton("small");
		smallbutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.Setnewsize(Templates.SMALL);
			}
		});
		button2.add(smallbutton);

		mediumbutton = new JButton("medium");
		mediumbutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.Setnewsize(Templates.MEDIUM);
			}
		});
		button2.add(mediumbutton);

		largebutton = new JButton("large");
		largebutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.Setnewsize(Templates.LARGE);
			}
		});
		button2.add(largebutton);

		// clear button
		clearbutton = new JButton("clear");
		clearbutton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				_paintPanel.clearPaint();
			}
		});
		button2.add(clearbutton);

		add(button2, BorderLayout.EAST);
	}

}
