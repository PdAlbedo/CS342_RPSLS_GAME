package zex_client_0;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.function.Consumer;

public abstract class Network {
	
	private ConnThread connthread = new ConnThread();
	private Consumer<Serializable> callback;
	
	public Network(Consumer<Serializable> callback) {
		this.callback = callback;
		connthread.setDaemon(true);
		
	}
	
	public ConnThread getTh() {
		return this.connthread;
	}
	public void startConn() throws Exception{
		connthread.start();
	}
	
	public void send(Serializable data) throws Exception{
		connthread.out.writeObject(data);
	}
	
	public void closeConn() throws Exception{
		connthread.socket.close();
	}
	
	abstract protected boolean isServer();
	abstract protected String getIP();
	abstract protected int getPort();
	
	class ConnThread extends Thread{
		private Socket socket;
		private ObjectOutputStream out;
		private ObjectInputStream in;
		
		public String getinPut() {
			String a = "NONE";
			try {
				a = in.readUTF();
			} catch (IOException e) {
			}
			return a;
		}
		
		public void run() {
			try(ServerSocket server = null;
					Socket socket = new Socket(getIP(), getPort());
					ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream in = new ObjectInputStream(socket.getInputStream())){
				
				this.socket = socket;
				this.out = out;
				this.in = in;
				socket.setTcpNoDelay(true);
				
				while(true) {
					Serializable data = (Serializable) in.readObject();
					callback.accept(data);
				}
				
			}
			catch(Exception e) {
				callback.accept("connection Closed_Client");
			}
		}
	}

}
