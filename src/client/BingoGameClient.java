package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.DefaultListModel;

import data.Data;

public class BingoGameClient implements Runnable {
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket socket;
	String id;
	
	
	public BingoGameClient(ObjectOutputStream oos,ObjectInputStream ois) {
		// TODO Auto-generated constructor stub
		this.oos=oos;
		this.ois=ois;
		this.id=id;
		Data d=new Data(Data.SHOWALL);
		Object obj[]={d};
		try {
			oos.writeObject(obj);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		GameLobbyUI gl=GameLobbyUI.getGL();
		
		
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Object obj[]=(Object[])ois.readObject();
				String command=(String)obj[0];
				switch (command) {
				case "showall":
					ArrayList<String> list=new ArrayList<>();
					list=(ArrayList<String>)obj[1];
					GameLobbyUI.gl.list.setListData(list.toArray());
					
					break;

				default:
					break;
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

	
}
