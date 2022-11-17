package Stack_program;
import java.util.*;
public class Problem_6 {
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
	Node stack=null;
	Node min_stack=null;
	int list[]={18,19,29,15,18};
	public void push_stack(int data)
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
	public void push_minStack(int data)
	{
		Node new_node=new Node(data);
		if(min_stack==null)
		{
			new_node.next=null;
			min_stack=new_node;
		}
		else
		{
			new_node.next=min_stack;
			min_stack=new_node;
		}
	}
	public int pop_stack()
	{
		int data=stack.data;
		stack=stack.next;
		return data;
	}
	public void pop_minStack()
	{
		min_stack=min_stack.next;
	}
	public void getMinimum()
	{
		for(int i=0;i<list.length;i++)
		{
			push_stack(list[i]);
			if(min_stack==null || min_stack.data>list[i])
			{
				push_minStack(list[i]);
			}
		}
		for(int i=0;i<list.length;i++)
		{
			int data=pop_stack();
			if(data==min_stack.data)
			{
				pop_minStack();
				break;
			}
		}
		System.out.print("Main Stack ");
		while(stack!=null)
		{
			System.out.print(stack.data+" ");
			stack=stack.next;
		}
		System.out.print("\nMin Stack ");
		while(min_stack!=null)
		{
			System.out.print(min_stack.data);
			min_stack=min_stack.next;
		}
	}
	public static void main(String args[])
	{
		Problem_6 p6=new Problem_6();
		p6.getMinimum();
	}
}
