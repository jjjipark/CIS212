
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class JieunParkAssigment2
{

	public static void main(String[] args)
	{

		int length = 0;
		Scanner var = new Scanner(System.in);
		double density = 0;

		while (true)
		{
			try
			{
				System.out.println("Please array length: ");
				length = var.nextInt();
				if (length < 0)
				{
					System.out.println("Enter positive integer");
					continue;
				}
				break;
			} catch (InputMismatchException e)
			{
				System.out.println("Error: The value should be an integer");
				var.next();
			}
		}

		while (true)
		{
			try
			{
				System.out.println("Enter density: ");
				density = var.nextDouble();
				if (density < 0.0 || density > 1.0)
				{
					System.out.println("Density is out of range");
					continue;
				}
				break;
			} catch (InputMismatchException e)
			{
				System.out.println("Error: The value should be an integer");
				var.next();
			}
			var.close();
		}

		long start1 = System.nanoTime();
		int[] denseArray = dense(length, density);
		long end1 = System.nanoTime() - start1;
		System.out.println("create dense length:" + denseArray.length + " time:" + end1 / 100000d);

		long start_spar = System.nanoTime();
		ArrayList<Integer> convert_spar = convert_sparse(denseArray);
		long end2 = System.nanoTime() - start_spar;
		System.out.println("convert to sparse length: " + convert_spar.size() + " time: " + end2 / 1000000);

		long start2 = System.nanoTime();
		ArrayList<Integer> sparseArray = sparse(length, density);
		long end3 = System.nanoTime() - start2;
		System.out.println("create sparse length: " + sparseArray.size() + " time: " + end3 / 1000000d);

		long start_dense = System.nanoTime();
		int[] convert_den = convert_dense(sparseArray);
		long end4 = System.nanoTime() - start_dense;
		System.out.println("convert to dense length: " + convert_den.length + " time: " + end4 / 1000000);

		long start_dMax = System.nanoTime();
		int[] dMax = maxdense(denseArray);
		long end5 = System.nanoTime() - start_dMax;
		System.out.println("find max (dense); " + dMax[0] + " at: " + dMax[1]);
		System.out.println("dense find time: " + end5 / 1000000);

		long start_sMax = System.nanoTime();
		int[] sMax = maxsparse(sparseArray);
		long end6 = System.nanoTime() - start_sMax;
		System.out.println("find max (sparse): " + sMax[0] + " at " + sMax[1]);
		System.out.println("sparse fine time: " + end6 / 1000000);
	}

	public static int[] dense(int length, double density)
	{
		int[] dense_array = new int[length];
		Random random = new Random();
		// double d = Math.random();
		for (int i = 0; i < length; ++i)
		{
			if (random.nextDouble() < density)
			{
				dense_array[i] = random.nextInt(1000000);

			} else
			{
				dense_array[i] = 0;
			}
		}
		// System.out.println(dense_array);
		return dense_array;
	}

	public static ArrayList<Integer> sparse(int length, double density)
	{
		ArrayList<Integer> sparse_array1 = new ArrayList<Integer>();
		Random random = new Random();
		for (int i = 0; i < length; ++i)
		{
			if (random.nextDouble() < density)
			{
				sparse_array1.add(random.nextInt(1000000));
			}
		}
		// System.out.println(sparse_array1);
		return sparse_array1;
	}

	public static ArrayList<Integer> convert_sparse(int[] dense)
	{
		ArrayList<Integer> sparse_array2 = new ArrayList<Integer>();
		for (int i = 0; i < dense.length; ++i)
		{
			int number = dense[i];
			if (number != 0)
			{
				sparse_array2.add(number);
			}
		}
		return sparse_array2;
	}

	public static int[] convert_dense(ArrayList<Integer> sparse)
	{
		int[] new_array3 = new int[sparse.size() - 1];
		for (int i = 0; i < sparse.size() - 1; ++i)
		{
			if (sparse.get(i) == i)
			{
				new_array3[i] = sparse.get(i);
			} else
			{
				new_array3[i] = 0;
			}
		}
		return new_array3;
	}

	public static int[] maxdense(int[] dense)
	{
		int[] maxarray = new int[2];
		int max = 0;
		int index = 0;
		for (int i = 0; i < dense.length; ++i)
		{
			if (dense[i] > max)
			{
				max = dense[i];
				index = i;
			}
			maxarray[0] = max;
			maxarray[1] = index;
		}
		return maxarray;
	}

	public static int[] maxsparse(ArrayList<Integer> sparse)
	{
		int[] maxarray1 = new int[2];
		int max = 0;
		int index = 0;
		for (int i = 0; i < sparse.size(); ++i)
		{
			if (sparse.get(i) > max)
			{
				max = sparse.get(i);
				index = i;
			}
			maxarray1[0] = max;
			maxarray1[1] = index;
		}
		return maxarray1;
	}

}
