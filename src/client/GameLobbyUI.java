package client;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import tabletest.TableTest.TableEventHandler;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JButton;

public class GameLobbyUI extends JFrame implements ActionListener {
	
	private JTable table;
	private Object [][] tableData = new Object[0][0];
	private String [] tableColumns = {"방제목", "빙고주제", "인원"};

	JButton btn_create;
	JButton btn_exit;
	public TableModel tm;
	JLabel person_num;
	public static GameLobbyUI gl=new GameLobbyUI();
	JList list;
	public static GameLobbyUI getGL()
	{
		return gl;
	}

	
		private GameLobbyUI() {
		setTitle("빙고게임 대기실");
		// TODO Auto-generated constructor stub
		this.setBounds(300, 300, 580, 349);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GO! GO! Bingo Game");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 39));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 585, 53);
		getContentPane().add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 327, 214);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		tm = new TableModel(tableData, tableColumns);
		table = new JTable(tm);
		table.setFillsViewportHeight(true);
		table.addMouseListener(new TableEventHandler());
		
		table.getColumnModel().getColumn(0).setPreferredWidth(60);
		table.getColumnModel().getColumn(1).setPreferredWidth(60);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		
		table.setColumnSelectionAllowed(true);
		(table.getTableHeader()).setReorderingAllowed(false);
		table.setCellSelectionEnabled(false);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("접속자 목록");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(349, 57, 202, 15);
		getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(349, 82, 202, 163);
		getContentPane().add(scrollPane_1);
		
		list = new JList();
		scrollPane_1.setViewportView(list);
		
		btn_create = new JButton("방만들기");
		btn_create.setBounds(147, 278, 97, 23);
		btn_create.addActionListener(this);
		getContentPane().add(btn_create);
		
		btn_exit = new JButton("종료하기");
		btn_exit.setBounds(256, 278, 97, 23);
		getContentPane().add(btn_exit);
		
		JLabel person_num = new JLabel("접속인원:00명");
		person_num.setFont(new Font("굴림", Font.PLAIN, 13));
		person_num.setHorizontalAlignment(SwingConstants.CENTER);
		person_num.setBounds(376, 255, 141, 15);
		getContentPane().add(person_num);
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btn_create) {
			new MakeRoomUI();
			
		} else {
			int index = table.getSelectedRow();
			String value = (String)table.getValueAt(index, 0);
			System.out.println(value);
		}
	}

	class TableModel extends DefaultTableModel {
		
		public TableModel(Object [][] defaultRowData,Object [] defaultColumnNames){
			super.setDataVector(defaultRowData,defaultColumnNames);			 
    	}

		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}		
	}
	
	public class TableEventHandler extends MouseAdapter {
		public void mouseClicked(MouseEvent me){
			
		}
	}

}
