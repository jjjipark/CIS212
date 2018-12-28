
public class Rectangle implements Measurable
{
	public double height;
	public double width;

	public Rectangle(double x, double y)
	{
		height = x;
		width = y;
	}

	public double getheight()
	{
		return height;
	}

	public double getwidth()
	{
		return width;
	}

	public double getArea()
	{
		return height * width;
	}

}
