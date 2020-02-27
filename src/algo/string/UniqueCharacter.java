package algo.string;

public class UniqueCharacter {

	private boolean isUniqueString(String input){
		
		boolean flag = true;
		char[] cInput= input.toCharArray();
		int j=0;
		for ( int i =0;i<cInput.length; i++){
			j=i+1;
			while( j<cInput.length){
				if(cInput[i]==cInput[j]){
					flag= false;
					return flag;
				}
				j++;
			}
		}
		return flag;
	}
	
	private boolean isSameString(String input1, String input2){
		
		boolean flag = false;
		
		if( input1.equals(input2)){
			flag=true;
			
		}else{
			flag=false;
		}
		return flag;
	}
	
	private boolean isEqualString(String input1, String input2){
		
		boolean flag = false;
		
		if( input1==input2){
			flag=true;
			
		}else{
			flag=false;
		}
		return flag;
	}
	
	private void  testEquals(){
		 String str1 = "Hello world.";
		    String str2 = "Hello world.";

		    if (str1 == str2)
		        System.out.print("str1 == str2\n");
		    else
		        System.out.print("str1 != str2\n");

		    if(str1.equals(str2))
		        System.out.print("str1 equals to str2\n");
		    else
		        System.out.print("str1 doesn't equal to str2\n");

		    String str3 = new String("Hello world.");
		    String str4 = new String("Hello world.");

		    if (str3 == str4)
		        System.out.print("str3 == str4\n");
		    else
		        System.out.print("str3 != str4\n");

		    if(str3.equals(str4))
		        System.out.print("str3 equals to str4\n");
		    else
		        System.out.print("str3 doesn't equal to str4\n");
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UniqueCharacter uc= new UniqueCharacter();
		System.out.println("Input as amita :"+uc.isUniqueString("amita"));
		System.out.println("Input as Amita :"+uc.isUniqueString("Amita"));
		
		System.out.println("Input as amita Amita :"+uc.isSameString("amita","Amita"));
		System.out.println("Input as amita amita :"+uc.isSameString("amita","amita"));

		System.out.println("Input as amita =Amita :"+uc.isEqualString("amita","Amita"));
		System.out.println("Input as amita= amita :"+uc.isEqualString("amita","amita"));
		
		uc.testEquals();
	
	}
	

}
