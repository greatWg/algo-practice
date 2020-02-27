package algo.string;

public class StringMethods {
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String Text= "Astrtology Physics";
		String Pattern="rto";
		StringMethods stringMethods= new StringMethods();
		
		stringMethods.TestStringMatches(Text, Pattern);
		stringMethods.TestStringContainCharSequence(Text, Pattern);
		stringMethods.TestStringContentEqualsCharSequence(Text, Pattern);
		stringMethods.TestStringIndexOfString(Text, Pattern);
		
		Pattern ="Ast";
		stringMethods.TestStringStartsWithPrefix(Text, Pattern);
		Pattern="sics";
		stringMethods.TestStringEndsWithSuffix(Text, Pattern);
	}
	
	public void TestStringMatches(String Text, String Pattern)
	{
		System.out.println("String Matches: " + Text.matches(Pattern));
	}
	
	public void TestStringContainCharSequence( String Text, String Pattern)
	{
		System.out.println("Contain charSequence: " + Text.contains(Pattern));
	}
	
	public void TestStringContentEqualsCharSequence(String Text, String Pattern)
	{
		System.out.println("Equal charSequence: " + Text.contentEquals(Pattern));
	}

	public void TestStringStartsWithPrefix(String Text, String Pattern)
	{
		System.out.println("StartsWith Prefix: " + Text.startsWith(Pattern));
	}
	
	public void TestStringEndsWithSuffix(String Text, String Pattern)
	{
		System.out.println("EndsWith suffix: " + Text.endsWith(Pattern));
	}
	
	public void TestStringIndexOfString(String Text, String Pattern)
	{
		System.out.println("Index of String: " + Text.indexOf(Pattern));
	}
}
