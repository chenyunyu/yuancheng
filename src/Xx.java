import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Xx {

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setVisible(true);
		jf.setSize(600, 600);
		jf.setTitle("ÏÂÑ©ÁË");
		jf.setResizable(false);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SJPanel1 sj=new SJPanel1();
		jf.add(sj);
		sj.moveSnow();
	}
}
class SJPanel1 extends JPanel{
	int x[]=new int[600] ;
	int y[]=new int[600] ;
	public SJPanel1(){
		for (int i = 0; i < x.length; i++) {
			x[i]=(int)(Math.random()*800);
			y[i]=(int)(Math.random()*800);
		}
		
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(Color.BLACK);
		g.setColor(Color.WHITE);
		for (int i = 0; i < x.length; i++) {
			g.drawString("Ñ©»¨", x[i], y[i]);
		}
		
	}
	public void moveSnow(){
		new Thread(){
			public void run(){
				while(true){
					for (int i = 0; i < x.length; i++) {
						y[i]=y[i]+2;
						if(y[i]>=600){
							y[i]=0;
					}
					
					}
					repaint();
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}