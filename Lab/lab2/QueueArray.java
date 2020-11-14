public class QueueArray{
	int front;
	int rear;
	int len;
	int first;
	int arr [];

	public QueueArray(int n){
		len = 0;
		rear = -1;
		front = -1;
		first = -1;
		arr = new int [n];
	}
	public int len(){
		return len;
	}
	public boolean isEmpty(){
		if (len == 0){
			return true;
		}
		return false;
	}
	
	public void enqueue(int n){
		if (isEmpty()){
			arr[0] =n;
			front = 0;
			rear = 0;
			first = arr[0];
		}
		else{
			arr[rear+1]= n;
			rear = rear+1;
		}
		len = len+1;
	}

	public int first(){
		if (isEmpty()){
			return 0;
		}
		else{
			return arr[front];
		}
	}
	public int dequeue(){
		if(isEmpty()){
			return 0;
		}
		else{

			front = front +1;
		}
		len = len -1;
		return arr[front - 1];
	

	}
	public static void main(String[] args){
		QueueArray o = new QueueArray(5);

		o.enqueue(2);
		o.enqueue(4);
		o.enqueue(6);
		o.enqueue(8);

		System.out.println("The first element is: "+o.first());
		System.out.println("The length of queueelement: "+o.len());
		System.out.println("The dequeue element is: "+o.dequeue());
		System.out.println("The queue isEmpty: "+o.isEmpty());

		assert(o.first()==4);
		assert(o.len()==3);
		assert(o.isEmpty()==false);
		System.out.println("All the test are passed.");
		


	}
}