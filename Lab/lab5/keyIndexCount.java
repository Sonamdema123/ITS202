public class keyIndexCount{
	
	public void key(int a[])

	{
		int N = a.length;

		int R = 256;

		int [] aux = new int [N];

		int [] count = new int [R+1];

		//compute frequency counts
		for (int i = 0; i < N; i++)
		{
			count [a[i]+1]++;
		}

		//Transform counts to indices
		for (int r = 0; r < R; r++)
		{
			count[r+1]+= count[r];
		}	
		//Distribute the records
		for (int i = 0; i < N; i++)
		{
			aux[count[a[i]]++] = a[i];
		}
		//copy back
		for (int i = 0; i < N; i++)
		{
			a[i] = aux[i];
		}
		for (int i = 0; i<N;i++)
		{
			System.out.print(" "+a[i]);
		}
	}

	public static void main(String [] args)
	{
		keyIndexCount obj = new keyIndexCount();
		
		int a[] ={0,1,2,1,4,3};

		obj.key(a);

	}

}
