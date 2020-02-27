package algo.sorting;

/* Have a list of people info <name, age> pairs, output a list of names sorted by their age ascending.
 * 
 * class Person {
 * public String name;
 * public int age;
 *
 * example:
 * input: [<"Gina", 12>,<"Chris", 10>,<"Tom", 2>]
 * output: ["Tom","Chris","Gina”] 
 * 
 * String[] sortPeople (Person[] people)
 * {
 * }
 * 
 * 
 */

public class SortingOfObjects 
{
	public String[] sortingObjects(Person[] persons)
	{
		String [] names= new String[persons.length];
		mergeSort( persons, 0, persons.length-1);
		
		for(int i=0; i<persons.length; i++ )
		{	
			names[i]= persons[i].name;
			System.out.println(names[i]);
		}
	  
	   return names;
	}

	private void mergeSort( Person[] persons, int low, int high)
	 {
		 if (low<high)
		 {
			 int middle = (low+high)/2;
			 mergeSort(persons, low, middle);
			 mergeSort(persons, middle+1, high);
			 merge(persons, low, middle, high);
		 }
	 }

	private void merge(Person[] persons, int low, int middle, int high) 
	{
		Person[] helper= new Person[persons.length];
		
		for(int i=0; i<persons.length; i++ )
		{
			helper[i]= persons[i];
		}
		int i = low;
		int j = middle+1;
		int k = low;
		
		while(i<=middle && j<=high)
		{
			if(helper[i].compareTo(helper[j])<=0)
			{
				persons[k]=helper[i];	
				i++;
			}
			else
			{
				persons[k]=helper[j];
				j++;
			}
			k++;
		}
		//copy the rest of the left side of the array into target array
		while(i<=middle){
			persons[k]=helper[i];
			i++;
			k++;
		}
	}
	
	
	public static void main(String[] args)
	{
		Person[] persons = new Person[]{ new Person("Gina", 18),new Person("Amita", 10),  new Person("Tina", 15)};
		SortingOfObjects so= new SortingOfObjects();
		so.sortingObjects(persons);
	}
}

class Person implements Comparable<Person>
{
	public String name;
	public int age;
	
	Person(String name, int age)
	{
		this.name= name;
		this.age= age;
	}
	@Override
	public int compareTo(Person other) 
	{
		if (this.age< other.age)
	      return -1;
	    else if (this.age == other.age)
	      return 0;
	    else 
	      return 1;
	}
}
