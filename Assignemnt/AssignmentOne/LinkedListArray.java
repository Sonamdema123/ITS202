
public class LinkedListArray{

	int size;
	int count = 0;
	double full_1over4;//
	double full_3over4;//
	int array [];
	
	//constructor
	public LinkedListArray(int length){
		size = length;
		array =  new int [size];
		full_1over4 = 0.25;//
		full_3over4 =  0.75;//
	}
	//adding element in the array
	public void add(int ele)
	{
		array[count] = ele;
		count+=1;
	}
	//remove the last element in the array
	public void pop()
	{
		if (count > 0){
			array[count-1] = 0;
			count-=1;
		}
	}
	//resize the size of array to double when the array is 3/4th full and half in size when array is 1/4th full.
	public void resize()
	{
		if (count == full_1over4){
			
			int[] temp = new int [size/2];

			for (int i = 0;i<count;i++){
				temp[i]=array[i];
			}
			size = size/2;
			array = temp;
		}
		if (count == full_3over4){

			int [] temp = new int[size*2];

			for (int i=0;i<count;i++){
				temp[i] = array[i];
			}
			size = size*2;
			array = temp;
		}

	}
	public int size(){
		return size;
	}
	
	public int check()
	{
		return count;
	}
	public String toString()
	{
		String s=Integer.toString(size);
		return s;
	} 

	public static void main(String[] args){
		int initial =10;

		LinkedListArray o = new LinkedListArray(10);

		o.add(1);
		o.add(2);
		o.add(3);
		o.add(4);
		o.check();
		o.resize();
		//element in the array before changing.
		System.out.print("List of an element in array: ");

		for (int i = 0; i < o.size; i++){
			System.out.print(o.array[i]+ " ");
		}
		//size of element before removing the element
		System.out.println("\nSize of the array is: "+o.size);
		System.out.println("Number of element in array is: "+o.count);
		//remove the element of the array
		o.pop();
		//element in the array after removing 
		System.out.print("\nList of an element in array after pop: ");

		for (int i = 0; i <o.size; i++){
			System.out.print(o.array[i]+" ");
		}
		//size of element after removing the element.
		System.out.println("\nSize of the array after is: "+o.size);
		System.out.println("Number of element in array after is: "+o.count);

		//size of element after changing
		System.out.print("\nList of element in array after: ");

		if (o.size!=initial){
			for (int i = 0; i < o.size; i++){
				System.out.print(o.array[i] + " ");
			}
			System.out.println("\nSize of the array has changed as array is full by 1/4 or 3/4 is "+o.size);
		}
		else{
			for (int i = 0; i < o.size; i++){
				
				System.out.print(o.array[i]+" ");
			}
			System.out.println("\nSize of array remain same as that is "+ o.size);
		}
		System.out.println("Number of element in array after is "+o.count);
		System.out.println("toString " +o.toString());


		assert(o.size() == 10);
	
		System.out.println("All test are passed");

	}

}