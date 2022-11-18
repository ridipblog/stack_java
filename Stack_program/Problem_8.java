package Stack_program;
import java.util.*;
public class Problem_8 {
	Scanner sc=new Scanner(System.in);
	public void isPalindrome()
	{
		String name;
		System.out.print("Enter String ");
		name=sc.nextLine();
		char ch[]=name.toCharArray();
		int i=0,j=name.length()-1;
		while(i<j && ch[i]==ch[j])
		{
			i++;
			j--;
		}
		if(i<j)
		{
			System.out.print("String Is Not PalinDrome");
		}
		else
		{
			System.out.print("String Is Palindrome");
		}
	}
	public static void main(String args[])
	{
		Problem_8 p8=new Problem_8();
		p8.isPalindrome();
	}
}
