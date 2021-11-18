import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

import javax.swing.JButton;

import obj.Box;
import obj.Char;
import obj.Point;
import obj.Tile;
import obj.Wall;
import obj.onBox;

public class MyPanel extends MyUtill {
	Random ran = new Random();
	JButton reset = new JButton();
	Box box[] = new Box[7];
	onBox onbox[] = new onBox[7];
	Point point[] = new Point[7];

	Wall wall[] = new Wall[50];
	Tile tile[] = new Tile[50];
	Char me = null;
	boolean left, up, down, right, move;
	int map[][] = new int[9][8];
	int Checkpoint[][] = new int[9][8];
	String fileName = "map.txt";
	String text = "";
	boolean pointCheck, pointCheck2;
	final int box2 = 4;
	final int point2 = 5;
	final int wall2 = 2;
	final int me2 = 3;
	final int tile2 = 1;
	final int onbox2 = 6;
	boolean win;

	public MyPanel() {
		setLayout(null);
		setBounds(0, 0, game.SIZEX, game.SIZEY);
		setVisible(true);
		revalidate();
		addKeyListener(this);
		setFocusable(true);
		setMap();
		setWall();
		setBox();
		setonBox();
		setTile();
		setChar();
		setPoint();
		resetButton();

	}

	private void resetButton() {
		reset.setLayout(null);
		reset.setText("reset");
		reset.setBounds(game.SIZEX - 150, 0, 100, 30);
		add(reset);
		setVisible(true);
		revalidate();
		reset.addActionListener(this);
	}

	public void reset() {
		setMap();
		setWall();
		setBox();
		setonBox();
		setTile();
		setChar();
		setPoint();
		win = false;
	}

