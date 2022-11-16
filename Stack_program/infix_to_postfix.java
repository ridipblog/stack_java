package Stack_program;
import java.util.*;
public class infix_to_postfix {
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
	Node postfix=null;
	Node EPostfix=null;
	Scanner sc=new Scanner(System.in);
	public void pushPostfix(char c)
	{
		Node new_node=new Node(c);
		if(postfix==null)
		{
			new_node.next=null;
			postfix=new_node;
		}
		else
		{
			new_node.next=postfix;
			postfix=new_node;
		}
	}
	public char popPostfix()
	{
		char data;
		data=postfix.data;
		postfix=postfix.next;
		return data;
	}
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
		char data;
		data=head.data;
		head=head.next;
		return data;
	}
	public int getPri(char data)
	{
		if(data=='/' || data=='*')
		{
			return 2;
		}
		else if(data=='+' || data=='-')
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	public void toPostfix()
	{
		String infix;
		System.out.print("Enter Infix Express ");
		infix=sc.nextLine();
		char exp[]=infix.toCharArray();
		for(int i=0;i<infix.length();i++)
		{
			if(exp[i]=='/' || exp[i]=='*' || exp[i]=='+' || exp[i]=='-' || exp[i]=='(' || exp[i]==')')
			{
				if(head==null)
				{
					push(exp[i]);
				}
				else
				{
					if(exp[i]=='(')
					{
						push(exp[i]);
					}
					else
					{
						if(exp[i]==')')
						{
							while(head.data!='(')
							{
								pushPostfix(pop());
							}
							char temp=pop();
						}
						else
						{
							if(getPri(exp[i])>getPri(head.data))
							{
								push(exp[i]);
							}
							else
							{
								while(getPri(exp[i])<=getPri(head.data))
								{
									pushPostfix(pop());
									if(head==null)
									{
										break;
									}
								}
								push(exp[i]);
							}
						}
					}
				}
			}
			else
			{
				pushPostfix(exp[i]);
			}
		}
		if(head!=null)
		{
			while(head!=null)
			{
				pushPostfix(pop());
			}
		}
		while(postfix!=null)
		{
			Node new_node=new Node(popPostfix());
			if(EPostfix==null)
			{
				new_node.next=null;
				EPostfix=new_node;
			}
			else
			{
				new_node.next=EPostfix;
				EPostfix=new_node;
			}
		}
		while(EPostfix!=null)
		{
			System.out.print(EPostfix.data);
			EPostfix=EPostfix.next;
		}
	}
	public static void main(String args[])
	{
		infix_to_postfix itp=new infix_to_postfix();
		itp.toPostfix();
	}
}
