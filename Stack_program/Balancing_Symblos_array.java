package Stack_program;

import java.util.*;

public class Balancing_Symblos_array {
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
	Node head=null;
	Scanner sc=new Scanner(System.in);
	public void push(char c)
	{
		Node new_node=new Node(c);
		if(head==null)
		{
			new_node.next=null;
			head=new_node;
		}
		else
		{
			new_node.next=head;
			head=new_node;
		}
	}
	public char pop()
	{
		char c;
		c=head.data;
		head=head.next;
		return c;
	}
	public boolean check_parentheses()
	{
		String parentheses;
		char temp;
		int flag=1;
		System.out.print("Enter Parentheses ");
		parentheses=sc.nextLine();
		char exp[]=parentheses.toCharArray();
		for(int i=0;i<parentheses.length();i++)
		{
			if(exp[i]=='(' || exp[i]=='{')
			{
				push(exp[i]);
			}
			if(exp[i]==')' || exp[i]=='}')
			{
				if(head==null)
				{
					flag=0;
					break;
				}
				else
				{
					temp=pop();
					if(temp=='{' && exp[i]==')')
					{
						flag=0;
					}
					if(temp=='(' && exp[i]=='}')
					{
						flag=0;
					}
				}
			}
		}
		if(head!=null)
		{
			flag=0;
		}
		if(flag==0)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public static void main(String args[])
	{
		Balancing_Symblos_array bsa=new Balancing_Symblos_array();
		boolean check=bsa.check_parentheses();
		if(check==true)
		{
			System.out.print("Parentheses Is Valid ");
		}
		else
		{
			System.out.print("Parenthses Is Not Valid ");
		}
	}
}
