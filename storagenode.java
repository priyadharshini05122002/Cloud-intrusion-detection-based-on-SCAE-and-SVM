import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.event.*;
import java.sql.*;
import java.rmi.*;
import java.security.InvalidKeyException;
import java.security.Key;
import org.jvnet.substance.*;

public class storagenode 
{		

public static void main(String[] args)throws Exception
{
srvimp rob = new srvimp(2001);
Naming.rebind("storagenode",rob);
System.out.println("Server is waiting for Client to Connect:");
storagewindow sw=new storagewindow();
}
	
	

}

class storagewindow extends JFrame implements ActionListener 

{
	
	 JLabel vfile;
	 
	 JLabel file;
	  JLabel packet;
	  JLabel fid;
	 JLabel title,title1;
	 
	 JLabel n1;
	 
	 JButton open;
	 JButton detail;
	 JButton view;
	 
	 JTextField fname1;
	 JTextField file1;
	 JTextField fid1;
	 JTextArea packet1;
	 JTextArea packet2;
	
	 String msg="";
	 String filesel;
	 
	 Container c;
	 ImageIcon ii;
	 ImageIcon i2;
	
	
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
	public storagewindow()
	{
	
		initializeComponent();
	
	}
		
			private void initializeComponent()

	 {
		 //new net();
		 //v = net.vnode;
		 vfile=new JLabel("<html><font color=#FFFFFF size=+1><strong>All Files</strong></font>");
		 fid=new JLabel("<html><font color=#FFFFFF size=+1><strong>File ID:</strong></font>");
		 file=new JLabel("<html><font color=#FFFFFF size=+1><strong>File</strong></font>");
		 packet=new JLabel("<html><font color=#FFFFFF size=+1><strong>Packet Sending</strong></font>");
		 title=new JLabel("<html><font color=#FFFFFF size=+2><strong>Cloud Intrusion Detection</strong></font>");
		 title1=new JLabel("<html><font color=#FFFFFF size=+2><strong></strong></font>");
		 n1=new JLabel("<html><font color=#FFFFFF size=+1><strong>Storage Node</strong></font>");

	
		
		JLabel imageLabel1 = new JLabel();
		ImageIcon v1 = new ImageIcon(this.getClass().getResource("AnimatedTower.gif"));
		imageLabel1.setIcon(v1);
	
	    
	   
	        
		
		 open=new JButton("All Files");
		 open.addActionListener(this);
		 detail=new JButton("Details");
		 detail.addActionListener(this);
		 view=new JButton("View");
		 view.addActionListener(this);
	
		 fname1=new JTextField(10);
		 file1=new JTextField(10);
		 fid1=new JTextField(10);
	
		 packet1=new JTextArea();
		 packet2=new JTextArea(6,20);
		 JScrollPane sa = new JScrollPane(packet2);
		 JScrollPane sa1 =new JScrollPane(packet1);
        
		 
		 c=getContentPane();
		 c.setLayout(null);
		 //c.add(vfile);
		// c.add(file);
		 //c.add(packet);
		 c.add(sa1);
		 c.add(sa);
		 c.add(n1);
	
	
		 c.add(fid);
		 c.add(fid1);
		 
		 c.add(imageLabel1);
		 
		 
		 c.add(title);
		 c.add(title1);
	    c.add(open);
	  	 c.add(detail);
	  	 c.add(view);
	
		 //c.add(fname1);
		// c.add(file1);
		 
		 c.setBackground(new java.awt.Color(100,50,45));
        c.setLocation(300,300);
		 
		 
		
		 
		title.setBounds(75,30,700,50);
		title1.setBounds(300,80,500,50);	
	   
	    fid.setBounds(250,430,200,50);
	    fid1.setBounds(345,445,100,25); 
	    
	    
	   	imageLabel1.setBounds(305,185,350,150);
	   	
	
		vfile.setBounds(100,150,250,25);
		file.setBounds(30,200,250,25);
		packet.setBounds(150,300,200,25);
		sa1.setBounds(65,185,150,150);
		sa.setBounds(500,185,200,150);
		n1.setBounds(305,315,150,100);
	
		
		open.setBounds(77,145,125,25);
		detail.setBounds(533,145,125,25);
		view.setBounds(345,495,75,25);
	
		fname1.setBounds(150,150,150,25);
		file1.setBounds(150,200,100,25);
		
		 
		 
		 
		 setSize(800,600);
		 setVisible(true);
		 setTitle("Storage Node");

	   }
	   
	   
	   
	   
	   public void actionPerformed(ActionEvent ae)
	
