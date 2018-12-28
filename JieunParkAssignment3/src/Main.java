import java.util.ArrayList;
import java.util.Random;

public class Main
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

	private static double calculateSum(ArrayList<Measurable> sum_list)
	{
		double sum = 0;
		for (int i = 0; i < sum_list.size(); ++i)
		{
			Measurable all_sum = sum_list.get(i);
			sum += all_sum.getArea();
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
			double randomNum = nextDouble();

			if (randomNum < 0.25) // rectangle
			{
				list.add(new Box(nextDouble(), nextDouble(), nextDouble()));
				box += 1;

			} else if (randomNum < 5.0)
			{
				list.add(new Sphere(nextDouble()));
				sphere += 1;

			} else if (randomNum < 7.5)
			{
				list.add(new Rectangle(nextDouble(), nextDouble()));
				rectangle += 1;

			} else
			{
				list.add(new Circle(nextDouble()));
				circle += 1;
			}
		}
		System.out.println("rects: " + rectangle + " boxes: " + box + " circles: " + circle + " sphere: " + sphere);
		System.out.println("sum: " + calculateSum(list));
		System.out.println(Double.MIN_VALUE);

	}

}
