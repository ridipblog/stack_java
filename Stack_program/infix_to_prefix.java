package Stack_program;
import java.util.*;
public class infix_to_prefix extends infix_to_postfix {
	Node prefix=null;
	Scanner sc=new Scanner(System.in);
	public String reverseInfix(String infix)
	{
		char infix_exp[]=infix.toCharArray();
		char r_infix[]=new char[infix.length()];
		int j=0;
		for(int i=infix.length()-1;i>=0;i--)
		{
			if(infix_exp[i]==')')
			{
				infix_exp[i]='(';
			}
			else if(infix_exp[i]=='(')
			{
				infix_exp[i]=')';
			}
			r_infix[j]=infix_exp[i];
			j++;
		}
		String exp = String.valueOf(r_infix);
		return exp; 
	}
	public char popEPostfix()
	{
		char data;
		data=EPostfix.data;
		EPostfix=EPostfix.next;
		return data;
	}
	public void toPostfix(String infix)
	{
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
			Node new_node=new Node(popEPostfix());
			if(prefix==null)
			{
				new_node.next=null;
				prefix=new_node;
			}
			else
			{
				new_node.next=prefix;
				prefix=new_node;
			}
		}
	}
	public void resultPrefix()
	{
		while(prefix!=null)
		{
			System.out.print(prefix.data);
			prefix=prefix.next;
		}
	}
	public void toPrefix()
	{
		String infix,r_infix;
		System.out.print("Enter Infix Expression ");
		infix=sc.nextLine();
		r_infix=reverseInfix(infix);
		toPostfix(r_infix);
		resultPrefix();
	}
	public static void main(String args[])
	{
		infix_to_prefix itpre=new infix_to_prefix();
		itpre.toPrefix();
	}
}
