import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Xiaxue {

	public static void main(String[] args) {
		JFrame jf = new JFrame();   //ʵ����
		jf.setVisible(true);   //������ʾ
		jf.setSize(800, 800);   //���ڴ�С
		jf.setTitle("ѩ��");  //����
		jf.setResizable(false);  //�̶����ڴ�С
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رմ���,����ر�
		SJPanel sj = new SJPanel();   //ʵ����
		jf.add(sj);       //��ӵ�����
		sj.moveSnow();   //���÷���
	}

}

class SJPanel extends JPanel {   //�̳�
	int[] x = new int[400];  //��������
	int[] y = new int[400];

	public SJPanel() {  //���췽��
		for (int i = 0; i < x.length; i++) {
			x[i] = (int) (Math.random() * 800);   //�����������
			y[i] = (int) (Math.random() * 800);
		}
	}

	@Override
	public void paint(Graphics g) {   //����
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(Color.BLUE);  //���ñ���ɫ
		g.setColor(Color.RED);    //���û�����ɫ
		for (int i = 0; i < x.length; i++) {   //��forѭ������������
			g.drawString("$", x[i], y[i]);  //���ݼ�����
		}
	}
	public void moveSnow() {
		new Thread() {  //�����߳�
			public void run() {
				while (true) {   //ѭ������
					for (int i = 0; i < x.length; i++) {
						y[i] = y[i] + 10;
						if (y[i] >= 700) {
							y[i] = 0;
						}

					}
					repaint();  //�ظ���
					try {   //�쳣�������
						Thread.sleep(100);   //���ý����л�ʱ��
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}