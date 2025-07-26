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


public class sink extends JFrame implements ActionListener
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

	 
	 
	 
	 JButton view;
	 JButton send;
	 JButton mis;
	 JButton detail;
	 
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
	 public sink()
	
	 {
	
		initializeComponent();
		
	 }
		
		
		private void initializeComponent()

	   {
		 //new net();
		 //v = net.vnode;
		 fname=new JLabel("<html><font color=#FFFFFF size=+1><strong>Search Query</strong></font>");
		 file=new JLabel("<html><font color=#FFFFFF size=+1><strong>File</strong></font>");
		 packet=new JLabel("<html><font color=#FFFFFF size=+1><strong>Packet Sending</strong></font>");
		 title=new JLabel("<html><font color=#FFFFFF size=+2><strong>Cloud Intrusion Detection</strong></font>");
		 title1=new JLabel("<html><font color=#FFFFFF size=+2><strong></strong></font>");
		
		
		JLabel imageLabel1 = new JLabel();
		ImageIcon v1 = new ImageIcon(this.getClass().getResource("archi1.jpg"));
		imageLabel1.setIcon(v1);     
	        
		
		 view=new JButton("View Files");
		 view.addActionListener(this);
		 send=new JButton("Receive");
		 send.addActionListener(this);
		 mis=new JButton("Misbehavior Details");
		 mis.addActionListener(this);
		 detail=new JButton("File Details");
		 detail.addActionListener(this);
	
		 fname1=new JTextField(10);
		 file1=new JTextField(10);
	
		 packet1=new JTextArea();
		 JScrollPane sa = new JScrollPane(packet1);
		 
		 c=getContentPane();
		 c.setLayout(null);
	      c.add(fname);
		 //c.add(file);
		 //c.add(packet);
		 c.add(sa);
		
		 
		 c.add(imageLabel1);
		 
		 
		 c.add(title);
		 c.add(title1);
	     c.add(view);
	  	 c.add(send);
	  	 c.add(mis);
	     c.add(detail);
		 c.add(fname1);
		 //c.add(file1);
		 
		 c.setBackground(new java.awt.Color(100,50,45));
         c.setLocation(300,300);
		 
		 
		
		 
		title.setBounds(75,30,700,50);
		title1.setBounds(300,80,500,50);	
	
	   	imageLabel1.setBounds(370,250,350,300);
	   
	
		fname.setBounds(295,175,250,25);
		file.setBounds(30,200,250,25);
		packet.setBounds(170,300,200,25);
		sa.setBounds(62,225,150,150);
	
		
		view.setBounds(75,175,125,25);
		send.setBounds(465,225,125,25);
		mis.setBounds(60,425,155,25);
		detail.setBounds(60,465,155,25);
	
		fname1.setBounds(465,175,150,25);
		file1.setBounds(150,200,100,25);
		
		 
		 
		 
		 setSize(800,600);
		 setVisible(true);
		 setTitle("Sink");

	    }
	   
	   
	   
	   public void actionPerformed(ActionEvent ae)
	
	  	{
	  		
	   
	   	if(ae.getSource()==view)
		{
         try
         {
         
         String url = "rmi://127.0.0.1/storagenode";

         srvint in = (srvint) Naming.lookup(url);
            String v="view";
            
          StringBuffer sb=(in.viewfile(v));
          
          packet1.setText(sb.toString());
            
            
		}
		catch(Exception e)
		{
			 System.out.println(e);
		}	
		}
		
		if(ae.getSource()==detail)
		{
         
        new detail();
         } 
		
	  		
	   
	   	if(ae.getSource()==send)
		{
			
         
         
         if(fname1.getText().equals(""))
		{
		
			JOptionPane.showMessageDialog(null,"Enter File Name");
			
			fname1.requestFocus(); 
		}
		else
		{ 
		   String fn=fname1.getText();
		   
		  
			
			try
			{
				 String url = "rmi://127.0.0.1/storagenode";

                 srvint in = (srvint) Naming.lookup(url);
                 
                byte[] b1=in.storefile(fn);
                 
                 
                 String file,dir,path,ms;
	

	
		      FileDialog fd2=new FileDialog(this,"SAVE",FileDialog.SAVE);
		      fd2.setVisible(true);
		      file=fd2.getFile();
		      dir=fd2.getDirectory();
		      path=dir+file;
		     
			
			try
			{
			FileOutputStream fos=new FileOutputStream(path);
			
						
			for(int k=0;k<=b1.length;k++)
			{
							
				fos.write(b1[k]);
				
			}
			}catch(Exception e){}

	    }
                 
                 
                 
                 
				
			
			catch(Exception e)
			{
				System.out.println(e);
			}
			
		}
         
         
       
		}
		
		
		
		/* misbehavior details */
		
	   	if(ae.getSource()==mis)
		{
         
         new viewmis();
        }   
		
		
			
		}
		
		
	
		
		public static void main(String args[])
	    {
		new sink();
		}
		
		
	}