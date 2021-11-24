package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import drink.Drink;
import drink.Sales;

public class mainPanel extends MyUtill {

	public static Vector<Drink> result = new Vector<>();
	public static Vector<Vector<String>> saleslist = new Vector<>();
	
	
	// 결제관련
	JButton reset = new JButton();// 추후이미지 대체//이미지 아이콘 인자
	JButton payment = new JButton();
	// 주문라벨
	JLabel su = new JLabel();
	JLabel amount = new JLabel();
	JLabel suInt = new JLabel();
	JLabel amountInt = new JLabel();
	// 메뉴 관련
	JButton category[] = new JButton[4];// 추후 디저트등 추가 가능성

	JButton menu[] = new JButton[16];//
	JButton menu2[] = new JButton[16];//
	//매출
	JButton sales = new JButton();//

	int menuPage = 0;
	JButton movepage[] = new JButton[2];//

	static JFrame popupframe = null;
	static JFrame paymentFrame = null;
	static JFrame salesFrame = null;
	
	int menucate = 0;
	int price[] = new int[16];
	String name[] = new String[16];
	public Drink drink[] = new Drink[16];

	// 주문관련
	public static int cnt = 0;
	public static int priceAll = 0;

	public mainPanel() {
		setLayout(null);
		setBounds(0, 0, 500, 800);
		setVisible(true);
		revalidate();
		setBackground(Color.white);
		setLabel();
		setprice();
		setButton();
		cateButton();
		setMenuButton();
	}

	private void setprice() {
		int x = 100;
		for (int i = 0; i < price.length; i++) {
			price[i] = x;
			x += 300;
		}
		String temp= "아아";
		for (int i = 0; i < name.length; i++) {
			name[i]=temp+(i+1);
		}

	}

	private void setMenuButton() {

		int x = 30;
		int y = 150;
		for (int i = 0; i < 9; i++) {
			if (i + menuPage < menu.length) {
				drink[i + menuPage] = new Drink(price[i + menuPage], name[i+menuPage], i + menuPage);
				menu[i + menuPage] = new JButton(drink[i + menuPage].getImage());
				menu[i + menuPage].setBounds(x, y, 140, 140);
				menu[i + menuPage].setBackground(new Color(247, 247, 247));
				if (menuPage == 0) {
					menu[i + menuPage].setText("메뉴이미지");
				} else {
					menu[i + menuPage].setText("메뉴이미지2");
				}
				x += 150;
				if (i % 3 == 2) {
					x = 30;
					y += 150;
				}
				menu[i + menuPage].addActionListener(this);
				add(menu[i + menuPage]);
			}
		}
	}

	private void setLabel() {

		su.setLayout(null);
		su.setBounds(30, 690, 50, 50);
		su.setText("주문수량");
		add(su);
		suInt.setLayout(null);
		suInt.setBounds(200, 690, 50, 50);
		suInt.setText(cnt + "");
		suInt.setHorizontalAlignment(JLabel.RIGHT);
		add(suInt);

		amount.setLayout(null);
		amount.setBounds(30, 710, 50, 50);
		amount.setText("주문금액");
		add(amount);

		amountInt.setLayout(null);
		amountInt.setBounds(200, 710, 50, 50);
		amountInt.setForeground(Color.red);
		amountInt.setText(priceAll + "");
		amountInt.setHorizontalAlignment(JLabel.RIGHT);
		add(amountInt);

	}

	private void setButton() {
		reset.setLayout(null);
		reset.setBounds(270, 700, 100, 50);
		reset.setText("전체 취소");
		reset.addActionListener(this);
		add(reset);
		payment.setLayout(null);
		payment.setBounds(370, 700, 100, 50);
		payment.setText("결제하기");
		payment.addActionListener(this);
		add(payment);
		
		sales.setLayout(null);
		sales.setBounds(200, 600, 100, 50);
		sales.setText("매출관리");
		sales.addActionListener(this);
		add(sales);

		int x = 50;
		String pageName[] = { "이전페이지", "다음페이지" };
		for (int i = 0; i < movepage.length; i++) {
			movepage[i] = new JButton();
			movepage[i].setLayout(null);
			movepage[i].setBounds(x, 600, 100, 50);
			movepage[i].setText(pageName[i]);
			movepage[i].addActionListener(this);
			add(movepage[i]);
			x += 300;
		}

	}

	private void cateButton() {
		int x = 35;
		int y = 80;
		String[] cate = { "커피", "티&에이드", "디저트", "과일쥬스" };
		for (int i = 0; i < category.length; i++) {
			category[i] = new JButton();
			category[i].setLayout(null);
			category[i].setBounds(x, y, 100, 40);
			category[i].setText(cate[i]);
			add(category[i]);
			x += 110;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == movepage[1]) {
			for (int j = 0; j < 9; j++) {
				remove(menu[j]);
			}
			menuPage += 9;

			setMenuButton();
		}
		if (e.getSource() == movepage[0]) {
			for (int j = 0; j < menu.length - menuPage; j++) {
				remove(menu[j + menuPage]);
			}
			menuPage -= 9;
			setMenuButton();
		}

		for (int i = 0; i < 9; i++) {
			if (i + menuPage < menu.length) {
				if (e.getSource() == menu[i + menuPage]) {
					popupframe = new addlistPopupFrame(i + menuPage, drink[i + menuPage]);
				}
			}
		}

		for (int i = 0; i < category.length; i++) {
			if (category[i] == e.getSource()) {
				menuPage = 0;
				setMenuButton();
			}
		}
		if (e.getSource() == payment) {// 최종결제
			
			
			
		}
		if (e.getSource() == reset) {
			result.clear();
			addlistPopupPanel.result.clear();
			cnt = 0;
			priceAll = 0;
		}
		
		if (e.getSource() == payment &&cnt>0) {
			paymentFrame = new PaymentFrame();
		}
		
		if (e.getSource() == sales) {
			salesFrame = new SalesFrame();
		}
		

		repaint();
		revalidate();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (menuPage + 9 > menu.length) {
			movepage[1].setVisible(false);
			movepage[0].setVisible(true);
		} else {
			movepage[0].setVisible(false);
			movepage[1].setVisible(true);
		}
		if (popupframe != null) {
			amountInt.setText(priceAll + "");
			suInt.setText(cnt + "");
//			System.out.println(result.size());
//			String.format("%d", 
		}

		repaint();
		revalidate();
	}

}
