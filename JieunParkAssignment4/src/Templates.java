import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Templates
{
	public final static int SMALL = 5;
	public static final int MEDIUM = 10;
	public static final int LARGE = 15;

	public static final Color black = Color.BLACK;
	public static final Color green = Color.GREEN;
	public static final Color yellow = Color.YELLOW;
	public static final Color gray = Color.GRAY;

	private Point point;
	private int size;
	private Color color;

	public Templates(Point _point, Color _color, int _size)
	{
		point = _point;
		color = _color;
		size = _size;

	}

	public Color getcolor()
	{
		return color;
	}

	public Point getPoint()
	{
		return point;
	}

	public int getSize()
	{
		return size;
	}

	public void paint(Graphics g)
	{
		if (size == SMALL)
		{
			g.fillOval(point.x, point.y, SMALL, SMALL);
		} else if (size == MEDIUM)
		{
			g.fillOval(point.x, point.y, MEDIUM, MEDIUM);
		} else
		{
			g.fillOval(point.x, point.y, LARGE, LARGE);
		}
	}

	public void setcolor(Graphics g)
	{
		if (color == black)
		{
			g.setColor(black);
		} else if (color == gray)
		{
			g.setColor(gray);
		} else if (color == yellow)
		{
			g.setColor(yellow);
		} else
		{
			g.setColor(green);
		}
	}

}
