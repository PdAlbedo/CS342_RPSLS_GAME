package zex_server_0;

public class Node {
	private int num;
	private int score;
	private Node next;
	
	public Node(int a, int b) {
		this.num = a;
		this.score = b;
		this.next = null;
	}
	
	public int getNum() {
		return this.num;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNum(int a) {
		this.num = a;
	}
	
	public void setScore(int b) {
		this.score = b;
	}
	
	public void setNext(Node a) {
		this.next = a;
	}
}
