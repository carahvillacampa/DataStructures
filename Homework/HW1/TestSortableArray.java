package homework1;

public class TestSortableArray {
	public static void main(String[ ] args) {
		String course = "csc 300 spring 2019";
		String[ ] terms = course.split(" ");
		SortableArray<String> items = new SortableArray<String>(4);
		for (String term : terms)
			items.add(term);
		items.remove();
		items.add("quarter");
		System.out.println("Before sorting:");
		for (String term : items)
			System.out.print(term + " ");
		items.sort();
		System.out.println("\nAfter sorting:");
		for (String term : items) //can't use this unless you use the iterable interface
			System.out.print(term + " ");
		System.out.println();
	}
}
