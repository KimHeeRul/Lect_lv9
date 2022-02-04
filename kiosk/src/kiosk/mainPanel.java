package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import drink.Drink;
import drink.Drink2;

public class mainPanel extends MyUtill {

	public static Vector<Drink> result = new Vector<>();
	public static Vector<Vector<String>> saleslist = new Vector<>();

	int cate = 0;
	ImageIcon logo;

	// 결제관련
	JButton reset = new JButton();// 추후이미지 대체//이미지 아이콘 인자
	JButton payment = new JButton();
	// 주문라벨
	JLabel su = new JLabel();
	JLabel amount = new JLabel();
	JLabel suInt = new JLabel();
	JLabel amountInt = new JLabel();
	// 메뉴 관련
	JButton category[] = new JButton[2];// 추후 디저트등 추가 가능성

	JButton menu[] = new JButton[16];//
	JButton menu2[] = new JButton[16];//
	// 매출
	JButton sales = new JButton();//

	int menuPage = 0;
	JButton movepage[] = new JButton[2];//

	static JFrame popupframe = null;
	static JFrame paymentFrame = null;
	static JFrame salesFrame = null;

	int menucate = 0;
	int price[] = { 1500, 2500, 2000, 2500, 2500, 2500, 3000, 3000, 3000, 3500, 3500, 3500, 1500, 2500, 3000, 3000 };
	String name[] = { "아메리카노", "스페셜아메리카노", "헤이즐넛아메리카노", "유자아메리카노", "카푸치노", "카페라떼", "헤이즐럿라떼", "바닐라라떼", "크리미라떼",
			"헤이즐넛크리미라떼", "카페모카", "카라멜마끼아또", "에소프레소", "더치커피", "더치시나몬라떼", "더치코코넛라떼" };
	public Drink drink[] = new Drink[16];

