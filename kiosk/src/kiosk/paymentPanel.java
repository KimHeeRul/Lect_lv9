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

import drink.Drink;

public class paymentPanel extends MyUtill {
	// 결제관련
	ImageIcon image;
	ImageIcon addImage;

//	public static Vector<Drink> result = new Vector<>();

	JButton odder = null;// 추후이미지 대체//이미지 아이콘 인자
	JButton cancle = null;
//	JButton plus = null;
//	JButton minus = null;
	JButton next = null;
	JButton prev = null;

	// 주문라벨
	JLabel text = new JLabel();
	JLabel text2 = new JLabel();
	JLabel text3 = new JLabel();
	JLabel text4 = new JLabel();
	JLabel total = new JLabel();
	JLabel totalPay = new JLabel();

//	JLabel oddlist = new JLabel();
	ArrayList<JLabel> oddlist = new ArrayList<>();
	ArrayList<JLabel> oddlist2 = new ArrayList<>();
	ArrayList<JLabel> oddlist3 = new ArrayList<>();

	// 메뉴 관련
	int num = mainPanel.cnt;
	int pay = mainPanel.priceAll;
	String fileName;
	Drink drink;

	int size = 0;
	int start = 0;

	public paymentPanel(Vector result) {

		if (mainPanel.result.size() >= 5) {
			size = 5;
		} else {
			size = mainPanel.result.size();
		}
		setLayout(null);
		setBounds(0, 0, 400, 650);
		setVisible(true);
		setBackground(Color.white);
		setLabel();
//		setImage();
		setButton();
		revalidate();

	}

	private void setImage(int i) {
		this.fileName = String.format("images/coffee_sub%02d.png", i + 1);
		this.image = new ImageIcon(
				new ImageIcon(this.fileName).getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));

		this.fileName = String.format("images/coffee_sub%02d.png", i + 1);
		addImage = new ImageIcon(new ImageIcon("images/coffee_sub01.png").getImage());

	}

	private void setLabel() {
		text.setLayout(null);
		text.setBounds(80, 70, 300, 50);
		text.setText("주문리스트");
		text.setFont(new Font("nanumBunyuk", Font.BOLD, 20));
		text.setForeground(new Color(236, 97, 135));
		add(text);

		text2.setLayout(null);
		text2.setBounds(180, 70, 300, 50);
		text2.setText("를 확인해 주세요");
		text2.setFont(new Font("nanumBunyuk", Font.BOLD, 20));
		text2.setForeground(Color.black);
		add(text2);

		text3.setLayout(null);
		text3.setBounds(10, 0, 300, 50);
		text3.setText("주문리스트");
		text3.setFont(new Font("nanumBunyuk", Font.BOLD, 20));
		text3.setForeground(new Color(72, 124, 174));
		add(text3);

		text4.setLayout(null);
		text4.setBounds(15, 130, 350, 50);
		text4.setText("메뉴　　　　　　　　　　　　수량　　　　가격");
		text4.setFont(new Font("nanumBunyuk", Font.BOLD, 15));
		text4.setForeground(new Color(136, 134, 130));
		add(text4);

		total.setLayout(null);
		total.setBounds(15, 430, 350, 50);
		total.setText("총 수량  " + num + "개");
		total.setFont(new Font("nanumBunyuk", Font.PLAIN, 18));
		total.setForeground(Color.black);
		add(total);

		totalPay.setLayout(null);
		totalPay.setBounds(100, 430, 250, 50);
		totalPay.setText("총 결제 금액  " + pay);
		totalPay.setFont(new Font("nanumBunyuk", Font.PLAIN, 18));
		totalPay.setForeground(Color.black);
		totalPay.setHorizontalAlignment(JLabel.RIGHT);
		add(totalPay);
/////////////////////////////////////////

//		oddlist.setLayout(null);
//		oddlist.setBounds(10, 180, 250, 50);
//		oddlist.setText(mainPanel.result.get(0).getName());
//		oddlist.setFont(new Font("nanumBunyuk", Font.BOLD, 18));
//		oddlist.setForeground(Color.black);
//		add(oddlist);

		setList();

//		JScrollPane js = new JScrollPane(oddlist);
//		js.setBounds(-1, 182, 398, 250);
//		js.setAutoscrolls(true);
//		add(js);

	}

	private void setList() {
		int x = 10;
		int y = 180;

		for (int i = start; i < size; i++) {

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
			oddlist3.get(i).setText(
					(mainPanel.result.get(i).getPrice() + addlistPopupPanel.sizePay) * mainPanel.result.get(i).getNum()
							+ "");
			oddlist3.get(i).setFont(new Font("nanumBunyuk", Font.BOLD, 18));
			oddlist3.get(i).setForeground(Color.black);
			oddlist3.get(i).setHorizontalAlignment(JLabel.RIGHT);
			add(oddlist3.get(i));

			y += 40;
		}

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

		prev = new JButton(addImage);
		prev.setLayout(null);
		prev.setBounds(20, 380, 50, 40);
		prev.setText("<");
		prev.setBackground(new Color(210, 0, 60));
		prev.setFont(new Font("nanumBunyuk", Font.PLAIN, 20));
		prev.setForeground(Color.white);
		prev.addActionListener(this);
		add(prev);

		next = new JButton(addImage);
		next.setLayout(null);
		next.setBounds(320, 380, 50, 40);
		next.setText(">");
		next.setBackground(new Color(210, 0, 60));
		next.setFont(new Font("nanumBunyuk", Font.PLAIN, 20));
		next.setForeground(Color.white);
		next.addActionListener(this);
		add(next);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == odder) {
			for (int i = 0; i < mainPanel.result.size(); i++) {
				String name = mainPanel.result.get(i).getName();
				String num = mainPanel.result.get(i).getNum() + "";
				String price = (mainPanel.result.get(i).getPrice() + addlistPopupPanel.sizePay)
						* mainPanel.result.get(i).getNum() + "";
				mainPanel.saleslist.add(new Vector<String>());
				mainPanel.saleslist.get(mainPanel.saleslist.size() - 1).add(name);
				mainPanel.saleslist.get(mainPanel.saleslist.size() - 1).add(num);
				mainPanel.saleslist.get(mainPanel.saleslist.size() - 1).add(price);
			}
			mainPanel.result.clear();
			addlistPopupPanel.result.clear();
			mainPanel.cnt = 0;
			mainPanel.priceAll = 0;
			mainPanel.paymentFrame.dispose();

		} else if (e.getSource() == next && size <= 5 && size < mainPanel.result.size()) {
			start += 5;
			if (mainPanel.result.size() - start > 5) {
				size += 5;
			} else {
				size += mainPanel.result.size() - start;
			}

			System.out.println(start);
			setList();
		} else if (e.getSource() == prev && start >= 5) {
			start -= 5;
			
			size=5;

			System.out.println(start);
			System.out.println(size);
			setList();
			//라벨 지우는거해야함
		}

		repaint();
		revalidate();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//		g.drawImage(image.getImage(), 10, 10, null);
		g.setColor(new Color(246, 246, 244));
		g.fillRect(0, 0, 400, 50);
		g.setColor(new Color(241, 241, 240));
		g.drawLine(0, 50, 400, 50);

		g.setColor(new Color(246, 246, 244));
		g.fillRect(0, 130, 400, 50);
		g.setColor(new Color(242, 241, 240));
		g.drawRect(0, 130, 400, 50);
		g.drawRect(0, 130, 400, 300);

		repaint();

	}

}
