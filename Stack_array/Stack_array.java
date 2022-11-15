package Stack_array;

import java.util.Scanner;

public class Stack_array {
	int top=-1;
	int n=10;
	int a[]=new int[n];
	Scanner sc=new Scanner(System.in);
	public void push()
	{
		if(top==(n-1))
		{
			System.out.print("Stack Overflow ");
		}
		else
		{
			int data,n;
			while(true)
			{
				System.out.print("Enter Data or 0 Exit ");
				data=sc.nextInt();
				if(data==0)
				{
					break;
				}
				top=top+1;
				a[top]=data;
			}
		}
	}
	public void pop()
	{
		if(top==-1)
		{
			System.out.print("Stack Underflow ");
		}
		else
		{
			System.out.print("Deleted Item "+a[top]);
			top=top-1;
		}
	}
	public void display()
	{
		for(int j=top;j>=0;j--)
		{
			System.out.print(a[j]+" ");
		}
	}
	public static void main(String args[])
	{
		Stack_array sa=new Stack_array();
		Scanner sc=new Scanner(System.in);
		int c;
		while(true)
		{
			System.out.print("\n1 For Push \n");
			System.out.print("2 For Pop \n");
			System.out.print("3 For Display ");
			c=sc.nextInt();
			if(c==1)
			{
				sa.push();
			}
			else if(c==2)
			{
				sa.pop();
			}
			else if(c==3)
			{
				sa.display();
			}
			else
			{
				break;
			}
		}
	}
}
