package kiosk;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import drink.Drink;

public class addlistPopupPanel extends MyUtill {
	// 결제관련
	ImageIcon image;
	ImageIcon plusImage;
	ImageIcon minusImage;
	ImageIcon size;
	ImageIcon sweet;

	public static Vector<Drink> result = new Vector<>();

	JButton addlist = null;// 추후이미지 대체//이미지 아이콘 인자
	JButton cancle = null;
	JButton plus = null;
	JButton minus = null;
	// 주문라벨
	JLabel su = new JLabel();
	JLabel pay = new JLabel();
	JLabel name = new JLabel();
	
	JLabel text = new JLabel();
	JLabel text2 = new JLabel();
	
	
	// 메뉴 관련
	int num = 1;
	String fileName;
	Drink drink;

	public addlistPopupPanel(int i, Drink drink) {
		setLayout(null);
		setBounds(0, 0, 400, 650);
		setVisible(true);
		setBackground(Color.white);
		this.drink = drink;
		setLabel(drink, i);
		setImage(i);
		setButton();
		revalidate();

	}

	private void setImage(int i) {
		this.fileName = String.format("images/coffee_sub%02d.png", i + 1);
		this.image = new ImageIcon(
				new ImageIcon(this.fileName).getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH));

//		this.fileName = String.format("images/plus.jpg", i + 1);
		plusImage = new ImageIcon(new ImageIcon("images/plus.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		minusImage= new ImageIcon(new ImageIcon("images/minus.jpg").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

		size= new ImageIcon(new ImageIcon("images/minus.jpg").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
		sweet= new ImageIcon(new ImageIcon("images/minus.jpg").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH));
	}

	private void setLabel(Drink drink, int i) {
		su.setLayout(null);
		su.setBounds(220, 70, 50, 50);
		su.setText(num + "");
		add(su);
		System.out.println(drink.getPrice());
		pay.setLayout(null);
		pay.setBounds(300, 70, 50, 50);
		pay.setText(drink.getPrice() + "");
		pay.setFont(new Font("Arial", Font.PLAIN, 20));
		pay.setForeground(new Color(125,79,65));
		add(pay);
		
		name.setLayout(null);
		name.setText(drink.getName());
		name.setBounds(180, 10, 100, 100);
		name.setFont(new Font("nanumBunyuk", Font.BOLD, 30));
		name.setForeground(new Color(125,79,65));
		add(name);
		
		text.setLayout(null);
		text.setText("사이즈를 선택하세요");
		text.setBounds(10, 120, 200, 100);
		text.setFont(new Font("nanumBunyuk", Font.BOLD, 20));
		text.setForeground(new Color(125,79,65));
		add(text);
		
		
		text2.setLayout(null);
		text2.setText("당도를 선택하세요");
		text2.setBounds(10, 250, 200, 100);
		text2.setFont(new Font("nanumBunyuk", Font.BOLD, 20));
		text2.setForeground(new Color(125,79,65));
		add(text2);
		
		
		
		
	}

	private void setButton() {

		addlist = new JButton();
		addlist.setLayout(null);
		addlist.setBounds(210, 530, 160, 50);
		addlist.setText("주문담기");
		addlist.setBackground(new Color(230,0,65));
		addlist.setFont(new Font("nanumBunyuk", Font.BOLD, 18));
		addlist.setForeground(Color.white);
		addlist.addActionListener(this);
		add(addlist);
		
		cancle = new JButton();
		cancle.setLayout(null);
		cancle.setBounds(20, 530, 160, 50);
		cancle.setText("취소");
		cancle.setBackground(new Color(65,65,65));
		cancle.setFont(new Font("nanumBunyuk", Font.BOLD, 18));
		cancle.setForeground(Color.white);
		cancle.addActionListener(this);
		add(cancle);

		plus = new JButton(plusImage);
		plus.setLayout(null);
		plus.setBounds(235, 85, 20, 20);
		plus.addActionListener(this);
		add(plus);

		minus = new JButton(minusImage);
		minus.setLayout(null);
		minus.setBounds(190, 85, 20, 20);
		minus.addActionListener(this);
		add(minus);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == plus) {
			num++;
		}

		if (e.getSource() == minus) {
			if (num > 1) {
				num--;
			}
		}

		if (e.getSource() == addlist) {
			int idx = -1;
			for (int i = 0; i < result.size(); i++) {
				if (drink.getName().equals(result.get(i).getName())) {
					idx = i;
				}
			}
			if (idx != -1) {
				drink.setNum(result.get(idx).getNum() + num);

			} else {
				drink.setNum(num);
				result.add(drink);
				mainPanel.result.add(drink);
			}
			mainPanel.priceAll += drink.getPrice() * num;
			mainPanel.cnt += num;
			mainPanel.popupframe.dispose();
		}
		if (e.getSource() == cancle) {
			mainPanel.popupframe.dispose();
		}

		repaint();
		revalidate();

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image.getImage(), 10, 10, null);
		su.setText(num + "");
		
		g.setColor(new Color(232,230,226));
		g.fillRect(0, 150, 400, 40);
		
		g.fillRect(0, 280, 400, 40);
		
		g.fillRect(0, 410, 400, 40);
		 
		int x=20;
		int y=195;
		for (int i = 0; i < 2; i++) {
			g.drawImage(size.getImage(), x,y,null);
			x+=80;
			g.drawImage(size.getImage(), x,y,null);
			x=20;
			y+=130;
		}
		
		
		repaint();

	}

}
