import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snows {

	public static void main(String[] args) {
		JFrame jf = new JFrame(); // 创建类的对象
		jf.setVisible(true); // 让窗口显示
		jf.setBounds(50, 50, 500, 600); // 窗口大小和位置
		jf.setResizable(false); // 固定窗口大小
		jf.setTitle("下雪"); // 设置标题
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗口时,程序关闭
		SnowJPanel1 sj = new SnowJPanel1();
		jf.add(sj);
		sj.Add();
	}
}
class SnowJPanel1 extends JPanel { // 继承画布
	int x;
	int y;
	int i = 1;
	@Override
	public void paint(Graphics g) { // 画笔
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(Color.LIGHT_GRAY); // 背景颜色
		g.setFont(new Font("楷体", Font.ITALIC, 50));
		g.setColor(Color.BLUE); // 画笔颜色
		for(int i=1;i<=100;i++){
		Random ran = new Random();
		x = ran.nextInt(460);
		y = ran.nextInt(500);
		g.drawString("*", x, y); // 内容及位置
		}
	}
	public void Add() {
		new Thread() {
			public void run() {
				while (i <= 60) {
					repaint();
					i++;
				}
			}
		}.start();
	}
}
