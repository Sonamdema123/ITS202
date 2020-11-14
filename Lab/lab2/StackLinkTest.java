public class StackLinkTest{
	public static void main(String[] args){
		StackLinkedList o = new StackLinkedList();
		o.push(2);
		o.push(4);
		o.push(8);

		System.out.println("The stack is empty: "+o.isEmpty());
  		System.out.println("The element size is: "+o.size());
  		System.out.println("The top is: "+o.top());
  		o.pop();
  		System.out.println("The element size is: "+o.size());

  		assert(o.isEmpty()==false);
  		assert(o.size()==2);
  		assert(o.top()==4);
  		System.out.println("All test are passed.");
	}
}