package algo.trees.TrinaryTree;

public class StringOperation {
	
	public long StringToLong(String s)
	{	
		long value = -1; //default return value
		//if string can be convert then return the value else print exception message and return default value
		if(s.matches("(-)*[0-9]+(l)*"))
		{
			try
			{
				value = Long.parseLong(s); 
			}
			catch(NumberFormatException ex)
			{
				System.out.println("The input string " + s +" can not be parsed in long data type.");
				ex.printStackTrace();
			}
		}
		return value;
	}
	
	public static void main(String args[])
	{
		long defaultOutput= -1;
		StringOperation sl = new StringOperation();
		//Invalid test cases
		System.out.println(defaultOutput == sl.StringToLong("a")? "Failure":"Success" );
		System.out.println(defaultOutput == sl.StringToLong("a12")? "Failure":"Success" );
		System.out.println(defaultOutput == sl.StringToLong("1.21")? "Failure":"Success" );
		System.out.println(0 == sl.StringToLong("0")? "Success":"Failure" );
		System.out.println(-1 == sl.StringToLong("-1")? "Success":"Failure" );
		
		//Valid test cases 
		System.out.println(123450 == sl.StringToLong("123450")? "Success":"Failure" );
		System.out.println(-12345 == sl.StringToLong("-12345")? "Sucesss":"Failure" );
		
		// Boundary test cases
		System.out.println(9223372036854775807l == sl.StringToLong("9223372036854775807")? "Success" :"Failure" );
		System.out.println(defaultOutput == sl.StringToLong("9223372036854775808")? "Failure":"Success" );
		
		System.out.println(-9223372036854775808l == sl.StringToLong("-9223372036854775808")? "Success" :"Failure");
		System.out.println(defaultOutput == sl.StringToLong("-9223372036854775809")? "Failure":"Success" );
	}
}
