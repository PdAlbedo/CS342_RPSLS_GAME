package zex_server_0;

import java.net.Socket;
import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import zex_server_0.Network.ConnThread;

public class Main extends Application{
	
	Text port_info, server_info;
	TextField to_client;
	TextField port_enter = new TextField();
	Button server_on, server_off, server_send, btn_quit;
	TextArea from_client, online_players;
	list record;
	Stage myStage;
	Scene scene;
	HashMap<String, Scene> sceneMap;
	
	int p;
	private Server con = createServer(5555);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("Server End");
		myStage = primaryStage;
		port_info = new Text("Port Number: ");
		server_info = new Text("Server Message: ");
		to_client = new TextField();
		server_on = new Button("Server On");
		server_off = new Button("Server Off");
		server_send = new Button("Send Message");
		btn_quit = new Button("Quit");
		from_client = new TextArea();
		from_client.setPrefHeight(250);
		online_players = new TextArea();
		int p1, p2;
		
		btn_quit.setOnAction(e->primaryStage.close());
		
		server_on.setOnAction(event -> { 
			System.out.println("\ninit()\n");
			try {
				init();
			} catch(Exception e) {
			}
			// Confusing on thread
			//checkThe();
			checkStat();
		});
		server_off.setOnAction(event -> { 
			try {
				stop();
			} catch(Exception e) {
				
			}
		});
		server_send.setOnAction(event -> {
			String note = to_client.getText();
			note = "From Server: " + note;
			try {
				con.send(note);
			} catch(Exception e) {
				
			}
			//to_client.clear();
		});
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(70));
		scene = new Scene(pane, 1100, 500);
		
		VBox cont = new VBox(20, online_players, from_client);
        pane.setCenter(cont);
        cont.setPadding(new Insets(50, 12, 30, 12));
		
		HBox port = new HBox(10, port_info, port_enter);
		HBox on_off = new HBox(10, server_on, server_off);
		HBox message_0 = new HBox(10, server_info, to_client, server_send);
		HBox message = new HBox(50, message_0, btn_quit);
		HBox Lpart = new HBox(20, port, on_off);
		HBox info = new HBox(100, Lpart, message);
		pane.setTop(info);
		info.setAlignment(Pos.TOP_LEFT);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	//////////////////////////////////////////////////////////////not work.
	/*
	public void checkThe() {
		while (true) {
			try {
				ConnThread n = con.getThe_s();
				ConnThread n1 = new ConnThread();
				n1.start();
			} catch (Exception e) {
				
			}
		}
	}
	*/
	////////////////////////////////////////////////////////////////
	public void checkStat() {
		if (con.getTh().getinPut() == "Replay") {
			con.replay();
		}
	}
	
	@Override
	public void init() throws Exception{
		con.startConn();
	}
	
	@Override
	public void stop() throws Exception{
		con.closeConn();
	}
	
	private Server createServer(int port) {
		return new Server(port, data-> {
			Platform.runLater(()->{
				from_client.appendText(data.toString() + "\n");
			});
		});
	}
}





















