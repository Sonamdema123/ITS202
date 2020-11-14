public class LinkedList{

	int size;
	Node head;
	Node tail;

	public LinkedList(){
		size = 0;
		head = null;
		tail = null;
	}
	//size():Returns the number of the element in the list
	public int size(){
		return size;
	}
	//isEmpty:Return true if the list is empty.
	public boolean isEmpty(){
		if (size() == 0){
			return true;
		}
		return false;
	}
	//first():Return the first element in the list.
	public int first(){

		if (isEmpty()){
			return 0;
		}
		return head.getElement();

	}
	//last():Return the last element in the list.
	public int last(){

		if (isEmpty()){
			return 0;
		}
		return tail.getElement();

	}
	//addFirst(e):Add the new element to the front of the list.
	public void addFirst(int n){
		Node newest = new Node(n,null);
		
		if (size()==0){
			head = newest;
			tail = newest;
			
		}
		else{
			newest.setNext(head);
			head = newest;

		}
		size = size+1;
	}
	//addLast(e):add the new element to the end of the list.
	public void addLast(int n){
		Node newest = new Node(n,null);
		
		if (size()==0){
			head = newest;
			tail = newest;
			
		}
		else{
			tail.setNext(newest);
			tail = newest;

		}
		size += 1;
	}

	//removeFirst():remove and returns the first element of the list.
	public int removeFirst(){
		int deletedelement = head.getElement();
		if (size()==0){
			return 0;
		}
		else{
			head = head.getNext();
		}
		size-=1;
		return deletedelement;

	}
}

class Node{

	private int element;
	private Node next;
	//constructor
	public Node(int element, Node next){
		this.element = element;
			this.next = next;
	}
	//getElement
	public int getElement(){
		return element;
	}
	//getNext()
	public Node getNext(){
		return next;
	}
	//setElement()
	public void setElement(int n){
		element = n;
	}
	//setnext()
	public void setNext(Node n){
		next = n;
	}
}