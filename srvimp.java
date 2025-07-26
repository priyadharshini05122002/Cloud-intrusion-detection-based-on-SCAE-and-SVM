import java.rmi.*;
import java.io.*;
import java.util.*;
import java.rmi.server.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class srvimp extends UnicastRemoteObject implements srvint
{
    srvimp(int x)throws RemoteException
    {
        
    }

 public void getfile(String a,String b,StringBuffer s)throws RemoteException
{

String s1=new String(s);


   try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
          PreparedStatement ps =con.prepareStatement("insert into file(nodename,filename,file) values(?,?,?)");
          ps.setString(1,a) ;
          ps.setString(2,b) ;
          ps.setString(3,s1) ;
          ps.executeUpdate();
          System.out.println("one file received from :"+a);
           
           }
        catch(Exception e)
        {
            System.out.println(e);
        }
}

 public StringBuffer viewfile(String v)throws RemoteException
{

   
  String fname=null;
  String fname1=null;
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
          	 
          	 sb.append(fname);
             sb.append("\n");    	
       
          	 
          }
           
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return sb;
        
      }  
        
        
        public StringBuffer misview()throws RemoteException
{


   
 String fname=null,pas=null,node=null,cd=null,add=null;
 
  StringBuffer sb = new StringBuffer();
   try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
           Statement st=con.createStatement();
           String sql="select * from misbehave";
           ResultSet rs=st.executeQuery(sql);
          while(rs.next())
          {
          	 fname=rs.getString("filename");
          	 node=rs.getString("node");
          	 cd=rs.getString("cdate");
          	 add=rs.getString("address");
          	  pas=rs.getString("pass");
          	 sb.append("File Name:\t");
          	 sb.append(fname);
             sb.append("\n");
             sb.append("Node Name:\t");
          	 sb.append(node);
             sb.append("\n");
             sb.append("Date:\t");
             sb.append(cd);
             sb.append("\n");
             sb.append("IP Address:\t");
             sb.append(add);
             sb.append("\n");
             sb.append("Error Password:");
             sb.append(pas);
             sb.append("\n");    	
             
             sb.append("****************************************");
             sb.append("\n");
             sb.append("\n");
          	 
          	 
          }
           
          }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return sb;
        
      }  
        
        public StringBuffer details()throws RemoteException
         {

         String fname=null,nname=null,fid=null;
             
          StringBuffer sb1=new StringBuffer();      
   
     try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
           Statement st=con.createStatement();
           String sql="select * from file";
           ResultSet rs=st.executeQuery(sql);
          while(rs.next())
          {
          	
          	fid=rs.getString("ID"); 
            fname=rs.getString("filename");
            nname=rs.getString("nodename");
          	
          	
          	sb1.append("File ID:");
          	sb1.append(fid);
          	sb1.append("\n"); 
          	sb1.append("File Name:");	
          	
          	sb1.append(fname);
          	sb1.append("\n");
          	sb1.append("File Received From:");
          	sb1.append(nname);
          	sb1.append("\n");
          	sb1.append("*********************");
          	sb1.append("\n");
          }
           
          }
        
        catch(Exception e)
        {
            System.out.println(e);
        }
        return sb1;
        
      }  
        
        
        
        
        
       public byte[] receivefile(String r)throws RemoteException
     {


   
  
  byte[] ba=null;

     try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
           Statement st=con.createStatement();
           String sql="select * from file where filename='"+r+"'";
           
           ResultSet rs=st.executeQuery(sql);
           while(rs.next())
          {
          ba=rs.getBytes("file");
          
          }
       
         
           
           }
        catch(Exception e){
            System.out.println(e);
        }
  
  
       
        return ba;
      }
      
      
      
      
          public byte[] storefile(String x)throws RemoteException
{


   
  
  byte[] ba1=null;

  try   {
           Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbase","root","");
       
           Statement st=con.createStatement();
           String sql="select * from file where filename='"+x+"'";
           
           ResultSet rs=st.executeQuery(sql);
           while(rs.next())
          {
          ba1=rs.getBytes("file");
          
          }
       
         
           
           }
        catch(Exception e){
            System.out.println(e);
        }
  
  
       
        return ba1;
      }     
        
       
        
       
}








