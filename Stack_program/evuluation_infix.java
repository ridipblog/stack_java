package Stack_program;
import java.awt.Window.Type;
import java.util.*;
public class evuluation_infix {
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
	static class Node_1
	{
		String data;
		Node_1 next;
		Node_1(String data)
		{
			this.data=data;
			this.next=null;
		}
	}
	Node_1 operand=null;
	Node operator=null;
	Scanner sc=new Scanner(System.in);
	public void push_operand(String data)
	{
		Node_1 new_node=new Node_1(data);
		if(operand==null)
		{
			new_node.next=null;
			operand=new_node;
		}
		else
		{
			new_node.next=operand;
			operand=new_node;
		}
	}
	public void push_operator(char data)
	{
		Node new_node=new Node(data);
		if(operator==null)
		{
			new_node.next=null;
			operator=new_node;
		}
		else
		{
			new_node.next=operator;
			operator=new_node;
		}
	}
	public String pop_operand()
	{
		String data=operand.data;
		operand=operand.next;
		return data;
	}
	public char pop_operator()
	{
		char op=operator.data;
		operator=operator.next;
		return op;
	}
	public String operation(float a,float b,char op)
	{
		float result=0;
		if(op=='+')
		{
			result=a+b;
		}
		else if(op=='-')
		{
			result=a-b;
		}
		else if(op=='/')
		{
			result=a/b;
		}
		else if(op=='*')
		{
			result=a*b;
		}
		String data=String.valueOf(result);
		return data;
	}
	public int getPri(char data)
	{
		int value=0;
		if(data=='+' || data=='-')
		{
			value=1;
		}
		else if(data=='/' || data=='*')
		{
			value=2;
		}
		else
		{
			value=0;
		}
		return value;
	}
	public void final_operation()
	{
		char op=pop_operator();
		String a=pop_operand();
		String b=pop_operand();
		float data_1=Float.valueOf(a);
		float data_2=Float.valueOf(b);
		push_operand(operation(data_2,data_1,op));
	}
	public void e_infix()
	{
		String infix;
		System.out.print("Enter Infix Expression ");
		infix=sc.nextLine();
		char exp[]=infix.toCharArray();
		for(int i=0;i<infix.length();i++)
		{
			if(Character.isDigit(exp[i]))
			{
				push_operand(String.valueOf(exp[i]));
			}
			else
			{
				if(operator==null)
				{
					push_operator(exp[i]);
				}
				else
				{
					if(exp[i]=='(')
					{
						push_operator(exp[i]);
					}
					else
					{
						if(exp[i]==')')
						{
							while(operator.data!='(')
							{
								final_operation();
							}
							char temp=pop_operator();
						}
						else
						{
							if(getPri(exp[i])>getPri(operator.data))
							{
								push_operator(exp[i]);
							}
							else
							{
								while(getPri(exp[i])<=getPri(operator.data))
								{
									final_operation();
									if(operator==null)
									{
										break;
									}
								}
								push_operator(exp[i]);
							}
						}
					}
				}
			}
		}
		while(operator!=null)
		{
			final_operation();
		}
		System.out.printf("%.0f",Float.valueOf(operand.data));
	}
	public static void main(String args[])
	{
		evuluation_infix ei=new evuluation_infix();
		ei.e_infix();
	}
}
