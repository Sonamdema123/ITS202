public class StackArray
{
	int array[];
	int top;
	int size;//1//2//1

	public StackArray(int n)
	{
		array = new int[n];
		top = -1;//-2//-1
		size = 0;
	}
	public int size()
	{
		return size;
	}
	public boolean isEmpty()
	{
		if(size()==0)
		{
			return true;
		}
		return false;
	}
	public void push(int n)
	{
		if(isEmpty())
		{
			array[0]=n;
			top = 0;
		}
		else
		{
			array[top+1] =n;
		}
		top++;
		size++;

	}
	public int top()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			return array[top];
		}
	}
	public int pop()
	{
		if(isEmpty())
		{
			return 0;
		}
		else
		{
			top = top -1;
			size=size-1;
			return array[top+1];
		}
	}
	public static void main(String[] args) {
		StackArray o = new StackArray(10);
		o.push(1);
		o.push(2);
		o.push(3);

		System.out.println("Top of the element: "+o.top());
		System.out.println("The pop element is : "+o.pop());
		System.out.println("Element size in the stack: "+o.size());
		System.out.println("The stack is empty: "+o.isEmpty());

		assert(o.top()==2);
		assert(o.size()==2);
		assert(o.isEmpty()==false);
		System.out.println("All test are passed.");
	}
}