	  	{
	  		
	   
		if(ae.getSource()==open)
		
		{ 
		
		  String aa= packet1.getText();
		  String aaa="null";
		  if(aaa != aa)
		  {
		  packet1.setText("");
		  }
		 
             String fname=null;
             
             StringBuffer sb = new StringBuffer();
   
     try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
           Statement st=con.createStatement();
           String sql="select * from file";
           ResultSet rs=st.executeQuery(sql);
          while(rs.next())
          {
          	 fname=rs.getString("filename");
          	 packet1.append(fname);
          	 //sb.append(fname);
             packet1.append("\n");    	
          	 //fname1=ss.append(fname).append("\n");
          	 
          }
           
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
      
        }
        
          if(ae.getSource()==view)
		
		{ 
        
        String v= fid1.getText();
        if(fid1.getText().equals(""))
		{
		
			JOptionPane.showMessageDialog(null,"Enter File Name");
			fid1.requestFocus(); 
			
		}
		else
		{
	     String fd=fid1.getText();
         new admin1(fd);
         fid1.setText("");	 
      	}
        }
        
        
        if(ae.getSource()==detail)
		
		{ 
        
        String p= packet2.getText();
		  String pp="null";
		  if(p != pp)
		  {
		  packet2.setText("");
		  }
        
             String fname=null,nname=null,fid=null;
             
             
   
     try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
           Statement st=con.createStatement();
           String sql="select * from file";
           ResultSet rs=st.executeQuery(sql);
          while(rs.next())
          {
          	packet2.append("File ID:");
          	fid=rs.getString("ID"); 
          	packet2.append(fid);
          	packet2.append("\n");
          	packet2.append("File Name:");
          	 fname=rs.getString("filename");
          	 packet2.append(fname);
          	packet2.append("\n");
          	 packet2.append("File Received From:");
          	 nname=rs.getString("nodename");
          	 packet2.append(nname);
          	packet2.append("\n");
          	packet2.append("*********************");
          	packet2.append("\n"); 
          	 
          }
           
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
      
        }
		
		
		}
			public static void main(String args[])
	    {
		new storagewindow();
		}
		}

	
	


 class admin1 extends JFrame implements ActionListener,ItemListener

{
	


	private JLabel label1;
	private JTextField text1;
	
	

	private JButton submit;

	Container c;
String a1;	
 admin1(String a)
	{
		
     this.a1=a;
	
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
	
		label1=new JLabel("Enter Password");
		 
		 c.add(label1);
		   
		
		 text1=new JTextField(10);
		 text1.addActionListener(this);
		 c.add(text1);
		 
		 
		
		  
	
		 
		submit=new JButton("submit");
		submit.addActionListener(this);
		c.add(submit);
		add(submit);
		submit.setBounds(160,100,100,20);
setLayout(null);	
add(label1);
label1.setBounds(40,40,120,25);
add(text1);
text1.setBounds(160,40,140,20);




 
	this.setSize(400,175);
		this.show();	
		
	}
	
		public void actionPerformed(ActionEvent ae)
	
	
	
	{
	  	   this.dispose();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	     String pa="admin";  
		if(ae.getSource()==submit)
		{
	     
	     
	     if(text1.getText().equals(""))
		{
		
			JOptionPane.showMessageDialog(null,"Enter Password");
			text1.requestFocus(); 
			
		}
		else if(text1.getText().equals(pa))
		{
		// if password correct show original file
		
		
		String fnam1="asdas";
		
	  byte[] b1=null;

  try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
       
           Statement st=con.createStatement();
           String sql="select * from file where filename='"+a1+"'";
           
           ResultSet rs=st.executeQuery(sql);
           while(rs.next())
          {
          b1=rs.getBytes("file");
          
          }
       
           
           }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        
         
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
		else
		{
		// if password not correct show encrypted  file
		
		
		String node="storagenode";
				
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        
       String pass=text1.getText();
        	
        
        try   {
        	
        	InetAddress Address = InetAddress.getLocalHost();
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
            Statement st=con.createStatement();
            String sql="insert into misbehave(filename,node,cdate,address,pass) values('"+a1+"','"+node+"','"+date+"','"+Address+"','"+pass+"')";
            st.executeUpdate(sql);
                        
           }
          catch(Exception e)
           {
            System.out.println(e);
           }
        
        
         byte[] b1=null;

  try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
       
           Statement st=con.createStatement();
           String sql="select * from file where filename='"+a1+"'";
           
           ResultSet rs=st.executeQuery(sql);
           while(rs.next())
          {
          b1=rs.getBytes("file");
          
          }
       
           
           }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        new viewfile(a1,b1);
         
             
  
		JOptionPane.showMessageDialog(null,"You are not authorized to view file");
		text1.requestFocus(); 
					
		}
		
	     
        
		}

		
		
	    }
	
	
	
	public void itemStateChanged(ItemEvent ie)
{ 
repaint();
}
	public static void main(String arg[])
	{
		
	}	


}

 class viewfile extends JFrame 
{


	private JTextArea box;
	private JButton submit;
	JScrollPane sa;
	Container c;
   byte[] ba;
   String na;
	viewfile(String n,byte[] a)
	{
    this.na=n;
	this.ba=a;
		c=getContentPane();
		c.setLayout(new FlowLayout());
	
	  
		 box=new JTextArea(25,40);
		 sa = new JScrollPane(box);
		 sa.setBounds(20,20,500,500);
		 c.add(sa);
		 String ba1=new String(ba);
		 String x=encryptString(ba1);
		 box.append(x);
		this.setTitle(na+".txt");
		this.setSize(500,500);
		this.show();	
		
	}
	
	public static String encryptString(String str)
   {
      StringBuffer sb = new StringBuffer (str);
	  String key="Encrypt Key";

      int lenStr = str.length();
      int lenKey = key.length();
	   
      //
      // For each character in our string, encrypt it...
      for ( int i = 0, j = 0; i < lenStr; i++, j++ ) 
      {
         if ( j >= lenKey ) j = 0;  // Wrap 'round to beginning of key string.

         //
         // XOR the chars together. Must cast back to char to avoid compile error. 
         //
         sb.setCharAt(i, (char)(str.charAt(i) ^ key.charAt(j))); 
      }

      return sb.toString();
   }
   
	public void itemStateChanged(ItemEvent ie)
{ 
repaint();
}
	public static void main(String arg[])
	{

	
	}
	}	