package Stack_program;

public class problem_11 {
	int stack[]=new int[5];
	int top=-1;
	public void push(int data)
	{
		top++;
		stack[top]=data;
	}
	public void pop()
	{
		top--;
	}
	public void insertAtBottom(int data)
	{
		if(top==-1)
		{
			push(data);
		}
		else
		{
			int temp=stack[top];
			pop();
			insertAtBottom(data);
			push(temp);
		}
	}
	public void reverseStack()
	{
		if(top!=-1)
		{
			int temp=stack[top];
			pop();
			reverseStack();
			insertAtBottom(temp);
		}
	}
	public static void main(String args[])
	{
		problem_11 p11=new problem_11();
		for(int i=0;i<5;i++)
		{
			p11.push(10+i);
		}
		p11.reverseStack();
		while(p11.top!=-1)
		{
			System.out.print(p11.stack[p11.top]+" ");
			p11.pop();
		}
	}
}
