import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Xiaxue {

	public static void main(String[] args) {
		JFrame jf = new JFrame();   //实例化
		jf.setVisible(true);   //窗口显示
		jf.setSize(800, 800);   //窗口大小
		jf.setTitle("雪花");  //标题
		jf.setResizable(false);  //固定窗口大小
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭窗口,程序关闭
		SJPanel sj = new SJPanel();   //实例化
		jf.add(sj);       //添加到窗口
		sj.moveSnow();   //调用方法
	}

}

class SJPanel extends JPanel {   //继承
	int[] x = new int[400];  //创建数组
	int[] y = new int[400];

	public SJPanel() {  //构造方法
		for (int i = 0; i < x.length; i++) {
			x[i] = (int) (Math.random() * 800);   //产生随机坐标
			y[i] = (int) (Math.random() * 800);
		}
	}

	@Override
	public void paint(Graphics g) {   //画布
		// TODO Auto-generated method stub
		super.paint(g);
		setBackground(Color.BLUE);  //设置背景色
		g.setColor(Color.RED);    //设置画笔颜色
		for (int i = 0; i < x.length; i++) {   //用for循环输出多个内容
			g.drawString("$", x[i], y[i]);  //内容及坐标
		}
	}
	public void moveSnow() {
		new Thread() {  //创建线程
			public void run() {
				while (true) {   //循环条件
					for (int i = 0; i < x.length; i++) {
						y[i] = y[i] + 10;
						if (y[i] >= 700) {
							y[i] = 0;
						}

					}
					repaint();  //重复画
					try {   //异常捕获机制
						Thread.sleep(100);   //设置进程切换时间
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
}