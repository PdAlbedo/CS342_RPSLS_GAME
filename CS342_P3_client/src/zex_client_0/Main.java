package zex_client_0;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.BufferedReader; 

public class Main extends Application {
	
	Button btn_connect = new Button("Start Connection");
	Button btn_rock, btn_paper, btn_scissors, btn_lizard, btn_spock;
	Button btn_re, btn_quit;
	Text address_info, port_info;
	TextField address_enter = new TextField();
	TextField port_enter = new TextField();
	TextArea game_process;
	Stage myStage;
	Scene scene;
	HashMap<String, Scene> sceneMap;
	String ip_add,c;
	String z;
	int port_num;
	private Client con;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Client End");
		myStage = primaryStage;
		address_info = new Text("Server IP Address: ");
		port_info = new Text("Connection Port: ");
		btn_re = new Button("Play Again");
		btn_quit = new Button("Quit");
		btn_rock = new Button("ROCK");
		btn_paper = new Button("PAPER");
		btn_scissors = new Button("SCISSORS");
		btn_lizard = new Button("LIZARD");
		btn_spock = new Button("SPOCK");
		game_process = new TextArea();

		btn_re.setDisable(true);
		btn_quit.setDisable(true);
		
		btn_connect.setOnAction(event -> {
			String a = getadd();
			int b = getport();
			con = createClient(a,b);
			game_process.clear();
			game_process.appendText("Client Estabilshed...\n");
			try {
				init();
			} catch(Exception e) {
				
			}
		});
		
		btn_re.setOnAction(event -> {
			String message = "Replay";
			try {
				con.send(message);
			} catch(Exception e) {
				
			}
		});
		
		btn_quit.setOnAction(e->primaryStage.close());
		
		btn_rock.setOnAction(event -> {
			if (con == null) {
				System.out.println("not in rock\n");
			}
			try {
				if (con == null) {
					System.out.println("not in rock\n");
				}
				con.send("Player 1 plays: ROCK");
			} catch(Exception e) {
			}
			/*///////////////////////////////////////////////////////GET INPUT_ WRONG
			while (con.getTh().getinPut() == "NONE") {
			}
			if (con.getTh().getinPut() == "YOU WIN.") {
				btn_re.setDisable(false);
				btn_quit.setDisable(false);
			}
			else if (con.getTh().getinPut() == "YOU WIN THE ROUND") {
				int tmp0 = con.getPts();
				String tmp1 = "I got " + tmp0 + "Points.\n";
				tmp0++;
				con.setPts(tmp0);
				try {
					con.send(tmp1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				game_process.appendText("/////////////////////////////////////////////");
				game_process.appendText(con.getTh().getinPut());
				game_process.appendText("/////////////////////////////////////////////");
			}
			*/
		});
		
		btn_paper.setOnAction(event -> {
			try {
				con.send("Player 1 plays: PAPER");
			} catch(Exception e) {
				
			}
			/*
			while (con.getTh().getinPut() == "NONE") {
			}
			if (con.getTh().getinPut() == "YOU WIN.") {
				btn_re.setDisable(false);
				btn_quit.setDisable(false);
			}
			else if (con.getTh().getinPut() == "YOU WIN THE ROUND") {
				int tmp0 = con.getPts();
				String tmp1 = "I got " + tmp0 + "Points.\n";
				tmp0++;
				con.setPts(tmp0);
				try {
					con.send(tmp1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				game_process.appendText("/////////////////////////////////////////////");
				game_process.appendText(con.getTh().getinPut());
				game_process.appendText("/////////////////////////////////////////////");
			}
			*/
		});
		
		btn_scissors.setOnAction(event -> {
			try {
				con.send("Player 1 plays: SCISSORS");
			} catch(Exception e) {
				
			}
			/*
			while (con.getTh().getinPut() == "NONE") {
			}
			if (con.getTh().getinPut() == "YOU WIN.") {
				btn_re.setDisable(false);
				btn_quit.setDisable(false);
			}
			else if (con.getTh().getinPut() == "YOU WIN THE ROUND") {
				int tmp0 = con.getPts();
				String tmp1 = "I got " + tmp0 + "Points.\n";
				tmp0++;
				con.setPts(tmp0);
				try {
					con.send(tmp1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				game_process.appendText("/////////////////////////////////////////////");
				game_process.appendText(con.getTh().getinPut());
				game_process.appendText("/////////////////////////////////////////////");
			}
			*/
		});
		
