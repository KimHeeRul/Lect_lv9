package basic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Expanel extends JPanel implements KeyListener{
	//¡ŸπŸ≤ﬁ ∫“∞°
	JTextField jf = new JTextField();

	//¡ŸπŸ≤ﬁ ∞°¥…
	JTextArea ja=new JTextArea();
	public Expanel() {
		setLayout(null);
		setBounds(100, 100, 400, 500);
		setTextField();
		setTextArea();
		
		
		
	}

	private void setTextArea() {
		ja.setBounds(100,180,200,200);
		ja.addKeyListener(this);
		ja.setFocusable(true);
		add(ja);
	}

	private void setTextField() {
		jf.setBounds(100,100,100,30);
		jf.addKeyListener(this);
		jf.setFocusable(true);
		add(jf);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println(e.getSource());
		if (e.getKeyCode()==e.VK_ENTER) {
			System.out.println(jf.getText());
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}

public class Ex09 extends JFrame {
	public Ex09() {
		setLayout(null);
		setBounds(100, 100, 400, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new Expanel());
		setVisible(true);
		revalidate();
	}

	public static void main(String[] args) {
		new Ex09();
	}
}
