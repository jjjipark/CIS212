
public class Circle implements Measurable
{
	private double radius;

	public Circle(double x)
	{
		radius = x;
	}

	public double getRadius()
	{
		return radius;

	}

	@Override
	public double getArea()
	{
		return Math.PI * Math.pow(radius, 2);
	}

}
