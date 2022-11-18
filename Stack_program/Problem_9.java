package Stack_program;
import java.util.*;
public class Problem_9 {
	static class Node
	{
		char data;
		Node next;
		Node(char data)
		{
			this.data=data;
			this.next=null;
		}
	}
	String name;
	int index=0;
	Node stack=null;
	Scanner sc=new Scanner(System.in);
	public void push(char data)
	{
		Node new_node=new Node(data);
		if(stack==null)
		{
			new_node.next=null;
			stack=new_node;
		}
		else
		{
			new_node.next=stack;
			stack=new_node;
		}
	}
	public void pop()
	{
		stack=stack.next;
	}
	public void insertStack(char ch[])
	{
		while(index<name.length()/2)
		{
			push(ch[index]);
			index++;
		}
		index++;
	}
	public void isPalindrome()
	{
		System.out.print("Enter String ");
		name=sc.nextLine();
		char ch[]=name.toCharArray();
		insertStack(ch);
		while(stack!=null && ch[index]==stack.data)
		{
			pop();
			index++;
		}
		if(stack!=null)
		{
			System.out.print("String Not Palindrome ");
		}
		else
		{
			System.out.print("String Is Palindrome ");
		}
	}
	public static void main(String args[])
	{
		Problem_9 p9=new Problem_9();
		p9.isPalindrome();
	}
}
