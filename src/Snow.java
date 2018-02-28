import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snow {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(700, 800);
		jf.setTitle("Ñ­»·");
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SnowJPanel sj = new SnowJPanel();
		jf.add(sj);
		sj.moveSnow();
	}
}

class SnowJPanel extends JPanel {
	int x[]=new int[600];
	int y[]=new int[600];
	 public SnowJPanel() {
		for (int i = 0; i < x.length; i++) {
			x[i]=(int)(Math.random()*600);
			y[i]=(int)(Math.random()*600);
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(Color.GREEN);
		g.setColor(Color.RED);
		for (int i = 0; i < x.length; i++) {
			g.drawString("*", x[i], y[i]);
		}
	}
	public void moveSnow() {
		new Thread() {
			public void run() {
				while (true) {
					for (int i = 0; i < x.length; i++) {
						y[i]++;
						if (y[i] >= 700) {
							y[i] = 0;
					}
					}
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}