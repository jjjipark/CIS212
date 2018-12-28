
public class Box extends Rectangle
{

	private double depth;

	public Box(double x, double y, double z)
	{

		super(x, y);
		this.depth = z;
	}

	public double getDepth()
	{
		return depth;
	}

	public double surfacebox()
	{
		return getArea();
	}

	public double getArea()
	{
		return (getheight() * getwidth()) * 2 + (getheight() * depth) * 2 + (getheight() * getwidth()) * 2;
	}
}
