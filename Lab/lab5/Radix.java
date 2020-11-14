public class Radix
{
	public static void sort(String [] a ,int w)
	{
		int N = a.length;
		int R = 256;
		String[] aux = new String[N];

		for (int d = w-1; d >= 0;d--)
		{
			//Sort by key-indexed counting on dth char
			int [] count = new int [R+1];
			//compute frequency counts.
			for (int i = 0; i < N; i++)
			{
				count [a[i].charAt(d)+1]++;

			}
			
			for (int r = 0; r < R; r++)
			{
				//Tranform counts to indices
				count[r+1] += count[r];
			}
			
			for(int i = 0; i < N; i++)
			{
				//Distribute
				aux[count[a[i].charAt(d)]++] = a[i];
			}
			
			for (int i = 0; i < N; i++)
			{
				//copy back
				a[i] = aux[i];
			}
		
		}
		System.out.println("Array after sorting:");
		for (int i = 0; i<a.length;i++)
		{
			System.out.println(a[i]+" ");
		}

	}
	
	public static void main(String[] args)
	{
		Radix obj = new Radix();
		String a[] = {"sonam","karma","jigmi","jonny","sampa"};
		obj.sort(a,5);

	}
}