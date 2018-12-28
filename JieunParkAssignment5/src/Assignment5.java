import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Assignment5
{
	private static ArrayList<Phonebook> data = new ArrayList<Phonebook>();

	public static class Phonebook
	{
		private String _name;
		private String _number;

		public Phonebook(String name, String number)
		{
			_name = name;
			_number = number;
		}

		public String getName()
		{
			return _name;
		}

		public String getNumber()
		{
			return _number;
		}

	}
	// selection sorts, from the textbook Ch.19

	public static ArrayList<Phonebook> selectionsort(ArrayList<Phonebook> data)
	{
		ArrayList<Phonebook> sort = new ArrayList<Phonebook>(data);
		for (int i = 0; i < sort.size(); ++i)
		{
			int smallest = i;
			for (int index = i + 1; index < sort.size(); ++index)
			{
				if ((sort.get(index).getName().compareTo(sort.get(smallest).getName())) < 0)
				{
					smallest = index;
				}

			}
			swap(sort, i, smallest);
		}
		return sort;
	}

	public static void swap(ArrayList<Phonebook> data, int first, int second)
	{
		Phonebook temp = data.get(first);
		data.set((first), data.get(second));
		data.set((second), temp);
	}

	// merge sorts, from the textbook Ch.19

	public static ArrayList<Phonebook> mergeSort(ArrayList<Phonebook> data)
	{
		ArrayList<Phonebook> sort = new ArrayList<Phonebook>(data);
		sortArray(sort, 0, sort.size() - 1);

		return sort;
	}

	public static void sortArray(ArrayList<Phonebook> data, int low, int high)
	{
		if ((high - low) >= 1)
		{
			int middle1 = (low + high) / 2;
			int middle2 = middle1 + 1;

			sortArray(data, low, middle1);
			sortArray(data, middle2, high);

			merge(data, low, middle1, middle2, high);
		}
	}

	public static void merge(ArrayList<Phonebook> data, int left, int middle1, int middle2, int right)
	{

		int leftIndex = left;
		int rightIndex = middle2;
		int combinedIndex = left;
		ArrayList<Phonebook> combined = new ArrayList<Phonebook>(data);

		while (leftIndex <= middle1 && rightIndex <= right)
		{
			if ((data.get(leftIndex).getName().compareTo(data.get(rightIndex).getName())) <= 0)
			{
				combined.set(combinedIndex++, data.get(leftIndex++));
			} else
			{
				combined.set(combinedIndex++, data.get(rightIndex++));
			}
		}
		if (leftIndex == middle2)
		{
			while (rightIndex <= right)
			{
				combined.set(combinedIndex++, data.get(rightIndex++));
			}
		} else
		{
			while (leftIndex <= middle1)
			{
				combined.set(combinedIndex++, data.get(leftIndex++));
			}
		}

		for (int i = left; i <= right; ++i)
		{
			data.set(i, combined.get(i));
		}

	}

	public static boolean check(ArrayList<Phonebook> data)
	{
		boolean checking = true;
		for (int i = 1; i < data.size(); ++i)
		{
			if ((data.get(i - 1).getName().compareTo(data.get(i).getName())) > 0)
			{
				checking = false;
			}
		}
		return checking;
	}

	public static class Reader
	{

		public void readFile()
		{
			try
			{
				BufferedReader bf = new BufferedReader(new FileReader("phonebook.txt"));
				String line = bf.readLine();
				while (line != null)
				{
					String[] part = line.split(" ");
					data.add(new Phonebook(part[1] + " " + part[2], part[0]));
					line = bf.readLine();
					// System.out.println(data.get(2));
					// System.out.println(line); // null printed??
				}
				bf.close();
			} catch (Exception e)
			{
				System.err.println(e.getMessage());
			}
		}
	}

	public static class OpenFile
	{
		public void openFile(ArrayList<Phonebook> data, String input)
		{
			try
			{
				// BufferedReader bf = new BufferedReader(new
				// FileReader("phonebook.txt"));
				// String line = bf.readLine();
				BufferedReader fr = new BufferedReader(new FileReader("phonebook.txt"));
				BufferedWriter fw = new BufferedWriter(new FileWriter("output.txt"));
				String line = null;

				while ((line = fr.readLine()) != null)
				{
					if (line.contains(input))
					{
						fw.write(line + "\n");
					}
				}
				// System.out.println("success");
				fw.close();
				fr.close();
			} catch (Exception e)
			{
				System.out.println("Exception: " + e);
			}
		}
	}

	public static void main(String[] args)
	{
		Reader read = new Reader();
		read.readFile();
		ArrayList<Phonebook> selection_list;
		ArrayList<Phonebook> merge_list;

		long start = System.nanoTime();
		selection_list = selectionsort(data);
		long end = System.nanoTime() - start;
		System.out.println("Selection Sort: " + end / 1000000000.0);

		long start2 = System.nanoTime();
		merge_list = mergeSort(data);
		long end2 = System.nanoTime() - start2;
		System.out.println("Merge Sort: " + end2 / 1000000000.0);

		OpenFile newfile = new OpenFile();
		newfile.openFile(data, "new");

	}

}
