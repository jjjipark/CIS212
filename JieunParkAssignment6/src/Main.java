import java.util.HashSet;
import java.util.Set;

public class Main
{
	public static void main(String[] array)
	{
		OccurrenceSet<Integer> intset = new OccurrenceSet<Integer>();
		System.out.println("INTEGER");
		intset.add(1);
		intset.add(3);
		intset.add(3);
		intset.add(5);
		intset.add(3);
		System.out.println(intset);
		System.out.println(intset.isEmpty());

		Set<Integer> test1 = new HashSet<Integer>();
		test1.add(0);
		test1.add(2);
		Set<Integer> test2 = new HashSet<Integer>();
		test2.add(4);
		test2.add(7);
		intset.addAll(test1);
		System.out.println(intset);
		intset.addAll(test2);
		System.out.println(intset);

		intset.remove(1);
		System.out.println(intset);
		intset.removeAll(test2);
		System.out.println(intset);

		// contains
		System.out.println(intset.contains(new Integer(1)));
		System.out.println(intset.contains(new Integer(5)));
		System.out.println(intset.containsAll(test1));
		System.out.println(intset.containsAll(test2));
		//// retainsAll
		System.out.println(intset);
		System.out.println(intset.retainAll(test1));
		System.out.println(intset.retainAll(test2));

		intset.clear();
		System.out.println(intset);
		System.out.println(intset.isEmpty());
		System.out.println("Done with Integer");

		System.out.println("STRING");
		System.out.println("------------------------");
		OccurrenceSet<String> strset = new OccurrenceSet<String>();
		strset.add("hello");
		strset.add("hello");
		strset.add("world");
		strset.add("here");
		System.out.println(strset);

		System.out.println(strset.isEmpty());
		/// addAll
		Set<String> test3 = new HashSet<String>();
		test3.add("CIS");
		test3.add("212");
		Set<String> test4 = new HashSet<String>();
		test4.add("Java");
		strset.addAll(test3);
		System.out.println(strset);
		strset.addAll(test4);
		System.out.println(strset);

		// remove
		strset.remove("hello");
		System.out.println(strset);
		strset.removeAll(test3);
		System.out.println(strset);

		// contain
		System.out.println(strset.contains(new String("here")));
		System.out.println(strset.containsAll(test4));

		// Empty and clear
		strset.clear();
		System.out.println(strset);
		System.out.println(strset.isEmpty());
	}
}