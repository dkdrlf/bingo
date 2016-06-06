package client;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import client.GameLobbyUI.TableModel;

import javax.swing.JTable;
import javax.swing.JTextArea;

public class GameRoomUI extends JFrame implements ActionListener {
	JTextField a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25;

	JTextField[] jt_a={a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25,a26};
	JButton[] btn_b={b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25};
	private JTable table;
	DefaultTableModel dt=new DefaultTableModel();
	String column[]={"차례","ID","상태","빙고"};
	private JTextField textField;
	
	JButton ready;
	JButton exit;
	CardLayout c;
	JPanel panel;
	public GameRoomUI() {
		setTitle("빙고게임 창");
		// TODO Auto-generated constructor stub
		this.setBounds(300, 300, 600, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 30, 351, 299);
		getContentPane().add(panel);
		c=new CardLayout(0, 0);
		panel.setLayout(c);
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "name_1925665454453");
		panel_1.setLayout(new GridLayout(5,5));
		
		for(int a=0;a<25;a++)
		{
			jt_a[a]=new JTextField();
			panel_1.add(jt_a[a]);
		}
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "name_2895533320205");
		panel_2.setLayout(new GridLayout(5,5));
		
		for(int a=0;a<25;a++)
		{
			btn_b[a]=new JButton();
			panel_2.add(btn_b[a]);
		}
		
		JLabel lblNewLabel = new JLabel("빙고주제:");
		lblNewLabel.setBounds(0, 0, 204, 30);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("참가자");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(351, 30, 233, 30);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(351, 61, 233, 255);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(dt);
		dt.setColumnIdentifiers(column);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("제한시간 :00초");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(351, 316, 233, 23);
		getContentPane().add(lblNewLabel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 329, 351, 97);
		getContentPane().add(scrollPane_1);
		
		JTextArea textArea = new JTextArea();
		scrollPane_1.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(0, 431, 351, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		ready = new JButton("준비완료");
		ready.setBounds(361, 349, 97, 23);
		ready.addActionListener(this);
		getContentPane().add(ready);
		
		exit = new JButton("방나가기");
		exit.setBounds(475, 349, 97, 23);
		getContentPane().add(exit);
		Object[] ob={1,2,3,4};
		Object[] ob1={1,2,3,4};
		Object[] ne={7,8,9,10};
		dt.addRow(ob);
		dt.addRow(ob1);
		dt.removeRow(0);
		dt.insertRow(0,ne);
		
		
		
		this.setVisible(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==ready)
		{
			for(int a=0;a<25;a++)
			{
				btn_b[a].setText(jt_a[a].getText());
			}
			
		}
		c.previous(panel);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameRoomUI();
		

	}
}
