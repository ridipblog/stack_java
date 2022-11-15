package Stack_linked;

import java.util.Scanner;

public class Stack_linked {
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=next;
		}
	}
	Node head=null;
	Scanner sc=new Scanner(System.in);
	public void push()
	{
		int data;
		while(true)
		{
			System.out.print("Enter Data or 0 Exit ");
			data=sc.nextInt();
			if(data==0)
			{
				break;
			}
			else
			{
				Node new_node=new Node(data);
				if(head==null)
				{
					head=new_node;
					head.next=null;
				}
				else
				{
					new_node.next=head;
					head=new_node;
				}
			}
		}
	}
	public void pop()
	{
		if(head==null)
		{
			System.out.print("Stack Underflow ");
		}
		else
		{
			System.out.print("Deleted Item "+head.data);
			head=head.next;
		}
	}
	public void peek()
	{
		int index,i=0;
		if(head==null)
		{
			System.out.print("Stack Underflow ");
		}
		else
		{
			while(true)
			{
				System.out.print("\nEnter Index or 0 Exit ");
				index=sc.nextInt();
				if(index==0)
				{
					break;
				}
				else
				{
					Node temp=head;
					i=0;
					while(i!=index-1)
					{
						temp=temp.next;
						i++;
					}
					System.out.print("Item "+temp.data);
				}
			}
		}
	}
	public void display()
	{
		if(head==null)
		{
			System.out.print("Stack Underflow");
		}
		else
		{
			Node temp=head;
			while(temp!=null)
			{
				System.out.print(temp.data+" ");
				temp=temp.next;
			}
		}
	}
	public static void main(String args[])
	{
		Stack_linked sl=new Stack_linked();
		Scanner sc=new Scanner(System.in);
		int c;
		while(true)
		{
			System.out.print("\n1 For push \n");
			System.out.print("2 For Pop \n");
			System.out.print("3 For Peek \n");
			System.out.print("4 For Display ");
			c=sc.nextInt();
			if(c==1)
			{
				sl.push();
			}
			else if(c==2)
			{
				sl.pop();
			}
			else if(c==3)
			{
				sl.peek();
			}
			else if(c==4)
			{
				sl.display();
			}
			else
			{
				break;
			}
		}
	}
}
