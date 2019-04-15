package zex_server_0;

import java.io.Serializable;
import java.util.function.Consumer;

public class Server extends Network {

	private int port;
	private list player;
	
	public Server(int port, Consumer<Serializable> callback) {
		super(callback);
		// TODO Auto-generated constructor stub
		this.port = port;
	}

	public ConnThread getThe_s() {
		ConnThread tmp = getTh_n();
		return tmp;
	}
	
	public Node getHd() {
		return this.player.getHead();
	}
	
	public void setHd(Node a) {
		this.player.setHead(a);
	}
	
	public void replay() {
		Node tmp = this.player.getHead();
		while (tmp.getNext() != null) {
			if (tmp != null) {
				tmp.setNum(-1);
				tmp.setScore(0);
			}
			tmp.setNext(tmp);
		}
	}
	
	@Override
	protected boolean isServer() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	protected String getIP() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected int getPort() {
		// TODO Auto-generated method stub
		return port;
	}

}
