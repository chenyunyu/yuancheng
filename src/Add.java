import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Add {

	public static void main(String[] args) {
  JFrame jf=new JFrame();
  jf.setVisible(true);
  jf.setSize(800, 800);
  jf.setTitle("Ôö¼Ó");
  jf.setResizable(false);
  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  JJPanel jj=new JJPanel();
  jf.add(jj);
	}
}
class JJPanel extends JPanel{
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(Color.BLACK);
		g.setColor(Color.RED);
		Font f=new Font("ºÚÌå", Font.BOLD, 40);
		g.setFont(f);
		g.drawString("$", 400, 400);
	}
}