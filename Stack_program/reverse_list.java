package Stack_program;
import java.util.*;
public class reverse_list {
	static class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;
			this.next=null;
		}
	}
	Node head=null;
	Scanner sc=new Scanner(System.in);
	public void push(int data)
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
	public int pop()
	{
		int data=head.data;
		head=head.next;
		return data;
	}
	public void reverse()
	{
		int list[]=new int[5];
		int temp;
		for(int i=0;i<5;i++)
		{
			System.out.print("Enter Number "+(i+1) +" ");
			list[i]=sc.nextInt();
			push(list[i]);
		}
		System.out.print("With Out Reverse \n");
		for(int i=0;i<5;i++)
		{
			System.out.print(list[i]+" ");
			temp=pop();
			list[i]=temp;
		}
		System.out.print("\nWith Reverse \n");
		for(int i=0;i<5;i++)
		{
			System.out.print(list[i]+" ");
		}
	}
	public static void main(String args[])
	{
		reverse_list rl=new reverse_list();
		rl.reverse();
	}
}
