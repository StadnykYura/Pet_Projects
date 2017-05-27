package linkedList;

public class LinkedList {

	 	private int size;
	    private Node head;
	    private Node tail;

	/* Конструктор без аргументів */
	    public LinkedList() {
	    	this.size = 0;
	       this.head = null;
	       this.tail = null;
	    }

	    /* Додати елемент в кінець списку */
	    public void add(Integer data) {
	        Node node = new Node();
	        node.setData(data);
	        if (head == null || size()==0) {
	           head = node;
	           tail = node;
	            size++;
	        }
	        else {
	            tail.setNext(node);
	            tail = node;
	            size++;
	        }
	    }

	/* Отримати елемент по індексу, повертає null якщо такий елемент недоступний */
	    public Integer get(int index) {
	        if (size() == 0 || index > (size()-1) || index < 0) {
	            return null;
	        }
	        Node t = head;
	        int i = 0;
	        while (i < index) {
	            t = t.getNext();
	            i++;
	        }
	        return t.getData();
	    }

	    /* Вилучення елементу за індексом, повертає true у разі успіху або false в іншому випадку */
	    public boolean delete(int index) {
	        
	        if (head == null || index < 0 || index > size()-1 || size() == 0) {
	        	return false;
	        }
	        // якщо перший елемент списку, та в списку більше ніж 1 елемент
	        if (index == 0 && size > 1) {
	            head = head.getNext();
	            size--;
	            return true;
	        }
	        // якщо один елемент в списку
	        if (head == tail) {         
	            head.setNext(null);
	            head.setData(0);
	            tail.setNext(null);
	            tail.setData(0);
	            size --;
	            return true;
	        }

	        Node nodeToDel = head;
	        Node nodePrev = nodeToDel;
	        int i = 0;
	        while (i < index) {
	            nodePrev = nodeToDel;
	            nodeToDel = nodeToDel.getNext();
	            i++;
	        }

	        if (nodeToDel == tail) {
	        tail = nodePrev;
	            size--;
	            return true;
	        } else {
	                nodePrev.setNext(nodeToDel.getNext());
	                    size--;
	                    return true;
	                }
	        }

	    /*Поверта розмір списку: якщо елементів в списку нема то повертає 0 (нуль)*/
	    public int size() {
	        return size;
	    }

	    public void printList() {
	        Node node  = head;
	        int i = 0;
	        while (i < size()){
	            System.out.print(node.getData()+ " ");
	            node = node.getNext();
	            i++;
	        }
	        System.out.print( "    Head=" + head.getData()+ "  Tail="+tail.getData()+ "  size="+ size());
	        System.out.println();
}
	
}
