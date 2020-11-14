public class StackLinkedList{
	
	Node head; 
	int size;

	public StackLinkedList(){
		Node head = null; 
		int size = 0;;	
	}

	public void push(int n){
		Node newest = new Node(n);
		newest.next = head;
		head = newest;
		System.out.println(n);

		size += 1;
	}
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		else{
			return false;
			
		}
		
	}
	public int size(){
		return size;
	}
	public int top(){
		if (head == null) {
			System.out.println("The stack is empty");
		}
		return head.n;
	}
	public void pop(){
		Node temp = head;
		this.head = this.head.next;
		System.out.println("The pop data is ="+temp.n);

		size -= 1;
	}
}
class Node{
	int n;
	Node next;

	public Node(int n){
		this.n = n;
		this.next = null;
	}
}
