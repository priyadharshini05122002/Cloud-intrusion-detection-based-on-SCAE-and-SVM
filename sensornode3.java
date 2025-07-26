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

public class sensornode3 extends JFrame implements ActionListener

{
	String filesel,s1,s2,mst;
    String[] pmes;
    String[] str1=new String[10];
    Random r;
    File f;
	

	 JLabel fname;
	 JLabel file;
	 JLabel packet;
	 JLabel title,title1;

	 
	 JLabel n1;
	 
	 JButton open;
	 JButton send;
	 JButton reset;
	 
	 JTextField fname1;
	 JTextField file1;
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
	 public sensornode3()
	
	 {
	
		initializeComponent();
		
	 }
		
		
		private void initializeComponent()

	   {
		 
		 fname=new JLabel("<html><font color=#FFFFFF size=+1><strong>FileName</strong></font>");
		 file=new JLabel("<html><font color=#FFFFFF size=+1><strong>File</strong></font>");
		 packet=new JLabel("<html><font color=#FFFFFF size=+1><strong>Packet Sending</strong></font>");
		 title=new JLabel("<html><font color=#FFFFFF size=+2><strong>Cloud Intrusion Detection</strong></font>");
		 title1=new JLabel("<html><font color=#FFFFFF size=+2><strong></strong></font>");
		 n1=new JLabel("<html><font color=#FFFFFF size=+1><strong>Sensor Node3</strong></font>");
		 	
	
		
		JLabel imageLabel1 = new JLabel();
		ImageIcon v1 = new ImageIcon(this.getClass().getResource("AnimatedTower.gif"));
		imageLabel1.setIcon(v1);
	
	    
	    
	  
	        
		
		 open=new JButton("Open");
		 open.addActionListener(this);
		 send=new JButton("Send");
		 send.addActionListener(this);
	
		 fname1=new JTextField(10);
		 file1=new JTextField(10);
	
		 packet1=new JTextArea();
		 
		 c=getContentPane();
		 c.setLayout(null);
		 c.add(fname);
		 c.add(file);
		 c.add(packet);
		 c.add(packet1);
		 c.add(n1);
		
		 
		 c.add(imageLabel1);
		
		  
		 c.add(title);
		 c.add(title1);
	     c.add(open);
	  	 c.add(send);
	
		 c.add(fname1);
		 c.add(file1);
		 
		 c.setBackground(new java.awt.Color(100,50,45));
         c.setLocation(300,300);
		 
		 
		
		 
		title.setBounds(75,30,700,50);
		title1.setBounds(300,80,500,50);	
	
	   	imageLabel1.setBounds(475,125,450,350);
	   
	
		fname.setBounds(30,150,250,25);
		file.setBounds(30,200,250,25);
		packet.setBounds(150,300,200,25);
		packet1.setBounds(150,350,150,150);
		n1.setBounds(475,375,150,100);
	
		
		open.setBounds(255,200,75,25);
		send.setBounds(150,245,75,25);
	
		fname1.setBounds(150,150,150,25);
		file1.setBounds(150,200,100,25);
		 
		
		 
		 
		 setSize(800,600);
		 setVisible(true);
		 setTitle("Sensor Node3");

	    }
	   
	   
	   
	   public void actionPerformed(ActionEvent ae)
	
	  	{
	  		
	   
	   	if(ae.getSource()==send)
		{

		if(fname1.getText().equals(""))
		{
		
			JOptionPane.showMessageDialog(null,"Enter File Name");
			fname1.requestFocus(); 
			
		}
		else if(file1.getText().equals(""))
		{
		
			JOptionPane.showMessageDialog(null,"Browse File");
			
			file1.requestFocus(); 
		}
		else 
		{        
		       System.out.println("Connected To StorageNode....");
		       System.out.println("\n");
			
			    String nm="sensornode3";
			
			    String fn =fname1.getText();
				
				f=new File(filesel);
	         	String st;
		try
		{
		
		   String url = "rmi://127.0.0.1/storagenode";

         srvint in = (srvint) Naming.lookup(url);
	
		    
		
		
			int sz;
			byte[] buffer;

			pmes=new String[10];
			r =new Random();
			FileInputStream fin=new FileInputStream(filesel);
	
			sz=fin.available()/7;
			buffer=new byte[sz];
				
			int m=r.nextInt(7);
			StringBuffer sb=new StringBuffer();

			for(int i=0;i<=7;i++)
			{	

				fin.read(buffer);
				st=new String(buffer);
				pmes[i]=st;
				sb.append(st);
			}
			
			String pt=packet1.getText();
			String pt1="null";
			
			
			if(pt!=pt1)
			{
				packet1.setText("");
			}
			
			
		System.out.println("File Sending From Sensornode3 to Storagenode");
		System.out.println("\n");	
        System.out.println("Filename:\t"+fn);
        System.out.println("\n");
         
			
			
			for(int i=0;i<=7;i++)
			{	
               
			if(i!=m)
			{
				
			packet1.append("Packet["+i+"]:PACK");
			packet1.append("\n");
				
			new cc3(i,m);	
			
			}
			else 
			{
			packet1.append("Packet["+i+"]:NACK");
			packet1.append("\n");
				new cc3(i,m);	
			}
			
		
			
			
			}
		    
		    System.out.println("\n \t Packet["+m+"]:Positive ACK" );
		    System.out.println("\n File Sent To Storagenode" );
	        packet1.append("Packet["+m+"]:PACK");
	  
	       
	   
	  
	
		
			in.getfile(nm,fn,sb);
			file1.setText("");	
			fname1.setText("");	
				
			}
			catch(Exception e)
			{
			}
       
		
		
	 
		}
		
		}
		
		
		if(ae.getSource()==open)
		
		{ 
        
        FileDialog fd1=new FileDialog(this,"OPEN",FileDialog.LOAD);
	    fd1.setVisible(true);
     	filesel=fd1.getDirectory()+fd1.getFile();
	    file1.setText(filesel);
         
        }
		
		
		}
			public static void main(String args[])
	    {
		new sensornode3();
		System.out.println("Sensornode3 Started....");
		}
		}
		
class cc3 extends Thread
{
	

	Thread t;	

	cc3(int ps,int rm)
	{
		try
		{
		
		
			   if(rm!=ps)
			   {
			   	System.out.println("\t Packet["+ps+"]:Positive ACK");
		        System.out.println("\n");
			   	
			   		t.sleep(2000);
			   }
			   else
			   {
			   	System.out.println("Packet["+ps+"]:Negative ACK");
		        System.out.println("\n");
			   	
			   }
			   
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		
	}
	
	
	

}
