package zex_client_0;

import java.io.Serializable;
import java.util.function.Consumer;

public class Client extends Network {

	private String ip;
	private int port; 
	private int pts;
	
	public Client(String ip, int port, Consumer<Serializable> callback) {
		super(callback);
		this.ip = ip;
		this.port = port;
		this.pts  = 0;
	}

	protected int getPts() {
		return this.pts;
	}
	
	protected void setPts(int a) {
		this.pts = a;
	}
	
	protected boolean isServer() {
	
		return false;
	}

	protected String getIP() {
		return this.ip;
	}

	protected int getPort() {
		return this.port;
	}

}
