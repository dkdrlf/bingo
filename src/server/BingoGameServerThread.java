package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import javax.print.event.PrintEvent;

import data.Data;
import data.GameRoom;
import data.User;

public class BingoGameServerThread implements Runnable {
	
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private boolean exit;
	private BingoGameServer parent;
	static ArrayList<User> connectedUserList = new ArrayList<>(); //������ ���ӵ� Ŭ���̾�Ʈ, �� Ŭ���̾�Ʈ�� ObjectOutputStream�� �����Ǿ� ����
	static HashMap<String, GameRoom> gameRoomList = new HashMap<>();
	private Data data;
	public BingoGameServerThread(){}
	public BingoGameServerThread(BingoGameServer parent, Socket client) {
		
		this.parent = parent;
		try {
			ois = new ObjectInputStream(client.getInputStream());
			oos = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 서버에 발생되는 모든 이벤트 로그를 표시한다.
	 */
	public void printEventLog(String message)
	{
		String logMessage=String.format("[%tY-%<tm-%<td %<tH:%<tM:%<tS] %s%n",new Date(), message);
		parent.textArea.append(logMessage);
	}
	
	/**
	 *  서버에 접속된 사용자 목록을 보여준다
	 * @param userList
	 */
	public void updateConnectionList(ArrayList<User> userList)
	{
		parent.list.setListData(userList.toArray());
	}
	
	@Override
	public void run() {
		while(!exit){
			try {
				//data = (Data)ois.readObject();
				Object obj[]=(Object[])ois.readObject();
				data=(Data)obj[0];
				
				switch(data.getCommand()){
					case Data.LOGIN: {
						User u=(User)obj[1];	
						u.setOos(oos);
						connectedUserList.add(u);
						printEventLog(u.getId()+"가접속했습니다");
						this.updateConnectionList(connectedUserList);
					}
						break;
					case Data.SHOWALL:
						ArrayList<String> list=new ArrayList<>();
						for(int a=0; a<connectedUserList.size();a++)
						{
							list.add(connectedUserList.get(a).getId());
						}
						Object obj1[]={"showall",list};
						for(int a=0;a<connectedUserList.size();a++)
						{
							connectedUserList.get(a).getOos().writeObject(obj1);
						}
						break;
						
					case Data.MAKE_ROOM: {
					
					}
						break;
						
					case Data.JOIN: {
						
					}
						break;
						
					case Data.CHAT_MESSAGE:
					case Data.SEND_WINNING_RESULT:
					case Data.GAME_READY:
					case Data.GAME_START:
					case Data.SEND_BINGO_DATA: {
						sendDataRoommate(data.getGameRoom().getRoomID());
					}
						break;
					case Data.EXIT: {
						
					}
						break;
				}//switch
				
			} catch (IOException e) {
				exit = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}//while
	}//run
	
	/**
	 * ���� �濡 �ִ� �������� Data��ü ����
	 * */
	public void sendDataRoommate(String roomID){
		
	}
	
	/**
	 * ��� �������� Data��ü ����
	 * */
	public void broadCasting(){
		
	}
	

	public static void main(String[] args) {
		BingoGameServerThread b=new BingoGameServerThread();
		b.printEventLog("dd");
	}
	
}
