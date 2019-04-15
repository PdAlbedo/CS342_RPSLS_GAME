package zex_server_0;

public class list {
	private Node head;
	
	public void setHead(Node a) {
		this.head = a;
	}
	
	public Node getHead() {
		return this.head;
	}
	
	public void reset() {
		Node tmp = this.head;
		while (tmp.getNext() != null) {
			if (tmp != null) {
				tmp.setNum(-1);
				tmp.setScore(0);
			}
			tmp.setNext(tmp);
		}
	}
}
