public class QueueLinkedList{

	Node front;
	Node tail;
	int size;

	public QueueLinkedList(){
		front = null;
		tail = null;
		size  = 0;
	}
	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

	public void enqueue(int n){
		Node newest = new Node (n,null);
		if (size == 0){
			front = newest;
			tail = newest;
			System.out.println("The enqueue element is: "+n);
		}
		else{
			tail.setNext(newest);
			tail = newest;
			System.out.println("The enqueue element is: "+n);
		}
		size++;
	}
	public int dequeue(){
		int removeele = front.getElement();
		if(isEmpty()){
			return 1;
		}
		else{
			front = front.getNext();
			size--;
			System.out.println("The dequeue element is: "+removeele);
		}
		return removeele;
	}
	public int first(){
		int firstele = front.getElement();
		if (size == 0){
			System.out.println("QueueUnderFlow");
		}
		else{
			return firstele;
		}
		return first();
	}
	public int len(){
		if(isEmpty()){
			return 1;
		}
		return size;

	}
}
class Node{
	//declare variable
	private int element;
	private Node next;

	public Node(int element,Node next){
		this.element = element;
		this.next = next;
	}
	//getElement
	public int getElement(){
		return element;
	}
	//getNext
	public Node getNext(){
		return next;
	}
	//setElement
	public void setElement(int ele){
		element = ele;
	}
	//setNext
	public void setNext(Node ele){
		next = ele;
	}
}
