import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Snows {

	public static void main(String[] args) {
		JFrame jf = new JFrame(); // ������Ķ���
		jf.setVisible(true); // �ô�����ʾ
		jf.setBounds(50, 50, 500, 600); // ���ڴ�С��λ��
		jf.setResizable(false); // �̶����ڴ�С
		jf.setTitle("��ѩ"); // ���ñ���
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // �رմ���ʱ,����ر�
		SnowJPanel1 sj = new SnowJPanel1();
		jf.add(sj);
		sj.Add();
	}
}
class SnowJPanel1 extends JPanel { // �̳л���
	int x;
	int y;
	int i = 1;
	@Override
	public void paint(Graphics g) { // ����
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(Color.LIGHT_GRAY); // ������ɫ
		g.setFont(new Font("����", Font.ITALIC, 50));
		g.setColor(Color.BLUE); // ������ɫ
		for(int i=1;i<=100;i++){
		Random ran = new Random();
		x = ran.nextInt(460);
		y = ran.nextInt(500);
		g.drawString("*", x, y); // ���ݼ�λ��
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
