
public class Sphere extends Circle
{

	public Sphere(double x)
	{
		super(x);
	}

	public double getArea()
	{
		return 4 * Math.pow(getRadius(), 2) * Math.PI;
	}
}
