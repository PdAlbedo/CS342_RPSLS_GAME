package zex_server_0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ServerTest {

	@Test
	void testGetHd() {
		Server tmp = new Server(5555, null);
		Node a = new Node(1,2);
		tmp.setHd(a);
		Node b = tmp.getHd();
		assertEquals(b, a, "Get head of the player list Successful.");
		//fail("Not yet implemented");
	}

	@Test
	void testReplay() {
		Server tmp = new Server(5555, null);
		Node a = new Node(1,2);
		tmp.setHd(a);
		tmp.replay();
		assertEquals(tmp.getHd().getNum(), -1, "Reset Successful.");
		assertEquals(tmp.getHd().getScore(), 0, "Reset Successful.");
		//fail("Not yet implemented");
	}

}
