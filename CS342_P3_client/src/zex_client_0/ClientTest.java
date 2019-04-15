package zex_client_0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	void testIsServer() {
		Client tmp = new Client("127.0.0.1", 5555, null);
		assertEquals(tmp.isServer(), false, "Check Client Status Successful.");
		//fail("Not yet implemented");
	}

	@Test
	void testGetIP() {
		Client tmp = new Client("127.0.0.1", 5555, null);
		String a = tmp.getIP();
		assertEquals(a, "127.0.0.1", "Get IP Successful.");
		//fail("Not yet implemented");
	}

	@Test
	void testGetPort() {
		Client tmp = new Client("127.0.0.1", 5555, null);
		int a = tmp.getPort();
		assertEquals(a, 5555, "Get Port Num Successful.");
		//fail("Not yet implemented");
	}

	@Test
	void testGetPts() {
		Client tmp = new Client("127.0.0.1", 5555, null);
		tmp.setPts(111);
		int a = tmp.getPts();
		assertEquals(a, 111, "Get Points Successful.");
		//fail("Not yet implemented");
	}

}
