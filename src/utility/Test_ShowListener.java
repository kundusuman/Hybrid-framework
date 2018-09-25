package utility;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class Test_ShowListener 
{
	static JFrame frame=null;
	static int i=0;
	static JLabel label_Icon=null;
	static JLabel label_Test=null;
//this method is to set the value of the progressbar this method shoud be called after init() method
	public static void  set(String testname)
	{
		Init();
		label_Test.setText(label_Test.getText() + testname);
}
//this method is for initialize the jframe and jprogressbar
	public static void Init()
	{
         frame= new JFrame("JProgress Demo");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        frame.setLayout(new FlowLayout());
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,60);
        frame.setLocation((int)screenSize.getWidth()/2-320, (int)screenSize.getHeight()/2-22+40);
        frame.setVisible(true);
        Image imageIcon =new ImageIcon("D:\\Suman\\HYBRID\\Framework3\\Images\\loader.gif").getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        label_Icon = new JLabel(new ImageIcon(imageIcon));
        label_Icon.setBounds(0, 0, 50, 50);
        label_Test=new JLabel();
        label_Test.setText("Test_Name -> ");
        label_Test.setFont(new Font("Courier", Font.BOLD,16));    //frame.setUndecorated(true);
        frame.setBackground(new Color(0.6f,1.0f,1.0f,0.8f));
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.yellow));
        frame.getContentPane().add(label_Icon);
        frame.getContentPane().add(label_Test);
        frame.setAlwaysOnTop(true);
        
        
	}
//stop jframe and jprogressbar
	public static void end()
	{
		frame.setVisible(false); //you can't see me!
        frame.dispose();
	}	
	
		
}


