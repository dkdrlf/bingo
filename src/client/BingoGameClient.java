package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import data.Data;
import data.User;

public class BingoGameClient implements Runnable {
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket socket;
	String id;
	String commit;
	User user;
	GameLobbyUI gl;
	GameRoomUI g;
	
	public BingoGameClient(User user) {
		this.user = user;
		Socket socket;
		try {
			socket = new Socket("localhost", 7777);
			oos=new ObjectOutputStream(socket.getOutputStream());
			ois=new ObjectInputStream(socket.getInputStream());
			Data d=new Data(Data.LOGIN);
			d.setUser(user);
			
			gl=GameLobbyUI.getGL();
			gl.setBingGameClient(this);
			
			Thread t=new Thread(this);
			t.start();
			sendData(d);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void sendData(Data data){
		try {
			oos.writeObject(data);
			oos.reset();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Data u=(Data)ois.readObject();
				
				switch (u.getCommand()) {
				case Data.LOGIN:
					gl.updateUserList(u.getUserList());
					gl.updateTableList(u.getRoomList());
					break;
					
				case Data.MAKE_ROOM:
					gl.updateUserList(u.getUserList());
					gl.updateTableList(u.getRoomList());
					g=GameRoomUI.getGameRoomUI();
					gamePersons(g,u);
					break;

				default:
				case Data.JOIN:
					gl.updateUserList(u.getUserList());
					gl.updateTableList(u.getRoomList());
					g=GameRoomUI.getGameRoomUI();
					gamePersons(g,u);
					
					//GameRoomUI g=new GameRoomUI(title, id)
					//break;
				}
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void gamePersons(GameRoomUI game,Data d)
	{
		game.lb_title.setText(d.getGameRoom().getTitle());
		game.setTable(d.getGameRoom().getUserList());
	}

	
}
