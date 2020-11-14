import java.util.Scanner;
public class InsertionSort
{
	 
	public static void Sort(int arr[])
	{ 
		for (int i = 1;i < arr.length; i++) 
		{ 
	 
			for (int j=i-1; j >=0 && arr[j+1]<arr[j]; j--)
			{ 

				int temp=arr[j+1];
				arr[j+1]=arr[j];
				arr[j]=temp;
	 		} 
	 	} 
	}
	public static void printarray(int arr[])
	{
		for(int i=0; i < arr.length; i++)
		{
	 
			System.out.print(arr[i]+" ");
		}
	 
	}
	public static void main(String[] args) 
	{
		Scanner cin = new Scanner(System.in);
		System.out.println("Enter number of elements in the array:");
		int n = cin.nextInt();

		int arr[] = new int[n];

		System.out.println("Enter "+n+" elements:");

		for( int i=0; i < n; i++)
		{
		 
			arr[i] = cin.nextInt();
		}
		 
		System.out.println( "Elements before sorting:");
		printarray(arr);
		Sort(arr);
		System.out.println( "\nElements after sorting:");
		printarray(arr);
	 
	}
 
 
}