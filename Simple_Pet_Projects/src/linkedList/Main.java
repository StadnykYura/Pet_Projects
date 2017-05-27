package linkedList;

public class Main {

	public static void main (String[] args) {
	    LinkedList ls = new LinkedList();
	    
	    ls.add(null);
	    ls.add(20);
	    ls.add(null);
	    ls.add(30);
	    ls.printList();
	    ls.add(40);
	    ls.printList();
	    ls.delete(0);
	    ls.printList();
	    ls.delete(1);
	    ls.printList();
	    ls.delete(1);
	    ls.printList();
	    ls.delete(1);
	    ls.printList();
	    ls.delete(0);
	    ls.printList();
	    ls.add(100);
	    ls.add(200);
	    ls.add(330);
	    ls.add(400);
	    ls.add(500);
	    ls.printList();
	    System.out.println("Get 1  "+ls.get(1));
	    System.out.println("Get 0  "+ls.get(0));
	    System.out.println("Get 10  "+ls.get(10));
	    ls.delete(6);
	    ls.printList();
	    System.out.println(" size is  "+ ls.size());
	    ls.delete(4);
	    ls.printList();
	    System.out.println(ls.size());
	}
	
}
	   
