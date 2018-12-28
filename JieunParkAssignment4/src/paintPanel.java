import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JPanel;

public class paintPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ArrayList<Templates> points;

	private Color color;
	private int size;

	public paintPanel()
	{
		points = new ArrayList<>();
		color = Templates.black;
		size = Templates.SMALL;

		addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent event)
			{
				points.add(new Templates(event.getPoint(), color, size));
				repaint();
			}
		});
	}

	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (Templates point : points)
		{
			point.setcolor(g);
			point.paint(g);
		}
	}

	public void setnewcolor(Color color_)
	{
		color = color_;
	}

	public void Setnewsize(int size_)
	{
		size = size_;
	}

	public void clearPaint()
	{
		points = new ArrayList<Templates>();
		repaint();
	}

}