	int price2[] = { 3500, 3500, 3500, 2500, 2500, 2500, 2500, 2500, 3500, 2500, 2500, 2500, 2500, 3000, 3500, 3500 };
	String name2[] = { "허니레몬티", "허니유자티", "허니자몽티", "얼그레이", "국화차", "민트초코티", "캐모마일", "페퍼민트", "청포도에이드", "보이차", "루이보스",
			"로즈힙", "히비스커스", "복숭아아이스티", "블루레몬에이드", "자몽에이드" };
	public Drink drink2[] = new Drink[16];

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
		setImage();
		setButton();
		cateButton();
		setMenuButton();
	}

	private void setImage() {
		logo = new ImageIcon(
				new ImageIcon("images/logo.png").getImage().getScaledInstance(200, 80, Image.SCALE_SMOOTH));
	}

	private void setMenuButton() {
		int x = 30;
		int y = 150;
		for (int i = 0; i < 9; i++) {
			if (i + menuPage < menu.length) {
				drink[i + menuPage] = new Drink(price2[i + menuPage], name[i + menuPage], i + menuPage,"images/coffee_sub");
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

	private void setMenuButton2() {
		int x = 30;
		int y = 150;
		for (int i = 0; i < 9; i++) {
			if (i + menuPage < menu.length) {
				drink2[i + menuPage] = new Drink(price[i + menuPage], name2[i + menuPage], i + menuPage,"images/tea_sub");
				menu[i + menuPage] = new JButton(drink2[i + menuPage].getImage());
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
		su.setBounds(30, 690, 100, 50);
		su.setText("주문수량");
		su.setFont(new Font("nanumBunyuk", Font.BOLD, 15));
		add(su);
		suInt.setLayout(null);
		suInt.setBounds(200, 690, 50, 50);
		suInt.setText(cnt + "");
		suInt.setHorizontalAlignment(JLabel.RIGHT);
		add(suInt);

		amount.setLayout(null);
		amount.setBounds(30, 710, 100, 50);
		amount.setText("주문금액");
		amount.setFont(new Font("nanumBunyuk", Font.BOLD, 15));
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
		reset.setBackground(new Color(68, 68, 68));
		reset.setForeground(Color.white);
		reset.setFont(new Font("nanumBunyuk", Font.BOLD, 15));
		reset.addActionListener(this);
		add(reset);
		payment.setLayout(null);
		payment.setBounds(370, 700, 100, 50);
		payment.setText("결제하기");
		payment.addActionListener(this);
		payment.setBackground(new Color(0, 68, 130));
		payment.setForeground(Color.white);
		payment.setFont(new Font("nanumBunyuk", Font.BOLD, 15));
		add(payment);

		sales.setLayout(null);
		sales.setBounds(200, 600, 100, 50);
		sales.setText("매출관리");
		sales.addActionListener(this);
		sales.setBackground(new Color(226, 0, 66));
		sales.setForeground(Color.white);
		sales.setFont(new Font("nanumBunyuk", Font.BOLD, 15));
		add(sales);

		int x = 50;
		String pageName[] = { "이전", "다음" };
		for (int i = 0; i < movepage.length; i++) {
			movepage[i] = new JButton();
			movepage[i].setLayout(null);
			movepage[i].setBounds(x, 600, 100, 50);
			movepage[i].setText(pageName[i]);
			movepage[i].setBackground(new Color(246, 166, 2));
			movepage[i].setForeground(Color.white);
			movepage[i].setFont(new Font("nanumBunyuk", Font.BOLD, 25));
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
			category[i].setBackground(new Color(246, 166, 2));
			category[i].setForeground(Color.white);
			category[i].setFont(new Font("nanumBunyuk", Font.BOLD, 13));
			category[i].addActionListener(this);
			add(category[i]);
			x += 110;
		}
		for (int j = 0; j < category.length; j++) {
			if (j==0) {
				category[j].setBackground(Color.white);
				category[j].setForeground(Color.black);
			}else {
				category[j].setBackground(new Color(246, 166, 2));
				category[j].setForeground(Color.white);
			}
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

			if (cate == 0) {
				setMenuButton();

			} else if (cate == 1) {
				setMenuButton2();
			}

		}
		if (e.getSource() == movepage[0]) {
			for (int j = 0; j < menu.length - menuPage; j++) {
				remove(menu[j + menuPage]);
			}
			menuPage -= 9;
			if (cate == 0) {
				setMenuButton();
			} else if (cate == 1) {
				setMenuButton2();
			}

		}

		for (int i = 0; i < 9; i++) {
			if (i + menuPage < menu.length) {
				if (e.getSource() == menu[i + menuPage]) {
					if (cate == 0) {
						popupframe = new addlistPopupFrame(i + menuPage, drink[i + menuPage],"images/coffee_sub");
					} else if (cate == 1) {
						System.out.println("1dsd");
						popupframe = new addlistPopupFrame(i + menuPage, drink2[i + menuPage],"images/tea_sub");
						
					}
				}
			}
		}

		for (int i = 0; i < category.length; i++) {
			if (category[i] == e.getSource()) {
				if (i == 0) {
					if (menuPage != 0) {
						for (int j = 0; j < menu.length - menuPage; j++) {
							remove(menu[j + menuPage]);
						}
					} else {
						for (int j = 0; j < 9; j++) {
							remove(menu[j]);
						}
					}
					for (int j = 0; j < category.length; j++) {
						if (i==j) {
							category[j].setBackground(Color.white);
							category[j].setForeground(Color.black);
						}else {
							category[j].setBackground(new Color(246, 166, 2));
							category[j].setForeground(Color.white);
						}
					}
					
					cate = i;
					menuPage = 0;
					setMenuButton();
				} else if (i == 1) {
					if (menuPage != 0) {
						for (int j = 0; j < menu.length - menuPage; j++) {
							remove(menu[j + menuPage]);
						}
					} else {
						for (int j = 0; j < 9; j++) {
							remove(menu[j]);
						}
					}
					for (int j = 0; j < category.length; j++) {
						if (i==j) {
							category[j].setBackground(Color.white);
							category[j].setForeground(Color.black);
						}else {
							category[j].setBackground(new Color(246, 166, 2));
							category[j].setForeground(Color.white);
						}
					}
					cate = i;
					menuPage = 0;
					setMenuButton2();
				} else if (i == 2) {
					setMenuButton();

				}
			}
		}

		if (e.getSource() == reset)

		{
			result.clear();
			addlistPopupPanel.result.clear();
			cnt = 0;
			priceAll = 0;
		}

		if (e.getSource() == payment && cnt > 0) {
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
		g.setColor(new Color(190, 30, 26));
		g.fillRect(0, 70, 500, 50);
		g.setColor(new Color(190, 30, 26));
		g.fillRect(0, 70, 500, 50);
		g.drawImage(logo.getImage(), 250 - 200 / 2, -10, null);

		repaint();
		revalidate();
	}

}
