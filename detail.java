import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.rmi.*;
import javax.swing.border.*;
import org.jvnet.substance.*;
 public class detail extends JFrame 
{
	private JTextArea box;
	private JButton submit;
	JScrollPane sa;
	Container c;
	    	static 
                {
		try 
                {
                        
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
	detail()
	{

	
		c=getContentPane();
		c.setLayout(new FlowLayout());
		
	  
		 box=new JTextArea(20,30);
		 sa = new JScrollPane(box);
		 sa.setBounds(20,20,170,175);
		 c.add(sa);
		 
		 
		 
		 
		 
//StringBuffer sb=null;
  try   {
  	
  	 
  	 String url = "rmi://127.0.0.1/storagenode";
     srvint in = (srvint) Naming.lookup(url);
            
            
          StringBuffer sb=(in.details());
          
          box.setText(sb.toString());
           }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
		 
		  setTitle("File Details");
		 
		 
		 
		this.setSize(375,375);
		this.show();	
		
	}
	public void itemStateChanged(ItemEvent ie)
{ 
repaint();
}
	public static void main(String arg[])
	{
	detail b=new detail();
	
	}
	}	


	
	
		
	
	
		
		
	    
