import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.event.*;
import java.sql.*;
import java.rmi.*;
import org.jvnet.substance.*;

public class login extends JFrame implements ActionListener

{

	
	
	 JLabel fname;
	 JLabel file;
	 JLabel packet;
	 JLabel title,title1;

	 
	 JLabel n1,n2;
	 
	 JButton open;
	 JButton send;
	 JButton reset;
	 
	 JTextField fname1;
	 JPasswordField file1;
	 JTextArea packet1;
	
	 String msg="";

	 
	 Container c;
	 ImageIcon ii;
	 ImageIcon i2;
	 	Socket c1;
	 
	     	static {
		try {
                        
			SubstanceLookAndFeel
					.setCurrentWatermark("org.jvnet.substance.watermark.SubstanceMagneticFieldWatermark");
			SubstanceLookAndFeel
					.setCurrentTheme("org.jvnet.substance.theme.SubstanceCharcoalTheme");
			SubstanceLookAndFeel
					.setCurrentGradientPainter("org.jvnet.substance.painter.SpecularGradientPainter");
			SubstanceLookAndFeel
					.setCurrentButtonShaper("org.jvnet.substance.button.BaseButtonShaper");
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	 public login()
	
	 {
	
		initializeComponent();
		
	 }
		
		
		private void initializeComponent()

	   {
		 
		 fname=new JLabel("<html><font color=#FFFFFF size=+1><strong>User Name</strong></font>");
		 file=new JLabel("<html><font color=#FFFFFF size=+1><strong>Password</strong></font>");
		 
		 title=new JLabel("<html><font color=#FFFFFF size=+2><strong>ADMIN LOGIN </strong></font>");
		 
		
		JLabel imageLabel1 = new JLabel();
		ImageIcon v1 = new ImageIcon(this.getClass().getResource(""));
		imageLabel1.setIcon(v1);
	
	    
	    
	    
	       
	
	    
	        
	        
		
		
		
		 send=new JButton("Send");
		 send.addActionListener(this);
	
		 fname1=new JTextField(10);
		 file1=new JPasswordField(10);
	
		
		 
		 c=getContentPane();
		 c.setLayout(null);
		 c.add(fname);
		 c.add(file);
		
		
		 
		 c.add(imageLabel1);
		 
		 c.add(title);
		 
	      	 c.add(send);
	
		 c.add(fname1);
		 c.add(file1);
		 
		 c.setBackground(new java.awt.Color(100,90,150));
         c.setLocation(300,300);
		 
		 
		
		 
		title.setBounds(75,30,700,50);
	
	
	   	imageLabel1.setBounds(450,100,350,250);
	   
	
		fname.setBounds(30,100,250,25);
		file.setBounds(30,150,250,25);
	
		
		send.setBounds(150,215,75,25);
	
		fname1.setBounds(150,100,150,25);
		file1.setBounds(150,150,150,25);
		 
		 
		 
		 
		 setSize(350,300);
		 setVisible(true);
		 setTitle("Admin Login");

	    }
	   
	   
	   
	   public void actionPerformed(ActionEvent ae)
	
	  	{
	  		
	   
	   	if(ae.getSource()==send)
		{

		if(fname1.getText().equals(""))
		{
		
			JOptionPane.showMessageDialog(null,"Enter UserName");
			fname1.requestFocus(); 
			
		}
		else if(file1.getText().equals(""))
		{
		
			JOptionPane.showMessageDialog(null,"Password");
			
			file1.requestFocus(); 
		}
		else if((fname1.getText().equals("admin"))&&(file1.getText().equals("admin")))
		{
		
			new sink();
			this.dispose();
		}

        else
        {
        JOptionPane.showMessageDialog(null,"Invalid UserName and Password");
			
			fname1.requestFocus();	
        }		
	
		
	 
		}
		
	
		
	
			
		}
			public static void main(String args[])
	    {
		new login();
		}
		}
		
