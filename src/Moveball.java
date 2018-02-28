import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Moveball extends JFrame { // 继承窗口类
	public Moveball() {
		this.setVisible(true);
		this.setBounds(50, 50, 500, 700);
		this.setTitle("接球大杂烩");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BallJPanel bp = new BallJPanel(); // 创建画布类对象
		this.add(bp);
		bp.move();
	}

	public static void main(String[] args) {
		new Moveball(); // 调用Moveball类
	}
}

class BallJPanel extends JPanel implements MouseMotionListener {
	int x = 100;
	int y = 120;
	int d = 70;
	int px = 100;
	int py = 600;
	int pw = 200;
	int f = 0;
	boolean flag=false;
	int speed=1;
	int score=0;
	Color ballColor;//球的颜色
	Color bgColor;//背景色
	public BallJPanel() {
		addMouseMotionListener(this);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(bgColor);
		g.setColor(ballColor);
		
		g.fillOval(x, y, d, d);
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
		g2.setStroke(new BasicStroke(5)); // 设置线的粗细
		g.drawLine(px, py, px + pw, py); // 画线
		Font f=new Font("楷体",Font.ITALIC,30);
		g.setFont(f);
		g.drawString("分数:"+score, 50, 70);
		g.setColor(Color.RED);
		if(flag){
		g.drawString("GAME_OVER",120,300);
		}
	}

	public void move() {
		new Thread() {
			public void run() {
				while (true) {
					repaint();
					if (f == 0) {
						x--;
						y--;
					}
					if (f == 1) {
						x++;
						y--;
					}
					if (f == 2) {
						x++;
						y++;
					}
					if (f == 3) {
						x--;
						y++;
					}
					if (x <= 0) {
						if (f == 0) {
							f = 1;
						} else {
							f = 2;
						}
					}
					if (x >= 500 - d) {
						if (f == 1) {
							f = 0;
						} else {
							f = 3;
						}
					}
					if (y <= 0) {
						if (f == 0) {
							f = 3;
						} else {
							f = 2;
						}
					}
					if (y >= py - d) {
						if (px <= x + d / 2 && x + d / 2 <= px + pw) {
							if (f == 2) {
								f = 1;
							} else {
								f = 0;
							}
						} else {
							this.stop();
						}
						speed++;
						if(speed>=10){
							speed=10;
						}
						score+=5;
						if(score%10==0){
							pw+=100;
						}
						pw++;
						if(pw>=300){
							pw=500;
						}
						int r=(int) (Math.random()*256);
						int g=(int) (Math.random()*256);
						int b=(int) (Math.random()*256);
						ballColor=new Color(r,g,b);
						bgColor=new Color(b,r,g);
					}

					try {
						Thread.sleep(3);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		px = e.getX() - pw / 2;

	}
}