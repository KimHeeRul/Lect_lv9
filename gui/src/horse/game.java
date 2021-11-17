package horse;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;

class panel extends MyUtill implements Runnable {
	public JButton start = new JButton();
	public JButton reset = new JButton();
	Horse horse[] = new Horse[5];
	boolean button, run;
	public final int READY = 0;
	public final int RUN = 1;
	public final int GOAL = 2;
	Random ran = new Random();
	private int ms;
	int endX = Race.SIZE - 120;
	private JLabel timer = new JLabel();
	private JLabel rankLabel[] = new JLabel[5];
	int rank=1;
	private int startX = 30;
	private int startY = 200;

	int cnt = 0;
	boolean game;

	public panel() {
		setLayout(null);
		setBounds(0, 0, Race.SIZE, Race.SIZE);
		setHorse();
		setButton();
		setTimer();
		rank();
		revalidate();
	}

	private void setHorse() {
		int x = startX;
		int y = startY;
		for (int i = 0; i < horse.length; i++) {
			horse[i] = new Horse(i + 1, x, y, 120, 100, String.format("hores%d", i + 1));
			y += 100;
		}

	}

	public void setTimer() {
		ms = 0;

		this.timer.setBounds(130, 20, 50, 30);
		this.timer.setText("ready");
		add(this.timer);
	}

	public void setButton() {
		start.setBounds(50, 20, 70, 30);
		start.setVisible(true);
		start.setText("start");
		start.addActionListener(this);
		add(start);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		if (e.getSource() == start) {
			if (button) {
				start.setText("start");
				button = false;
				for (int i = 0; i < horse.length; i++) {
					horse[i].setState(READY);
				}
				run = false;
				resetStart();

			} else {
				start.setText("reset");
				button = true;
				run = true;
				for (int i = 0; i < horse.length; i++) {
					horse[i].setState(RUN);
				}
				gameStart();
			}

		}

		repaint();
		revalidate();
	}

	private void update() {

		boolean goal = false;

		for (int i = 0; i < horse.length; i++) {
			Horse temp = this.horse[i];
			int jump = ran.nextInt(30) + 1;
			int xx = temp.getX() + jump;

			if (temp.getState() == temp.RUN) {
//				temp.setX(temp.getX() + jump);
				if (xx >= this.endX && !goal) {
					temp.setState(GOAL);
					temp.setX(endX);
					temp.setRecord(String.format("%d.%03d", this.ms / 1000, this.ms % 1000));
					temp.setRank(rank);
					this.rank++;

				} else if (xx >= this.endX && goal) {
					i--;
					continue;
				}
				temp.setX(xx);
			}
		}
	}

	private void gameStart() {
//		while (!game) {
//			for (int j = 0; j < horse.length; j++) {
//				int x = horse[i].getX();
//			}
//		}
	}

	private void resetStart() {
		cnt = 0;
		startX = 30;
		startY = 200;
		game = false;
		setTimer();
		setHorse();
		rank();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
//		int y = 100;
		for (int i = 0; i < horse.length; i++) {
			Horse temp = horse[i];
			int x = horse[i].getX();

			g.drawImage(temp.getImage().getImage(), temp.getX(), temp.getY()-100, null);
//			if (horse[i].getState() == RUN) {
//				int xplus = ran.nextInt(30) + 1;
//				x = horse[i].getX() + xplus;
//				horse[i].setX(x);
//			}

			if (temp.getState() == temp.GOAL) {
				g.setFont(new Font("", Font.BOLD, 20));
				g.drawString(temp.getRank() + "등", this.endX - 100, temp.getY());
				g.setFont(new Font("", Font.BOLD, 10));
				g.drawString(temp.getRank() + "등", this.endX - 50, temp.getY());
//				if (horse[i].getState() != GOAL && cnt < 5) {
//					horse[i].setX(Race.SIZE - 120);
//					horse[i].setState(GOAL);
//					horse[i].setRank(cnt);
//					cnt++;
//					System.out.println(cnt);
//					System.out.println("1");
//					this.rankLabel[i]
//							.setText(cnt + "등 " + String.format("%5d.%3d", this.ms / 1000, this.ms % 1000) + "초");
//				}
			}
		}

		int x1 = 50;
		int y1 = 200;
		int x2 = Race.SIZE - 100;
		int y2 = 200;
		for (int i = 0; i < horse.length; i++) {
			g.drawLine(x1, y1, x2, y2);
			y1 += 100;
			y2 += 100;
		}
		if (run) {

			try {
				Thread.sleep(100);
				update();

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		if (cnt == 5) {
//			game = true;
			run = false;
		}
		repaint();
	}

	private void rank() {
		int y = 100;
		for (int i = 0; i < rankLabel.length; i++) {
			this.rankLabel[i] = new JLabel();
			this.rankLabel[i].setBounds(Race.SIZE - 200, y, 100, 100);
			rankLabel[i].setVisible(true);
			add(this.rankLabel[i]);
			y += 100;
		}
	}

	@Override
	public void run() {
		while (true) {
			if (run) {
				this.ms++;
				this.timer.setText(String.format("%d.%03d", this.ms / 1000, this.ms % 1000));
			}
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

	}
}
