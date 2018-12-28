
import java.util.ArrayList;
import java.util.Random;

public class Main1
{

	private static double nextDouble()
	{
		Random random = new Random();
		double range = random.nextDouble();
		if (range < Double.MIN_VALUE)
		{
			nextDouble();
		}
		return range;

	}

	private static double calculateSum(ArrayList<Measurable> list)
	{
		double sum = 0;
		for (int i = 0; i < list.size(); ++i)
		{
			Measurable num = list.get(i);
			sum += num.getArea();
		}
		return sum;
	}

	public static void main(String[] args)
	{
		ArrayList<Measurable> list = new ArrayList<Measurable>();
		int circle = 0;
		int sphere = 0;
		int rectangle = 0;
		int box = 0;

		for (int i = 0; i < 1000; ++i)
		{
			double random_number = nextDouble();
			if (random_number < 0.25)
			{
				list.add(new Circle(nextDouble()));
				circle += 1;
			} else if (random_number < (0.25 * 2))
			{
				list.add(new Rectangle(nextDouble(), nextDouble()));
				rectangle += 1;
			} else if (random_number < (0.25 * 3))
			{
				list.add(new Sphere(nextDouble()));
				sphere += 1;
			} else
			{
				list.add(new Box(nextDouble(), nextDouble(), nextDouble()));
				box += 1;
			}
		}

		System.out.println("rects: " + rectangle + " boxes: " + box + " circles: " + circle + " sphere: " + sphere);
		System.out.println("sum: " + calculateSum(list));
	}
}