	private void setMap() {
		String fileName = "map.txt";
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			String data = "";
			text = "";
			while (data != null) {
				data = br.readLine();
				if (data != null) {
					text += data + "\n";
				}
			}
			fr.close();
			br.close();
			String[] result = text.split("\n");
			for (int i = 0; i < result.length; i++) {
				String[] result2 = result[i].split("/");
				for (int j = 0; j < result2.length; j++) {
					map[i][j] = Integer.parseInt(result2[j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void setBox() {
		int x = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == box2) {
					box[x] = new Box(j, i, "tile4");
					x++;
				}
			}
		}
	}

	private void setonBox() {
		int x = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == onbox2) {
					onbox[x] = new onBox(j, i, "tile6");
					x++;
				}
			}
		}
	}

	public void setTile() {
		int x = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == tile2) {
					tile[x] = new Tile(j, i, "tile1");
					x++;
				}
			}
		}

	}

	private void setPoint() {
		int x = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == point2) {
					point[x] = new Point(j, i, "tile5");
					Checkpoint[i][j] = 1;
					x++;
				} else {
					Checkpoint[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < Checkpoint.length; i++) {
			for (int j = 0; j < Checkpoint[i].length; j++) {
				System.out.print(Checkpoint[i][j]);
			}
			System.out.println();
		}
	}

	private void setWall() {
		int x = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == wall2) {
					wall[x] = new Wall(j, i, "tile2");
					x++;
				}
			}
		}
	}

	private void setChar() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == me2) {
					me = new Char(j, i, "tile3");
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		JButton target = (JButton) e.getSource();
		if (target == reset) {
			reset();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int x = 0; x < box.length; x++) {
			Box temp = box[x];
			if (temp != null) {

				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] == box2) {
							g.drawImage(temp.getImage().getImage(), j * 50, i * 50, null);
						}
					}
				}
			}
		}
		for (int x = 0; x < onbox.length; x++) {
			onBox temp = onbox[x];
			if (temp != null) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] == onbox2) {
							g.drawImage(temp.getImage().getImage(), j * 50, i * 50, null);
						}
					}
				}
			}
		}
		
		for (int x = 0; x < wall.length; x++) {
			Wall temp = wall[x];
			if (temp != null) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] == wall2) {
							g.drawImage(temp.getImage().getImage(), temp.getX() * 50, temp.getY() * 50, null);
						}
					}
				}
			}
		}
		for (int x = 0; x < tile.length; x++) {
			Tile temp = tile[x];
			if (temp != null) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] == tile2) {
//							tile[x].setY(i);
//							tile[x].setX(j);
							g.drawImage(temp.getImage().getImage(), j * 50, i * 50, null);
						}
					}
				}
			}
		}
		for (int x = 0; x < point.length; x++) {
			Point temp = point[x];
			for (int i = 0; i < Checkpoint.length; i++) {
				for (int j = 0; j < Checkpoint[i].length; j++) {
					if (Checkpoint[i][j] == 1&&map[i][j] ==tile2 ) {
						map[i][j] = point2;
					}
//					System.out.print(Checkpoint[i][j]);
				}
//				System.out.println();
			}
			if (temp != null) {
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < map[i].length; j++) {
						if (map[i][j] == point2) {
							g.drawImage(temp.getImage().getImage(), j * 50, i * 50, null);
						}
					}
				}
			}
		}

		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == me2) {
					me.setY(i);
					me.setX(j);
					g.drawImage(me.getImage().getImage(), j * 50, i * 50, null);
				}
			}
		}

		requestFocusInWindow();
		repaint();

	}

	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (!win) {
			System.out.println("1");
			if (e.getKeyCode() == e.VK_RIGHT) {
				right = true;
			} else if (e.getKeyCode() == e.VK_LEFT) {
				left = true;
			} else if (e.getKeyCode() == e.VK_UP) {
				up = true;
			} else if (e.getKeyCode() == e.VK_DOWN) {
				down = true;
			}

			moveCheck();
			winCheck();
		}
	}

	private void winCheck() {
		int cnt = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == onbox2) {
					cnt++;
				}
			}
		}
		if (cnt == point.length) {
			win = true;
			new result();

		}

	}

	private void moveCheck() {
		int xx = me.getX();
		int yy = me.getY();
		boolean move = false;
		boolean check = false;
		if (right) {
			xx++;
		} else if (left) {
			xx--;
		} else if (up) {
			yy--;
		} else if (down) {
			yy++;
		}

		if (pointCheck(xx, yy)) {
			pointCheck = true;
			map[me.getY()][me.getX()] = tile2;
			map[yy][xx] = me2;
		} 
		else {
			System.out.println(pointCheck);

			move = true;
		}

		if (boxCheck(xx, yy)) {
			int ballY = yy;
			int ballX = xx;

			if (right == true && map[ballY][ballX + 1] != wall2 && map[ballY][ballX + 1] != box2
					&& map[ballY][ballX + 1] != onbox2) {
				if (map[ballY][ballX] == onbox2) {
					check = true;
				}
				ballX++;

			} else if (left == true && map[ballY][ballX - 1] != wall2 && map[ballY][ballX - 1] != box2
					&& map[ballY][ballX - 1] != onbox2) {
				if (map[ballY][ballX] == onbox2) {
					check = true;
				}
				ballX--;
			} else if (up == true && map[ballY - 1][ballX] != wall2 && map[ballY - 1][ballX] != box2
					&& map[ballY - 1][ballX] != onbox2) {
				if (map[ballY][ballX] == onbox2) {
					check = true;
				}
				ballY--;
			} else if (down == true && map[ballY + 1][ballX] != wall2 && map[ballY + 1][ballX] != box2
					&& map[ballY + 1][ballX] != onbox2) {
				if (map[ballY][ballX] == onbox2) {
					check = true;
				}
				ballY++;
			} else {
				move = false;
			}
			if (move) {
				if (map[ballY][ballX] == point2) {
					System.out.println("Æ÷ÀÎÆ®");
					map[ballY][ballX] = onbox2;
				} else {
					map[ballY][ballX] = box2;

				}
			}

		}

		if (map[yy][xx] == wall2) {
			System.err.println("Äô");
			move = false;
		}
		if (move) {
			if (pointCheck) {
				pointCheck = false;
				map[me.getY()][me.getX()] = point2;
			} else {
				if (check) {
					pointCheck = true;
				}
				map[me.getY()][me.getX()] = tile2;
			}
			map[yy][xx] = me2;
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

	private boolean boxCheck(int xx, int yy) {
		if (map[yy][xx] == box2 || map[yy][xx] == onbox2) {
			return true;
		} else {
			return false;
		}
	}

	private boolean pointCheck(int xx, int yy) {
		if (map[yy][xx] == point2) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		if (!win) {
			if (e.getKeyCode() == e.VK_RIGHT) {
				right = false;
			} else if (e.getKeyCode() == e.VK_LEFT) {
				left = false;
			} else if (e.getKeyCode() == e.VK_UP) {
				up = false;
			} else if (e.getKeyCode() == e.VK_DOWN) {
				down = false;
			}
		}
	}

}