		btn_lizard.setOnAction(event -> {
			try {
				con.send("Player 1 plays: LIZARD");
			} catch(Exception e) {
				
			}
			/*
			while (con.getTh().getinPut() == "NONE") {
			}
			if (con.getTh().getinPut() == "YOU WIN.") {
				btn_re.setDisable(false);
				btn_quit.setDisable(false);
			}
			else if (con.getTh().getinPut() == "YOU WIN THE ROUND") {
				int tmp0 = con.getPts();
				String tmp1 = "I got " + tmp0 + "Points.\n";
				tmp0++;
				con.setPts(tmp0);
				try {
					con.send(tmp1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				game_process.appendText("/////////////////////////////////////////////");
				game_process.appendText(con.getTh().getinPut());
				game_process.appendText("/////////////////////////////////////////////");
			}
			*/
		});
		
		btn_spock.setOnAction(event -> {
			try {
				con.send("Player 1 plays: SPOCK");
			} catch(Exception e) {
				
			}
			/*
			while (con.getTh().getinPut() == "NONE") {
			}
			if (con.getTh().getinPut() == "YOU WIN.") {
				btn_re.setDisable(false);
				btn_quit.setDisable(false);
			}
			else if (con.getTh().getinPut() == "YOU WIN THE ROUND") {
				int tmp0 = con.getPts();
				String tmp1 = "I got " + tmp0 + "Points.\n";
				tmp0++;
				con.setPts(tmp0);
				try {
					con.send(tmp1);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			else {
				game_process.appendText("/////////////////////////////////////////////");
				game_process.appendText(con.getTh().getinPut());
				game_process.appendText("/////////////////////////////////////////////");
			}
			*/
		});
		
		Image pic_1 = new Image("rock.png");
		ImageView v_1 = new ImageView(pic_1);
		v_1.setFitHeight(200);
		v_1.setFitWidth(100);
		v_1.setPreserveRatio(true);
		btn_rock.setGraphic(v_1);
		
		Image pic_2 = new Image("paper.png");
		ImageView v_2 = new ImageView(pic_2);
		v_2.setFitHeight(200);
		v_2.setFitWidth(100);
		v_2.setPreserveRatio(true);
		btn_paper.setGraphic(v_2);
		
		Image pic_3 = new Image("scissors.png");
		ImageView v_3 = new ImageView(pic_3);
		v_3.setFitHeight(200);
		v_3.setFitWidth(100);
		v_3.setPreserveRatio(true);
		btn_scissors.setGraphic(v_3);
		
		Image pic_4 = new Image("lizard.jpg");
		ImageView v_4 = new ImageView(pic_4);
		v_4.setFitHeight(200);
		v_4.setFitWidth(100);
		v_4.setPreserveRatio(true);
		btn_lizard.setGraphic(v_4);
		
		Image pic_5 = new Image("spock.png");
		ImageView v_5 = new ImageView(pic_5);
		v_5.setFitHeight(200);
		v_5.setFitWidth(100);
		v_5.setPreserveRatio(true);
		btn_spock.setGraphic(v_5);
		
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(70));
		scene = new Scene(pane, 1100, 600);
		
		HBox re_quit = new HBox(20, btn_re, btn_quit);
		HBox ip_field = new HBox(20, address_info, address_enter);
		HBox port_field = new HBox(20, port_info, port_enter);
		HBox btn_c_box = new HBox(btn_connect);
		VBox func_sec = new VBox(20, re_quit, ip_field, port_field, btn_c_box);
		pane.setTop(func_sec);
		func_sec.setAlignment(Pos.TOP_LEFT);
		
		HBox rpsls = new HBox(20, btn_rock, btn_paper, btn_scissors, btn_lizard, btn_spock);
		pane.setCenter(rpsls);
		rpsls.setAlignment(Pos.CENTER);
		rpsls.setPadding(new Insets(10, 50, 30, 12));
		
		pane.setBottom(game_process);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	public String getadd() {
		z = address_enter.getText();
		address_enter.clear();
		
		return z;
	}
	
	public int getport() {
		c = port_enter.getText();
		try {
			port_num = Integer.parseInt(c);
		} catch(NumberFormatException ex) {
			
		}
		port_enter.clear();
		return port_num;
	}
	
	public void init() throws Exception{
		if (con == null) {
			return;
		}
		con.startConn();
	}
	
	public void stop() throws Exception{
		con.closeConn();
	}
	
	private Client createClient(String ip, int port) {
		return new Client(ip, port, data -> {
			Platform.runLater(()->{
				game_process.appendText(data.toString() + "\n");
			});
		});
	}
}
