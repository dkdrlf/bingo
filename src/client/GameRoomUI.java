package client;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class GameRoomUI extends JFrame {
	JTextField a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25;

	JTextField[] jt_a={a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11,a12,a13,a14,a15,a16,a17,a18,a19,a20,a21,a22,a23,a24,a25};
	JButton[] btn_b={b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23,b24,b25};
	
	public GameRoomUI() {
		// TODO Auto-generated constructor stub
		this.setBounds(300, 300, 600, 500);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 30, 351, 299);
		getContentPane().add(panel);
		CardLayout c=new CardLayout(0, 0);
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

		c.previous(panel);
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameRoomUI();
		

	}
}
