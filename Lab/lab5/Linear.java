public class Linear{
	public void Search(int array[]){
		int N = array.length;
		int search = 3;
		for(int i = 0; i < N; i++){
			if(array[i]==search){
				System.out.println("The search value "+ search + " is in index "+i);
				return ;
			}
			else{
				System.out.println("The target value is not found in the array");
			}
		}
	}
	public static void main(String [] args){
		Linear obj = new Linear();
		int array[] = {1,2,3,4,5,6};
		obj.Search(array);

	}
}