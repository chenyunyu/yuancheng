import javax.swing.*;
import java.awt.event.*;
public class UITest extends JFrame implements ActionListener{
 JButton button;
 int count;
 UITest(){
  count = 0;
  button = new JButton("��Ч��ť��"+count);
  button.addActionListener(this);
  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  this.getContentPane().add(button);
  this.setSize(300,300);
  this.setVisible(true);
 }
 public void actionPerformed(ActionEvent arg0) {
  // TODO �Զ����ɷ������
  count++;
  button.setText(""+count);
this.add(new JButton(""+count));
 }
 /**
  * @param args
  */
 public static void main(String[] args) {
  // TODO �Զ����ɷ���
  new UITest();

 }

}