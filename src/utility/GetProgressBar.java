package utility;

/**
 * @author suman
 * @date 31/08/2018
 * @purpose creating a jframe and add a new jprogressbar in that
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class GetProgressBar extends JFrame
{
	static JFrame frame=null;
	static JLabel label=null;
	static JProgressBar pb=null;
	static  String str=null;
	static int i=0;
//this method is to set the value of the progressbar this method shoud be called after init() method
	public static void  set(int jbarval)
	{
		try
		{
			
			i++;
			pb.setValue(jbarval);
			str=String.valueOf(i) + str.substring(str.indexOf("/"));
	        label.setText(str);
		}
	catch(NullPointerException e)
		{
		System.out.println("call init() first");
		}
}
//this method is for initialize the jframe and jprogressbar
	public static void Init(int totalTest)
	{
         frame= new JFrame("JProgress Demo");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
// creates progress bar setting values of pregress bar
        pb = new JProgressBar();
        pb.setMinimum(0);
        pb.setMaximum(100);
        pb.setStringPainted(true);
        pb.setForeground(Color.BLUE.darker());
        pb.setBackground(Color.LIGHT_GRAY);
        pb.setPreferredSize(new Dimension(200,22));
        pb.setUI(new IllusionProgressBarUI());
        pb.setStringPainted(true);
// settings jframe and  add progress bar
        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(pb);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(270,37);
        frame.setLocation((int)screenSize.getWidth()/2-220, (int)screenSize.getHeight()/2-22);
        frame.setVisible(true);
        pb.setBounds(0, 0,200,22);
        str="0/"+ "" + String.valueOf(totalTest);
        label = new JLabel("Testing");
        label.setText(str);
        
        frame.setAlwaysOnTop(true);
        
        //frame.setUndecorated(true);
        frame.setBackground(new Color(1.0f,1.0f,0.7f,0.8f));
        label.setBounds(200, 0, 50, 20);
        frame.getContentPane().add(label);
        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.YELLOW));
        
	}
//stop jframe and jprogressbar
	public static void end()
	{
		frame.setVisible(false); //you can't see me!
        frame.dispose();
	}	
	
		
}