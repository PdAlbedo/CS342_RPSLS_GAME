package zex_server_0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NodeTest {

	@Test
	void testNode() {
		Node tmp = new Node(1,2);
		assertEquals(tmp.getNum(), -1, "Set Node Successful.");
		assertEquals(tmp.getScore(), 0, "Set Node Successful.");
		//fail("Not yet implemented");
	}

	@Test
	void testSetNum() {
		Node tmp = new Node(1,2);
		tmp.setNum(999);
		assertEquals(tmp.getNum(), 999, "Set Num Successful.");
		fail("Not yet implemented");
	}

	@Test
	void testSetScore() {
		Node tmp = new Node(1,2);
		tmp.setScore(999);
		assertEquals(tmp.getScore(), 999, "Set Num Successful.");
		fail("Not yet implemented");
	}

	@Test
	void testSetNext() {
		Node tmp = new Node(1,2);
		Node tmp1 = new Node(3,4);
		tmp.setNext(tmp1);
		assertEquals(tmp.getNext().getNum(),3, "Set Next Successful.");
		assertEquals(tmp.getNext().getScore(), 4, "Set Next Successful.");
		//fail("Not yet implemented");
	}

}
