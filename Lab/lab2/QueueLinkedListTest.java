public class QueueLinkedListTest{
	public static void main(String[] args){

		QueueLinkedList o = new QueueLinkedList();

		o.enqueue(2);
		o.enqueue(4);
		o.enqueue(6);
		o.enqueue(8);

		System.out.println("The deleted element is: "+o.dequeue());
		System.out.println("The first element is: " +o.first());
		System.out.println("The queue isEmpty: " +o.isEmpty());
		System.out.println("The length of a queue elements is : " + o.len());

		
		assert(o.isEmpty() == false);
		assert(o.first() == 4);
		assert(o.len() == 3);
		System.out.println("All the test are passed");
	}
}
