package horse;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Horse {
	public final int READY = 0;
	public final int RUN = 1;
	public final int GOAL = 2;

	private int num;
	private int x, y, w, h;
	private String fileName;
	private ImageIcon image;

	private int state;// 0.reddy,1 run ,2 goal
	private int rank;
	private String record;

	public Horse(int num, int x, int y, int w, int h, String fileName) { //이름 필요한가?
		this.num = num;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fileName = String.format("images/horse%d.png", this.num);
		this.image = new ImageIcon(new ImageIcon(this.fileName).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.image = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
	}// 이미지 수정

	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public int getREADY() {
		return READY;
	}

	public int getRUN() {
		return RUN;
	}

	public int getGOAL() {
		return GOAL;
	}

	public int getNum() {
		return num;
	}

	public int getW() {
		return w;
	}

}
