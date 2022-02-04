package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import drink.Drink;

public class SalesPanel extends MyUtill {
	// 결제관련
	ImageIcon image;
	ImageIcon addImage;

//	public static Vector<Drink> result = new Vector<>();

	JButton odder = null;// 추후이미지 대체//이미지 아이콘 인자
	JButton cancle = null;
	JButton plus = null;
	JButton minus = null;
	// 주문라벨
	JLabel text = new JLabel();
	JLabel text2 = new JLabel();
	JLabel text3 = new JLabel();
	JLabel text4 = new JLabel();
	JLabel total = new JLabel();
	JLabel totalSalse = new JLabel();

//	JLabel oddlist = new JLabel();
	ArrayList<JLabel> oddlist = new ArrayList<>();
	ArrayList<JLabel> oddlist2 = new ArrayList<>();
	ArrayList<JLabel> oddlist3 = new ArrayList<>();

	// 메뉴 관련
	int num = mainPanel.cnt;
	int pay = 0;
	String fileName;
	Drink drink;

	JTable table = null;
	Vector<String> colName = null;
	public SalesPanel(Vector result) {
		setLayout(null);
		setBounds(0, 0, 400, 650);
		setVisible(true);
		setBackground(new Color(70,70,72));
		setTable();

		setLabel();
		revalidate();

	}

	private void setTable() {
		this.colName = new Vector();
		this.colName.add("메뉴");
		this.colName.add("수량");
		this.colName.add("가격");
		table = new JTable(mainPanel.saleslist, colName);
		table.setBounds(0, 50, 400, 400);
		table.setBorder(new LineBorder(Color.black));
		table.setGridColor(Color.black);
		add(table);

		JScrollPane js = new JScrollPane(table);
		js.setBounds(0, 50, 400, 400);
		js.setAutoscrolls(true);
		add(js);

	}


	private void setLabel() {
		for (int i = 0; i < mainPanel.saleslist.size(); i++) {
			pay += Integer.parseInt(mainPanel.saleslist.get(i).get(2));
		}

		totalSalse.setLayout(null);
		totalSalse.setBounds(100, 460, 250, 50);
		totalSalse.setText("총 매출  " + pay);
		totalSalse.setFont(new Font("nanumBunyuk", Font.PLAIN, 18));
		totalSalse.setForeground(Color.white);
		totalSalse.setHorizontalAlignment(JLabel.RIGHT);
		add(totalSalse);
		
		text.setLayout(null);
		text.setBounds(10, 0, 250, 50);
		text.setText("매출 관리");
		text.setFont(new Font("nanumBunyuk", Font.BOLD, 18));
		text.setForeground(Color.white);
		add(text);
		
		
/////////////////////////////////////////

//		oddlist.setLayout(null);
//		oddlist.setBounds(10, 180, 250, 50);
//		oddlist.setText(mainPanel.result.get(0).getName());
//		oddlist.setFont(new Font("nanumBunyuk", Font.BOLD, 18));
//		oddlist.setForeground(Color.black);
//		add(oddlist);

		int x = 10;
		int y = 180;
		for (int i = 0; i < mainPanel.result.size(); i++) {
			oddlist.add(new JLabel());
			oddlist.get(i).setBounds(x, y, 250, 50);
			oddlist.get(i).setText(mainPanel.result.get(i).getName());
			oddlist.get(i).setFont(new Font("nanumBunyuk", Font.BOLD, 18));
			oddlist.get(i).setForeground(Color.black);
			add(oddlist.get(i));

			oddlist2.add(new JLabel());
			oddlist2.get(i).setBounds(x + 210, y, 25, 50);
			oddlist2.get(i).setText(mainPanel.result.get(i).getNum() + "");
			oddlist2.get(i).setFont(new Font("nanumBunyuk", Font.BOLD, 18));
			oddlist2.get(i).setForeground(Color.black);
			oddlist2.get(i).setHorizontalAlignment(JLabel.RIGHT);
			add(oddlist2.get(i));

			oddlist3.add(new JLabel());
			oddlist3.get(i).setBounds(x + 260, y, 80, 50);
			oddlist3.get(i).setText(mainPanel.result.get(i).getPrice() * mainPanel.result.get(i).getNum() + "");
			oddlist3.get(i).setFont(new Font("nanumBunyuk", Font.BOLD, 18));
			oddlist3.get(i).setForeground(Color.black);
			oddlist3.get(i).setHorizontalAlignment(JLabel.RIGHT);
			add(oddlist3.get(i));

			y += 40;
		}

		for (int i = 0; i < mainPanel.result.size(); i++) {
			System.out.println("2");
		}

//		JScrollPane js = new JScrollPane(oddlist);
//		js.setBounds(-1, 182, 398, 250);
//		js.setAutoscrolls(true);
//		add(js);

	}

	private void setButton() {

		odder = new JButton(addImage);
		odder.setLayout(null);
		odder.setBounds(200 - 160 / 2, 530, 160, 50);
		odder.setText("확인");
		odder.setBackground(new Color(210, 0, 60));
		odder.setFont(new Font("nanumBunyuk", Font.PLAIN, 20));
		odder.setForeground(Color.white);
		odder.addActionListener(this);
		add(odder);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == odder) {
			mainPanel.result.clear();
			addlistPopupPanel.result.clear();
			mainPanel.cnt = 0;
			mainPanel.priceAll = 0;
			mainPanel.paymentFrame.dispose();

		}

		repaint();
		revalidate();

	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		g.drawImage(image.getImage(), 10, 10, null);
		g.setColor(new Color(65,65,67));
		g.fillRect(0, 0, 400, 50);
		repaint();

	}

}
