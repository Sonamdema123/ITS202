public class Binary{
	public int search(int []a, int target, int lo,int hi)
	{
		if(hi>=lo)
		{
			int mid = (lo+hi)/2;
			if(target==a[mid])
			{
				return mid;
			}
			else if(target<a[mid]){
				return search(a,target,lo,mid-1);
			}
			else{
				return search(a,target,mid+1,hi);
			}
		}
		return -1;
	}
	public void sort(int []a)
	{
		int n=a.length;
		System.out.println("The sorted array are: ");
		for(int i=0; i<=n-1;i++)
		{
			int smallest=i;
			for(int j=i+1; j<n; j++)
			{
				if(a[j]<a[smallest])
				{
					smallest = j;
				}	
			}
			int temp=a[smallest];
			a[smallest] = a[i];
			a[i]=temp;
			
			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args) 
	{
		Binary obj = new Binary();
		int a[]={2,9,3,4,0,1};
		obj.sort(a);
		int x = obj.search(a, 9,0,5);
		if(x == -1)
		{
			System.out.println("The element is not found");
		}
		System.out.println("\nThe targeted value is in index: "+x);
	}
}