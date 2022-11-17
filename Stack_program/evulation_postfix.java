package Stack_program;
import java.util.*;
public class evulation_postfix {
	static class Node
	{
		float data;
		Node next;
		Node(float data)
		{
			this.data=data;
			this.next=null;
		}
	}
	Node head=null;
	Scanner sc=new Scanner(System.in);
	public void push(float data)
	{
		Node new_node=new Node(data);
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
	public float pop()
	{
		float data=head.data;
		head=head.next;
		return data;
	}
	public float operation(float a,float b,char operand)
	{
		float result=0;
		if(operand=='+')
		{
			result=a+b;
		}
		else if(operand=='-')
		{
			result=a-b;
		}
		else if(operand=='/')
		{
			result=a/b;
		}
		else if(operand=='*')
		{
			result=a*b;
		}
		return result;
	}
	public void e_postfix()
	{
		String postfix;
		System.out.print("Enter Postfix Expression ");
		postfix=sc.nextLine();
		char exp[]=postfix.toCharArray();
		for(int i=0;i<postfix.length();i++)
		{
			if(Character.isDigit(exp[i]))
			{
				push(exp[i]-'0');
			}
			else
			{
				float data_1=pop();
				float data_2=pop();
				float result=operation(data_2,data_1,exp[i]);
				push(result);
			}
		}
		while(head!=null)
		{
			System.out.printf("%.0f",pop());
		}
	}
	public static void main(String args[])
	{
		evulation_postfix ep=new evulation_postfix();
		ep.e_postfix();
	}
}
